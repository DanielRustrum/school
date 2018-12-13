package p4_Package;

/**
 * Class for storing class room information
 * for use in a recursive-backtracking process
 * @author MichaelL
 *
 */
public class RoomClass
   {
    /**
     * constant for setting class association to no class
     */
    public static final int NO_CLASS = -1;
    
    /**
     * constant for setting standard string length
     */
    public static final int STD_STR_LEN = 80;
    
    /**
     * name of building housing specified room
     */
    private String buildingName;
    
    /**
     * room number
     */
    private int roomNumber;
    
    /**
     * room capacity
     */
    private int roomCapacity;
    
    /** 
     * associated class index, 
     * used to associate this room to a class in search operation
     */
    private int associatedClassIndex;
    
    /** 
     * Default constructor
     */
    public RoomClass()
       {
        roomNumber = 0;
        roomCapacity = 0;
        associatedClassIndex = 0;
        
        buildingName = "---";
       }
    
    /**
     * Initialization constructor
     * 
     * @param setBuildingName sets building name in which room resides
     * 
     * @param setRoomNum sets room number
     * 
     * @param setRoomCap sets room capacity
     */
    public RoomClass( String setBuildingName, int setRoomNum, int setRoomCap )
       {
        buildingName = setBuildingName;
        
        roomNumber = setRoomNum;
        
        roomCapacity = setRoomCap;
       }
    
    /**
     * Copy constructor
     * 
     * @param copied RoomClass object to be copied
     */
    public RoomClass( RoomClass copied )
       {
        buildingName = copied.buildingName;
        
        roomNumber = copied.roomNumber;
        
        roomCapacity = copied.roomCapacity;
       }
    
    /**
     * sets data for one room
     * 
     * @param inBldgName building name where room is found
     * 
     * @param inRoomNum number of room
     * 
     * @param inRoomCapacity room capacity
     * 
     * @param inAssocClsIndex index used for associating 
     * an element in a class array to the room 
     */
    public void setRoomData( String inBldgName, int inRoomNum, int inRoomCapacity, int inAssocClsIndex )
       {
        buildingName = inBldgName;
        
        roomNumber = inRoomNum;
        
        roomCapacity = inRoomCapacity;
        
        associatedClassIndex = inAssocClsIndex;        
       }
    
    /**
     * sets index used for associating 
     * an element in a class array to the room 
     * 
     * @param inAssocIndex index provide to method for setting
     */
    public void setAssociatedIndex( int inAssocIndex )
       {
        associatedClassIndex = inAssocIndex;
       }
      
    /**
     * returns index used for associating 
     * an element in a class array to the room 
     * 
     * @return associated index as integer
     */
    public int getAssociatedIndex()
       {
        return associatedClassIndex;
       }
    
    /**
     * returns capacity of room
     * 
     * @return capacity of room
     */
    public int getRoomCapacity()
       {
        return roomCapacity;
       }
    
    /**
     * compares this room to another one
     * 
     * @param otherRoom to be compared to this one
     * 
     * @return this greater than other: greater than zero;
     * this equal to other: equals zero
     * this less than other: less than zero
     */
    public int compareTo( RoomClass otherRoom )
       {
        int difference;
        
        difference = compareStrings( buildingName, otherRoom.buildingName );
        
        if( difference != 0 )
           {
            return difference;
           }
        
        return roomNumber - otherRoom.roomNumber;
       }

    /**
     * returns information about room object,
     * in the form: "Building Name: _building name_, Room Number: _room number_,
     * Room Capacity: _room capacity_
     * 
     * @return object information as string
     */
    public String toString()
       {
        return "Building Name: " + buildingName 
                + ", Room Number: " + roomNumber
                     + ", Room Capacity: " + roomCapacity;
       }
    
    /**
     * utility compares two strings, utility method
     * for other methods
     * 
     * @param oneString one of the two strings to be compared
     * 
     * @param otherString the other of the two strings to be compared
     * 
     * @return first greater than second: greater than zero;
     * first equal to second: equals zero
     * first less than second: less than zero
     */
    public int compareStrings( String oneString, String otherString )
       {
        int difference, index = 0;

        while( index < oneString.length() && index < otherString.length() )
          {
           difference = toLower( oneString.charAt( index ) ) 
                        - toLower( otherString.charAt( index ) );

           if( difference != 0 )
              {
               return difference;
              }

           index++;
          }

       return oneString.length() - otherString.length();
      }        
    
    /**
     * utility for setting a single upper case letter to lower case
     * 
     * @param testChar character to be set to lower case
     * if it is an upper case letter
     * 
     * @return character lower case of given upper case letter;
     * unchanged input character if input is not upper case letter
     */
    char toLower( char testChar )
       {
        if( testChar >= 'A' && testChar <= 'Z' )
           {
            return (char)( testChar - 'A' + 'a' );
           }
        
        return testChar;
       }
   }
