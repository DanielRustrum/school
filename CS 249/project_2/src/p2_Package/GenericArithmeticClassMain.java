package p2_Package;

public class GenericArithmeticClassMain
   {
    public static final int UPPER_LIMIT = 999;
    public static final int LOWER_LIMIT = 100;
    public static final int DEFAULT_DIGIT_SIZE = 20;
   
    public static void main(String[] args)
       {
        int index, result, base = 16, decimalValDigits = 5, numDigitArrayDigits = 12, arrayCapacity = 50;
        BaseClass bc_1 = new BaseClass( base, numDigitArrayDigits, "1174" );
        BaseClass bc_2 = new BaseClass( base, numDigitArrayDigits, "74" );
        BaseClass tempBC;
        GenericArithmeticClass<BaseClass> ac = new GenericArithmeticClass<BaseClass>( 2 );

        System.out.println( "BC_1: (" + bc_1.getValueAsBase() + ") " + bc_1.getValueAsDecimal() );
        System.out.println( "BC_2: (" + bc_2.getValueAsBase() + ") " + bc_2.getValueAsDecimal() );

        System.out.println( "BC_1: " + bc_1.toString() );
        System.out.println( "BC_2: " + bc_2.toString() );

        result = bc_1.compareTo( bc_2 );
        
        if( result > 0 )
           {
            System.out.println( "Result: " + result + ", BC_1 is greater than BC_2");
           }
        
        else if( result < 0 )
           {
            System.out.println( "Result: " + result + ", BC_1 is less than BC_2");
           }
        
        else
           {
            System.out.println( "Result: " + result + ", BC_1 is equal to BC_2");            
           }
        
        ac.setValueAt( 0,  bc_1 );
        ac.setValueAt( 1,  bc_2 );
        
        System.out.println( "bc_1 from GenArrClass: " + ac.getValueAt( 0 ) );
        System.out.println( "bc_2 from GenArrClass: " + ac.getValueAt( 1 ) );
        
        ac = createValues( base, arrayCapacity, decimalValDigits );
      
        // ac.runBubbleSort( arrayCapacity );
        // ac.runSelectionSort( arrayCapacity );
        // ac.runInsertionSort( arrayCapacity );
        
        for( index = 0; index < arrayCapacity; index++ )
           {      
            tempBC = ac.getValueAt( index );
            System.out.println( "Value: " + tempBC );
           }
        
       }

    public static GenericArithmeticClass<BaseClass> createValues( int base, int numItems, int numDecimalDigits )
       {
        int valsIndex;
        String newNumString;
        String[] numStrs = new String[ numItems ];
        BaseClass tempValue;
        GenericArithmeticClass<BaseClass> values = new GenericArithmeticClass<BaseClass>( numItems );
        
        for( valsIndex = 0; valsIndex < numItems; valsIndex++ )
           {
            do
               {
                newNumString = generateStringRand( numDecimalDigits );
               }
            while( valueInArray( numStrs, newNumString, valsIndex ) );

            numStrs[ valsIndex ] = newNumString;
            
            tempValue = new BaseClass( base, DEFAULT_DIGIT_SIZE, newNumString );
            
            values.setValueAt( valsIndex, tempValue );            
           }
    
        return values;
       }
    
    // makes simple string check; does not check for value
    public static boolean valueInArray( String[] list, String testVal, int numItems )
       {
        int index;
        
        for( index = 0; index < numItems; index++ )
           {
            if( list[ index ].equals( testVal ) )
               {
                return true;
               }
           }
        
        return false;
       }

    public static String generateStringRand( int numDigits )
       {
        final int RANDOM_LIMIT = 1000000;
        int numberIndex, value, range = 10; // number of digits in decimal
        String strValue = "";
        boolean firstVal = true;
        
        for( numberIndex = 0; numberIndex < numDigits; numberIndex++ )
           {
            do
               {
                value = (int)( Math.random() * RANDOM_LIMIT ) % range;
               }
            while( firstVal && value == 0 );
       
            strValue += (char)( value + '0' );
            
            firstVal = false;
           }
        
        return strValue;
       }
   }
