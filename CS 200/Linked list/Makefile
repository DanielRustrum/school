CFLAGS=-O0 -Wall -Wextra

run_tests: tests
	./tests

tests: tests.o linked_list.o

tests.o: tests.c linked_list.h

linked_list.o: linked_list.c linked_list.h


.PHONY: clean debug run_tests

debug: CFLAGS += -g
debug: clean
debug: tests

clean:
	rm -f *.o run_tests
