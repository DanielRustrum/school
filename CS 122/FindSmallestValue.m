%
% Script/Function: FindSmallestValue
%
% Description: finds the smallest value between two numbers
%
% Algorithm: compares numbers
%
% Function Input: two values
%
% Function Output: smallest value
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
function shortest = FindSmallestValue( valueOne, valueTwo )

   % set smallest to first value
   shortest = valueOne;
   
   % compare second value
   if valueTwo < shortest 
      %
       shortest = valueTwo;
      %
   end
   
end



% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
