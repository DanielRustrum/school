/***********************************************************
*  Name: Daniel Rustrum                                    *
*  Date: 00/00/2018                                        *   
*  File:                                                 *
*  Description:                                          *
*                                                        *
*                                                        *
***********************************************************/

#include <stdio.h>

int main() {
    int rank = 4;

    scanf("%d", &rank);

    switch(rank)
    {
        case 1:
        case 2: printf("Lower Division");
            break;
        case 3:
        case 4: printf("Upper Division");
            break;
        case 5: printf("Graduate Student");
            break;
        default: printf("Invalid Rank");
            break;
    }
    
    return 0;
}