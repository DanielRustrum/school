// header files
#include "ConfigAccess.h"

/*
 * Function name: getConfigData
 * Algorithm: opens file, acquires configuration data,
 * 		returns pointer to data structure
 * Precondition: for correct operation, file is available, is formatted correctly,
 * 		and has all configuration lines and data although
 * 		the configuration lines are not required to be
 * 		in a specific order
 * Postcondition: in correct operation,
 * 		returns pointer to correct configuration data structure
 * Exceptions: correct and appropriately (without program failure)
 * 		responds to and reports file access failure,
 * 		incorrectly formatted lead or end descriptors,
 * 		incorrectly formatted prompt, data out of range,
 * 		and incomplete file conditions
 * Notes: none
 */
int getConfigData( char *fileName, ConfigDataType **configData )
{
	// initialize function/variables
	
		// set constant number of data lines to 9
		const int NUM_DATA_LINES = 9;

		// set line counter to zero
		int lineCtr = 0;

		// set read only constant to "r"
		const char READ_ONLY_FLAG[] = "r";

		// create pointer for data input
		ConfigDataType *tempData;

		// declare other variables
		FILE *fileAccessPtr;
		char dataBuffer[ MAX_STR_LEN ];
		int intData, dataLineCode;
		double doubleData;

	// initialize config data pointer in case of return error
	*configData = NULL;
	
	// open file
		// function: fopen
	fileAccessPtr = fopen( fileName, READ_ONLY_FLAG );

	// check for file open failure
	if( fileAccessPtr == NULL )
	{
		// return file access error
		return CFG_FILE_ACCESS_ERR;
	}

	// get first line, check for failure
		// function: getLineTo
	if( getLineTo( fileAccessPtr, MAX_STR_LEN, COLON,
				dataBuffer, IGNORE_LEADING_WS ) != NO_ERR
			|| compareString( dataBuffer, "Start Simulator Configuration File" )
									!= STR_EQ )
	{
		// close file access
			//function: fclose
		fclose( fileAccessPtr );

		// return corrupt file data
		return CFG_CORRUPT_DESCRIPTOR_ERR;
	}

	// create temp pointer to config data structure
		// function: malloc
	tempData = (ConfigDataType *) malloc( sizeof( ConfigDataType ) );
		
	// loop to end of config data items
	while( lineCtr < NUM_DATA_LINES )
	{
		// get line leader, check for failure
			// function: getLineTo
		if( getLineTo( fileAccessPtr, MAX_STR_LEN, COLON,
					dataBuffer, IGNORE_LEADING_WS ) != NO_ERR )
		{
			// free temp struct memory
				// function: free
			free( tempData );

			// close file access
				// function: fclose
			fclose( fileAccessPtr );

			// return incomplete file error
			return INCOMPLETE_FILE_ERR;
		}

		// find correct data line by number
			// function: getDataLineCode
		dataLineCode = getDataLineCode( dataBuffer );

		// check for data line found
		if( dataLineCode != CFG_CORRUPT_PROMPT_ERR )
		{
			// get data value
				
				// check for version number (double value)
				if( dataLineCode == CFG_VERSION_CODE )
				{
					// get version number
						//function: fscanf
					fscanf( fileAccessPtr, "%lf", &doubleData );
				}

				// otherwise, check for metaData of logTo file names
				// or CPU Scheduling names (strings)
				else if( dataLineCode == CFG_MD_FILE_NAME_CODE
						|| dataLineCode == CFG_LOG_FILE_NAME_CODE
						|| dataLineCode == CFG_CPU_SCHED_CODE
						|| dataLineCode == CFG_LOG_TO_CODE )
				{
					// get string input
						// function: fscanf
					fscanf( fileAccessPtr, "%s", dataBuffer );
				}

				// otherwise, assume integer data
				else
				{
					// get integer input
						// function: fscanf
					fscanf( fileAccessPtr, "%d", &intData );
				}

			// check for data value in range
				// function: valueInRange
			if( valueInRange( dataLineCode, intData, doubleData, dataBuffer ) == True )
			{
				// assign to data pointed depending on config item
				switch( dataLineCode )
				{
					// case version code
					case CFG_VERSION_CODE:
						
						// assign version to double data
						tempData->version = doubleData;
						break;

					// case meta data file name code
					case CFG_MD_FILE_NAME_CODE:
						
						// assign version to string data
							// function: copyString
						copyString( tempData->metaDataFileName, dataBuffer );
						break;

					// case cpu schedule code
					case CFG_CPU_SCHED_CODE:

						// assign cpu schedule code using string data
							// function: getCpuSchedCode
						tempData->cpuSchedCode = getCpuSchedCode( dataBuffer );
						break;

					// case quantum cycles code
					case CFG_QUANT_CYCLES_CODE:
					
						// assign quantum cycles to int data
						tempData->quantumCycles = intData;
						break;

					// case memory available code
					case CFG_MEM_AVAILABLE_CODE:

						// assign memory available to int data
						tempData->memAvailable = intData;
						break;

					// case processor cycles code
					case CFG_PROC_CYCLES_CODE:

						// assign processor cycle rate to int data
						tempData->procCycleRate = intData;
						break;

					// case I/O cycles code
					case CFG_IO_CYCLES_CODE:
					
						// assign I/O cycle rate to int data
						tempData->ioCycleRate = intData;
						break;

					// case log to code
					case CFG_LOG_TO_CODE:

						// assign code using string data ocnverted
						// to log to code
							// function: getLogToCode
						tempData->logToCode = getLogToCode( dataBuffer );
						break;

					// cose log to file name code
					case CFG_LOG_FILE_NAME_CODE:

						// assign log to file name using string data
							// function: copyString
						copyString( tempData->logToFileName, dataBuffer );
						break;
				}
			}

			//otherwise, assume data value not in range
			else
			{
				// free temp struct memory
					// function: free
				free( tempData );

				// close file access
					// function: fclose
				fclose( fileAccessPtr );

				// return data out of range
				return CFG_DATA_OUT_OF_RANGE_ERR;
			}
		}

		// otherwise, assume data line not found
		else
		{	
			// free temp struct memory
				// function: free
			free( tempData );

			// close file access
				// function: fclose
			fclose( fileAccessPtr );

			// return corrupt config file code
			return CFG_CORRUPT_PROMPT_ERR;
		}

		// increment line counter
		lineCtr++;
	}
	// end master loop
	
	// acquire end of sim config string
		// function: getLineTo
	if( getLineTo( fileAccessPtr, MAX_STR_LEN, PERIOD,
				dataBuffer, IGNORE_LEADING_WS ) != NO_ERR
			|| compareString( dataBuffer, "End Simulator Configuration File" )
								!= STR_EQ )
	{
		// free temp struct memory
			//function: free
		free( tempData );

		// close file access
			// function: fclose
		fclose( fileAccessPtr );

		// return corrupt config file code
		return CFG_CORRUPT_DESCRIPTOR_ERR;
	}

	// assign temp pointer to parameter return pointer
	*configData = tempData;
	
	// close file access
		// function: fclose
	fclose( fileAccessPtr );
				
	// return no error code
	return NO_ERR;
}

