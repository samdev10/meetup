# Filename: stateofwater.py
# Author: Suresh Gurram
# Email address:
# Description: Program to know the state of water at a given temperature
# Last changed: Jan 22, 2020

temperature = int(input('Please enter temperature in Fahrenheit :'))

if temperature <= 32:
    print('State of water at ' + str(temperature) + ' degree fahrenheit will be solid')
elif temperature >= 100:
    print('State of water at ' + str(temperature) + ' degree fahrenheit will be gaseous')
else:
    print('State of water at ' + str(temperature) + ' degree fahrenheit will be liquid')
