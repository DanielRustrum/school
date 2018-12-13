        %
% Script/Program: FindPrimes
%
% Description: finds primary numbers between two given limits (inclusive)
%
% Author: Michael Leverington
%
% Revision: Rev 1.00, 29 April 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% reference data
NUM_VALUES_PER_LINE = 10;

% title (fprintf)
fprintf( '\nPrime Number Finding Program\n' );
fprintf( '============================\n\n' );

% get input from user

   % get lower limit (input)
   lowerLimit = input( 'Enter lower limit of number range: ' );
   
   % get upper limit (input)
   upperLimit = input( 'Enter upper limit of number range: ' );

% process data - find primes

   % set array index to 1
   index = 1;
   
   % loop across given range
   for testVal = lowerLimit:upperLimit
      %
       if ValueIsPrime( testVal )
          %
           primeArr( index ) = testVal;
           
           index = index + 1;
          %
       end
      %
   end
   % end of loop across range
   
% show results

   % show output header (fprintf)
   fprintf( '\nPrimes between %d and %d:\n', lowerLimit, upperLimit );

   % show values (DisplayIntData)
   DisplayIntData( primeArr, NUM_VALUES_PER_LINE );


% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
