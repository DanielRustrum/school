package p5_Package;

/**
 * @author daniel_rustrum
 *
 */
public class IteratorClass {
    /**
     * constant value for initializing default capacity array
     */
    private static final int DEFUALT_CAPACITY = 10;
    /**
     * for access failure messaging
     */
    public static final int FAILED_ACCESS = -999999;
    /**
     * Stores current capacity 
     */
    private int iterCapacity;
    /**
     * Stores current size
     */
    private int iterSize;
    /**
     * Stores iterator index
     */
    private int iterIndex;
    /**
     * Stores iterator data
     */
    private int[] iterStorage;
    
    /**
     * Default constructor
     * 
     */
    IteratorClass()
    {
        iterCapacity = DEFUALT_CAPACITY;
        iterSize = 0;
        iterIndex = 0;
        iterStorage = new int[iterCapacity];
    }
    
    /**
     * Initialization constructor 
     * 
     * @param capacitySetting initial capacity of iterator class
     */
    IteratorClass(int capacitySetting)
    {
        iterCapacity = capacitySetting;
        iterSize = 0;
        iterIndex = 0;
        iterStorage = new int[capacitySetting];
    }
    
    /**
     * Copy constructor 
     * 
     * @param copied IteratorClass object to be copied
     */
    IteratorClass(IteratorClass copied)
    {
        int index;
        iterCapacity = copied.iterCapacity;
        iterSize = copied.iterSize;
        iterIndex = copied.iterIndex;
        iterStorage = new int[iterCapacity];
        for(index = 0; index < iterSize; index++)
        {
            iterStorage[ index ] = copied.iterStorage[ index ];
        }

    }

    /**
     * Shuffles The Array Index Left
     * 
     * @param currentIndex The Index To Stop Shuffling At
     */
    private void shuffleLeft(int currentIndex)
    {
        int index;
        for(index = iterSize-1; index >= currentIndex; index--)
        {
            iterStorage[index+1] = iterStorage[index];
        }
    }
    
    /**
     * Inserts item prior to iterator index in list and moves index to new Item
     * 
     * It will Resize the array if needed
     * 
     * @param newValue
     */
    public void insertPriorToIterator(int newValue)
    {
        int wantedIndex = iterIndex - 1;
        checkForResize();
        //Shuffle Indexes Right To Clear Spot
        shuffleLeft(wantedIndex);
        iterSize++;
        // Store Value
        iterStorage[wantedIndex] = newValue;
        iterIndex = wantedIndex;
    }
    
    /**
     * Inserts item after iterator index in list and move the iterator
     * and resize the array if needed
     * 
     * @param newValue
     */
    public void insertAfterIterator(int newValue)
    {
        int wantedIndex = iterIndex + 1;
        checkForResize();
        //Shuffle Indexes Right To Clear Spot
        shuffleLeft(wantedIndex);
        iterSize++;
        // Store Value
        iterStorage[wantedIndex] = newValue;
        iterIndex = wantedIndex;
    }
    
    /**
     * Moves to next index
     */
    public void moveNext()
    {
        iterIndex = iterIndex + 1;
    }
    
    /**
     * Moves To Previous Index
     */
    public void movePrevious()
    {
        iterIndex = iterIndex - 1;
    }
    
    /**
     * Gets value at current location of iterator
     * 
     * @return Value if successful, FAILED_ACCESS if not
     */
    public int retrieveAtCurrent()
    {
        try
        {
            return iterStorage[iterIndex];            
        }
        catch(IndexOutOfBoundsException valueNotUse)
        {
            return FAILED_ACCESS;
        }
    }
    
    /**
     * Shuffle The array Elements Right
     * 
     * @param currentIndex Index To Start At
     */
    private void shuffleRight(int currentIndex)
    {
        int index;
        for(index = currentIndex; index < iterSize; index++)
        {
            iterStorage[index] = iterStorage[index+1];
        }
    }
    
    /**
     * Removes and returns value from list at current iterator position 
     * 
     * @return Value returned if successful, FAILED_ACCESS if not
     */
    public int removeAtCurrent()
    {
        try
        {
            int value;
            value = iterStorage[iterIndex];
            // Shuffle Left to remove value
            shuffleRight(iterIndex);
            //Decrease Size
            iterSize--;
            //Move Iterator
            movePrevious();
            return value;
        }
        catch(IndexOutOfBoundsException valueNotUse)
        {
            return FAILED_ACCESS;
        }
    }
    
    /**
     * Set Index To The Beginning of array
     */
    public void setToBeginning()
    {
        iterIndex = 0;
    }
    
    /**
     * Sets Index To End of array
     */
    public void setToEnd()
    {
        iterIndex = iterSize-1;
    }
    
    /**
     * checks for iterator at end of list
     * 
     * @return Boolean result of test
     */
    public boolean isAtEnd()
    {
        return (iterIndex == iterSize);
    }
    
    /**
     * checks for iterator at beginning of list
     * 
     * @return Boolean result of test
     */
    public boolean isAtBeginning()
    {
        return (iterIndex == 0);
    }
    
    /**
     * checks for empty list
     * 
     * @return Boolean result of test
     */
    public boolean isEmpty()
    {
        return (iterSize == 0);
    }
    
    /**
     * Check if array resize is needed
     * Resizes to double the current array capacity
     */
    private void checkForResize()
    {
        int index;
        int[] dataHolder = new int[iterCapacity];
        if(iterSize == iterCapacity)
        {
            // Copy Data For Storage
            for(index = 0; index < iterSize; index++)
            {
                dataHolder[ index ] = iterStorage[ index ];
            }
            //Increase Storage
            iterCapacity *= 2;
            iterStorage = new int[iterCapacity];
            // Copy Data Back into Array
            for(index = 0; index < iterSize; index++)
            {
                iterStorage[ index ] = dataHolder[ index ];
            }
        }
    }
    
    /**
     * Sets size and index to 0
     */
    public void clear()
    {
        iterSize = 0;
        iterIndex = 0;
    }
    
    /**
     * provides array data as a string, including indication of current element, 
     */
    @Override
    public String toString()
    {
        String result = "";
        int index;
        for(index = 0; index < iterSize; index++)
        {
            if(index == iterIndex)
            {
                result += "|" + iterStorage[index] + "| ";
            }
            else
            {
                result += iterStorage[index] + " ";
            }
        }
        return result;
    }
}
