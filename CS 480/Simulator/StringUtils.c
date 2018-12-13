#include "StringUtils.h"

// global constants
const int MAX_STR_LEN = 200;
const int STD_STR_LEN = 80;
const char NULL_CHAR = '\0';
const int SUBSTRING_NOT_FOUND = -101;
const int STR_EQ = 0;
const char SPACE = ' ';
const char COLON = ':';
const char SEMICOLON = ';';
const char LEFT_PAREN = '(';
const char RIGHT_PAREN = ')';
const char PERIOD = '.';
const Boolean IGNORE_LEADING_WS = True;
const Boolean ACCEPT_LEADING_WS = False;

/*
 * Function Name: getStringLength
 * Algorithm: find the length of the string, up to the null character
 * Precondition: given C-style with null character at the end
 * Postcondition: return the number of characters (int) form the beginning
 * 		to the null character
 * Exceptions: none
 * Note: limit test loop to maximum characters for safety
 */

int getStringLength( char *testStr )
{
	// initialize function/variables
	int index = 0;

	// loop up to the null character or limit
	while( index < MAX_STR_LEN && testStr[ index ] != NULL_CHAR )
	{
		// increment the counter index
		index++;
	}
	// end loop
	
	// return the counter index value
	return index;
}

/*
 * Function name: copyString
 * Algorithm: copies contents of one string into another
 * Precondition: given c-style source string, having a null character ('\0')
 * 		at end of string; destination string is passed in
 * 		as a parameter with enough memeory 
 * Postcondition: destination string contains an exact copy
 * 		of the source string
 * Exceptions: none
 * Note: limit test loop to maximum characters for safety
 */
void copyString( char *destination, char *source )
{
	// initialize function/variables
	int index = 0;
	
	// loop until null character is found in source string
	// loop limits to MAX_STR_LEN
	while( index < MAX_STR_LEN && source[ index ] != NULL_CHAR )
	{
		// assign source character to destination element
		destination[ index ] = source [ index ];

		// increment index
		index++;
		
		// assign null character to next destination element
		destination[ index ] = NULL_CHAR;
	}
	// end loop
}

/*
 * Function name: concatenateString 
 * Algorithm: concatenates or appends contents of one string
 * Precondition: given C-style source string, having a null hcaracter ('\0')
 * 		at end of string; destination string is passed in
 * 		as a parameter with enough memeory to accept the source string
 * Postcondition: destination string contains its original string with
 * the source string appended or concatenated to the end of it
 * Exceptions: none
 * Note: limit test loop to maximum characters for safety
 */

void concatenateString( char *destination, char *source )
{
	// initialize function/variables
	
		// set destination index to length of destination string
			// function: getStringLength
		int destIndex = getStringLength( destination );

		// set source index to zero
		int sourceIndex = 0;

	// loop to end of source index (null character)
	// loop limited to MAX_STR_LEN
	while( sourceIndex < MAX_STR_LEN && source[ sourceIndex ] != NULL_CHAR )
	{
		// assign source character to destination at destination index
		destination[ destIndex ] = source[ sourceIndex ];
		
		// increment source and destination indices;
		sourceIndex++; 
		destIndex++;

		// assign null character to next destination element
		destination[ destIndex ] = NULL_CHAR;
	}
	// end loop
}

/*
 * Function name: compareString 
 * Algorithm: compares two string alphabetically such that:
 * 		if oneStr < otherStr, the function returns a value < 0
 * 		if oneStr > otherStr, the function returns a value > 0
 * 		if oneStr == other Str, the function returns a 0
 * 		if two strings are identical up to the point that one is longer,
 * 		the difference in lengths will be returned
 * Precondition: given two C-style strings, having a null character ('\0')
 * 		at end of each string
 * Postcondition: integer value returned as specified 
 * Exceptions: none
 * Note: limit test loop to maximum characters for safety
 */

int compareString( char *oneStr, char *otherStr )
{
	// initialize function/varaibles
	
		// initialize index to zero
		int index = 0;

		// initialize other variables
		int difference;
	
	// loop to end of one of the two strings
	// loop limited to MAX_STR_LEN
	while( index < MAX_STR_LEN
			&& oneStr[ index ] != NULL_CHAR
				&& otherStr[ index ] != NULL_CHAR )
	{
		// find the difference between the currently aligned characters
		difference = oneStr[ index ] - otherStr[ index ];

		// check for non-zero difference
		if( difference != 0 )
		{	
			// reutrn non-zero difference
			return difference;
		}

		// increment index
		index++;
	}
	// end loop
	
	// assume strings are equal at this point, return string length difference
		// function: getStringLength
	return getStringLength( oneStr ) - getStringLength( otherStr );
}

