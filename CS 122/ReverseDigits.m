%
% Script/Function: ReverseDigits
%
% Description: reverses digits in an array of integers
%
% Algorithm: iterates through half of array, swapping ends
%
% Function Input: array of digits
%
% Function Output: array of digits reversed
%
% Device Input: none
%
% Device Output: none
%
% Dependencies: length
%
% Author: Michael Leverington
%
% Revision: Rev 1.00, 03 March 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function revArray = ReverseDigits( inputArray )

   % set return array to input array
   revArray = inputArray;
   
   % set upper and lower indices
   lowerIndex = 1;
   upperIndex = length( inputArray );
   
   % loop from beginning to half way through 
   while lowerIndex < upperIndex
      %
       % swap ends
       
          % assign one element to a temporary value
          temp = revArray( lowerIndex );
   
          % assign other element to first element
          revArray( lowerIndex ) = revArray( upperIndex );
          
          % assign temporary value to other element           
          revArray( upperIndex ) = temp;
       
       % update indices
       lowerIndex = lowerIndex + 1;
       upperIndex = upperIndex - 1;
      %
   end
   % end loop across half of array
end

% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
