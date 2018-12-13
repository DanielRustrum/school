#include "ConfigAccess.h"
#include <sys/time.h>

int interupt;
int quantum;
int quantumCount;

void startTimer();
double getTimer();
void* cycleSpin(void* cycleTime);
void cycleOperation(int cycles);
void printWithTimer(char *logString);
Boolean checkForInterupt();
Boolean checkforProcessSwitch();
void setupCycles(ConfigDataType *config);