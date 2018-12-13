%
% Script/Function: ToPower
%
% Description: finds base value to given exponent
%
% Algorithm: repeated multiplication of value times itself
%
% Function Input: base value, exponent value
%
% Function Output: value representing base to exponent
%
% Device Input: none
%
% Device Output: none
%
% Dependencies: abs used to make exponent positive
%
% Author: Michael Leverington
%
% Revision: Rev 1.00, 29 April 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function expValue = ToPower( baseVal, expVal )

   % set expVal to working exp val
   wkgExponentVal = abs( expVal );
   
   % set initial result to 1
   expValue = 1;
   
   % iterate expVal number of times
   for expCtr = 1:wkgExponentVal
      %
       expValue = expValue * baseVal;
      %
   % end exponent loop
end
% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%