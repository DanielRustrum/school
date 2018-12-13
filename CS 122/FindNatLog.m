%
% Script/Function: FindNatLog
%
% Description: finds natural log using mathematical series
%
% Algorithm: uses mathematical series to a given precision to find natural log
%
% Function Input: value from which natural log will be found
%
% Function Output: natural log of given value
%
% Device Input: none
%
% Device Output: none
%
% Dependencies: abs used to make input value positive, ToPower
%
% Author: Michael Leverington
%
% Revision: Rev 1.00, 29 April 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function natLogVal = FindNatLog( value )

   % set precision to given value
   precision = 25;
   
   % get magnitude of input value
   value = abs( value );
   
   % set working fraction
   wkgFraction = ( value - 1 ) / ( value + 1 );
   
   % set series value to 1
   seriesVal = 1;
   
   % set series sum to 0
   natLogSum = 0;
   
   % loop up to precision number of times
   for iteration = 1:precision
      %
       % conduct calculation
       natLogSum = natLogSum + ToPower( wkgFraction, seriesVal ) ...
                                                              / seriesVal;
       
       % increment series value by 2
       seriesVal = seriesVal + 2;      
      % 
   end
   % end of precision number loop
   
   % multiply sum by 2
   natLogVal = natLogSum * 2;

end
% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
