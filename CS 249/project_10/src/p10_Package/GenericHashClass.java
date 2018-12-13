package p10_Package;

public class GenericHashClass<GenericData extends java.lang.Comparable<GenericData>> {
    /**
     * Table size default
     */
    private final int DEFAULT_TABLE_SIZE = 10;
    /**
     * Default number of characters of data string to use in hash calculation
     */
    private final int DEFAULT_NUM_HASH_DIGITS = 6;
    /**
     * Constant for returning item not found with search
     */
    public final int ITEM_NOT_FOUND = -1;
    /**
     * Constant for setting linear probing
     */
    public static final int LINEAR_PROBING = 101;
    /**
     * Constant for setting quadratic probing
     */
    public static final int QUADRATIC_PROBING = 102;
    /**
     * Working number of characters from data string to use in hash calculation
     */
    private int numHashDigits;
    /**
     * Size of the array table
     */
    private int tableSize;
    /**
     * Flag for setting linear or quadratic probing
     */
    private int probeFlag;
    /**
     * Array for hash table
     */
    private Object[] tableArray;
    
    /**
     * Default constructor 
     */
    public GenericHashClass()
    {
        int index;
        tableSize = DEFAULT_TABLE_SIZE;
        numHashDigits = DEFAULT_NUM_HASH_DIGITS;
        probeFlag = LINEAR_PROBING;
        tableArray = new Object[tableSize];
        for(index = 0; index < tableSize; index++)
        {
            tableArray[index] = null;
        }
    }
    
    /**
     * Initialization constructor
     * @param inProbeFlag sets linear or quadratic probing
     */
    public GenericHashClass(int inProbeFlag)
    {
        int index;
        tableSize = DEFAULT_TABLE_SIZE;
        numHashDigits = DEFAULT_NUM_HASH_DIGITS;
        probeFlag = inProbeFlag;
        tableArray = new Object[tableSize];
        for(index = 0; index < tableSize; index++)
        {
            tableArray[index] = null;
        }
    }
    
    /**
     * Initialization constructor
     * 
     * @param inTableSize sets table size
     * @param inHashDigits sets number of characters from data string for use in has
     * @param inProbeFlag sets linear or quadratic probing
     */
    public GenericHashClass(int inTableSize,
                            int inHashDigits,
                            int inProbeFlag)
    {
        int index;
        tableSize = inTableSize;
        numHashDigits = inHashDigits;
        probeFlag = inProbeFlag;
        tableArray = new Object[tableSize];
        for(index = 0; index < tableSize; index++)
        {
            tableArray[index] = null;
        }
    }
    
    /**
     * Copy constructor
     * 
     * @param copied GenericHashClass copied object
     */
    public GenericHashClass(GenericHashClass<GenericData> copied)
    {
        int index;
        tableSize = copied.tableSize;
        numHashDigits = copied.numHashDigits;
        probeFlag = copied.probeFlag;
        for(index = 0; index < tableSize; index++)
        {
            tableArray[index] = copied.tableArray[index];
        }
    }
    
    /**
     * Adds GenericData item to hash table
     * 
     * @param newItem GenericData item
     * @return Boolean success of operation
     */
    public boolean addItem(GenericData newItem)
    {
        int hashIndex, loopIndex = 1, hashPower, quadHashStorage;
        final int quadraticPower = 2;
        boolean foundItem = false;
        hashIndex = generateHash(newItem);
        quadHashStorage = hashIndex;
        while(!foundItem && hashIndex < tableSize)
        {
            if(tableArray[hashIndex] == null)
            {
                tableArray[hashIndex] = newItem;
                return true;
            }
            if(probeFlag == QUADRATIC_PROBING)
            {
                hashPower = toPower(loopIndex, quadraticPower);
                hashIndex = quadHashStorage + hashPower;
            }
            else
            {
                hashIndex++;
            }
            loopIndex++;
        }
        return false;
    }
    
    /**
     * Removes item from hash table
     * 
     * @param toBeRemoved GenericData value used for requesting data uses findItemInde
     * @return GenericData item removed, or null if not found
     */
    @SuppressWarnings("unchecked")
    public GenericData removeItem(GenericData toBeRemoved)
    {
        int itemIndex;
        GenericData itemFound;
        itemIndex = findItemIndex(toBeRemoved);
        itemFound = (GenericData)tableArray[itemIndex];
        tableArray[itemIndex] = null;
        return itemFound;
    }
    
