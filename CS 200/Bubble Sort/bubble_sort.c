// Bubble sort
#include <stdio.h>

void bubbleSort(int*, int);

void fillArrayWithZeros(int*, int);

void fillArrayWithNumbers(int*, int);

void display(int*, int);

void swap(int*, int*);

int main(void){
    printf("Hello!\n\n\n\n");
    int numberAmount = 0;
    // Ask user for number amount to sort
    printf("Please enter how many numbers you want to sort (up to 20):\n\t");
    // Get Number Amount
    scanf("%d",&numberAmount);
    // Create number array
    // If Sorting is Valid
    if(numberAmount < 2) {
        printf("Since you have fewer than two numbers, they are already sorted!\n");
    }
    else {
        int numbers[numberAmount];
        fillArrayWithZeros(numbers, numberAmount);
        fillArrayWithNumbers(numbers, numberAmount);
        bubbleSort(numbers, numberAmount);
        display(numbers, numberAmount);
    }
}

void bubbleSort(int numbers[3], int numberAmount){
    int loopNumber = 0;
    while (loopNumber < numberAmount) {           
        // Bubble Sort Numbers
        int i, j;
        for (i = 0; i < numberAmount-1; i++)      
        
            // Last i elements are already in place   
            for (j = 0; j < numberAmount-i-1; j++) 
                if (numbers[j] > numbers[j+1])
                    swap(&numbers[j], &numbers[j+1]);
        
        loopNumber++;
    }   
}

void fillArrayWithZeros(int* numbers, int numberAmount){
    int i = 0;
    while(i < numberAmount){
        numbers[i] = 0;
        i++;
    }
}

void fillArrayWithNumbers(int* numbers, int numberAmount) {
    int i = 0;
    while(i < numberAmount){

        int enteredNumber = 0;
        // Ask user to enter number
        printf("Please Enter the next number:\n\t");
        
        // Grab number to sort
        scanf("%d",&enteredNumber);
        numbers[i] = enteredNumber;
        i++;
    }
}

void display(int* numbers, int numberAmount) {
    // Notify that this is the output
    printf("Here are the results:\n");
    
    // Loop to print out values
    int printIndex = 0;
    for(int j = 0; j < numberAmount; j++) {
        printIndex = numbers[j];
        printf("%d ", printIndex);
    }
    // print newline after numbers
    printf("\n");
}

void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}