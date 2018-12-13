package p9_Package;

import java.util.Random;

/**
 * Simple main class operation to test ArrayHeapClass
 * 
 * @author MichaelL
 *
 */
public class BT_HeapClassMain
   {
      /** 
       * Main method tests heap addition and removal with simple
       * array input and output operations, then tests with class
       * display flag set to observe internal operations
       * 
       * @param args not used
       */
      public static void main(String[] args)
         {
          BT_HeapClass testClass = new BT_HeapClass();
          BT_HeapClass.NodeClass removedNode;
          int index, numLetters = 20;
          
          
          char[] letters = createLetterList( numLetters );
          
          testClass.setViewFlag( true );  // can be set to true to show bubble up display

          for( index = 0; index < numLetters; index++ )
             {
              System.out.println( "\nAdding letter: " + letters[ index ] );
              testClass.addItem( letters[ index ] );
              //testClass.displayTreeStructure();
             }

          testClass.setViewFlag( true ); // can be set to true to show trickle down display
          
          for( index = 0; index < numLetters; index++ )
             {
              removedNode = testClass.removeItem();
              System.out.println( "\nLetter: " + removedNode.dataValue + " removed.");
              //testClass.displayTreeStructure();
             }
         }
      
      /**
       * Creates specified number of random capital letters
       * with a maximum of 26
       * 
       * @param lettersRequested integer number of letters requested
       * 
       * @return character array with letter list
       */
      public static char[] createLetterList( int lettersRequested )
         {
          int maxNumLetters = 26;
          int index;
          char[] letterArr;
          char testLetter;

          if( lettersRequested > maxNumLetters )
             {
              lettersRequested = maxNumLetters;
             }
          
          letterArr = new char[ lettersRequested ];
          
          for( index = 0; index < lettersRequested; index++ )
             {
              do
                 {
                  testLetter = getRandLetter();
                 }
              while( isInArray( letterArr, index, testLetter ) );
              
              letterArr[ index ] = testLetter;
             }
          
          return letterArr;
         }
      
      /**
       * Checks for letter in array
       * 
       * @param ltrArr character array of capital letters
       * 
       * @param numLetters integer number of elements in the array
       * 
       * @param testChar character value to be tested against the array
       * 
       * @return Boolean result of test
       */
      public static boolean isInArray( char[] ltrArr, int numLetters, char testChar )
         {
          int index;
          
          for( index = 0; index < numLetters; index++ )
             {
              if( testChar == ltrArr[ index ] )
                 {
                  return true;
                 }
             }
          
          return false;
         }

      /**
       * Generates random letter between 'A' and 'Z' inclusive
       * 
       * @return character random letter as specified
       */
      public static char getRandLetter()
         {
          Random randEngine = new Random();
          
          return (char)( 'A' + randEngine.nextInt( 26 ) );
         }
   }

