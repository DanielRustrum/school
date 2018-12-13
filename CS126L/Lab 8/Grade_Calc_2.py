def percentage_per_category(score_list, max_list):
    '''
    Calculates the percentage in a given category
    '''
    points_earned = sum(score_list)
    total_points = sum(max_list)
    percentage = float(points_earned/total_points)
    return percentage * 100


def letter_grade(percent):
    '''
    Calculates the letter grade given the percent of a category
    '''
    if percent >= 90:
        return "A"
    elif percent >= 80:
        return "B"
    elif percent >= 70:
        return "C"
    elif percent >= 60:
        return "D"
    else:
        return "F"


def weighted_score(percentage, weight):
    '''
    Calculates the weighted score of a category
    '''
    return percentage*weight


def read_grade_data(file):
    # Open File
    input_filehandle = open(file, 'r')
    # Define Grade Dictionary
    grade_dictionary = {}
    # Separate lines of data
    for line in input_filehandle:
        strippedline = line.strip()
        # Separate line into parts
        splitline = strippedline.split(' ')
        grades = " ".join(splitline[2:])
        # Create Dictionary
        grade_dictionary[splitline[0]] = [splitline[1], grades.split(",")]
    # Close File
    input_filehandle.close()
    # return Data
    return grade_dictionary


def write_grade_report(filehandle, data):
    # Open File
    html_file = open(filehandle, 'r+')
    # Write File
    # Create a string to write to the html file
    html = '<html><head>\n\
<meta http-equiv="content-type" content="text/html; charset=windows-1252"></head><body>\
<h1>Homework Statistics (10.0)</h1>\n\
<ul>\n\
  <li><b>Average: </b>' + data['homework'][0] + '</li>\n\
  <li><b>Letter Grade: </b>' + data['homework'][1] + '</li>\n\
  <li><b>Overall Grade Contribution: </b>' + data['homework'][2] + '</li>\n\
</ul>\n \
<h1>Quizzes Statistics (10.0)</h1>\n\
<ul>\n\
  <li><b>Average: </b>' + data['quiz'][0] + '</li>\n\
  <li><b>Letter Grade: </b>' + data['quiz'][1] + '</li>\n\
  <li><b>Overall Grade Contribution: </b>' + data['quiz'][2] + '</li>\n\
</ul>\n\
<h1>Tests Statistics (35.0)</h1>\n\
<ul>\n\
  <li><b>Average: </b>' + data['test'][0] + '</li>\n\
  <li><b>Letter Grade: </b>' + data['test'][1] + '</li>\n\
  <li><b>Overall Grade Contribution: </b>' + data['test'][2] + '</li>\n\
</ul>\n\
<h1>Projects Statistics (30.0)</h1>\n\
<ul>\n\
  <li><b>Average: </b>' + data['project'][0] + '</li>\n\
  <li><b>Letter Grade: </b>' + data['project'][1] + '</li>\n\
  <li><b>Overall Grade Contribution: </b>' + data['project'][2] + '</li>\n\
</ul>\n\
<h1> Final Statistics (15.0)</h1>\n\
<ul>\n\
  <li><b>Average: </b>' + data['final'][0] + '</li>\n\
  <li><b>Letter Grade: </b>' + data['final'][1] + '</li>\n\
  <li><b>Overall Grade Contribution: </b>' + data['final'][2] + '</li>\n\
</ul>\n\
<h1>Cumulative Grade</h1>\n\
<ul>\n\
  <li><b>Average: </b>' + data['cumulative'][0] + '</li>\n\
  <li><b>Letter Grade: </b>' + data['cumulative'][1] + '</li>\n\
</ul>\n\
</body></html>'
    print(html)
    html_file.write(html)
    # Close File
    html_file.close()


def main():
    file = read_grade_data("lab8input.txt")
    output_dic = {'homework': [], 'quiz': [], 'test': [], 'project': [], 'final': []}

# Final
    final_list = []
    max_final = []
    min_final = []

    # separate max and min
    for j in range(len(file['Final'][1])):
        # Split Final
        final = file['Final'][1][j]
        x = final.split('/')
        final_list.append(x)

    # Assign max and min values
    for k in range(len(final_list)):
        max_final.append(int(final_list[k][1]))
        min_final.append(int(final_list[k][0]))

    # Get Percentage
    final_percentage = percentage_per_category(min_final, max_final)

    # Get Final Weight
    pre_final_weight = float(file['Final'][0].strip('%')) / 100

    # Get Weighted Percentage
    final_weight = weighted_score(final_percentage, pre_final_weight)

    # Get Letter Grade
    final_letter = letter_grade(final_percentage)

    # Add data to output_dic
    output_dic['final'] = [str(round(final_percentage)/100), final_letter, str(final_weight)]

