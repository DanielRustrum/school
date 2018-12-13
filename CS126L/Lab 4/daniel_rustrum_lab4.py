__author__ = "Nate Zeleny"


# Define letter grade
def percentage(work, max):
    # Set average score to zero
    average_score = 0
    # find average score
    average_score = sum(work)/sum(max)
    # Return average score
    return average_score


# Define letter grade
def letter_grade(percentage):
    # Check if 90 percent
    if percentage >= 90:
        # Give an A
        return "A"
    # Check if 80 percent
    elif percentage >= 80:
        # Give an B
        return "B"
    # Check if 70 percent
    elif percentage >= 70:
        # Give an C
        return "C"
    # Check if 60 percent
    elif percentage >= 60:
        # Give an D
        return "D"
    # Otherwise fail assignment
    else:
        # Give an F
        return "F"


# Define weighted score
def weighted_score(percent, weight):
    # multiply weighted with percentage
    weighted = percent * weight
    # Return weighted
    return weighted


# Define main function
def main():
    # Set Up
    Homework_Correct = [39, 40, 29, 40, 0, 5]  # List for points on homework
    Homework_total = [40, 40, 40, 40, 40, 5]  # List for homework max score
    Quizzes_Correct = [10, 10, 9, 2, 10, 10, 10]  # List for points on Quizzes
    Quiz_total = [10, 10, 10, 10, 10, 10, 10]  # List for homework max score
    Test_Correct = [293, 284, 300]  # Listfor points on Tests
    Test_total = [300, 300, 300]  # List for homework max score
    # Homework percentage
    homework_score = percentage(Homework_Correct, Homework_total)*100
    # Quiz Percentage
    quiz_score = percentage(Quizzes_Correct, Quiz_total)*100
    # Test Percentage
    test_score = percentage(Test_Correct, Test_total)*100
    # Homework grade
    homework_grade = letter_grade(homework_score)
    # Quiz grade
    quiz_grade = letter_grade(quiz_score)
    # Test grade
    test_grade = letter_grade(test_score)
    # Get weighted homework grade
    w_homework_score = weighted_score(homework_score, .20)
    # Get weighted quiz grade
    w_quiz_score = weighted_score(quiz_score, .20)
    # Get weighted test grade
    w_test_score = weighted_score(test_score, .60)

    #  get total score
    total_score = (w_homework_score + w_quiz_score + w_test_score)
    total_grade = letter_grade(total_score)
    # Print Results
    print("Homework Grade:", round(homework_score, 2), homework_grade)
    print("Quiz Grade:", round(quiz_score, 2), quiz_grade)
    print("Test Grade:", round(test_score, 2), test_grade)
    print("Final Grade:", round(total_score, 2), total_grade)
main()
