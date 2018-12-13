'''
Problem 3:
    Reqs:
        User Inputs a point and y-intercept
        Recieves Float varible with slop
    Assumptions:
        Can be decimal
        The slope can't be undefined
    Contraints:
        use slope formula
    Formula:
        y = mx+b
        y-b = mx
        (y-b)/x = m
    Psuedo Code:
        Input X
        Input Y
        Input Y-intercept
        Find Slope
        Print Message

#Get X Coordinate
x = float(input("Enter X coordinate: "))
#Get Y Coordinate
y = float(input("Enter Y coordinate: "))
#Get Y-Intercept
y_intercept = float(input("Enter Y-Intercept: "))
#Find Slope
slope = str((y - y_intercept)/x)
#Print Message
print("The slope is " + slope)

Improvments:
    I could have fix the divisable by 0 problem for X coordinate
    I could have state when the slope is undefined

Problem 9:
    Reqs:
        Sort customer cents out
        print number of quarter, dimes, nickles, and penies
    Assumptions:
        No dollars wanted
        No decimal coins
        Number of coins on its own line
    Constraints:
        Dispense fewest coins possible

    Formula:
        coins % coin_value to find remainder
        coins / coin_value to find number of coins

    Psuedo Code:
        Input coin value
        Find number of quarters, round to whole number, and turn them to strings
        Find remaining value
        Find number of dimes, round to whole number, and turn them to strings
        Find remaining value
        Find number of nickles, round to whole number, and turn them to strings
        Find remaining value
        have coin remainder by the pennies
        print the number of each coin on its own line

# Get Number Of Coins
coins = int(input("Enter the coin amount: "))
# Get number of Quarters, make whole number
quarters = str(round((coins / 5)))
# Subtract quarters
coins %= 25
# Get number of Dimes, make whole number
dimes = str(round((coins / 5)))
# Subtract dimes
coins %= 10
# Get number of Nickles, make whole number
nickles = str(round((coins / 5)))
# Subtract nickles
coins %= 5
# Assign remainder of coins to Pennies
coins = str(coins)
# Print Coins
print("Quarters: " + quarters +
      "\nDimes: " + dimes +
      "\nNickels: " + nickles +
      "\nPennies: " + coins)

    Imporvements:
        I could find how many dollars they have before counting the quarters, so that there wouldn't
        be as many quarters given out.

Problem 13:
    Reqs:
        Enter a year month and day
        Format date month day year
    Assumptions:
        Date is entered yyyymmdd
        Alway will enter 8 digits
        Month needs to be spelled out
    Psuedo Code:
        Input 8 digit number
        Turn First four digits into year
        Turn next two digits into month
        Turn Month Number into Spelt Out Month
        Turn last two digits into day
        Concatinate month day, year
        print date

# Input Date
date = input("Enter a date (yyyymmdd): ")
# Seperate Out Year
year = date[:4]
# Seperate Out Month
month = date[4:6]
# Spell out month based on month's number
# January
if(month == "01"):
    month = "January"
# Febuary
elif(month == "02"):
    month = "Febuary"
# March
elif(month == "03"):
    month = "March"
# April
elif(month == "04"):
    month = "April"
# May
elif(month == "05"):
    month = "May"
# June
elif(month == "06"):
    month = "June"
# July
elif(month == "07"):
    month = "July"
# August
elif(month == "08"):
    month = "August"
# September
elif(month == "09"):
    month = "September"
# October
elif(month == "10"):
    month = "October"
# November
elif(month == "11"):
    month = "November"
# December
else:
    month = "December"
# Seperate Out Day
day = date[6:]
# Print Date
print("The Date You Entered Is " + month + " " + day + ", " + year)

    The thing I could improve is to give the user an error when they entered a none
    exisent day or month. I also could account for global events that happen that day.

Problem 19:
    Reqs:
        Inputs Hours, Minutes, Seconds
        Output speed at which runner needs to run

    Assumptions:
        Needs to be in MPH
        Marathon is 26.2 miles

    Formula:
        time = h + (m / 60) + (s / 60 / 60)
        26.2 / time = speed

    Psuedo Code:
        Get Inputs
        Convert Time into Hours
        Find Speed
        Round Speed
        Print Speed


#Get Inputs
hours = float(input("Enter Hour: "))
minutes = float(input("Enter Minutes: "))
seconds = float(input("Enter Seconds: "))
#Convert Time
run_time = hours + (minutes / 60) + ((seconds / 60) / 60)
#Find Speed
speed = 26.2 / run_time
#Round Speed
speed = str(round(speed, 3))
#Print Speed
print("You Must Run " + speed + " mph")

    Improvments:
        I could have only asked for one input and the user puts in the hour minute
        and seconds onto one line
'''