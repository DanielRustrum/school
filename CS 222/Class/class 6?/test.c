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
    float y;
    float x = 15;
    float x1 = 10;
    float y1 = 100;
    float x2 = 20;
    float y2 = 150;

    y = y1 + (
            (x-x1) / 
            (x2-x1)
        ) * (y2-y1);

    printf("%9.6f",y);

    return 0;
}