# story about a college student and how well he does in school

print("you are a student who has walked into class late \n \
 the professor tells you can either stay after class \n \
 and do your work or leave")

# saving choice_1 as the user input
choice_1 = input("Do you STAY or LEAVE: ").lower()
# Lowercase Choice
# choice_1 = (choice_1).lower()
# print(choice_1)
# the start of the if/else statements
if (choice_1 == "stay"):
    # continue story
    print("the teacher hands you a worksheet after class \n \
and tells you have 20 minutes to work on it, \n \
after looking at it you can tell it will take longer")
    # user input with three choices
    choice_1_2 = input("do you ask for MORE TIME, \
try to come back TOMORROW, or try and FINISH: ").lower()
    # Decide Which Choice Is Selected
    if choice_1_2 == "more time":
        print("The teacher asks for how much time is needed.")
        choice_1_3 = float(input("Input a number for how long it will take \
in minutes: "))
        try:
            if choice_1_3 <= 30:
                print("He states that he is fine with that. You \n \
spend the time to finish your work and get a good grade.")
            else:
                print("The teacher states he that can't stay past that time, \n \
so both of them will have to leave. you spent the rest \n \
of the time finishing the assignment, but ended up failing.")
        except:
            print("You should have entered a number")
    elif choice_1_2 == "tomorrow":
        print("The teacher accepts your statement with a big smile on his \
face. You come back tomorrow and get an A.")
    elif choice_1_2 == "finish":
        print("The Teacher thanks you for tring, but you get a C.")
    else:
        print("You Didn't Select A Right Statement")
elif (choice_1 == "leave"):
    print("you can't decide to either go to the mall or do your homework.")
    choice_2 = input("Do you go to the MALL or do your HOMEWORK: ").lower()
    if choice_2 == 'homework':
        print("You get your homework done and turn it in late. You \n \
end up getting a B.")
    elif choice_2 == 'mall':
        print("you fail the assignment and the teacher is mad at you.")
    else:
        print("You Didn't Select A Right Statement")
else:
    print("You Didn't Select A Right Statement")
