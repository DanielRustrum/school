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
    File *fileptr;
    fopen(FILE_NAME, fileptr);

    do {
        printf("Enter the grades a,b,c,d,f (q to quit)");
        scanf("%c", &letter);
        switch (letter)
        {
            case 'q':
                isrunning = false;
                break;
            case 'A':
                printf("Very Good!");
                fprintf(fileptr,"Very Good!");
                break;
            case 'B':
                printf("Good!");
                fprintf(fileptr,"Good!");
                break;
            case 'C':
                printf("Okay!");
                fprintf(fileptr,"Okay!");
                break;
            case 'D':
                printf("Doomed!");
                fprintf(fileptr,"Doomed!");
                break;
            case 'F':
                printf("Doomed!");
                fprintf(fileptr,"Doomed!");
                break;
            default:
                isrunning = false;
                break;
        }
    } while(isrunning);
    
    fclose(fileptr);
    return 0;
}