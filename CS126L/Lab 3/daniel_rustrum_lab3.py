# Import Random module
import random

# Grab the number of questions the user wants to answer
question_count = int(input("How many questions?: "))


# Define the functionality of the beginner questions
def beginner_questions():
    # Set the number of questions correct to 0
    questions_correct = 0
    # Set the number of questions answered to 0
    answer = 0
    # Set up operator
    operator = ""

    # loop for the of questions the user desires
    for i in range(0, question_count):
        # Choose a random operator
        question_operator = random.randint(0, 1)
        # Pick number betwen 1 through 10
        n1 = random.randint(1, 10)
        # Pick number betwen 1 through 10
        n2 = random.randint(1, 10)
        # if operator 0 is chosen assign +
        if question_operator == 0:
            # Create question
            answer = n1 + n2
            # Set operator to +
            operator = "+"
        # if operator 0 is chosen assign +
        elif question_operator == 1:
            # Create question
            answer = n1 - n2
            # Set operator to -
            operator = "-"
        # Display the question and Get users attempt at the question
        attempt = int(input("What is %i %s %i: " % (n1, operator, n2)))
        # Check if attempt is correct
        if attempt == answer:
            # Display correct
            print("correct")
            # Increment the number of correct questions
            questions_correct += 1
    # Display good job message if number of correct is greater than 50 percent
    if questions_correct > (question_count//2):
        print("You answered %i questions out of %i...good job!" %
              (questions_correct, question_count))
    # Display try again message if number of correct is lower than 50 percent
    else:
        print("You answered %i questions out of %i...get some help" %
              (questions_correct, question_count))


# Define the functionality of the intermediate questions
def intermediate_questions():
    # Set the number of questions correct to 0
    questions_correct = 0
    # loop for the of questons the user desires
    for i in range(0, question_count):
        # Choose a random operator
        question_operator = random.randint(0, 3)
        # Pick number between 1 through 25
        n1 = random.randint(1, 25)
        # Pick numer betwen 1 through 2
        n2 = random.randint(1, 25)
        # if operator 0 is chosen assign +
        if question_operator == 0:
            # Create question
            answer = n1 + n2
            # Set operator to +
            operator = "+"
        # if operator 1 is chosen assign -
        elif question_operator == 1:
            # Create question
            answer = n1 - n2
            # Set operator to -
            operator = "-"
        # if operator 2 is chosen assign *
        elif question_operator == 2:
            # Create question
            answer = n1 * n2
            # Set operator to *
            operator = "*"
        # if operator 3 is chosen assign /
        else:
            # Create question
            answer = n1/n2
            # Set operator to /
            operator = "/"
        # Display the question and Get users attempt at the question
        attempt = int(input("What is %i %s %i: " % (n1, operator, n2)))
        # Check if attempt is correct
        if attempt == answer:
            # Display correct
            print("correct")
            # Increment the number of correct questions
            questions_correct += 1
        # Print Incorrect
        else:
            print("incorrect")
    # Display good job message if number of correct is greater than 50 percent
    if questions_correct > (question_count//2):
        print("You answered %i questions out of %i...good job!" %
              (questions_correct, question_count))
    # Display try again message if number of correct is lower than 50 percent
    else:
        print("You answered %i questions out of %i...get some help" %
              (questions_correct, question_count))


def problem_check(answer, attempt, questions_correct):
    # Set attempt equal to attempt
    attempt1 = attempt
    # Check if attempt is equal to answer
    if attempt1 == answer:
        # Print correct
        print("correct")
        # Increment correct
        questions_correct += 1
        # return the incremented questions
        return questions_correct
    else:
        # Print incorrect
        print("incorrect")


def advanced_questions():
    # Set the number of questions correct to 0
    questions_correct = 0
    # Execute if number of question is greater than 0
    if question_count >= 1:
        # Pick numer betwen 1 through 10
        n1 = random.randint(0, 10)
        # Pick numer betwen 1 through 10
        n2 = random.randint(0, 10)
        # Display the question and Get users attempt at the question
        attempt = int(input("What is %i / %i: " % (n1, n2)))
        # Create question
        answer = n1 / n2
        # Check if problem is correct set it equal to questions_correct
        questions_correct = problem_check(answer, attempt, questions_correct)
    # Execute if number of question is greater than 1
    if question_count >= 2:
        # Pick numer betwen 1 through 10
        n1 = random.randint(0, 10)
        # Pick numer betwen 1 through 10
        n2 = random.randint(0, 10)
        # Display the question and Get users attempt at the question
        attempt = int(input("What is %i to the power of %i: " % (n1, n2)))
        # Create question
        answer = n1**n2
        # Check if problem is correct set it equal to questions_correct
        questions_correct = problem_check(answer, attempt, questions_correct)
    # Execute if number of question is greater than 2
    if question_count >= 3:
        # Pick numer betwen 1 through 10
        n1 = random.randint(0, 10)
        # Pick numer betwen 1 through 10
        n2 = random.randint(0, 10)
        # Pick numer betwen 1 through 10
        n3 = random.randint(0, 10)
        # Display the question and Get users attempt at the question
        attempt = int(input("What is %i times %i plus %i: " % (n1, n2, n3)))
        # Create question
        answer = n1*n2+n3
        # Check if problem is correct set it equal to questions_correct
        questions_correct = problem_check(answer, attempt, questions_correct)
    # Execute if number of question is greater than 3
    if question_count >= 4:
        # Pick numer betwen 1 through 10
        n1 = random.randint(0, 10)
        # Pick numer betwen 1 through 10
        n2 = random.randint(0, 10)
        # Display the question and Get users attempt at the question
        attempt = int(input("What is %i modulus %i: " % (n1, n2)))
        # Create question
        answer = n1 % n2
        # Check if problem is correct set it equal to questions_correct
        questions_correct = problem_check(answer, attempt, questions_correct)
    # Execute if number of question is greater than 4
    if question_count >= 5:
        # Pick numer betwen 1 through 1000
        n1 = random.randint(0, 1000)
        # Pick numer betwen 1 through 1000
        n2 = random.randint(0, 1000)
        # Display the question and Get users attempt at the question
        attempt = int(input("What is %i to the power of %i: " % (n1, n2)))
        # Create question
        answer = n1**n2
        # Check if problem is correct set it equal to questions_correct
        questions_correct = problem_check(answer, attempt, questions_correct)

    if questions_correct > (question_count//2):
        print("You answered %i questions out of %i...good job!" %
              (questions_correct, question_count))

    else:
        print("You answered %i questions out of %i...get some help" %
              (questions_correct, question_count))

# Check if the user wants to do some problems
if question_count > 0:
    # ask the user for difficulty
    difficulty = input("What difficulty do you want?\
(Type beginner, intermediate, or advanced): ").lower()
    # execute if user enter beginner
    if difficulty == "beginner":
        # call beginner questions
        beginner_questions()
    # execute if user enter intermediate
    elif difficulty == "intermediate":
        # call intermediate questions
        intermediate_questions()
    # execute if user enter advance
    elif difficulty == "advanced":
        # call advance questions
        advanced_questions()
    # execute if user doesn't enter correct info
    else:
        print("error")
# Display a message to the user when 0 or less question is picked
else:
    print("There's No Problems To Do!")
