package p10_Package;

/**
 * Description: class manages data for a state, its initials, 
 * its number of institutions, its average temperature,
 * its lowest temperature, and its highest temperature
 *  
 *  @author Michael Leverington
 * 
 */
public class StateDataClass implements Comparable<StateDataClass>
   {
    // public enumeration of sort keys
    static public final int SORT_BY_STATE_NAME = 0;
    static public final int SORT_BY_STATE_INITIALS = 1;
    static public final int SORT_BY_NUM_INSTITUTIONS = 2;
    static public final int SORT_BY_AVERAGE_TEMP = 3;
    static public final int SORT_BY_LOWEST_TEMP = 4;
    static public final int SORT_BY_HIGHEST_TEMP = 5;
    static public final int SORT_FORWARD = 6;
    static public final int SORT_BACKWARD = 7;
    
    // member data
    private String state;
    private String stateInitials;
    private int numInstitutions;
    private double avgTemp;
    private double lowestTemp;
    private double highestTemp;
    private static int sortKey, sortDirKey; 
    private static boolean sortKeyLock = false;
    
    /** 
     * Default constructor, initializes all state data to default values
     * 
     */
    public StateDataClass()
       {
        state = "---";
        stateInitials = "**";
        numInstitutions = 0;;
        avgTemp = 0.0;
        lowestTemp = 0.0;
        highestTemp = 0.0;
        
        if( !sortKeyLock )
           {
            sortKey = SORT_BY_STATE_NAME;
            sortDirKey = SORT_FORWARD;
            sortKeyLock = true;
           }
       }
      
    /** Initialization constructor, initializes all state data to default values
     * 
     * @param sortKeySet provides a constant value
     * to set sorting key
     * 
     * @param sortDirKeySet provides a constant value
     * for setting sorting direction (low to high, high to low)
     */
    public StateDataClass( int sortKeySet, int sortDirKeySet )
       {
        state = "-----";
        stateInitials = "**";
        numInstitutions = 0;
        avgTemp = 0.0;
        lowestTemp = 0.0;
        highestTemp = 0.0;
        
        if( !sortKeyLock )
           {
            sortKey = sortKeySet;
            sortDirKey = sortDirKeySet;
            sortKeyLock = true;
           }
       }
      
    /** Copy constructor, sets all data to copied object
     * 
     * @param copiedSC StateDataClass object to be copied
     */
    public StateDataClass( StateDataClass copiedSC )
       {
        state = copiedSC.state;
        stateInitials = copiedSC.stateInitials;
        numInstitutions = copiedSC.numInstitutions;
        avgTemp = copiedSC.avgTemp;
        lowestTemp = copiedSC.lowestTemp;
        highestTemp = copiedSC.highestTemp;
       }
      
    /** Initialization constructor, individually sets data values
     * 
     * @param stateIn String name of state
     * 
     * @param initialsIn String state initials
     * 
     * @param numInstIn integer number of institutions
     * for the state
     * 
     * @param avgTempIn double average temperature for the state
     * 
     * @param lowTempIn double lowest temperature for the state
     * 
     * @param highTempIn double highest temperature for the state
     * 
     */
    public StateDataClass( String stateIn, String initialsIn, 
                               int numInstIn, double avgTempIn, 
                                     double lowTempIn, double highTempIn )
       {
        state = stateIn;
        stateInitials = initialsIn;
        numInstitutions = numInstIn;
        avgTemp = avgTempIn;
        lowestTemp = lowTempIn;
        highestTemp = highTempIn;
        
        if( !sortKeyLock )
           {
            sortKey = SORT_BY_STATE_NAME;
            sortDirKey = SORT_FORWARD;
            sortKeyLock = true;
           }
       }
      
    /** Initialization constructor, individually sets data values,
     * and includes sort key settings
     * 
     * @param stateIn String name of state
     * 
     * @param initialsIn String state initials
     * 
     * @param numInstIn integer number of institutions
     * for the state
     * 
     * @param avgTempIn double average temperature for the state
     * 
     * @param lowTempIn double lowest temperature for the state
     * 
     * @param highTempIn double highest temperature for the state
     * 
     * @param sortKeySet integer value to set sorting key
     * 
     * @param sortDirKeySet integer value to set sorting direction
     * low to high, high to low
     * 
     */
    public StateDataClass( String stateIn, String initialsIn, 
                             int numInstIn, double avgTempIn, 
                               double lowTempIn, double highTempIn, 
                                    int sortKeySet, int sortDirKeySet )
       {
        state = stateIn;
        stateInitials = initialsIn;
        numInstitutions = numInstIn;
        avgTemp = avgTempIn;
        lowestTemp = lowTempIn;
        highestTemp = highTempIn;
        
        if( !sortKeyLock )
           {
            sortKey = sortKeySet;
            sortDirKey = sortDirKeySet;
            sortKeyLock = true;
           }           
       }
      
    /** Overrides Object.toString, provides raw data from object
     * <p>
     * Note: sortKey and sortDirKey not displayed
     * 
     */
    @Override
    public String toString()
       {
        return state + '/' + stateInitials + '/' + numInstitutions 
                     + '/' + avgTemp + '/' + lowestTemp + '/' + highestTemp;
       }
    
    /** Provides required method for comparing this object 
     * to another StateDataClass object
     * 
     * @param other object of StateDataClass with which to compare
     */
    public int compareTo( StateDataClass other )
       {
        int compareResult = 0, index = 0;
        
        switch( sortKey )
           {
            case SORT_BY_STATE_INITIALS:
               
                compareResult = stateInitials.charAt( 0 ) 
                                         - other.stateInitials.charAt( 0 );
                
                if( compareResult == 0 )
                   {
                    compareResult = stateInitials.charAt( 1 ) 
                                         - other.stateInitials.charAt( 1 );
                   }
               
                break;
               
            case SORT_BY_NUM_INSTITUTIONS:
               
                compareResult = this.numInstitutions - other.numInstitutions;  
               
                break;
               
            case SORT_BY_AVERAGE_TEMP:
               
                compareResult = (int)( this.avgTemp - other.avgTemp );
               
                break;
              
            case SORT_BY_LOWEST_TEMP:
            
            compareResult = (int)Math.ceil( this.lowestTemp - other.lowestTemp );
           
            break;
           
            case SORT_BY_HIGHEST_TEMP:
            
            compareResult = (int)Math.ceil( this.highestTemp - other.highestTemp );
           
            break;
           
            default:  // SORT_BY_STATE_NAME
               {
                while( index < this.state.length() 
                         && index < other.state.length() 
                              && compareResult == 0 )
                   {
                    compareResult = 
                        toLowerCase( this.state.charAt( index ) ) 
                          - toLowerCase( other.state.charAt( index ) );
                  
                    index++;  
                   }
              
                if( compareResult == 0 )
                   {
                    compareResult = this.state.length() 
                                               - other.state.length();
                   }                
               }
               
               break;
            }
        
        if( sortDirKey == SORT_BACKWARD )
           {
            compareResult *= -1;
           }                

        return compareResult;
       }

    /** Changes character to lower case only if character was originally 
     * an upper case letter
     * 
     * @param testChar Character to be tested, if it is upper case it will 
     * be converted to lower case;
     * otherwise the testChar will be returned unchanged
     * 
     * @return returns the lower case version of a letter 
     * if it was an upper case letter;
     * otherwise, the character is returned unchanged
     */
    public char toLowerCase( char testChar )
       {
        if( testChar >= 'A' && testChar <= 'Z' )
           {
            testChar = (char)( testChar - 'A' + 'a' );
           }
        
        return testChar;
       }

}

