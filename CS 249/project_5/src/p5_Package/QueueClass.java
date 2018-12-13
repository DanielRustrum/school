package p5_Package;

public class QueueClass {
    /**
     * queue data
     */
    public IteratorClass queueData;
    
    /**
     * default constructor
     */
    QueueClass()
    {
        queueData = new IteratorClass();
    }
    
    /**
     * initialization constructor,
     * 
     * @param setCapacity value for setting data capacity
     */
    QueueClass(int setCapacity)
    {
        queueData = new IteratorClass(setCapacity);
    }
    
    /**
     * copies a QueueClass object
     * 
     * @param copied QueueClass object to be copied
     */
    QueueClass(QueueClass copied)
    {
        queueData = new IteratorClass(copied.queueData);
    }
    
    /**
     * Puts data at the end of the queue
     * 
     * @param value integer data to be enqueued
     */
    public void enqueue(int value)
    {
        queueData.setToEnd();
        queueData.insertAfterIterator(value);
        queueData.setToBeginning();
    }
    
    /**
     * views data at front of queue
     * 
     * @return integer value found at front of queue
     */
    public int peekFront()
    {
        return queueData.retrieveAtCurrent();
    }
    
    /**
     * Removes data at the front of a queue
     * 
     * @return integer value removed from queue
     */
    public int dequeue()
    {
        int result = queueData.removeAtCurrent();
        queueData.setToBeginning();
        return result;
    }
    
    /**
     * clears queue data
     */
    public void clear()
    {
        queueData.clear();
    }
    
    /**
     * provides array data as a string
     */
    @Override
    public String toString()
    {
        return queueData.toString();
    }
}
