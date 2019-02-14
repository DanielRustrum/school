ProjectName=projectname
Standard=-std=c66
CFlags=-Wall

OFiles=main.o
Files=main.c

$(ProjectName): $(OFiles)
	gcc $(OFiles) -o $(ProjectName)

$(OFiles): $(Files)
	gcc -c $(Files)

clean:
	rm -f *.o $(ProjectName)