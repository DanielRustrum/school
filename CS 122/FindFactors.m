%
% Script/Function: FindFactors
%
% Description: finds prime factors for a given value
%
% Algorithm: starts with lowest prime factor (2), tests and loops
%            until all factors found
%
% Function Input: given value
%
% Function Output: array of factors
%
% Device Input: none
%
% Device Output: none
%
% Dependencies: mod, abs used to make value positive
%
% Author: Michael Leverington
%
% Revision: Rev 1.00, 29 April 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function factors = FindFactors( value )

   % set test value to input value magnitude
   testVal = abs( value );
   
   % initialize array index to 1
   arrIndex = 1;
   
   % start loop until value is 1
   while testVal > 1
      %
       % set initial prime to 2
       factor = 2;
       
       % loop until factor found
       while mod( testVal, factor ) ~= 0 
          %    
           % increment factor
           factor = factor + 1;
          %
       end
       % end factor search loop
      
       % place factor in array
       factors( arrIndex ) = factor;
       
       % increment array index
       arrIndex = arrIndex + 1;
      
       % divide by factor to find remaining value
       testVal = testVal / factor;
      %   
   end   
   % end value loop
end
% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
