%
% Script/Function: FindFactorial
%
% Description: finds factorial of given number
%
% Algorithm: uses repeated multiplication for factorial
%
% Function Input: value from which factorial will be found
%
% Function Output: factorial of value
%
% Device Input: none
%
% Device Output: none
%
% Dependencies: abs used to make value positive
%
% Author: Michael Leverington
%
% Revision: Rev 1.00, 29 April 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function factResult = FindFactorial( value )

   % set test value to input value
   workingVal = abs( value );
   
   % set initial factorial to 1
   factResult = 1;
   
   % loop while value greater than 1
   while workingVal > 1 
      %
       % multiply factorial by one less
       factResult = factResult * workingVal;
       
       % reduce working value by 1
       workingVal = workingVal - 1;
      %
   end
   % end value loop
end
% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
