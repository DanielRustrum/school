public class GenericBSTClass<GenericData extends Comparable>
{
    BST_Node BST_Root;

    private class BST_Node
    {

        GenericData data;
        BST_Node leftChild;
        BST_Node rightChild;

        public BST_Node( GenericData inData )
        {
            data = inData;

            leftChild = null;
            rightChild = null;
        }
    }

    public GenericBSTClass()
    {
        BST_Root = null;
    }

    public void insert( GenericData inData )
    {
        if( BST_Root == null )
            {
                BST_Root = new BST_Node( inData );
            }
        else
            {
                insertHelper( BST_Root, inData );
            }
    }

    @SuppressWarnings( "unchecked" )
    public void insertHelper( BST_Node localRoot, GenericData inData )
    {
        int compareValue = localRoot.nodeData.compareTo( inData );
        if( compareValue > 0 )
            {
                if( localRoot.leftChildRef == null )
                    {
                        localRoot.leftChildRef = new BST_Node( inData );
                    }
                else
                    {
                        insertHeper( localRoot.leftChildRef, inData );
                    }
            }
        else 
            {
                if( localRoot.rightChildRef == null )
                    {
                        localRoot.rightChildRef = new BST_Node( inData );
                    }
                else
                    {
                        insertHelper( localRoot.rightChildRef, inData );
                    }
            }
    }

    public GenericData removeNode( GenericData inData )
    {
        GenericData returnData = null;

        if( BST_Root != null )
            {
                returnData = search( inData );
                removeNodeHelper( BST_Root, inData );
            }
        return returnData;
    }

    public GenericData removeNodeHelper( BST_Node localRoot, GenericData outData )
    {
        int compareResult = localRoot.nodeData.compareTo( outData );

        // binary search for node to remove
        if( compareResult > 0 )
            {
                localRoot.leftChildRef = removeNodeHelper( localRoot.leftChildRef, outData );
            }
        else if( compareResult < 0 )
            {
                localRoot.rightChildRef = removeNodeHelper( localRoot.rightChildRef, outData );
            }
        // we found it!
        else
            {
                // case 1: localRoot with no children
                if( localRoot.leftChildRef == null && localRoot.rightChildRef == null )
                    {
                        localRoot = null;
                    }
                // case 2: localRoot with one child
                else if( localRoot.leftChildRef == null )
                    {
                        localRoot = localRoot.rightChildRef;
                    }
                else if( localRoot.rightChildRef == null )
                    {
                        localRoot = localRoot.leftChildRef;
                    }
                // case 3: localRoot with two children
                else
                    {
                        if( localRoot.leftChildRef.rightChildRef == null )
                            {
                                localRoot.nodeData = localRoot.leftChildRef.nodeData;
                                localRoot.leftChildRef = localRoot.leftChildRef.leftChildRef;
                            }
                        else
                            {
                                localRoot.nodeData = removeFromMax( localRoot, localRoot.leftChildRef ).nodeData;
                            }
                    }
            }
        return localRoot;
    }

    public GenericData removeFromMax( BST_Node maxParent, BST_Node maxLoc )
    {
        if( maxLoc.rightChild != null )
            {
                return BST_Node( maxLoc, maxLoc.rightChild );
            }


        maxParent.rightChild = null;
        return maxLoc;
    }


    public BST_Node rotateRight( BST_Node localRef )
    {
        BST_Node newRoot = localRoot.leftChildRef;
        BST_Node rightSubTree = newRoot.rightChildRef;

        newRoot.rightChildRef = localRef;
        localRef.leftChildRef = rightSubTree;

        return newRoot;
    }

    public BST_Node rotateLeft( BST_Node localRef )
    {
        BST_Node newRoot = localRoot.rightChildRef;
        BST_Node leftSubTree = newRoot.leftChildRef;

        newRoot.leftChild = localRef;
        localRef.rightChildRef = leftSubTree;
    }
}


public String getALine( int numChars, char delimiterChar )
{
    int index = 0;
    int inCharInt;
    String strBuff = "";

    try
        {
            inCharInt = fileIn.read();

            // swallow leading spaces
            while( inCharInt <= SPACE && index < numChars )
                {
                    if( (char) inCharInt == EOF )
                        {
                            return "EndOfFile";
                        }

                    inCharInt = fileIn.read();
                    index++;
                }

            while( index < numChars && (char) inCharInt != delimeterChar )
                {
                    if( inCharInt >= SPACE )
                        {
                            strBuff += (char) inCharInt;
                            index++;
                        }
                    inCharInt = fileIn.read();
                }
        }

    catch( IOException ioe )
        {
            return IOException;
        }

    return strBuff;
}

public int getAnInt( int numChars )
{
    boolean negativeFlag;

    String strBuff;
    int integerValue;
    int index = 0;
    int inCharInt;
    try
        {

            inCharInt = fileIn.read();

            while( index < numChars && !charInString( (char) inCharInt, "0123456789+-" ) )
                {
                    inCharInt = fileIn.read();
                    index++;
                }

            if( (char) inCharInt == MINUS_SIGN )
                {
                    negativeFlag = true;
                    inCharInt = fileIn.read();
                }

            while( charInString( (char) inCharInt, "0123456789" ) )
                {
                    strBuff += (char) inCharInt;
                    inCharInt = filein.read();
                }

        }

    catch( IOException ioe )
        {
            System.out.println( "IOException" );
            return 0;
        }

    integerValue = Integer.parseInt( strBuff );

    if( negativeFlag )
        {
            integerValue *= -1;
        }

    return integerValue;
}