/*
 * Function name: getDataLineCode
 * Algorithm: tests string for one of known leader strings, return line number
 * 		if string is correct, returns CFG_CORRUPT_DATA_ERR
 * 		if string is not found
 * Precondition: dataBuffer is valid C-Style string
 * Postcondition: return line number of data item in terms of a constant
 * 		(e.g., CFG_VERSION_CODE, CFG_CPU_SCHED_CODE, etc.)
 * Exceptions: return CFG_CORRUPT_FILE_ERR if string is not identified
 * Notes: none
 */
int getDataLineCode( char *dataBuffer )
{
	// return appropriate code depending on prompt string provided
	
		// check for version/phase string
			// function: compareString
		if( compareString( dataBuffer, "Version/Phase" ) == STR_EQ )
		{
			// return config version code
			return CFG_VERSION_CODE;
		}

		// check for file path string
			// function: compareString
		if( compareString( dataBuffer, "File Path" ) == STR_EQ )
		{
			// return meta data file path code
			return CFG_MD_FILE_NAME_CODE;
		}

		// check for cpu scheduling code string
			// function: compareString
		if( compareString( dataBuffer, "CPU Scheduling Code" ) == STR_EQ )
		{
			// return cpu schedule code code
			return CFG_CPU_SCHED_CODE;
		}

		// check for quantum time string
			// function: compareString
		if( compareString( dataBuffer, "Quantum Time (cycles)" ) == STR_EQ )
		{
			// return quantum cycles code
			return CFG_QUANT_CYCLES_CODE;
		}

		// check for memory available string
			// function: compareString
		if( compareString( dataBuffer, "Memory Available (MB)" ) == STR_EQ )
		{
			// return memory available code
			return CFG_MEM_AVAILABLE_CODE;
		}
			
		// check for processor cycle time string
			// function: compareString
		if( compareString( dataBuffer, "Processor Cycle Time (msec)" )
									== STR_EQ )
		{
			// return processor cycle time code
			return CFG_PROC_CYCLES_CODE;
		}

		// check for I/O cycle time string
			// function: compareString
		if( compareString( dataBuffer, "I/O Cycle Time (msec)" ) == STR_EQ )
		{
			// return I/O cycle time code
			return CFG_IO_CYCLES_CODE;
		}

		// check for log to string
			// function: compareString
		if( compareString( dataBuffer, "Log To" ) == STR_EQ )
		{
			// return log to code
			return CFG_LOG_TO_CODE;
		}

		// check for log file path string
			// function: compareString
		if( compareString( dataBuffer, "Log File Path" ) == STR_EQ )
		{
			// return log to file name code
			return CFG_LOG_FILE_NAME_CODE;
		}
	
	// at this point assume failed string access, return curropt prompt error
	return CFG_CORRUPT_PROMPT_ERR;
}

