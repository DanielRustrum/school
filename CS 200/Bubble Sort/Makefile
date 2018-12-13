CC = gcc
CFLAGS = -Wall -Wextra

bubble_sort: bubble_sort.o
	$(CC) bubble_sort.c -o bubble_sort.o $(CFLAGS)
# fill in rule for bubble_sort.o

# right above this line

.PHONY: clean debug
clean:
	rm -f bubble_sort *.o

debug: CFLAGS += -g
debug: clean bubble_sort
