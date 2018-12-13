import java.util.Arrays;

public class HeapArray
{

    public static final int DEFAULT_SIZE = 26;
    private static final char NULL_CHAR = '\0';

    private int arrayCapacity;
    private int arraySize;
        
    private int[] arrayData;

    public HeapArray()
    {
        arrayCapacity = DEFAULT_SIZE;
        arrayData = new int[ arrayCapacity ];

        arraySize = 0;
    }

    public HeapArray( int size )
    {
        arrayCapacity = size;
        arrayData = new int[ arrayCapacity ];

        arraySize = 0;
    }

    public void addItem( int dataChar )
    {
        if( arraySize < arrayCapacity )
            {
                arrayData[ arraySize ] = dataChar;
                bubbleUpHeap( arraySize );
                arraySize++;
            }
    }

    private void bubbleUpHeap( int currentItem )
    {
        if( currentItem > 0 )
            {
                int startingIndex = currentItem;
                int parentIndex = ( currentItem - 1 ) / 2;

                if( arrayData[ parentIndex ] < arrayData[ startingIndex ] )
                    {
                        swapElements( startingIndex, parentIndex );
                        bubbleUpHeap( parentIndex );
                    }
            }
    }


    public void swapElements( int first, int second )
    {
        int temp = arrayData[ first ];
        arrayData[ first ] = arrayData[ second ];
        arrayData[ second ] =  temp;
    }

    public int removeItem()
    {
        int newData;
        int removedData = -1;

        if( arraySize > 0 )
            {
                newData = arrayData[ arraySize - 1];
                removedData = arrayData[ 0 ];
            
                arrayData[ 0 ] = newData;

                arraySize--;
                trickleDownHeap( 0 );
            }
        return removedData;
    }

    public int findLeftHeight( int index )
    {
        if( index < arraySize )
            {
                return 1 + findLeftHeight( ( index * 2 ) + 1 );
            }
        return -1;
    }

    public int findRightHeight( int index )
    {
        if( index < arraySize )
            {
                return 1 + findRightHeight( ( index * 2 ) + 2 );
            }
        return -1;
    }

    private void trickleDownHeap( int currentIndex )
    {
        int leftChildIndex;
        int rightChildIndex;
        int maxIndex;

        if( currentIndex < arraySize )
            {
                leftChildIndex = ( 2 * currentIndex ) + 1;
                rightChildIndex = ( 2 * currentIndex ) + 2;

                if( rightChildIndex >= arraySize )
                    {
                        if( leftChildIndex >= arraySize )
                            {
                                return;
                            }
                        maxIndex = leftChildIndex;
                    }
                else if( arrayData[ leftChildIndex ] < arrayData[ rightChildIndex ] )
                    {
                        maxIndex = rightChildIndex;
                    }
                else
                    {
                        maxIndex = leftChildIndex;
                    }

                if( arrayData[ maxIndex ] > arrayData[ currentIndex ] )
                    {
                        swapElements( maxIndex, currentIndex );
                        trickleDownHeap( maxIndex );
                    }
            }
    }
    
    public String toString()
    {
        int index;

        String strBuf = "";
        for( index = 0; index < arraySize; index++ )
            {
                strBuf +=  arrayData[ index ] + " ";
            }
        return strBuf;
    }
    
    public static void main( String[] args )
    {
        HeapArray ha = new HeapArray();

        int index;
        ha.addItem( 25 );
        ha.addItem( 28 );
        ha.addItem( 2 );
        ha.addItem( 19 );
        ha.addItem( 34 );
        ha.addItem( 108 );
        ha.addItem( 12 );
        ha.addItem( 8 );
        ha.addItem( 190 );
        ha.addItem( 1122 );
        System.out.println( ha );
        System.out.println( ha.removeItem() );
        System.out.println( ha.removeItem() );
        System.out.println( ha.removeItem() );
        System.out.println( ha.removeItem() );
        System.out.println( ha.removeItem() );
        System.out.println( ha.removeItem() );
        System.out.println( ha.removeItem() );
        System.out.println( ha.removeItem() );
        System.out.println( ha.removeItem() );
        System.out.println( ha.removeItem() );
        System.out.println( ha.removeItem() );
        System.out.println( ha.removeItem() );
        System.out.println( ha.removeItem() );

    }
}
