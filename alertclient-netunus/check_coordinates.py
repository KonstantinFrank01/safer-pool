import paho.mqtt.client as mqtt
import time
import json

import RPi.GPIO as GPIO
from time import sleep

#Disable warnings (optional)
GPIO.setwarnings(False)

#Select GPIO mode
GPIO.setmode(GPIO.BCM)

#Set buzzer - pin 23 as output
buzzer=23 
ledPin=25
GPIO.setup(buzzer,GPIO.OUT)
GPIO.setup(ledPin, GPIO.OUT)

global_var = ""

def on_message(client, userdata, message):
    print("received message: " ,str(message.payload.decode("utf-8")))
    msgString = str(message.payload.decode("utf-8"))
    msgJson = json.loads(msgString) 
    print("received topic: ",str(message.topic))
    print(msgJson["x"])
    
    if int(msgJson["x"]) > -2 or int(msgJson["y"]) > -2 or int(msgJson["z"]) > -2:
        GPIO.output(buzzer,GPIO.HIGH)
        GPIO.output(ledPin,GPIO.HIGH)
        print ("Beep")
        sleep(0.5) # Delay in seconds
        GPIO.output(buzzer,GPIO.LOW)
        GPIO.output(ledPin,GPIO.LOW)
        print ("No Beep")
        sleep(0.5)
        
    print(msgJson["y"])
    print(msgJson["z"])
    global_var = str(message.payload)
    print(type(global_var), " Test")

mqttBroker ="192.168.2.163"

client = mqtt.Client("Smartphone")
client.connect(mqttBroker) 

client.loop_start()

client.subscribe("pool")
client.on_message=on_message


time.sleep(20)
client.loop_stop()

