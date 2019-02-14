/***********************************************************
*  Name: Daniel Rustrum                                    *
*  Date: 00/00/2018                                        *   
*  File:                                                 *
*  Description:                                          *
*                                                        *
*                                                        *
***********************************************************/

#include <stdio.h>
#include <stdbool.h>

#define FILE_NAME "hw2.log"

int main() {
    bool isrunning = true;
    char letter;
    FILE *fileptr;
    fileptr = fopen(FILE_NAME, "w");

    do {
        printf("Enter A grade A,B,C,D,F (q to quit): ");
        scanf("%c", &letter);
        switch (letter)
        {
            case 'q':
                isrunning = false;
                break;
            case 'A':
                printf("Very Good!\n");
                fprintf(fileptr,"Very Good!\n");
                break;
            case 'B':
                printf("Good!\n");
                fprintf(fileptr,"Good!\n");
                break;
            case 'C':
                printf("Okay!\n");
                fprintf(fileptr,"Okay!\n");
                break;
            case 'D':
                printf("Doomed!\n");
                fprintf(fileptr,"Doomed!\n");
                break;
            case 'F':
                printf("Doomed!\n");
                fprintf(fileptr,"Doomed!\n");
                break;
            default:
                break;
        }
    } while(isrunning);
  
    fclose(fileptr);
    return 0;
}