package p11_Package;

public class AdjacentNode
   {
    /**
     * character vertex letter
     */
    private char vertexLetter;
    
    /**
     * integer vertex weight
     */
    private int vertexWeight;
    
    /**
     * initialization constructor
     * 
     * @param vertex character vertex letter
     * 
     * @param weight integer vertex weight
     */
    public AdjacentNode( char vertex, int weight )
       {
        vertexLetter = vertex;
        
        vertexWeight = weight;
       }
    
    /**
     * copy constructor
     * 
     * @param copied AdjacentNode item to be copied
     */
    public AdjacentNode( AdjacentNode copied )
       {
        vertexLetter = copied.vertexLetter;
        
        vertexWeight = copied.vertexWeight;
       }
    
    /**
     * gets vertex letter
     * 
     * @return character vertex letter
     */
    public char getVertex()
       {
        return vertexLetter;
       }
    
    /**
     * gets vertex weight
     * 
     * @return integer vertex weight
     */
    public int getWeight()
       {
        return vertexWeight;
       }
    
   }
