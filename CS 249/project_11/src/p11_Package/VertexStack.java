package p11_Package;

/**
 * Class manages VertexNode data in stack data structure
 */
public class VertexStack
   {
    /**
     * stack data managed by array
     */
    VertexNode[] stackData;
    
    /**
     * constant space character
     */
    private final char SPACE = ' ';
    
    /**
     * constant dash character
     * 
     */
    private final char DASH = '-';
    
    /**
     * Default stack capacity
     */
    private final int STACK_CAPACITY = 26;
    
    /**
     * stack size
     * 
     */
    private int stackSize;
    
    /**
     * default constructor
     */
    public VertexStack()
       {
        stackData = new VertexNode[ STACK_CAPACITY ];

        stackSize = 0;
       }
   
    /**
     * copies a StackClass object
     * 
     * @param copied StackClass object to be copied
     */
    public VertexStack( VertexStack copied )
       {
        int index;
        
        stackSize = copied.stackSize;
        
        stackData = new VertexNode[ STACK_CAPACITY ];
        
        for( index = 0; index < stackSize; index++ )
           {
            stackData[ index ] = copied.stackData[ index ];
           }
       }
   
     /**
      * pushes data onto stack
      * 
      * @param value VertexNode data to be pushed
      * 
      * @return boolean result of operation success,
      * false if array is full, true otherwise
      */
     public boolean push( VertexNode value )
        {
         if( stackSize < STACK_CAPACITY )
            {
             stackData[ stackSize ] = value;
             
             stackSize++;
             
             return true;
            }
         
         return false;
        }
     
     /**
      * views data at front of stack
      * 
      * @return VertexNode value found at front of stack
      */
     public VertexNode peekTop()
        {
         if( !isEmpty() )
            {
             return stackData[ stackSize - 1 ];
            }
        
         return null;
        }
 
     /**
      * pops data from stack
      * 
      * @return VertexNode value removed from stack
      */
     public VertexNode pop()
        {
         if( !isEmpty() )
            {
             stackSize--;
             
             return stackData[ stackSize ];
            }
         
         return null;
        }

     /**
      * clears stack data
      */
     public void clear()
        {
         stackSize = 0;
        }
  
     /**
      * provides stack data as a string
      * with top value to right
      */
     public String toString()
        {
         int index;
         String outString = "Vertex Stack: ";
         
         if( isEmpty() )
            {
             outString += DASH;
            }
         
         for( index = 0; index < stackSize; index++ )
            {
             outString += stackData[ index ].getVertex();
             
             if( index < stackSize - 1 )
                {
                 outString += SPACE;
                }
            }
         
         return outString;
        }

    /**
     * returns empty condition
     * 
     * @return boolean result of method,
     * true if empty, false otherwise
     */
    public boolean isEmpty()
       {
        return stackSize == 0;
       }
    
   }
