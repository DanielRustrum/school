#include "Memory.h"
#include "ConfigAccess.h"

Boolean allocate(int memCode)
{
    int *codes = splitCode(memCode);

    struct MemoryNode *currentNode = mmu.firstNode;

    while(currentNode != NULL)
    {
        Boolean condition1 = codes[1] + codes[2] >= currentNode->start;
        Boolean condition2 = codes[1] + codes[2] <= (currentNode->start + currentNode->size);

        Boolean condition3 = codes[1] >= currentNode->start;
        Boolean condition4 = codes[1] <= (currentNode->start + currentNode->size);

        if((condition1 && condition2) || (condition3 && condition4))
        {
            free(codes);
            return False;
        }
        else
        {
            currentNode = currentNode->nextNode;
        }
    }

    mmu.memoryAvailable = mmu.memoryAvailable - codes[3];

    if(mmu.memoryAvailable <= 0)
    {
        mmu.memoryAvailable = mmu.memoryAvailable + codes[3];
        free(codes);
        return False;
    }

    struct MemoryNode newNode;
    newNode.memCode = memCode;
    newNode.start = codes[1];
    newNode.size = codes[1] - codes[2];
    newNode.prevNode = mmu.lastNode;
    newNode.nextNode = NULL;
    
    if(mmu.firstNode == NULL)
    {
        mmu.firstNode = &newNode;
    }

    mmu.lastNode = &newNode;
    free(codes);
    return True;
}


void deAllocate(ConfigDataType *config)
{
    mmu.firstNode = NULL;
    mmu.lastNode = NULL;
    mmu.memoryAvailable = config->memAvailable;
}

int* splitCode(int memCode)
{
    int i;
    int *numberArray = calloc(8, sizeof(int));
    for ( i = 0; i < 8; ++i, memCode /= 10 )
    {
        numberArray[i] = memCode % 10;
    }
    
    int code1 = (numberArray[7]*10) + numberArray[6];
    int code2 = (numberArray[5]*100) + (numberArray[4]*10) + numberArray[3];
    int code3 = (numberArray[5]*100) + (numberArray[4]*10) + numberArray[3];

    free(numberArray);

    int *result = calloc(8, sizeof(int));
    result[0] = code1;
    result[1] = code2;
    result[2] = code3;
    return result;
}

void memStart(ConfigDataType *config)
{
    mmu.firstNode = NULL;
    mmu.lastNode = NULL;
    mmu.memoryAvailable = config->memAvailable;
}

void memStop()
{
    mmu.firstNode = NULL;
    mmu.lastNode = NULL;
    mmu.memoryAvailable = 0;
}

