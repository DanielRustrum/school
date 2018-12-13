package p11_Package;

public class GraphClassMain
   {

   public static void main(String[] args)
      {
       GraphClass gc = new GraphClass();
       
       gc.setVertex( 'B', 'D', 2 );
       gc.setVertex( 'D', 'E', 5 );
       gc.setVertex( 'D', 'C', 3 );
       gc.setVertex( 'B', 'F', 4 );
       gc.setVertex( 'E', 'A', 3 );
       gc.setVertex( 'A', 'M', 4 );
       gc.setVertex( 'A', 'R', 6 );
       gc.setVertex( 'A', 'T', 5 );
/*
       gc.setVertex( 'C', 'B', 4 );
       gc.setVertex( 'C', 'P', 7 );
       gc.setVertex( 'D', 'O', 1 );
       gc.setVertex( 'N', 'D', 7 );
       gc.setVertex( 'M', 'D', 3 );
       gc.setVertex( 'B', 'D', 5 );
       gc.setVertex( 'B', 'A', 6 );
       gc.setVertex( 'E', 'A', 4 );
       gc.setVertex( 'L', 'F', 1 );
       gc.setVertex( 'K', 'L', 7 );
       gc.setVertex( 'R', 'L', 1 );
       gc.setVertex( 'P', 'M', 2 );
       gc.setVertex( 'Q', 'P', 1 );
       gc.setVertex( 'R', 'Q', 1 );
       gc.setVertex( 'S', 'R', 9 );
       gc.setVertex( 'K', 'R', 6 );
       gc.setVertex( 'J', 'K', 9 );
       gc.setVertex( 'K', 'H', 2 );
       gc.setVertex( 'F', 'J', 2 );
       gc.setVertex( 'E', 'F', 9 );
       gc.setVertex( 'G', 'E', 5 );
       gc.setVertex( 'I', 'J', 1 );
       gc.setVertex( 'G', 'I', 3 );
       gc.setVertex( 'H', 'G', 9 );
*/       
       System.out.println( "Adjacency Matrix Table\n");
       gc.generateAdjacencyMatrix();
   
       // System.out.println( "\nBreadth-First Traversal");
       //System.out.println( "Breadth-First Result: " + gc.BFS( 'B', true ) );

       System.out.println( "\nDepth First Traversal: " );
       System.out.println( "Depth-First Result: " + gc.DFS( 'B', true ) );
      }

   }
