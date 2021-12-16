#ports 15672 5672

from numpy.core.shape_base import block
from numpy.lib.function_base import average
import pika
import asyncio
import numpy
import os
import requests
import random
import matplotlib.pyplot as plt
from scipy.misc import electrocardiogram
  
# import numpy
import numpy as np


class Generators:
     """ This class houses all the functions that will generate data"""

     def electrocardiogramf():


          # define electrocardiogram as ecg model
          ecg = electrocardiogram()

          # frequency is 360
          frequency = 360
          listadavelhice=[]
          # calculating time data with ecg size along with frequency
          while True:

               for n in range(len(ecg)):
                    coracaodemelao = np.real((ecg[n]*(random.randrange(-10,10)**0.05)))
                    listadavelhice.append(coracaodemelao)

               time_data = np.arange(len(listadavelhice)) / frequency
               """
               plt.plot(time_data, listadavelhice)
               plt.xlabel("time in seconds")
               plt.ylabel("ECG in milli Volts")
               plt.xlim(9, 2500.2)
               plt.ylim(-1, 1.5)
               plt.show(block=True)
               """

     def temp():
          while True:
               avgtemp=37

               currtemp = avgtemp+random.randrange(-10,10)*0.15
     def pressaoarterial():
          sis=120
          dia=80
          while True:
               sisnew = sis+random.randrange(-20,20)*0.15
               dianew=dia +random.randrange(-20,20)
          
     def oxigeniosaturarion():
          #varia entre 96% e 99% com minimo em 94%
          #pode ir abaixo de 90% hypoxia
          #usar uma distruibuição 
          dist=   [0.11,0.10,0.09,0.09,0.09,0.09,0.09,0.09,0.09,0.08,0.08]
          values= [89,90,91,92,93,94,95,96,97,98,99]
          while True:
               getrandomoxi= np.random.choice(values,1,True,dist)
          
