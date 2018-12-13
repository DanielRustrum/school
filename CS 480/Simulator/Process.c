#include "Process.h"

char* optcodePrinter(char opLetter)
{
    char* opString;
    opString = "";

    if(opLetter == 'P')
    {
        opString = "operation";
    }
    if(opLetter == 'M')
    {
        opString = "allocation";
    }
    if(opLetter == 'I')
    {
        opString = "input";
    }
    if(opLetter == 'O')
    {
        opString = "output";
    }

    return opString;
}

void changeState(char* newstate, Process* currentProcess)
{
    currentProcess->state = newstate;
    printf("Process %s: set into the %s state ", currentProcess->processName, newstate);
}

int runOperation(Process *currentProcess, ConfigDataType *config)
{
    int error = 0;
    int processID = currentProcess->processID;
    OpCodeType *opWalker = currentProcess->opCode;
    char *opString = "";
    printf("%3.6f, OS: Process %i selected\n",  getTimer(), processID);
    
    changeState("Running", currentProcess);

    while( opWalker != NULL)
    {
        opString = optcodePrinter(opWalker->opLtr);

        if(opWalker->opLtr == 'A' && compareString(opWalker->opName, "end") == 0)
        {
            currentProcess = currentProcess->next;
        }

        if(opWalker->opLtr != 'S' && opWalker->opLtr != 'A')
        {
            printf("%3.6f, process:%i, %s %d start\n",  getTimer(), processID, opWalker->opName, opWalker->opLtr);
            error = runOpHelper(opWalker, currentProcess, config);
            printf("%3.6f, process:%i, %s %d end\n",  getTimer(), processID, opWalker->opName, opWalker->opLtr);
        }
        
        if(checkforProcessSwitch())
        {
            currentProcess->opCode = opWalker->next;
            changeState("Exiting",currentProcess);
            return 0;
        }
        else
        {
            opWalker = opWalker->next;
            nextQuantumCycle(currentProcess);
        }

    }
    changeState("Exiting",currentProcess);
    return error;
}

int runOpHelper(OpCodeType opCode, Process *currentProcess, ConfigDataType* config)
{
    if(opCode.opLtr == 'M')
    {
        allocate(opCode.opValue);
    }
    if(opCode.opLtr == 'I')
    {
        changeState("Waiting",currentProcess);
        cycleOperation( opCode.opValue);
        changeState("Running",currentProcess);
    }
    return 0;
}



Process* initProcess(struct OpCodeType *codes, int index)
{
    int index2 = 0;
    int cycleCounter = 0;
    Process *newProcess;
    newProcess->state = "NEW";
    newProcess->processID = index;
    newProcess->processName = "P" + newProcess->processID;
    newProcess->inIO = False;

    while(True)
    {
        if(codes[index2].opLtr != 'A' || codes[index2].opLtr != 'S')
        {
            cycleCounter += codes[index2].opValue;
        }
        if(codes[index2].next == NULL)
        {
            break;
        }
        index2++;
    }

    newProcess->cyclesLeft = cycleCounter;
    newProcess->opCode = codes;
    return newProcess;
}

Process* resolveIntrupt(Process *frontProcess, Process *nextProcess)
{
    Process *tempProcess = frontProcess;
    while(tempProcess != NULL)
    {
        if(tempProcess->inIO)
        {
            return tempProcess;
            interupt--;
        }
    }
    return nextProcess;
}

void nextQuantumCycle(Process* currentProcess)
{
    quantum++;
    currentProcess->cyclesLeft--;
}
