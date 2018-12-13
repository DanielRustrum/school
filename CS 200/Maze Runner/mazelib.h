#ifndef _maze_h
#define _maze_h
#include <stdbool.h>

//---- Directional Constants ------------------------------------------------//
typedef enum { NORTH = 0, EAST, SOUTH, WEST } direction;

//---- Function Prototypes

// Initializes the maze according to the width and height passed in.  The width and height should both be
// greater than 8.  The width should also be less than 80 and the height should be less than 26.
//
// The start of the maze is always in the upper left of the maze at coordinates (1, 1) and is marked with
// an 'S'.  Likewise the exit or end of the maze is always in the lower right corner and marked with an
// 'E'.  The coordinates of the exit vary since mazes of different sizes may be used
bool maze_init(int width, int height);

// Gets the width of the maze.  This and the following function both return -1 in case of an error.  This
// could be caused by calling either of these functions before calling maze_init().
int  maze_get_width(void);

// Gets the height of the maze.  This and the following function both return -1 in case of an error.  This
// could be caused by calling either of these functions before calling maze_init().
int  maze_get_height(void);

// returns true if the coordinate supplied is within the bounds of the maze and false otherwise.
bool maze_is_coord_in_bounds(int x, int y);

// Returns the character in the maze at a given coordinate.  A return value of '#' represents a wall, 'S'
// represents the starting place of the robot, 'E' represents the exit and ' ' represents an open space.
char maze_get_char(int x, int y);

// This function can be used to set a character in the maze to something new.  It will not set a square
// that's filled with a wall ('#'), the start of the maze marker ('S'), or the end of the maze marker
// ('E').
bool maze_set_char(int x, int y, char new_val);

// This function prints the maze as it currently is
void maze_print(void);

#endif
