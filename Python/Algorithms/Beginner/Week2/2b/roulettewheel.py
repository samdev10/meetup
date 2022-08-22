# Filename: magicdate.py
# Author: Suresh Gurram
# Email address:
# Description: Program to know if the given date is a magic date
# Last changed: Jan 23, 2020
month = int(input('Please enter the month: '))
date = int(input('Please enter the date: '))
year = int(input('Please enter the 2 digit year: '))
if month * date == year:
    print(str(month) + '/' + str(date)+ '/' + str(year)+ ' is magic date')
else:
    print(str(month) + '/' + str(date)+ '/' + str(year)+ ' is not a magic date')



