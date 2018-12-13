%
% Script/Program: FindGCD
%
% Description: Finds the greatest common divisor between two values
%
% Author: Michael Leverington
%
% Revision: Rev 1.00, 27 April 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% title
fprintf( '\nGCD Finding Program\n' );
fprintf( '===================\n\n' );

% data entry - user input

   % get first number
   firstNum = input( 'Enter first of two numbers: ' );
   
   % get second number
   secondNum = input( 'Enter second of two numbers: ' );
   
% processing - finding the GCS

   % find the smaller of the two values (FindSmallestValue)
   smaller = FindSmallestValue( firstNum, secondNum );
   
   % find the larger of the two values (FindLargestValue)
   larger = FindLargestValue( firstNum, secondNum );
   
   % set test GCD value to smaller value
   GCD_TestValue = smaller;
   
   % set GCD found flag to false
   GCD_FoundFlag = false;
   
   % loop until GCD found
   while ~GCD_FoundFlag
      %
       % check for common divisor (mod)
       if mod( smaller, GCD_TestValue ) == 0 ...
                                    && mod( larger, GCD_TestValue ) == 0 
          %
           % assign answer to test value
           gcdValue = GCD_TestValue;
           
           % set found flag to true
           GCD_FoundFlag = true;
          %
          
       else
          %
           % decrement gcd test value
           GCD_TestValue = GCD_TestValue - 1;
          %
       end
      %
   end
   % end GCD finding loop
   
% display results

   % show gcd of the two numbers (fprintf)
   fprintf( '\nThe GCD of the values %d and %d is %d\n\n', ...
                                              smaller, larger, gcdValue );

% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
