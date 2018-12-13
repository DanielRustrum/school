CC = gcc
CFLAGS = -Wall -Wextra -std=c11


maze_runner: maze_runner.o runner.o mazelib.o

maze_runner.o: maze_runner.c mazelib.h runner.h

runner.o: runner.c mazelib.h

mazelib.o: mazelib.c mazelib.h