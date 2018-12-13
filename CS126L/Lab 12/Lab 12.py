# Import all of random
import random

__author__ = "Daniel Rustrum and Hannah Hoxworth"


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


class BlackjackHand():
    def __init__(self):
        # A BlackjackHand doesn't take in any params, but it will need to
        # set-up a list for storing Cards
        
        # create list
        self.cards = []
        # set-up varible for score
        self.score = 0
        

    def add_card(self, new_card):
        # Adds a Card to Hand
        self.cards.append(new_card)

    def get_value(self):
        # Returns a numeric point value of the current hand. This should be
        # the sum of the point values of each card. In our implementaion
        # of blackjack, an Ace should be either 11 points, or 1, to give the
        # player the highest score without exceeding 21. Hint: First count
        # the total points assuming all aces are 11, along with the number
        #  of aces, then decrement point total as the rules allow.
        
        # Iterate through list
        for i in range(len(self.cards)):
            # Test if card is ace and score is less than 11
            if self.cards[i].get_value() == '11' and 11 < self.score:
                # Add one to score
                self.score += 1
            # Otherwise
            else:
                # Add card rank to score
                self.score += int(self.cards[i].get_value)
        # Return Score
        return self.score

    def __str__(self):
        # Returns a string of the current hand. The resulting string should
        # contain the __str__() value of each card, delimited by commas.
        
        # Iterate through list except for the last card
        for i in range(len(self.cards)-1):
            # Format output string
            self.output += self.cards[i] + ","
        # Add last card to string without a comma
        self.output += self.cards[-1]
        # return string
        return self.output

