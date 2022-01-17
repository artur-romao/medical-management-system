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
          self.connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost', port=5672))
          self.marychanel = self.connection.channel()
          
          self.marychanel.queue_declare(queue='oxi',durable=True)
          self.marychanel.queue_declare(queue='hb',durable=True)
          self.marychanel.queue_declare(queue='temp',durable=True)
          self.marychanel.queue_declare(queue='press',durable=True)
          
     async def electrocardiogramf(self):


          # define electrocardiogram as ecg model
          ecg = electrocardiogram()
          # frequency is 360
          frequency = 360
          # calculating time data with ecg size along with frequency
          hblist=[]
          i=0
          while True:
               
               if i>4:   
                    hblist=hblist[108000:]
               
               print("soy el i " ,i)

               for n in range(len(ecg)):
                    t = np.real((ecg[n]*(random.randrange(-10,10)**0.05)))
                    hblist.append(t)

               print(len(hblist))
               i+=1
               time_data = np.arange(len(hblist)) / frequency
               vallist=time_data[:250].tolist()+hblist[:250]
          
               tojson={'name':'hb', 'values':vallist, 'id':1}

               self.marychanel.basic_publish(exchange='', routing_key='hb', body=json.dumps(tojson))
               print("hi")
            
               await asyncio.sleep(2)
               """
               plt.plot(time_data, hblist)
               plt.xlabel("time in seconds")
               plt.ylabel("ECG in milli Volts")
               plt.xlim(9, 2500.2)
               plt.ylim(-1, 1.5)
               plt.show(block=True)
               """
                
     
          print("out")
     async def temp(self):
          i=3
          while True:
               avgtemp=37

               currtemp = avgtemp+random.randrange(-10,10)*0.15
               tojson={'name':'temp', 'values':currtemp, 'id':1}
               self.marychanel.basic_publish(exchange='', routing_key='temp', body=json.dumps(tojson))

               await asyncio.sleep(2)
               i-=1
               print("tem")
                
     async def pressaoarterial(self):
          sis=120
          dia=80
          i=3
          while True:
               sisnew = round(sis+random.randrange(-20,20)+random.random(),2)
               dianew=round(dia +random.randrange(-20,20)+random.random(),2)
               vallist = [sisnew, dianew]
               tojson={'name':'press', 'values': vallist ,'id':1}
               self.marychanel.basic_publish(exchange='', routing_key='press', body=json.dumps(tojson))
               await asyncio.sleep(2)
               i-=1
               print("pre")
                
     async def oxigeniosaturarion(self):
          #varia entre 96% e 99% com minimo em 94%
          #pode ir abaixo de 90% hypoxia
          #usar uma distruibuição 
          i=3
          dist=   [0.11,0.10,0.09,0.09,0.09,0.09,0.09,0.09,0.09,0.08,0.08]
          values= [89,90,91,92,93,94,95,96,97,98,99]
          while True:
               getrandomoxi= np.random.choice(values,1,True,dist)
               oxi= round(getrandomoxi[0] + random.random(),2)
               tojson={'name':'oxi', 'values':oxi , 'id':1}
               self.marychanel.basic_publish(exchange='', routing_key='oxi', body=json.dumps(tojson))
               

               await asyncio.sleep(2)
               i-=1
               print("ox")
                
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

     
     print(oxi)
     print(pressaoarterial)
     print(heartbeats)
     print(temperatura)
     loop.run_until_complete(asyncio.gather(heartbeats,oxi,pressaoarterial,temperatura))
     print(oxi)
     print(pressaoarterial)
     print(heartbeats)
     print(temperatura)
     loop.close()