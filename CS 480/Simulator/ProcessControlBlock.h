#include "MetaDataAccess.h"
#include "Process.h"

typedef struct ProcessControlBlock
{
    struct Process *frontProcess;
    struct Process *nextProcess;
    struct Process *lastProcess;
    char* operation;
} ProcessControlBlock;

typedef struct TTList
{
    int cycleTime;
    OpCodeType *codes;
    struct TTList *nextTime;
    struct TTList *prevTime;

} TTList;

typedef struct ProcessCodeList
{
    struct TTList *frontTime;
    struct TTList *currentTime;
    struct TTList *shortestTime;
} ProcessList;

struct ProcessControlBlock PCB;
struct ProcessCodeList PCL;
Boolean Preemptive;

void setupPCB(OpCodeType *codes, ConfigDataType* config);
void runPCB();
void cleanPCB();
void queueProcessesFCFS(OpCodeType *codes);
void queueProcessesSJF(OpCodeType *codes);
void setupProcesses();
struct Process createProcess(OpCodeType *codes);
void runNextProcess();
void sendProcessToBack(Process *ranProcess);
OpCodeType** splitCodes(struct OpCodeType *codes);