    /**
     * Returns item found
     * 
     * @param searchItem GenericData value to be found; uses findItemIndex
     * @return GenericData item found
     */
    @SuppressWarnings("unchecked")
    public GenericData findItem(GenericData searchItem)
    {
        int hashIndex, loopIndex = 1, hashPower, quadHashStorage;
        final int quadraticPower = 2;
        boolean foundItem = false;
        hashIndex = generateHash(searchItem);
        quadHashStorage = hashIndex;
        while(!foundItem && hashIndex < tableSize)
        {
            if(tableArray[hashIndex] == searchItem)
            {
                return (GenericData)tableArray[hashIndex];
            }
            if(probeFlag == QUADRATIC_PROBING)
            {
                hashPower = toPower(loopIndex, quadraticPower);
                hashIndex = quadHashStorage + hashPower;
            }
            else
            {
                hashIndex++;
            }
            loopIndex++;
        }
        return null;
    }
    
    /**
     * Searches for item index in hash table
     * 
     * @param searchItem GenericData value to be found
     * @return integer index location of search item
     */
    private int findItemIndex(GenericData searchItem)
    {
        int hashIndex, loopIndex = 1, hashPower, quadHashStorage;
        final int quadraticPower = 2;
        boolean foundItem = false;
        hashIndex = generateHash(searchItem);
        quadHashStorage = hashIndex;
        while(!foundItem && hashIndex < tableSize)
        {
            if(tableArray[hashIndex] == searchItem)
            {
                return hashIndex;
            }
            if(probeFlag == QUADRATIC_PROBING)
            {
                hashPower = toPower(loopIndex, quadraticPower);
                hashIndex = quadHashStorage + hashPower;
            }
            else
            {
                hashIndex++;
            }
            loopIndex++;
        }
        return ITEM_NOT_FOUND;
    }
    
    /**
     * Method converts GenericData item to hash value for use in hash table
     * 
     * @param item GenericData value to be converted to hash value
     * @return integer hash value
     */
    public int generateHash(GenericData item)
    {
        int index,hashedDigits = 0;
        String foundItem;
        foundItem = item.toString();
        for(index = 0; index < numHashDigits; index++)
        {
            hashedDigits += (int)foundItem.charAt(index);
        }
        return hashedDigits % tableSize;
    }
    
    /**
     * traverses through all array bins, finds min and max number of contiguous elements,
     *  and number of empty nodes; also shows table loading
     * 
     * @return String result of hash table analysis
     */
    public String showHashTableStatus()
    {
        int index, index2, maxData = 0, minData = tableSize, nullData = 0;
        int dataLengthIndex = 0;
        int[] dataLengths = new int[tableSize];
        String formattedString ="";
        
        for(index = 0; index < tableSize; index++)
        {
            if(tableArray[index] != null)
            {
                maxData++;
                formattedString += "D";
            }
            else
            {
                nullData++;
                dataLengths[dataLengthIndex] = maxData;
                maxData = 0;
                formattedString += "N";
                dataLengthIndex++;
            }
        }
        for(index2 = 0; index2 < tableSize; index2++)
        {
            if(dataLengths[index2] != 0 && dataLengths[index2] < minData)
            {
                minData = dataLengths[index2];
            }
            if(dataLengths[index2] > maxData)
            {
                maxData = dataLengths[index2];
            }
        }
        if(nullData == tableSize)
        {
            minData = 0;
            maxData = 0;
        }
        System.out.println("Hash Table Status:" + formattedString + "\n");
        System.out.println("Min contiguous: " + minData);
        System.out.println("Max contiguous: " + maxData);
        System.out.println("Empty Bin: " + nullData);
        return formattedString;
    }
    
    /**
     * Clears hash table by setting all bins to null
     */
    public void clearHashTable()
    {
        int index;
        tableArray = new Object[tableSize];
        for(index = 0; index < tableSize; index++)
        {
            tableArray[index] = null;
        }
    }
    
    /**
     * Local recursive method to calculate exponentiation with integers
     * 
     * @param base base of exponentiation
     * @param exponent exponent of exponentiation
     * @return result of exponentiation calculation
     */
    private int toPower(int base,
                        int exponent)
    {  
        if(exponent == 1)
        {
            return base;
        }
        return toPower(base, exponent-1) * base;
    }
}
