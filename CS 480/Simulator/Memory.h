#include "StringUtils.h"
#include "ConfigAccess.h"

typedef struct MemoryNode
{
    int size;
    int memCode;
    int start;
    struct MemoryNode *nextNode;
    struct MemoryNode *prevNode;
} MemoryNode;

typedef struct MMU {
    struct MemoryNode* firstNode;
    struct MemoryNode* lastNode;
    int memoryAvailable;
} MMU;

struct MMU mmu;

Boolean allocate(int memCode);
void deAllocate(ConfigDataType *config);
int* splitCode(int memCode);
void memStart();
void memStop();