/*
 * Function Name: getCpuSchedCode
 * Algorithm: converts string data (e.g., "SJF-N", "SRTF-P")
 * 		to constant code number to be stores as integer
 * Precondition: codeStr is a C-Style string with one
 * 		of the specified cpu scheduling operations
 * Postcondition: returns code representing shceduling actions
 * Exceptions: defaults to fcfs-n code
 * Notes: none
 */
ConfigDataCodes getCpuSchedCode( char *codeStr )
{
	// intialize function/variables
	
		// set up temp string for testing
			// function: getStringLength, malloc
		int strLen = getStringLength( codeStr );
		char *tempStr = (char *)malloc( strLen + 1 );
			
		// set default return to FCFS-N
		int returnVal = CPU_SCHED_FCFS_N_CODE;

	// set string to lower case for testing
		// function: setStrToLowerCase
	setStrToLowerCase( tempStr, codeStr );

	// check for SJF-N
		// function compareString
	if( compareString( tempStr, "sjf-n" ) == STR_EQ )
	{
		// set return to SJF-N code
		returnVal = CPU_SCHED_SJF_N_CODE;
	}

	// check for SRTF-P
		// function: compareString
	else if( compareString( tempStr, "srtf-p" ) == STR_EQ )
	{
		// set return to SRTF-P code
		returnVal = CPU_SCHED_SRTF_P_CODE;
	}

	// check for FCFS-P
		// function: compareString
	else if( compareString( tempStr, "fcfs-p" ) == STR_EQ )
	{
		// set return to FCFS-P code
		returnVal = CPU_SCHED_FCFS_P_CODE;
	}

	// check for RR-P
		// function: compareString
	else if( compareString( tempStr, "rr-p" ) == STR_EQ )
	{
		// set return to RR-P code
		returnVal = CPU_SCHED_RR_P_CODE;
	}

	// free temp string memory
		// function: free
	free( tempStr );

	// return code found
	return returnVal;
}

/*
 * Function name: valueInRange
 * Algorithm: tests one of three values (int, double, string) for being
 * 		in specified range, depending on data code
 * 		(i.e., specified config value)
 * Precondition: one of the three data values is valid
 * Postcondition: returns True if data is within specified parameters,
 * 		False otherwise
 * Exceptions: metadata or logfile names are ignored and return True
 * Notes: none
 */
