import random

# Create Card
class Card:
    def __init__(self, card_num):
        # seperate the deck for the number
        self.card_info_num = card_num % 13
        # Find Card Suit
        if card_num >= 0 and card_num < 13:
            self.card_suit = "Spades"
        elif card_num >= 13 and card_num < 26:
            self.card_suit = "Hearts"
        elif card_num >= 26 and card_num < 39:
            self.card_suit = "Clubs"
        else:
            self.card_suit = "Diamonds"

        # Set number cards
        if self.card_info_num < 10 and self.card_info_num != 0:
            self.card_rank = str(self.card_info_num + 1)
            self.card_value = self.card_rank
        # Set Ace rank and value
        elif self.card_info_num == 0:
            self.card_rank = 'Ace'
            self.card_value = '11'
        # Set Jack rank and value
        elif self.card_info_num == 10:
            self.card_rank = 'Jack'
            self.card_value = '10'
        # Set Queen rank and value
        elif self.card_info_num == 11:
            self.card_rank = 'Queen'
            self.card_value = '10'
        # Set King rank and value
        elif self.card_info_num == 12:
            self.card_rank = 'King'
            self.card_value = '10'

        # Set Card To Not Visible
        self.card_visible = False

    # Return Suits
    def get_suit(self):
        return self.card_suit

    # Return Rank
    def get_rank(self):
        return self.card_rank

    # Return Value
    def get_value(self):
        return self.card_value

    # Make Card Not Visible
    def face_down(self):
        self.card_visible = False

    # Make Card Visible
    def face_up(self):
        self.card_visible = True

    # Print Rank And Suit If Card Is Face Up
    def __str__(self):
        if self.card_visible:
            return '%s of %s' % (self.card_rank, self.card_suit)
        else:
            return '<facedown>'


# Create Chip Bank
class ChipBank:
    def __init__(self, value):
        self.value = value
        self.output_string = ''
        self.black = 0
        self.green = 0
        self.red = 0
        self.blue = 0
        self.total = 0

    # Withdraw Chips
    def withdraw(self, amount):
        # Test if amount is greater than bank
        # return appropriate response
        if self.value >= amount:
            self.value -= amount
            return 'you took out %s' % str(amount)
        else:
            self.output_string = 'you took out %s' % str(self.value)
            self.value = 0
            return self.output_string

    # Deposit Chips
    def deposit(self, amount):
        self.value += amount

    # Get Current Chip Balance
    def get_balance(self):
        return str(self.value)

    # return the minimum amount of chips
    def __str__(self):
        self.total = self.value
        self.black = self.total // 100
        self.total %= 100
        self.green = self.total // 25
        self.total %= 25
        self.red = self.total // 5
        self.total %= 5
        self.blue = self.total

        self.output_string = '%s blacks, %s greens, %s reds, %s blues - totalling $%s'\
                             % (str(self.black), str(self.green), str(self.red),
                                str(self.blue), str(self.value))
        return self.output_string


def main():
    if __name__ == "__main__":
        deck = []
        for i in range(52):
            my_card = Card(i)
            deck.append(my_card)
            my_card.face_up()
            print(my_card)
        print(random.choice(deck))
        card = Card(37)
        print(card)
        print(card.get_value())
        print(card.get_suit())
        print(card.get_rank())
        card.face_down()
        print(card)
        card.face_up()
        print(card)

        cs = ChipBank(149)
        print(cs)
        cs.deposit(7)
        print(cs.get_balance())
        print(cs)
        print(cs.withdraw(84))
        print(cs)
        cs.deposit(120)
        print(cs)
        print(cs.withdraw(300))
main()
