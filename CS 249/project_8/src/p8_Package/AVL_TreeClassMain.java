package p8_Package;

public class AVL_TreeClassMain
   {

      public static void main(String[] args)
         {
            AVL_TreeClass testClass = new AVL_TreeClass();

            // balanced case
/*            testClass.insert( 'M' );
            testClass.insert( 'G' );
            testClass.insert( 'R' );
            testClass.insert( 'B' );         
            testClass.insert( 'J' );
            testClass.insert( 'P' );
            testClass.insert( 'U' );
            testClass.insert( 'A' );
            testClass.insert( 'C' );
            testClass.insert( 'H' );
            testClass.insert( 'L' );
            testClass.insert( 'N' );
            testClass.insert( 'Q' );
            testClass.insert( 'S' );
            testClass.insert( 'X' );
*/            
            // unbalanced case
/*            testClass.insert( 'X' );
            testClass.insert( 'S' );
            testClass.insert( 'Q' );
            testClass.insert( 'N' );         
            testClass.insert( 'L' );
            testClass.insert( 'H' );
            testClass.insert( 'C' );
            testClass.insert( 'A' );
            testClass.insert( 'U' );
            testClass.insert( 'P' );
            testClass.insert( 'J' );
            testClass.insert( 'B' );
            testClass.insert( 'R' );
            testClass.insert( 'G' );
            testClass.insert( 'M' );
*/            
            // Right right cases
/*            testClass.insert( 'A' );
            testClass.insert( 'B' );
            testClass.insert( 'C' );
            testClass.insert( 'D' );         
            testClass.insert( 'E' );
            testClass.insert( 'F' );
            testClass.insert( 'G' );
            testClass.insert( 'H' );
            testClass.insert( 'I' );
            testClass.insert( 'J' );
            testClass.insert( 'K' );
*/          
            // Left left cases
            testClass.insert( 'Z' );
            testClass.insert( 'Y' );
            testClass.insert( 'X' );
            testClass.insert( 'W' );         
            testClass.insert( 'V' );
            testClass.insert( 'U' );
            testClass.insert( 'T' );
            testClass.insert( 'S' );
            testClass.insert( 'R' );
            testClass.insert( 'Q' );
            testClass.insert( 'P' );

            System.out.println( "\nTree height: " + testClass.findTreeHeight() );
  
            System.out.println( "\nTree Data Display:" );
                        
            testClass.displayTreeStructure();
            
            System.out.println( "\nList Data Display:" );
            
            testClass.displayTree( AVL_TreeClass.INORDER_TRAVERSE );
                        
         }

   }

