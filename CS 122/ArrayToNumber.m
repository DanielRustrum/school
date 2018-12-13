%
% Script/Function: ArrayToNumber
%
% Description: makes number out of array of digits
%
% Algorithm: iterates through array, adding digits to value
%
% Function Input: array of digits
%
% Function Output: numerical value of digit array
%
% Device Input: none
%
% Device Output: none
%
% Dependencies: none
%
% Author: Michael Leverington
%
% Revision: Rev 1.00, 03 March 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function numVal = ArrayToNumber( inputArray )
  
   % set base number to zero
   numVal = 0;
   
   % set multiplier to 1
   multiplier = 1;
   
   % loop across array of digits 
   for index = 1:length( inputArray )
      %
       % get digit from array
       digit = inputArray( index ) * multiplier;
       
       % add digit to number
       numVal = numVal + digit;
       
       % update multiplier
       multiplier = multiplier * 10;
      %
   end
   % end loop across half of array
end

% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