/*
 * Function name: getSubString
 * Algorithm: captures sub string within larger string
 * 		between two inclusive indices
 * Precondition: given a C-style source string, having a null character ('\0')
 * 		at end of each string, and another string parameter
 * 		with enough memory to hole to resulting substring
 * Postcondition: substring is returned as a parameter
 * Exceptions: empty string returned if any of the index parameters are
 * 		out of range
 * Note: copy of source string is made internally to protect from aliasing
 */

void getSubString( char *destStr, char *sourceStr,
						int startIndex, int endIndex)
{
	// intialize function/variables
		
		// set length of source string
			// function: getStringLength
		int sourceStrLen = getStringLength( sourceStr );
			
		// initialize destination index to zero
		int destIndex = 0;
		
		// initialize source index to start index parameter
		int sourceIndex = startIndex;

		// create point to temp string
		char *tempSourceStr;

	// check for indices within limits
	if( startIndex >= 0 && startIndex <= endIndex && endIndex < sourceStrLen )
	{
		// create temp string, copy source string to it
			// function: malloc, copyString
		tempSourceStr = (char *) malloc( sourceStrLen + 1 );
		copyString( tempSourceStr, sourceStr );

		// loop across requested substring (indices)
		while( sourceIndex <= endIndex )
		{
			// assign source character to destination element
			destStr[ destIndex ] = tempSourceStr[ sourceIndex ];

			// increment indices
			destIndex++;
			sourceIndex++;

			// add null character to next destination string element
			destStr[ destIndex ] = NULL_CHAR;
		}
		// end loop

		// release memory used for temp source string
			// function: free
		free( tempSourceStr );
	}

	// otherwiize, assume indices not in limits
	else
	{
		// create empty string with null character
		destStr[ 0 ] = NULL_CHAR;
	}
}

/*
 * Function name: findSubString
 * Algorithhm: linear search for given substring within a given test string
 * Precondition: given a C-style test string, having a null character ('\0')
 * 		at end of string, and given search string with
 * 		a null character ('\n') at the end of that string
 * Postcondition: index of substring location returned,
 * 		or SUBSTRING_NOT_FOUND constant is returned
 * Exceptions: none
 * Note: none
 */

int findSubString( char *testStr, char *searchSubStr )
{
	// intialize function/variables
	
		// initialize test string length
			// function: getStringLength
		int testStrLen = getStringLength( testStr );

		// initialize master index - location of sub string start point
		int masterIndex = 0;
	
		// initialize other varaibles
		int searchIndex, internalIndex;

	// loop across test string
	while( masterIndex < testStrLen )
	{	
		// set internal loop index to current test string index
		internalIndex = masterIndex;

		// set internal search index to zero
		searchIndex = 0;

		// loop to end of test string
		// while test string/sub string characters are the same
		while( internalIndex <= testStrLen
				&& testStr[ internalIndex ] 
					== searchSubStr[ searchIndex ] )
		{
			// increment test string, substring indices
			internalIndex++;
			searchIndex++;
			
			// check for end of substring (search completed)
			if( searchSubStr[ searchIndex ] == NULL_CHAR )
			{
				// return current test string index
				return masterIndex;
			}
		}
		// end loop

		// increment current test string index
		masterIndex++;
	}
	// end loop
	
	// assume tests have failed at this point, return SUBSTRING_NOT_FOUND
	return SUBSTRING_NOT_FOUND; // temp stub return
}

/*
 * Function name: setStrToLowerCase
 * Algorithm: iterates through string, set all uppercase letters
 * 		to lower case without changing any other characters
 * Precondition: given a C-style source string, having a null character ('\0')
 * 		at end if string, and destination string parameter
 * 		is passed with enough memory to hold the lower case string
 * Postcondition: all upper case letters in given string a sert
 * 		to lower case; no change to any other characters
 * Exceptions: limit on string loop in case incorrect string formate
 * Note: copy of source string is made internally to protect from aliasing
 */

