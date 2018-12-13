#include "Cycle.h"
#include "MetaDataAccess.h"
#include "ConfigAccess.h"
#include "StringUtils.h"

typedef struct Process 
{
    char *state;
    int processID;
    char* processName;
    struct OpCodeType *opCode;
    Boolean inIO;
    int cyclesLeft;

    struct Process *next;
} Process;

char* optcodePrinter(char opLetter);
void changeState(char* newstate, Process *currentProcess);
int runOperation(Process* currentProcess, ConfigDataType *config);
Process* initProcess(OpCodeType *codes, int index);
Process* resolveIntrupt();
void nextQuantumCycle();
