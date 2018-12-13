package p11_Package;

/**
 * Simple class for managing vertices and edges
 * in a graph
 * 
 * @author MichaelL
 *
 */
public class GraphClass
   {
    /**
     * default vertex capacity
     * <p>
     * Note: Limited to number of upper case letters in alphabet
     */
    private final int VERTEX_CAPACITY = 26;
    
    /**
     * indication of vertex not in list
     */
    private final int NOT_IN_LIST = -1;
    
    /**
     * constant space character
     * 
     */
    private final char SPACE = ' ';
    
    /**
     * constant dash character
     * 
     */
    private final char DASH = '-';
    
    /**
     * size of vertex array
     */
    private int vertexListSize;
    
    /**
     * array of vertices
     */
    VertexNode[] vertexList;
    
    /**
     * Default constructor
     */
    public GraphClass()
       {
        vertexList = new VertexNode[ VERTEX_CAPACITY ];
        
        vertexListSize = 0;
       }
    
    /**
     * Sets vertex with adjacency
     * <p>
     * Note: Adds new vertex as needed;
     * otherwise adds adjacent vertex and weight to existing vertex
     * <p>
     * Note: Adds vertices in both directions (e.g., A with B as adjacency,
     * and B with A as adjacency)
     * <p>
     * Uses insertVertex to minimize excessive coding
     * 
     * @param vertex character vertex letter
     * 
     * @param adjVertex character adjacent vertex letter
     * 
     * @param weight integer weight between vertices
     * 
     * @return boolean result of action,
     * false if vertex array is full, true otherwise
     */
    public boolean setVertex( char vertex, char adjVertex, int weight )
    {
        int foundVertex;
        if(vertexListSize == VERTEX_CAPACITY)
        {
            return false;
        }
        foundVertex = vertexInList(vertex);
        if(foundVertex > -1)
        {            
            vertexList[foundVertex].addAdjacentVertex(adjVertex, weight);
        }
        else
        {
            insertVertex(vertex, adjVertex, weight);
        }
        foundVertex = vertexInList(adjVertex);
        if(foundVertex > -1)
        {            
            vertexList[foundVertex].addAdjacentVertex(vertex, weight);
        }
        else
        {            
            insertVertex(adjVertex, vertex, weight);
        }
        return true;
    }          
    
    /**
     * inserts vertex, adjacent vertex, and weight
     * into array alphabetically
     * 
     * @param vertex character vertex letter
     * 
     * @param adjVertex character adjacent vertex letter
     * 
     * @param weight integer weight between vertices
     * 
     * @return boolean result of insertion,
     * false if vertex array is full, true otherwise
     */
    private boolean insertVertex( char vertex, char adjVertex, int weight )
    {
        int index = vertexListSize;
        
        if(vertexListSize == VERTEX_CAPACITY)
        {
            return false;
        }
        
        while( index > 0 && vertexList[ index - 1 ].getVertex() > vertex )
           {
            if( vertexList[ index ] == null )
               {
                vertexList[ index ] 
                            = new VertexNode( vertexList[ index - 1 ] );
               }
            
            else
               {
                vertexList[ index ] = vertexList[ index - 1 ];
               }
            
            index--;
           }
           
        vertexList[ index ] = new VertexNode(vertex, adjVertex, weight );
        
        vertexListSize++;
        return true;
    }
    
    /**
     * tests for vertex in list
     * 
     * @param testVertex character vertex to search for
     * 
     * @return integer index if vertex found,
     * constant NOT_IN_LIST otherwise
     */
    private int vertexInList( char testVertex )
    {
        int index;
        char indexVertex;
        for(index = 0; index < vertexListSize; index++)
        {
            if(vertexList[index] != null)
            {
                indexVertex = vertexList[index].getVertex();
                if(testVertex == indexVertex)
                {
                    return index;
                }
            }
        }

        return NOT_IN_LIST;
   }
  
    /**
     * gets complete vertex node and data
     * using the adjacent node data
     * <p>
     * Note: Cleans up access to this data
     * in the BFS and DFS methods
     * 
     * @param adjNode AdjacentNode data provided
     * 
     * @return VertexNode data found in array
     */
    private VertexNode adjToVertex( AdjacentNode adjNode )
    {
        int foundIndex;
        char refChar = adjNode.getVertex();
        foundIndex = vertexInList(refChar);
        return vertexList[foundIndex];
    }
    
    /**
     * Breadth-First Search (BFS)
     * is actually just a traversal
     * 
     * @param startVertex character vertex to start with
     * 
     * @param showQueue boolean flag to control display
     * of queue during operations
     * 
     * @return String result of traversal process
     * showing each visited vertex in the order it was visited
     */
    public String BFS( char startVertex, boolean showQueue )
    {
        int index, foundIndex;
        String result = "";
        VertexQueue queue = new VertexQueue();
        VertexNode currentNode;
        AdjacentNode adjNode;
        
        currentNode = vertexList[vertexInList(startVertex)];
        for(index = 0; index < vertexListSize; index++)
        {
            adjNode = currentNode.getFirstAdjacency();
            
            while(adjNode != null)
            {
                foundIndex = vertexInList(adjNode.getVertex());
                if(!vertexList[foundIndex].hasBeenVisited())
                {                    
                    vertexList[foundIndex].setVisited();
                    queue.enqueue(currentNode);
                    if(showQueue)
                    {
                        System.out.print(vertexList[foundIndex].getVertex());
                    }
                }
                currentNode.getNextAdjacency();
            }
            
            if(showQueue)
            {
                System.out.println();
            }
            
            result += currentNode.getVertex();
            currentNode = queue.dequeue();
        }
        return result;
    }
    
    /**
     * Depth-First Search (DFS)
     * is actually just a traversal
     * 
     * @param startVertex character vertex to start with
     * 
     * @param showStack boolean flag to control display
     * of stack during operations
     * 
     * @return String result of traversal process
     * showing each visited vertex in the order it was visited
     */
    public String DFS( char startVertex, boolean showStack )
    {
        int index, foundIndex;
        String result = "";
        boolean haveFirst = false;
        VertexStack stack = new VertexStack();
        VertexNode currentNode;
        AdjacentNode adjNode;
        
        currentNode = vertexList[vertexInList(startVertex)];
        for(index = 0; index < vertexListSize; index++)
        {
            adjNode = currentNode.getFirstAdjacency();
            stack.push(currentNode);
            foundIndex = vertexInList(adjNode.getVertex());
            
            result += currentNode.getVertex();
            while(adjNode != null)
            {
                if(!currentNode.hasBeenVisited())
                {                    
                    stack.push(currentNode);
                }
                currentNode.setVisited();
                System.out.print(currentNode.getVertex());
                currentNode = adjToVertex(adjNode);
                if(haveFirst)
                {
                    adjNode = currentNode.getNextAdjacency();
                }
                else
                {
                    adjNode = currentNode.getFirstAdjacency();
                    haveFirst = true;
                }
            }
            System.out.println();
            currentNode = stack.pop();
        }
        
        return result;
    }
    
    /**
     * generates an adjacency matrix table
     * that displays weights between vertices
     */
    public void generateAdjacencyMatrix()
    {
        int index, index2;
        AdjacentNode adjNode;
        
        System.out.print(SPACE);
        for(index = 0; index < vertexListSize; index++)
        {
            System.out.print(vertexList[index].getVertex());
        }
        System.out.println();
        for(index = 0; index < vertexListSize; index++)
        {
            System.out.print(vertexList[index].getVertex());
            adjNode = vertexList[index].getFirstAdjacency();
            for(index2 = 0; index2 < vertexListSize; index2++)
            {
                if(adjNode.getVertex() == vertexList[index2].getVertex())
                {
                    System.out.print(adjNode.getWeight());
                }
                else
                {
                    System.out.print(DASH);
                }
            }
            System.out.println();
        }
    }
    
    /**
     * clears all vertex visited flags
     * for use after completion of BFS, DFS
     */
    public void clearVisitedFlags()
       {
        int index;
        
        for( index = 0; index < vertexListSize; index++ )
           {
            vertexList[ index ].unSetVisited();
           }
       }
    
    /**
     * Recursive method that prints
     * a specified number of specified characters
     * 
     * @param numChars integer number of characters to print
     * 
     * @param outChar character value to be printed
     */
    void printChars( int numChars, char outChar )
       {
        if( numChars > 0 )
           {
            System.out.print( outChar );
            
            printChars( numChars - 1, outChar );
           }
       }
   }
