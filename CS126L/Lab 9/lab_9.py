import turtle

__author__ = 'Daniel Rustrum and Nate Zeleny'
'''
    Mathematical Concepts:
        star size = round(10.0/(magnitude+2))
'''


# Read Coord
def read_coord(file):
    # Open File
    handler = open(file, 'r')
    # Create Magintude Dictionary
    mag_dict = {'magnitude': [], 'dapper': []}
    # Create Coord Dictionary
    coord_dict = {'x': [], 'y': []}
    # Create Name Dictionary
    name_dict = {'name': [], 'harvard': []}
    # Split Lines Into Its Specified Dictionary
    for lines in handler:
        # x,y,z, dapper, mag, harvard, name(maybe)
        # Split Line and Get rid of \n
        formatted_line = lines.strip('\n').split(" ")
        # Set X Coord to x index
        coord_dict['x'].append(formatted_line[0])
        # Set Y coord to Y index
        coord_dict['y'].append(formatted_line[1])
        # Set Magnitude to magnitude index
        mag_dict['magnitude'].append(formatted_line[4])
        # Set Dapper Number to dapper Index
        mag_dict['dapper'].append(formatted_line[3])
        # Set harvard number to harvard index
        name_dict['harvard'].append(formatted_line[5])
        # test if there is more than 7 words in file line
        if len(formatted_line) >= 7:
            # join the star names together
            star_name = ' '.join(formatted_line[6:])
            # Set the star name to the name index
            name_dict['name'].append(star_name)
        else:
            # If there is no name set name to a black space
            name_dict['name'].append(' ')
    # Combine dictionaries into a tuple
    tup_dict = (coord_dict, mag_dict, name_dict)
    # Return tuple
    return tup_dict


def plot_plain_stars(picture_size, coordinates_dict):
    # Set Screen Size
    turtle.setup(picture_size, picture_size)
    # Set Background black
    turtle.bgcolor('black')
    turtle.pencolor('black')
    # Set Pen To Up
    turtle.penup()
    # Turn Off The Tracer
    turtle.tracer(0)
    # set speed
    turtle.speed(1)
    # set fill and begin
    turtle.fillcolor('white')
    for count in range(len(coordinates_dict['x'])):
        # Get Coords For X and Y
        x = float(coordinates_dict['x'][count]) * picture_size // 2
        y = float(coordinates_dict['y'][count]) * picture_size // 2
        # Pick Up Pen
        turtle.penup()
        # Go To X,Y
        turtle.goto(x, y)
        # Begin Turtle Fill
        turtle.begin_fill()
        # Create Square
        for i in range(4):
            turtle.forward(2)
            turtle.right(90)
        # End Fill
        turtle.end_fill()


def plot_by_magnitude(picture_size, coordinates_dict, magnitude_dict):
    # Set Screen Size
    turtle.setup(picture_size, picture_size)
    # Set Background black
    turtle.bgcolor('black')
    turtle.pencolor('black')
    # Set Pen To Up
    turtle.penup()
    turtle.tracer(0)
    # set speed
    turtle.speed(1)
    # set fill and begin
    turtle.fillcolor('white')
    for count in range(len(coordinates_dict['x'])):
        # Get Coords
        x = float(coordinates_dict['x'][count]) * picture_size // 2
        y = float(coordinates_dict['y'][count]) * picture_size // 2
        # Get Magnitude
        magnitude = round(10.0/(float(magnitude_dict['magnitude'][count])+2))
        # Set Max Magnitude if over the max
        if magnitude > 8:
            magnitude = 8
        turtle.penup()
        # Go To X,Y
        turtle.goto(x, y)
        # Begin fill
        turtle.begin_fill()
        # Create Square
        for i in range(4):
            turtle.forward(magnitude)
            turtle.right(90)
        # End fill
        turtle.end_fill()


def main():
    # Define Screen Size to Be 1000
    screen_size = 1000
    # Read star.txt
    file_data = read_coord('stars.txt')
    # Call Function Plot By Magintude
    plot_by_magnitude(screen_size, file_data[0], file_data[1])
    # End program when clicked on
    turtle.exitonclick()
main()
