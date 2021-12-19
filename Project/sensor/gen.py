#ports 15672 5672

from asyncio.tasks import sleep
from numpy.core.shape_base import block
from numpy.lib.function_base import average
import pika
import asyncio
import numpy
import json
import os
import requests
import random
import matplotlib.pyplot as plt
from scipy.misc import electrocardiogram
  
# import numpy
import numpy as np


class Generators:
     """ This class houses all the functions that will generate data"""
     def __init__(self):
          self.connection = pika.BlockingConnection(pika.ConnectionParameters(host='192.168.160.209', port=5672))
          self.marychanel = self.connection.channel()
          

     async def electrocardiogramf(self):


          # define electrocardiogram as ecg model
          ecg = electrocardiogram()

          # frequency is 360
          frequency = 360
          hblist=[]
          # calculating time data with ecg size along with frequency
          while True:

               for n in range(len(ecg)):
                    t = np.real((ecg[n]*(random.randrange(-10,10)**0.05)))
                    hblist.append(t)

               time_data = np.arange(len(hblist)) / frequency
               tojson={'name':'hb', 'times_data': time_data, "heart_values": hblist}
               self.marychanel.basic_publish(exchange='logs', routing_key='hb', body=json.dumps(tojson))
               await asyncio.sleep(2)
               """
               plt.plot(time_data, hblist)
               plt.xlabel("time in seconds")
               plt.ylabel("ECG in milli Volts")
               plt.xlim(9, 2500.2)
               plt.ylim(-1, 1.5)
               plt.show(block=True)
               """

     async def temp(self):
          while True:
               avgtemp=37

               currtemp = avgtemp+random.randrange(-10,10)*0.15
               tojson={'name':'temp', 'values':currtemp}
               self.marychanel.basic_publish(exchange='logs', routing_key='temp', body=json.dumps(tojson))

               await asyncio.sleep(20)

     async def pressaoarterial(self):
          sis=120
          dia=80
          while True:
               sisnew = round(sis+random.randrange(-20,20)+random.random(),2)
               dianew=round(dia +random.randrange(-20,20)+random.random(),2)

               tojson={'name':'press', "sis_values":sisnew, "dia_values": dianew}
               self.marychanel.basic_publish(exchange='logs', routing_key='pressao_arterial', body=json.dumps(tojson))
               await asyncio.sleep(20)

     async def oxigeniosaturarion(self):
          #varia entre 96% e 99% com minimo em 94%
          #pode ir abaixo de 90% hypoxia
          #usar uma distruibuição 
          dist=   [0.11,0.10,0.09,0.09,0.09,0.09,0.09,0.09,0.09,0.08,0.08]
          values= [89,90,91,92,93,94,95,96,97,98,99]
          while True:
               getrandomoxi= np.random.choice(values,1,True,dist)
               oxi= round(getrandomoxi[0] + random.random(),2)
               tojson={'name':'oxi', 'value':oxi}
               self.marychanel.basic_publish(exchange='logs', routing_key='oxi', body=json.dumps(tojson))
               

               await asyncio.sleep(20)
if __name__ == "__main__":
     g=Generators()

     loop= asyncio.get_event_loop()


     #criar tarefa pra cada gen
     #chamar com o gather
     #com o until complete
     #dar close

     heartbeats= loop.create_task(g.electrocardiogramf())
     oxi= loop.create_task(g.oxigeniosaturarion())
     pressaoarterial = loop.create_task(g.pressaoarterial())
     temperatura = loop.create_task(g.temp())


     loop.run_until_complete(asyncio.gather(heartbeats,oxi,pressaoarterial,temperatura))
     loop.close()