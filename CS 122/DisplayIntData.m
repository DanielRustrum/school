%
% Script/Function: DisplayIntData
%
% Description: displays a specified number of integers per line
%
% Algorithm: use of loop to iterate through number list
%
% Function Input: array of integers, number of integers per line
%
% Function Output: none
%
% Device Input: none
%
% Device Output: integers displayed, as specified
%
% Dependencies: Matlab function: fprintf, mod, length
%
% Author: Michael Leverington
%
% Revision: Rev 1.00, 15 April 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
function DisplayIntData( valueList, valuesPerLine )
 
   % find length of string list
   valLength = length( valueList );
   
   % print first offset tab
   fprintf( '\t' );
   
   % begin loop across list
   for index = 1:valLength
      %
         % display value
         fprintf( '%d', valueList( index ) );
         
         % check for not last string
         if index < valLength
            %
               % display comma
               fprintf( ', ' );
            %
         end
         
         % check for end of string line
         if mod( index, valuesPerLine ) == 0 
            %
               % display end line
               fprintf( '\n\t' );
            %    
         end
      %
   % end loop across list
   end
   
   % display end line for list
   fprintf( '\n\n' );
   
end



% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
