# Write a function that takes in (at least) a list containing dollar amounts for items purchased and calculates a tip based on level of service.
# Write a function that takes in a list containing dollar amounts for items purchases and a tax rate, and calculates the tax amount.
# Write a function that takes in (at least) a price and a Boolean variable (representing whether the price is for a service that you wish to
#       leave a tip for) and calculates the total cost for the item including tax and tip (if appropriate). Note: The solution to #3 should use the functions you built in #1 and #2.

'''
    Reqs:
        3 functions tip_calc, tax_calc, bill_calc
        tip calc needs bill and percentage, calculates tip
        tax calc needs bill and tax rate, calculates tax
        bill needs tip wanted and items
        user inputs 4 varibles
        function 1 and 2 in function 3
    Assumptions:
        user inputs when needed
        user has all info
        numbers aren't decimal
    I/O:
        Item prices, tip_wanted, tax_rate, tip_rate
        Total_price

'''


def tip_calc(bill=[], percent=15):
    bill_total = 0
    for calc in range(0,len(bill)):
        int(bill[calc])
        bill_total = bill_total + bill[calc]
    percentage = percent * .01
    total = bill_total * percentage
    return total


def tax_calc(bill=[], rate=9):
    bill_total = 0
    for calc in range(0, len(bill)):
        int(bill[calc])
        bill_total += bill[calc]
    percentage = rate * .01
    total = bill_total * percentage
    return total


def pay_bill(price, add_tip=False):
    tax_rate = int(input('What is the tax rate: '))
    tax = tax_calc(price, tax_rate)
    price += tax
    if add_tip is True:
        tip_rate = int(input('What is the rate you would want to tip at: '))
        tip = tip_calc(price, tip_rate)
        price += tip
    return price


def main():
    # Get Inputs
    items = input('seperate each item with a space: ')
    tip_wanted = bool(input('Do you want to tip(enter True or False): '))
    items.split(' ')
    pay_bill(items, tip_wanted)
main()


'''
    Reflect:
        I use three functions
        two of those are in other varibles
        I passed in user inputs

    Improvements:
        I could get the code to work

'''