void setStrToLowerCase( char *destStr, char *sourceStr )
{
	// intialize function/varaibles
	
		// create temp source string
			// function: getStringLength, malloc
		int strLen = getStringLength( sourceStr );
		char *tempStr = (char *) malloc( strLen + 1 );
		
		// initialize source string index to zero
		int index = 0;

	// copy source string to temp string
		// function: copyString
	copyString( tempStr, sourceStr );

	// loop to end of temp/source string
	// loop limited to MAX_STR_LEN
	while( index < MAX_STR_LEN && tempStr[ index ] != NULL_CHAR )
	{
		// change letter to lower case as needed and assign
		// to destination string
			// fucntion: setCharToLowerCase
		destStr[ index ] = setCharToLowerCase( tempStr[ index ] );

		// increment index
		index++;

		// add null character to next string element
		destStr[ index ] = NULL_CHAR;
	}
	// end loop
	
	// release tempt string memory
		// function: free
	free( tempStr );
}

/*
 * Function name: setCharToLowerCase
 * Algorithm: tests character parameter for uppercase, changes it to lower case
 * 		makes no changes if not upper case
 * Precondition: given character value
 * Postcondition: uppercase letter is set to lower case,
 * 		otherwise, character is returned unchanged
 * Exceptions: none
 * Note: none
 */
char setCharToLowerCase( char testChar )
{
	// initialize function/variables
		
		// none

	// check for character between 'A' and 'Z' inclusive
	if( testChar >= 'A' && testChar <= 'Z' )
	{
		// convert upper case letter to lower case
		testChar = (char) ( testChar - 'A' + 'a' );
	}

	// return character
	return testChar;
}

/* Function name: getLineTo
 * Algorithm: finds given text in file, ksipping white space if specified,
 * 		stops searching at given character or length
 * Precondition: file is open with valid file pointer;
 * 		char buffer has adequate memory for data;
 * 		stop character and length are valid
 * Postcondition: ignores leading white space if specified;
 * 		captures all printable characters and stores in string buffer;
 * Exceptions: returnes INCOMPLETE_FILE_ERR if no valid data found;
 * 		returns NO_ERR if successfull operation
 * Note: none
 */
int getLineTo( FILE *filePtr, int bufferSize, char stopChar,
		char *buffer, Boolean omitLeadingWhiteSpace )
{
	// initialize function/variables
	
		// intialize character index
		int charIndex = 0;

		// initialize status return to NO_ERR_
		int statusReturn = NO_ERR;

		// initialize buffer size available flag to true
		Boolean bufferSizeAvailable = True;

		// initialize other variables
		int charAsInt;

	// get the first character
		// function: fgetc
	charAsInt = fgetc( filePtr );

	// use a loop to consume leading white space, if flagged
	while( omitLeadingWhiteSpace == True 
			&& charAsInt != (int) stopChar
				&& charIndex < bufferSize
					&& charAsInt <= (int) SPACE )
	{
		// get next character (as integer)
			// function: fgetc
		charAsInt = fgetc( filePtr );
	}
	// end loop
	
	// capture string
	// loop while character is not stop character and buffer size if available
	while( charAsInt != (int) stopChar && bufferSizeAvailable == True )
	{
		// check for input failure
			// function: isEndOfFile
		if( isEndOfFile( filePtr ) == True )
		{
			// return incomplete file error
			return INCOMPLETE_FILE_ERR;
		}

		// check for usable (printable) character
		if( charAsInt >= (int) SPACE )
		{
			// assign input character to buffer string
			buffer[ charIndex ] = (char) charAsInt;
				
			// increment index
			charIndex++;
		}

		// set next buffer element to null character
		buffer[ charIndex ] = NULL_CHAR;

		// check for not at end of buffer size
		if( charIndex < bufferSize - 1 )
		{
			// get a new character
				// function: fgetc
			charAsInt = fgetc( filePtr );
		}

		// otherwise, assume end of buffer size
		else
		{
			// set buffer size Boolean to false to end loop
			bufferSizeAvailable = False;

			// set status return to buffer overrun error
			statusReturn = INPUT_BUFFER_OVERRUN_ERR;
		}
	}
	// end loop
	
	// return status data
	return statusReturn;
}

/*
 * Function name: isEndOfFile
 * Algorithm: reports end of file, using feof
 * Precondition: file is open with valid file pointer
 * Postcondition: reports end of file
 * Exceptions: none
 * Note: none
 */
Boolean isEndOfFile ( FILE *filePtr )
{
	// initialize function/varaibles
	
	// check for feof end of file response
		// fucntion: feof
	if( feof( filePtr ) != 0 )
	{
		// return true
		return True;
	}

	// assume test failed at this point, return false
	return False; // temp stub return
}
