package p5_Package;

public class StackClass {
    /**
     * stack data managed by IteratorClass object
     */
    public IteratorClass stackData;
    
    /**
     * default constructor
     */
    StackClass()
    {
        stackData = new IteratorClass();
        stackData.setToEnd();
    }
    
    /**
     * initialization constructor
     * 
     * @param setCapacity sets integer value to capacity
     */
    StackClass(int setCapacity)
    {
        stackData = new IteratorClass(setCapacity);
        stackData.setToEnd();
    }
    
    /**
     * copies a StackClass object
     * 
     * @param copied StackClass object
     */
    StackClass(StackClass copied)
    {
        stackData = new IteratorClass(copied.stackData);
    }
    
    /**
     * places a value on the stack
     * 
     * @param value value to be placed
     */
    public void push(int value)
    {
        stackData.insertAfterIterator(value);
    }
    
    /**
     * views the value on the top
     * 
     * @return value found on top
     */
    public int peekTop()
    {
        return stackData.retrieveAtCurrent();
    }
    
    /**
     * removes a value from the top of the stack
     * 
     * @return value removed from the top of the stack
     */
    public int pop()
    {
        return stackData.removeAtCurrent();
    }
    
    /**
     * clears stack data
     */
    public void clear()
    {
        stackData.clear();
    }
    
    /**
     * provides array data as a string
     */
    @Override
    public String toString()
    {
        return stackData.toString();
    }
}
