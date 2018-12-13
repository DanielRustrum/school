#include "ProcessControlBlock.h"
#include "Cycle.h"
#include "MetaDataAccess.h"
#include "ConfigAccess.h"
#include "StringUtils.h"
#include "Memory.h"

void setupPCB(OpCodeType *codes, ConfigDataType* config)
{
    printf("%3.6f, OS: Create Process Control Blocks\n",  getTimer());
    Preemptive = False;
    PCL.frontTime = NULL;
    PCL.currentTime = NULL;

    setupProcesses(codes, config);
    setupCycles(config);
    memStart();
    printf("%3.6f, OS: All processes initialized in New state\n",  getTimer());
}

void queueProcessesFCFS(OpCodeType *codes)
{
    OpCodeType **codesList = splitCodes(codes);
    Process *createdProcess;
    int index = 0, index2 = 0;

    while(codesList != NULL)
    {
        while(codesList[index2] != NULL)
        {
            createdProcess = initProcess(codesList[index2], index2);
            if(PCB.frontProcess == NULL)
            {
                PCB.frontProcess = createdProcess;
            }
            createdProcess = createdProcess->next;
            index2++;
        }

        if(PCB.frontProcess == NULL)
        {
            PCB.frontProcess = createdProcess;
        }

        if(codesList[index]->next == NULL)
        {
            PCB.lastProcess = createdProcess;
        }
        index++;
    }

}


void queueProcessesSJF(OpCodeType *codes)
{
    OpCodeType **codesList = splitCodes(codes);
    OpCodeType *Processcodes;
    Process *createdProcess;
    int index = 0, index2 = 0, index3 = 0;
    int shortestCycle = PCL.frontTime->cycleTime;

    while(codesList != NULL)
    {
        while(codesList[index2] != NULL)
        {
            while(PCL.currentTime == NULL)
            {
                if(shortestCycle > PCL.currentTime->cycleTime)
                {
                    shortestCycle = PCL.currentTime->cycleTime;
                    PCL.shortestTime = PCL.currentTime;
                }
                PCL.currentTime = PCL.currentTime->nextTime;
            }

            createdProcess = initProcess(PCL.shortestTime->codes, index2);

            PCL.shortestTime->nextTime->prevTime = PCL.shortestTime->prevTime->nextTime;
            PCL.shortestTime->prevTime->nextTime = PCL.shortestTime->nextTime->prevTime;

            if(PCB.frontProcess == NULL)
            {
                PCB.frontProcess = createdProcess;
            }
            createdProcess = createdProcess->next;
            index2++;
        }

        if(PCB.frontProcess == NULL)
        {
            PCB.frontProcess = createdProcess;
        }

        if(codesList[index]->next == NULL)
        {
            PCB.lastProcess = createdProcess;
        }
        index++;
    }
}

void setupProcesses(OpCodeType *codes, ConfigDataType* config)
{
    switch(config->cpuSchedCode)
    {
        case CPU_SCHED_SJF_N_CODE:
            queueProcessesSJF(codes);
            break;
		case CPU_SCHED_SRTF_P_CODE:
            queueProcessesSJF(codes);
            Preemptive = True;
            break;
		case CPU_SCHED_FCFS_P_CODE:
            queueProcessesFCFS(codes);
            Preemptive = True;
            break;
		case CPU_SCHED_RR_P_CODE:
            queueProcessesFCFS(codes);
            Preemptive = True;
            break;
		case CPU_SCHED_FCFS_N_CODE:
            queueProcessesFCFS(codes);
            break;
    }
}


void runPCB(ConfigDataType *config)
{
    runNextProcess(config);
}

void runNextProcess(ConfigDataType *config)
{
    int error = 0;
    Process *currentProcess;
    while(error == 0)
    {
        if(checkForInterupt())
        {
            currentProcess = resolveIntrupt(PCB.frontProcess,PCB.nextProcess);
        }
        else
        {
            currentProcess = PCB.nextProcess;
        }

        error = runOperation(currentProcess, config);
        sendProcessToBack(currentProcess);

        deAllocate(config);

        if(error != 0)
        {
            printf("Segmentaion Fault");
        }

        if(PCB.nextProcess->next != NULL)
        {
            PCB.nextProcess = PCB.nextProcess->next;
        }
        else
        {
            break;
        }
    }
}

void cleanPCB()
{
    memStop();
    PCB.frontProcess = NULL;
    PCB.nextProcess = NULL;
}

void sendProcessToBack(Process *ranProcess)
{
    PCB.frontProcess = ranProcess->next;
    if(ranProcess->cyclesLeft != 0)
    {
        ranProcess->next = NULL;
        PCB.lastProcess->next = ranProcess;
        PCB.lastProcess = ranProcess;
    }
}

OpCodeType** splitCodes(struct OpCodeType *codes)
{
    OpCodeType** codeList;
    int index = 0;
    int cycletime = 0;
    codes = codes->next;
    codeList[index] = codes;
    while(codes->opLtr != 'S')
    {
        cycletime += codes->opValue;
        if(codes->opLtr == 'A' && compareString(codes->opName, "end"))
        {
            index++;
            codeList[index] = codes->next;
            TTList TTL;
            TTL.cycleTime = cycletime;
            TTL.nextTime = NULL;
            TTL.prevTime = PCL.currentTime;
            TTL.codes = codes->next;
            if(PCL.frontTime == NULL)
            {
                PCL.frontTime = PCL.currentTime;
            }
            cycletime = 0;
            
        }
        codes = codes->next;
    }
    return codeList;
}