Boolean valueInRange( int lineCode, int intVal,
				double doubleVal, char *stringVal )
{
	// intialize function/variables
	
		// set output result to true
		Boolean result = True;

		// declare other variables
		char *tempStr;
		int strLen;
	
	// use line code to identify prompt line
	switch( lineCode )
	{
		// for version code
		case CFG_VERSION_CODE:
		
			// check if limits of version code are exceeded
			if( doubleVal < 0.00 || doubleVal > 10.00 )
			{
				// set Boolean result to false
				result = False;
			}
			break;

		// for cpu scheduling code
		case CFG_CPU_SCHED_CODE:

			// create temp string and set to lower case
				// function: getStringLength, malloc, setStrToLowerCase
			strLen = getStringLength( stringVal );
			tempStr = (char *)malloc( strLen + 1 );
			setStrToLowerCase( tempStr, stringVal );

			// check for not finding one of the scheduling strings
				// function: compareString
			if( compareString( tempStr, "none" ) != STR_EQ
						&& compareString( tempStr, "fcfs-n" ) != STR_EQ 
						&& compareString( tempStr, "sjf-n" ) != STR_EQ 
						&& compareString( tempStr, "srtf-p" ) != STR_EQ 
						&& compareString( tempStr, "fcfs-p" ) != STR_EQ
						&& compareString( tempStr, "rr-p" ) != STR_EQ )
			{
				// set Boolean result to false
				result = False;
			}

			// free temp string memory
				// function: free
			free( tempStr );
			break;

		// for quantum cycles
		case CFG_QUANT_CYCLES_CODE:
			
			// check for quantum cycles limits exceeded
			if( intVal < 0 || intVal > 100 )
			{
				// set Boolean result to false
				result = False;
			}
			break;

		// for memory available
		case CFG_MEM_AVAILABLE_CODE:

			// check for available memory limits exceeded
			if( intVal < 0 || intVal > 999 )
			{
				// set Boolean result to false
				result = False;
			}
			break;
			
		// check for process cycles
		case CFG_PROC_CYCLES_CODE:
			
			// check for process cycles limits exceeded
			if( intVal < 1 || intVal > 1000 )
			{
				// set Boolean result to false
				result = False;
			}
			break;

		// check for I/O cycles
		case CFG_IO_CYCLES_CODE:

			// check for I/O cycles limits exceeded
			if( intVal < 1 || intVal > 10000 )
			{
				// set Boolean result to false
				result = False;
			}
			break;

		// check for log to operation
		case CFG_LOG_TO_CODE:
			
			// create temp string and set to lower case
				// function: getStringLength, malloc, setStrToLowerCase
			strLen = getStringLength( stringVal );
			tempStr = (char *)malloc( strLen + 1 );
			setStrToLowerCase( tempStr, stringVal );

			//check for not finding one of the log to string
				// function: compareString
			if( compareString( tempStr, "both" ) != STR_EQ
					&& compareString( tempStr, "monitor" ) != STR_EQ
					&& compareString( tempStr, "file" ) != STR_EQ )
			{
				// set Boolean result to false
				result = False;
			}

			// free temp string memory
				// function: free
			free( tempStr );

			break;
	}

	// return result of limits analysis
	return result;
}

/*
 * Function name: getLogToCode
 * Algorithm: converts stirng data (e.g., "File", "Monitor")
 * 		to constant code number to be stored as integer
 * Precondition: codeStr is a C-Style string with one
 * 		of the specified log to operations
 * Postcondition: returns code representing log to actions
 * Exceptions: defaults to monitor code
 * Notes: none
 */
ConfigDataCodes getLogToCode( char *logToStr )
{
	// initialize functions/variables
	
		// create temp string
			// function: getStringLength, malloc
		int strLen = getStringLength( logToStr );
		char *tempStr = (char *)malloc( strLen + 1 );

		// set default return value to log to monitor
		int returnVal = LOGTO_MONITOR_CODE;

	// set temp string to lower case
		// function: setStrToLowerCase
	setStrToLowerCase( tempStr, logToStr );

	// check for BOTH 
		// function: compareString
	if( compareString( tempStr, "both" ) == STR_EQ )
	{
		// set reutrn value to both code
		returnVal = LOGTO_BOTH_CODE;
	}

	// check for FILE
		// function: compareString
	if( compareString( tempStr, "file" ) == STR_EQ )
	{
		// set return value to file code
		returnVal = LOGTO_FILE_CODE;
	}

	// free temp string memory
		// function: free
	free( tempStr );

	// return code found
	return returnVal;
}

