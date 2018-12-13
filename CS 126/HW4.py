# 5-5 5-6 5-10

# 5-5:
'''
    Reqs:
        last digit needs to be the same to return true
        needs three numbers

    Assumptions:
        User will enter a number

    psuedo code:
        grab input
        define same last digit
        grab last digit
        compare

# get input
n1 = input("enter number: ")
n2 = input("enter number: ")
n3 = input("enter number: ")
# define last digit
def same_last(n1,n2,n3):
    # grab last digit
    n1 = int(n1[-1])
    n2 = int(n2[-1])
    n3 = int(n3[-1])
    # compare
    if (n1 == n2) and (n2 == n3):
        return True
    else:
        return False
# call function
call = same_last(n1,n2,n3)
print(call)

    output:
        with the input 1 1 51
        it prints true
    improvments:
        I didn't have to change the string into an integer it would have worked fine as a string
'''
# 5-6:
'''
    requirements:
        Three numbers
        returns second highest
    Assumptions:
        user will enter a number
        numbers doesn't need to be in order
    Psuedo Code:
        Get Inputs
        Define Function
        compare numbers
        return number
# get input
n1 = int(input("enter number: "))
n2 = int(input("enter number: "))
n3 = int(input("enter number: "))
def second_highest(n1,n2,n3):
    highnum = 0
    # compare nums
    for i in range(0,n1+n2+n3):
        if i == n1 or i == n2 or i == n3:
            highnum += 1
        if highnum is 2:
            return i
# call function
call = second_highest(n1,n2,n3)
print(call)

    output:
        Entered 50,22,30
        returned 30

    improvments:
        I could find a way to get the second number without a loop
'''
# 5-10:
'''
    Reqs:
        seconds till midnight
        user enters time as string
    Assuptions:
        24 hour system
    formula:
        hour *60 * 60
        min * 60
        time - mid
    psuedo code:
        Get Input
        turn to seconds
        Calculate seconds
        return seconds

# Get input
time = input("what time is it(hhmmss): ")
# Define function
def til_midnight(time):
    # Setup hour
    hour = int(time[:2])
    # Setup minutes
    minutes = int(time[2:4])
    # Setup seconds
    seconds = int(time[4:])
    # Setup midight
    midnight = 86400
    # convert
    hour = hour * 60 *60
    # convert
    minutes = minutes * 60
    # find seconds
    seconds = hour + minutes + seconds
    # find time till midnight
    time_til = midnight - seconds
    # return function
    return time_til
mid = til_midnight(time)
print(mid)

    output:
        Entered 102030
        returned 49170
    improvments:
        I could have made it easier for the user to input the time
'''