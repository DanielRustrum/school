// Pre-compiler directive
#ifndef META_DATA_ACCESS_H
#define META_DATA_ACCESS_H

// header files
#include <stdio.h> // for file access
#include "StringUtils.h"

// global constants

typedef enum { MD_FILE_ACCESS_ERR = 3,
	MD_CORRUPT_DESCRIPTOR_ERR,
	OPCMD_ACCESS_ERR,
	CORRUPT_OPCMD_LETTER_ERR,
	CORRUPT_OPCMD_NAME_ERR,
	CORRUPT_OPCMD_VALUE_ERR,
	UNBALANCED_START_END_ERR,
	COMPLETE_OPCMD_FOUND_MSG,
	LAST_OPCMD_FOUND_MSG } OpCodeMessages;

typedef struct OpCodeType
{
	char opLtr;
	char opName[ 100 ];
	int opValue;

	struct OpCodeType *next;
} OpCodeType;

// function prototypes
int getOpCodes( char *fileName, OpCodeType **opCodeDataHead );
OpCodeType *addNode( OpCodeType *localPtr, OpCodeType *newNode );
int getOpCommand( FILE *filePtr, OpCodeType *inData );
Boolean checkOpString( char *testStr );
Boolean isDigit( char testChar );
OpCodeType *clearMetaDataList( OpCodeType *localPtr );
int updateStartCount( int count, char *opString );
int updateEndCount( int count, char *opString );
void displayMetaData( OpCodeType *localPtr );
void displayMetaDataError( int code );
OpCodeType *clearMetaDataList( OpCodeType *localPtr );

#endif
