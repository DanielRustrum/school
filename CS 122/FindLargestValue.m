%
% Script/Function: FindLargestValue
%
% Description: finds the largest value between two numbers
%
% Algorithm: compares numbers
%
% Function Input: two values
%
% Function Output: largest value
%
% Device Input: none
%
% Device Output: none
%
% Dependencies: none
%
% Author: Michael Leverington
%
% Revision: Rev 1.10, 27 April 2017, update for comparing numbers
%           Rev 1.00, 15 April 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function longest = FindLargestValue( valueOne, valueTwo )

   % set smallest to first value
   longest = valueOne;
   
   % compare second value
   if valueTwo > longest 
      %
       longest = valueTwo;
      %
   end
   
end



% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
