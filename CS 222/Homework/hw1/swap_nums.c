/***********************************************************
*  Name: Daniel Rustrum                                    *
*  Date: 01/31/2018                                        *   
*  File: swap_nums.c                                       *
*  Description: Asks for two numbers, then prints them,    *
*    then swap them, then prints them.                     *
***********************************************************/

#include <stdio.h>

int main() {
    int number1 = 0;
    int number2 = 0;
    int tempnum = 0;

    printf("Enter number 1:");
    scanf("%d", &number1);

    printf("Enter number 2:");
    scanf("%d", &number2);

    printf("number 1 = %d\n", number1);
    printf("number 2 = %d\n", number2);

    tempnum = number1;
    number1 = number2;
    number2 = tempnum;

    printf("number 1 = %d\n", number1);
    printf("number 2 = %d\n", number2);

    return 0;
}