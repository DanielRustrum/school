# Authors Daniel Rumstrum and Roger Sinnott
import random


# Credits
def credits():
	# Print Authors
	print("Made by Daniel Rustrum and Roger Sinnott")


# Start Game when Called
def game_start():
    # Define Correct
    correct = 0
    # Dictionary for questions and answers
    questions = [
        {'question': "How many light minutes are we from the sun? ", 'Answer': ['8', '6', '11', '42'], 'Correct': "1"},
        {'question': "Whats the name of the 9th planet?", 'Answer': ['Jupiter', "doesn't exist", "pluto", "Saturn"],
         'Correct': "2"},
        {'question': "how far in light years is the closest black hole? ",
         'Answer': ["27,000", "30,000", "6,000", "120,000"], 'Correct': "1"},
        {'question': "what is the name of our galaxy? ", 'Answer': ["halbert", "Milky Moo", "Milky Way", "Tater Tots"],
         'Correct': "3"},
        {'question': "How is the sun in kelvin?", 'Answer': ["5,778", "6,788", "3", "90,000,000"], 'Correct': "1"},
        {'question': "How far is Jupiter? (million KM)", 'Answer': ["60", "522", "768", "588"], 'Correct': "4"},
        {'question': "what is the diameter of Mars in miles? ", 'Answer': ["5,667", "4,212", "567", "9,001"],
         'Correct': "2"},
        {'question': "What color is mars depicted as?", 'Answer': ["periwinkle", "coral", "black", "red"],
         'Correct': "4"},
        {'question': "What circles the Earth?", 'Answer': ["Moon", "Mars", "Captain Fallon", "A sandwich"],
         'Correct': "1"},
        {'question': "How far is the closest star?",
         'Answer': ["8 light minutes", "32 light years", "22 feet", "78 schmecles"], 'Correct': "1"}
        ]

    # Randomize Questions
    random.shuffle(questions)

    # Iterate through each question
    for i,question in enumerate(questions):
        print(str(i + 1)+ ". " + question["question"])
        for choice in enumerate(question["Answer"]):
            print("\t" + choice[1])
        while(True):
            answer = int(input("Choose an Answer and enter 1-4: "))
            int(question["Correct"])
            if answer == int(question["Correct"]):
                print("Correct!")
                correct += 1
                break
            elif answer > 4 or answer < 1:
                print("Enter A Valid Response! Now!")
            else:
                print("Awwwwwww, Im sorry, That Wrong!")
                break

    # Print Scores
    print("You Scored %i of 10" % correct)
# EC: High score table with name and scores


# insert main menu here
def menu():
    in_game = True
    print("Welcome To Space Adventure.com.net.io\n")
    print("Type Play, Quit,or Credits to proceed")
    # loop infinately
    while in_game:
        response = input(">> ").upper()
        if response == "PLAY":
            game_start()
        elif response == "QUIT":
            print("Okay")
            in_game = False
        elif response == "CREDITS":
            credits()
        else:
            print("You typed an incorrect response. Dangus Con!")


# Define Main Function
def main():
    menu()

# Call Main Function
main()