class Blackjack():
    # BANK
    # A instance varible should store the users ChipBank. The instance
    # variable will be created during the __init__()
    def __init__(self, starting_dollars):
        # Creates a new Blackjack games in which the player starts with
        # 'starting_dollars' worth of money. This method will need to set up
        # instance varibles to support the rest of the game. This should
        # initialize the deck, and player's chip stack.
        # Remember to shuffle the deck after you create it.

        # Params:
        # starting_dollars: Initial amount of money the player has to wager.
        
        # Initialize Bank
        self.bank = ChipBank(starting_dollars)
        # Set up wager variable
        self.wager = 0
        # Initialize game_active var
        self.is_active = False
        # Initialize deck
        self.deck = []
        # Create Deck
        for i in range(52):
            # Add Card to deck
            self.deck.append(Card(i))
        # Shuffle deck
        random.shuffle(self.deck)


    def draw(self):
        # This method draws and return a card from the deck. If the deck is
        # empty when this method is called, rebuild and reshuffle the deck.
        # Make sure that all cards are drawn face up. Return a card object
        # after it is removed the deck.

        # Return:
        # A card object removed from deck

        # Test if deck is empty
        if self.deck is []:
            # Rebuild deck
            for i in range(52):
                # Add card to deck
                self.deck.append(Card(i))
            # Shuffle deck
            random.shuffle(self.deck)
        # Get first card
        new_card = self.deck[0]
        # Turn card face up
        new_card.face_up()
        # Delete Card From Deck
        self.deck.remove(self.deck[0])
        # Return drawn Card
        return new_card

    def start_hand(self, wager):
        # Starts a new hand of blackjack. Should initialize instance variable
        # with a new hand for the player and the dealer. Remember that the
        # first dealer's card should be set face down. This object should
        # withdraw the wager amount from the ChipBank, and remember that
        # value for the end of the game. Print both the player's hand and the
        # dealer's hand to the player, and check to see if the player wins
        # automatically with blackjack. If both the player AND the dealer
        # have 21, it is a tie, or "push."
        
        # Set up Player and Dealer
        self.player = BlackjackHand()
        self.dealer = BlackjackHand()
        # Initialize Card list
        self.card = []
        # Draw four cards
        for i in range(4):
            # Add drawn card to list
            self.card.append(self.draw())
        # Add Card to dealer
        self.dealer.add_card(self.card[0])
        # Add Card to dealer
        self.dealer.add_card(self.card[1].face_up())
        # Add Card to player
        self.player.add_card(self.card[2].face_up())
        # Add Card to player
        self.player.add_card(self.card[3].face_up())

        # Withdraw wager from bank
        self.bank.withdraw(wager)
        # Remember wager
        self.wager = wager

        # Start Game
        self.is_active = True

        # Set up testing parameters for dealer
        self.dealer_points = int(self.card[0].get_value()) + \
                            int(self.card[1].get_value())
        # Set up testing parameters for player
        self.player_points = int(self.card[2].get_value()) + \
            int(self.card[3].get_value())
        # Test if push
        if self.dealer_points == 21 and self.player_points == 21:
            # End hand
            self.end_hand('Push')
        # Test if player wins
        elif self.player_points == 21:
            # End Hand
            self.end_hand('Win')

    def hit(self):
        # The player choses to hit. Draw a card for the player, and display
        # the player's new hand. If they exceed 21 they bust, and if they get
        # 21 exactly they are forced to stand. This method takes no params
        # and has no return value-
        self.drawn_card = self.draw()
        self.player.add_card(self.drawn_card)
        if self.player.get_value() == 21:
            self.stand()
        elif self.player.get_value() > 21:
            self.end_hand('Lose')

    def stand(self):
        # The player stands, and the dealer flips their hidden card face up
        # and begins the process of drawing. The dealer only draws if their
        # hand current value is 16 or less. If the dealer draws over 21, they]
        # bust and the player wins. Ties can occur and are called "pushes."
        # This method has no parameters and no return values.

        self.dealer.cards[0].face_up()
        while self.dealer.get_value() <= 16:
            new_card = self.draw()
            self.dealer.add_card(new_card)
            if self.dealer.get_value() > 16 and self.dealer.get_value() <= 21:
                if self.dealer.get_value() == self.player.get_value():
                    self.end_hand("Push")
                elif self.dealer.get_value() < self.player.get_value():
                    self.end_hand("Win")
                else:
                    self.end_hand("Lose")
            elif self.dealer.get_value() > 21:
                self.end_hand("Win")

    def end_hand(self, outcome):
        # This method should be called when a winner has been determined.
        # This method is passed a parameter outcome, which will be "win",
        # "lose", or "push" depending on if the player won, the the dealer
        # won, or their was a tie. If the playerwins they should be given
        # double their wager back. A push should refund the original wager,
        # and a lose should result in no money being deposited. This methos
        # is responsiblefor settinf the two hands and the wager to None. THIS
        # METHOD SHOULD BE CALLED BY ANY OTHER METHOD IN WHICH A WINNER IS
        # FOUND.

        # Params:
        # outcome - a string contianing either "win", "lose", or "push"

        # End Game
        self.is_active = False
        if outcome == "Win":
            self.bank.deposit((self.wager * 2))
        elif outcome == "Push":
            self.bank.deposit(self.wager)



    def game_active(self):
        # Returns True or False, indicating if there is a current hand in
        # play. Should return True when start_hand() has been called, and
        # end_hand() has not yet been called to close the game

        # Return:
        # returs a boolean value, True or False, depending on if there is an
        # active hand that has not yet been resolved.

        # Return True or False if game is active
        return self.is_active


if __name__ == '__main__':
    blackjack = Blackjack(250)
    while blackjack.bank.value > 0:
        print('Your remaining chips:' + str(blackjack.bank))
        wager = int(input("How much would you like to wager? "))
        blackjack.start_hand(wager)
        while blackjack.game_active():
            choice = input("STAND or HIT: ").upper()
            if choice == "STAND":
                blackjack.stand()
            elif choice == "HIT":
                blackjack.hit()
        print()
    print("Out OF Money! Casino Wins!")