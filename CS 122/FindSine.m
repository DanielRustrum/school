%
% Script/Function: FindSine
%
% Description: finds geometrical Sine using Taylor series
%
% Algorithm: uses Taylor series to a given precision to find Sine
%
% Function Input: value from which Sine will be found
%
% Function Output: Sine of given value
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
function sinVal = FindSine( value )

   % set precision to given value
   precision = 10;
   
   % get magnitude of input value
   value = abs( value );
   
   % set sign value to positive
   signValue = 1;
   
   % set working value to 0
   sinVal = 0;
   
   % set series value to 1
   seriesVal = 1;
   
   % loop up to precision number of times
   for iteration = 1:precision
      %
       % conduct calculation
       sinVal = sinVal + signValue ...
               * ToPower( value, seriesVal ) / FindFactorial( seriesVal );
       
       % increment series value by 2
       seriesVal = seriesVal + 2;
       
       % toggle sign value
       signValue = signValue * -1;
      %
   end
   % end of precision number loop
end
% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
