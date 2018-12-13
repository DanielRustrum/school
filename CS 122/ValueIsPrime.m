%
% Script/Function: ValueIsPrime
%
% Description: reports if a value is prime or not
%
% Algorithm: iterates across all integer values up to
%            and including one more than the square root of the value
%
% Function Input: value to be checked for prime
%
% Function Output: true or false depending on the value
%
% Device Input: none
%
% Device Output: none
%
% Dependencies: abs used to make input value positive
%
% Author: Michael Leverington
%
% Revision: Rev 1.00, 29 April 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function primeFlag = ValueIsPrime( value )

   % find the magnitude of the number
   limit = abs( value );
   
   % find the square root of the number
   limit = sqrt( limit );
   
   % find first integer above square root
   limit = floor( limit + 1 );
   
   % initialize loop
   divisor = 2;
   
   % set prime flag to true
   primeFlag = true;
   
   % loop up to limit or if division found
   while divisor <= limit && primeFlag
      %
       % check for division
       if mod( value, divisor ) == 0
          %
           % set prime flag to false
           primeFlag = false;
          %
       end
          
       % update divisor value
       divisor = divisor + 1;
      %
   end
   % end of iterating division loop
end
% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
