// header files
#include <stdio.h>
#include "ConfigAccess.h"
#include "MetaDataAccess.h"
#include "ProcessControlBlock.h"
#include "Cycle.h"

/*
 * Function name: main
 * Algorithm: driver function to test file upload operation
 * Precondition: none
 * Postcondition: returns zero on success
 * Exceptions: none
 * Notes: demonstrates development and use of file upload function
 */
int main( int argc, char **argv )
{
	//initialize function/variables
	int configAccessResult;
	char configFileName[ MAX_STR_LEN ];
	ConfigDataType *configDataPtr;
	int mdAccessResult;
	char mdFileName[ MAX_STR_LEN ];
	OpCodeType *mdData;

	// display component title
		// function: printf
	printf( "\nConfig File Upload Component\n" );
	printf( "============================\n\n" );

	// check for not correct number of command line args
	if( argc < 2 )
	{
		//print missing command line arg error
			// function: printf
		printf( "ERROR: Program requires file name for config file " );
		printf( "as command line argument\n" );
		printf( "Program Terminated\n" );

		// return non-normal program result
		return 1;
	}

	// get data from config file
		// function: copyString, getConfigData
	copyString( configFileName, argv[ 1 ] );
	configAccessResult = getConfigData( configFileName, &configDataPtr );

	// check for successful upload
	if( configAccessResult == NO_ERR )
	{
		// display config file
			// function: displayConfigData
		//displayConfigData( configDataPtr );
	}

	// otherwise, assume failed upload
	else
	{
		// display config upload error
			// function: displayConfigError
		displayConfigError( configAccessResult );
	}

	// get data from meta data file
		// function: copyString, getOpCodes
	copyString( mdFileName, configDataPtr->metaDataFileName );
	mdAccessResult = getOpCodes( mdFileName, &mdData );

	// check for successful upload
	if( mdAccessResult == NO_ERR )
	{
		// display meta data file
			// function: displayMetaData
		//displayMetaData( mdData );
	}

	// otherwise, assume unsuccessful upload
	else
	{
		// display meta data error message
			// function: displayMetaDataError
		displayMetaDataError( mdAccessResult );
	}

	printf("--------------------------\n");
	printf("Begin Simulation\n\n");
	
	//Start System
	printf("%3.6f, OS: System Start\n", 0.0);
	startTimer();

	//Run PCB
	setupPCB(mdData, configDataPtr);
	runPCB(configDataPtr);
	cleanPCB();

	//System Stop
	printf("%3.6f, OS: System Stop\n", getTimer());

	printf("\n\nEnd Simulation - Complete");

	// shut down, clean up program
	
		// clear config data
			// function: clearConfigData
		clearConfigData( &configDataPtr );

		// clear meta data
			// function: clearMetaDataList
		mdData = clearMetaDataList( mdData );

		// add endLine for vertical spacing
			// function: printf
		printf( "\n" );


	// return success
	return 0;
}