/*
 * Function name: displayConfigData
 * Algorithm: diagnostic function to show config data output
 * Precondition: paramete has pointer to allocated data set
 * Postcondition: configuration data is displayed to the screen
 * Exceptions: none
 * Notes: none
 */
void displayConfigData( ConfigDataType *configData )
{
	// initialize function/variables
	char displayString[ STD_STR_LEN ];
	
	// print lines of display
		// function: printf, configCodeToString (translates coded items)
	printf( "\nConfig File Display\n" );
	printf( "===================\n" );
	printf( "Version                : %3.2f\n", configData->version );
	printf( "Program file name      : %s\n", configData->metaDataFileName );
	configCodeToString( configData->cpuSchedCode, displayString );
	printf( "CPU schedule selection : %s\n", displayString );
	printf( "Quantum Time           : %d\n", configData->quantumCycles );
	printf( "Memory Available       : %d\n", configData->memAvailable );
	printf( "Process cycle time     : %d\n", configData->procCycleRate );
	printf( "I/O cycle rate         : %d\n", configData->ioCycleRate );
	configCodeToString( configData->logToCode, displayString );
	printf( "Log to selection       : %s\n", displayString );
	printf( "Log file name          : %s\n", configData->logToFileName );
}

/*
 * Function name: displayConfigError
 * Algorithm: utility function to support display
 * 		of error code strings
 * Precondition: parameter holds constant value from error code list
 * 		for item (e.g., CFG_FILE_ACCESS_ERR, etc.)
 * Postcondition: correct error string (related to integer error code)
 * 		is displayed
 * Exceptions: none
 * Notes: none
 */
void displayConfigError( int errCode )
{
	// Define array with sever items, and short (40) lengths
	// Includes three potential errors from StringManipErrors
	char displayStrings[ 7 ][ 40 ] =
	{ "No Error",
		"Incomplete File Error",
		"Input Buffer Overrun",
		"Configuration File Access Error",
		"Corrupt Configuration Descriptor Error",
		"Data Out Of Range Configuration Error",
		"Corrupt Configuration Prompt Error" };
	
	// print error message
		// function: printf
	printf( "\nFATAL ERROR: %s, Program aborted\n", displayStrings[ errCode ] );
}

/*
 * Function name: configCodeToString
 * Algorithm: utility function to support display
 *		of CPU scheduling of Log To code strings
 * Precondition: code variable holds constant value from ConfigDataCodes
 * 		for item (e.g., CPU_SCHED_SRTF_p, LOGTO_FILE_CODE, etc.)
 * Postcondition: string parameter holds correct string
 *		associated with the given constant
 * Exceptions: none
 * Notes: none
 */
void configCodeToString( int code, char *outString )
{
	// Define array with eight items, and short (10) lengths
	char displayStrings[ 8 ][ 10 ] = { "SJF-P", "SRTF-P", "FCFS-P",
					"RR-P", "FCFS-N", "Monitor",
					"File", "Both" };
	
	// copy strin to return parameter
		// function: copyString
	copyString( outString, displayStrings[ code ] );
}

/*
 * Function name: clearConfigData
 * Algorithm: frees all allocated memory for config data
 * Precondition: pointer to config data linked list passed
 * 		in as a parameter
 * Postcondiiton: config data memory is freed,
 * 		pointed is set to null
 * Exceptions none
 * Notes: none
 */
void clearConfigData( ConfigDataType **configDataPtr )
{
	// check that config data pointer is not null
	if( *configDataPtr != NULL )
	{
		// free data structure memory
			// function: free
		free( *configDataPtr );
	}

	// set config data pointer to null (returned as parameter)
	*configDataPtr = NULL;
}
