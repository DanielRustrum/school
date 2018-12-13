CC = gcc
DEBUG = -g
CFLAGS = -Wall -std=c99 -pedantic -c $(DEBUG)
LFLAGS = -Wall -std=c99 -pedantic $(DEBUG)

PA04 : PA04.o MetaDataAccess.o ConfigAccess.o StringUtils.o Cycle.o ProcessControlBlock.o simtimer.o Memory.o Process.o
	$(CC) $(LFLAGS) PA04.o MetaDataAccess.o ConfigAccess.o StringUtils.o Cycle.o ProcessControlBlock.o simtimer.o Memory.o Process.o -o PA04 -lpthread

PA04.o : PA04.c
	$(CC) $(CFLAGS) PA04.c

MetaDataAccess.o : MetaDataAccess.c MetaDataAccess.h
	$(CC) $(CFLAGS) MetaDataAccess.c

ConfigAccess.o : ConfigAccess.c ConfigAccess.h
	$(CC) $(CFLAGS) ConfigAccess.c

StringUtils.o : StringUtils.c StringUtils.h
	$(CC) $(CFLAGS) StringUtils.c

Cycle.o : Cycle.c Cycle.h
	$(CC) $(CFLAGS) Cycle.c

ProcessControlBlock.o : ProcessControlBlock.c ProcessControlBlock.h
	$(CC) $(CFLAGS) ProcessControlBlock.c

Process.o : Process.c Process.h
	$(CC) $(CFLAGS) Process.c

simtimer.o : simtimer.c simtimer.h
	$(CC) $(CFLAGS) simtimer.c
	
Memory.o : Memory.c Memory.h
	$(CC) $(CFLAGS) Memory.c
clean:
	\rm *.o *.*~ PA02