# Tests
    tests_list = []
    max_tests = []
    min_tests = []

    # separate max and min
    for j in range(len(file['Tests'][1])):
        # Split Tests
        tests = file['Tests'][1][j]
        x = tests.split('/')
        tests_list.append(x)

    # Assign max and min values
    for k in range(len(tests_list)):
        max_tests.append(int(tests_list[k][1]))
        min_tests.append(int(tests_list[k][0]))

    # Get Percentage
    test_percentage = percentage_per_category(min_tests, max_tests)

    # Get Test Weight
    pre_test_weight = float(file['Tests'][0].strip('%')) / 100

    # Get Weighted Percentage
    test_weight = weighted_score(test_percentage, pre_test_weight)

    # Get Letter Grade
    test_letter = letter_grade(final_percentage)

    # Add data to output_dic
    output_dic['test'] = [str(round(test_percentage)/100), test_letter, str(test_weight)]

# Homework
    homework_list = []
    max_homework = []
    min_homework = []

    # separate max and min
    for j in range(len(file['Homework'][1])):
        # Split Homework
        homework = file['Homework'][1][j]
        x = homework.split('/')
        homework_list.append(x)

    # Assign max and min values
    for k in range(len(homework_list)):
        max_homework.append(int(homework_list[k][1]))
        min_homework.append(int(homework_list[k][0]))

    # Get Percentage
    homework_percentage = percentage_per_category(min_homework, max_homework)

    # Get Homework Weight
    pre_homework_weight = float(file['Homework'][0].strip('%')) / 100

    # Get Weighted Percentage
    homework_weight = weighted_score(homework_percentage, pre_homework_weight)

    # Get Letter Grade
    homework_letter = letter_grade(homework_percentage)

    # Add data to output_dic
    output_dic['homework'] = [str(round(homework_percentage)/100), homework_letter, str(homework_weight)]

# Quizzes
    quizzes_list = []
    max_quizzes = []
    min_quizzes = []

    # separate max and min
    for j in range(len(file['Quizzes'][1])):
        # Split Quizzes
        quizzes = file['Quizzes'][1][j]
        x = quizzes.split('/')
        quizzes_list.append(x)

    # Assign max and min values
    for k in range(len(quizzes_list)):
        max_quizzes.append(int(quizzes_list[k][1]))
        min_quizzes.append(int(quizzes_list[k][0]))

    # Get Percentage
    quizzes_percentage = percentage_per_category(min_quizzes, max_quizzes)

    # Get Quiz Weight
    pre_quizzes_weight = float(file['Quizzes'][0].strip('%')) / 100

    # Get Weighted Percentage
    quizzes_weight = weighted_score(quizzes_percentage, pre_quizzes_weight)

    # Get Letter Grade
    quizzes_letter = letter_grade(quizzes_percentage)

    # Add data to output_dic
    output_dic['quiz'] = [str(round(quizzes_percentage)/100), quizzes_letter, str(quizzes_weight)]

# Projects
    projects_list = []
    max_project = []
    min_project = []

    # separate max and min
    for j in range(len(file['Projects'][1])):
        # Split Projects
        projects = file['Projects'][1][j]
        x = projects.split('/')
        projects_list.append(x)

    # Assign max and min values
    for k in range(len(projects_list)):
        max_project.append(int(projects_list[k][1]))
        min_project.append(int(projects_list[k][0]))

    # Get Percentage
    project_percentage = percentage_per_category(min_project, max_project)

    # Get Project Weight
    pre_project_weight = float(file['Projects'][0].strip('%')) / 100

    # Get Weighted Percentage
    project_weight = weighted_score(project_percentage, pre_project_weight)

    # Get Letter Grade
    project_letter = letter_grade(project_percentage)

    # Add data to output_dic
    output_dic['project'] = [str(round(project_percentage)/100), project_letter, str(project_weight)]

# Cumulative Grade
    # Get Cumulative Grade Average
    cumulative_percentage = round(((final_percentage * pre_final_weight) + (test_percentage * pre_test_weight) +
                                  (homework_percentage * pre_homework_weight) + (quizzes_percentage *
                                  pre_quizzes_weight) + (project_percentage * pre_project_weight)))/100

    # Get Cumulative Grade
    cumulative_letter = letter_grade(cumulative_percentage)

    # Add data to output_dic
    output_dic['cumulative'] = [str(cumulative_percentage), cumulative_letter]

# write data
    write_grade_report('grade_calc_output.html', output_dic)
main()
