package p6_Package;

public class StackClassLL {
    /**
     * stack data managed by IteratorClass object
     */
    public IteratorClassLL stackData;
    
    /**
     * default constructor
     */
    StackClassLL()
    {
        stackData = new IteratorClassLL();
        stackData.setToEnd();
    }
    
    /**
     * copies a StackClass object
     * 
     * @param copied StackClass object
     */
    StackClassLL(StackClassLL copied)
    {
        stackData = new IteratorClassLL(copied.stackData);
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
