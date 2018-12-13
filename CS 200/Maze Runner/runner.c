#include "runner.h"
#include "mazelib.h"
#include <stdio.h>

// Set up 
int x;
int y;
direction facing;
char wallFacing;

void turnLeft(void);
void turnRight(void);
void move(void);
void getFacingWall();
void dropCookie();

void runner_init(void) {
    x = 1;
    y = 1;
    facing = EAST;
    wallFacing = ' ';
}

void runner_solve(void) {
    // Sorter
    while (maze_get_char(x, y) != 'E')
    {
        turnRight();
        while(wallFacing == '#') {
            turnLeft();
        }
        move();
        dropCookie();
    }
}

void turnLeft(void){
    if (facing == SOUTH) { facing = WEST; }
    else if (facing == WEST) { facing = NORTH; }
    else if (facing == NORTH) { facing = EAST; }
    else if (facing == EAST) { facing = SOUTH; }
    getFacingWall();
}

void turnRight(void){
    if (facing == SOUTH) { facing = EAST; }
    else if (facing == WEST) { facing = SOUTH; }
    else if (facing == NORTH) { facing = WEST; }
    else if (facing == EAST) { facing = NORTH; }
    getFacingWall();
}

void move(){
    if (facing == NORTH) { y = y - 1; }
    if (facing == SOUTH) { y = y + 1; }
    if (facing == EAST) { x = x + 1; }
    if (facing == WEST) { x = x - 1; }
}

void getFacingWall() {
    if (facing == NORTH) { wallFacing = maze_get_char(x, y-1); }
    if (facing == SOUTH) { wallFacing = maze_get_char(x, y+1); }
    if (facing == EAST) { wallFacing = maze_get_char(x+1, y); }
    if (facing == WEST) { wallFacing = maze_get_char(x-1, y); }
}

void dropCookie(void){
    if (maze_get_char(x, y) == ' ') { maze_set_char(x, y, '.'); }
    else if (maze_get_char(x, y) == '.') { maze_set_char(x, y, 'o'); }
    else if (maze_get_char(x, y) == 'o') { maze_set_char(x, y, 'O'); }
    else if (maze_get_char(x, y) == 'O') { maze_set_char(x, y, '@'); }
}