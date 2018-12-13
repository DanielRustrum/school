%
% Script/Function: FindExp
%
% Description: finds e to the x power using Taylor series
%
% Algorithm: uses Taylor series to a given precision to find e to the x
%
% Function Input: value from which e to the x will be found
%
% Function Output: e to the x of given value
%
% Device Input: none
%
% Device Output: none
%
% Dependencies: abs used to make input value positive,
%               ToPower, FindFactorial
%
% Author: Michael Leverington
%
% Revision: Rev 1.00, 29 April 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function expVal = FindExp( value )

   % set precision to given value
   precision = 15;
   
   % get magnitude of input value
   value = abs( value );
   
   % set working value to 1
   expVal = 1;
   
   % loop up to precision number of times
   for seriesVal = 1:precision
      %
       % conduct calculation
       expVal = expVal + ToPower( value, seriesVal ) ...
                                            / FindFactorial( seriesVal );
      %
   end
   % end of precision number loop
end
% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
