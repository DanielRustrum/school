#include <pthread.h>
#include "simtimer.h"
#include "StringUtils.h"
#include "Cycle.h"

void startTimer()
{
    accessTimer(ZERO_TIMER, " ");
}

double getTimer()
{
    double timer = accessTimer(LAP_TIMER, "  ");
    return timer;
}

void* cycleSpin(void* cycleTime)
{
    runTimer(*(int*)cycleTime);
    pthread_exit(NULL);
}

void cycleOperation(int cycles)
{
    pthread_t thread;
    int cycleTime = cycles * quantum;
    pthread_create(&thread, NULL, cycleSpin, (void*)&cycleTime);
    pthread_join(thread, NULL);
    interupt++;
}

Boolean checkForInterupt()
{
    return False;
}

Boolean checkforProcessSwitch()
{
    if(checkForInterupt())
    {
        return True;
    }
    if(quantumCount >= quantum)
    {
        quantumCount = 0;
        return True;
    }
    return False;
}

void setupCycles(ConfigDataType* config)
{
    interupt = 0;
    quantum = config->quantumCycles;
    quantumCount = 0;
}