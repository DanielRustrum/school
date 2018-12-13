'''
Number One
    Problem:
        The Monkey has to climb a 100 foot tree. Every minute that has gone passed the monkey would have climbed up three feet and fallen two feet.
        I need to figure out how long the monkey will take to get to the top of the tree.

    Contraints:
        Tree - 100 feet
        Monkey climbs one foot per minute
        Must get to top of Tree

    Assumptions:
        Monkey Height - 1 foot

    Inputs/Outputs:
        Input-
            Start Program
        Output-
            Notify when monkey climbed the tree
            Notify Monkey's Position

    Pseudo Code:
        Set up monkey_position Varible
        Get Starting Position From User
        Set Up monkey_time varible equal to 0
        Turn monkey_position into int
        Test if monkey is at top of tree minus the Height of the monkey
            If True:
                Stop while loop
                convert monkey_time into string
                print "The Monkey Made It" + monkey_time + " minutes!"
            If False:
                Add += 1 To monkey_position
                Add += 1 To monkey_time
                Test Condition Again


Number Two
    Problem:
        There were Three Contestants Adam, Joan, And Linus. Charles Saw That Adam won and Joan got second. Ada saw that Joan won and Linus got second.
        They each have one false fact and one true fact. I need to find the actual ranking of the contestants

    Contraints:
        They each have one false fact and one true fact
        Ada Saw JLA
        Charles Saw AJL

    Assumptions:
        We can assume the third place is mostly true

    Inputs/Outputs:
        Input:
            Is Adam First
        Output:
            Adam is First-
                ALJ
            Adam is Second-
                JAL


    Pseudo Code:
        Set up is_adam_first varible
        Get value from User And Assign it to is_adam_first varible
        Test if is_adam_first equals "true" or equals "True"
            If True:
                print "The Contestant Placement Is:"
                On its own line print contestants in the order Adam, Linus, Joan
            If False:
                print "The Contestant Placement Is:"
                On its own line print contestants in the order Joan, Adam, Linus
'''

#Number One Code
print("*Problem One* \n")    #Nortify What Problem User Is On

monkey_position = input("Set Where Monkey Starts(Must Be A Number): ")    #Set User Input As Monkey's Position On Tree
monkey_position = int(monkey_position)  #Make Monkey_Position From String Into Interger
monkey_time = 0     #Set Up Monkey Time Varible
while (monkey_position < 100):  #Test If Monkey Is Still Climbing Tree
    monkey_position += 1    #Add One To Monkey Position
    monkey_time += 1    #Add One Minute To Monkey_Time
if (monkey_position >= 100):    #Test If Monkey Made It To The Top Of The Tree
    monkey_time = str(monkey_time)  #Convert monkey_time into string
    print("The Monkey Made It In " + monkey_time + " Minutes!")    #Print That The Monky Made It To The Top Of The Tree

#Intermission
next_problem_ready = input("Type 'Next' If Your Ready For The Next Problem: ") # Grab User Input And Assign It To next_problem_ready
if (next_problem_ready == "Next"):  #Test If next_problem_ready equals "Next"
    print("Continuing!")    #Notify User
else:   #If User Didn't Type "Next"
    exit() #End Program

# Number Two Code
print("*Problem Two*\n")    #Nortify What Problem User Is On

is_adam_first = input("Input True If Adam Was First, Otherwise Enter False: ")      #Grab User Input and Assign It To is_adam_first varible
if(is_adam_first == "True" or is_adam_first == "true"):                             #Test If Input Is True If Adam Is In First
    print("The Contestant Placement Is: \n 1. Adam \n 2. Linus \n 3. Joan")         #Print Order Of Contestants
if(is_adam_first == "False" or is_adam_first == "false"):                           #Test If Input Is False
    print("The Contestant Placement Is: \n 1. Joan \n 2. Adam \n 3. Linus")         #Print Order Of Contestants If Adam Isn't In First

'''
Number One Reflection:
    What I did was take the position the user wants the monkey to be at it will calculate how long it will take for the monkey to climb from there. Fortunately, my plan worked the first time,
    all I had to do was declare a varible and keep track of said varible

Number Two Relfection:
    What I did was have the user decide if adam was first or not, then gave the positions based on that. I didn't understand how the question wanted me to get the outcome so, I went through seeing if
    it would make sense if the outcome will have any conflicts with any other outcomes in the line up evetually ending up with two results

'''