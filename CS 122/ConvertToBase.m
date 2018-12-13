%
% Script/Program: ConvertToBase
%
% Description: converts decimal value to other base
%
% Author: Michael Leverington
%
% Revision: Rev 1.00, 29 April 2017, initial code
%
% Notes: none
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% title (fprintf)
fprintf( '\nConvert Decimal to Different Base Program\n' );
fprintf(   '=========================================\n\n' );

% get input from user

   % get decimal value
   decVal = input( 'Enter value to be converted: ' );
   
   % get base to convert to 
   base = input( 'Enter base to convert to: ' );
   
% process data - convert value to other base

   % set original value as quotient
   quotient = decVal;
   
   % set index to 1
   index = 1;
   
   % loop while quotient is greater than or equal to zero
   while quotient > 0
      %
       % get remainder, add to array
       newVal( index ) = mod( quotient, base );
       
       % get integer quotient
       quotient = floor( quotient / base );
   
       % increment index
       index = index + 1;
      % 
   end
   % end loop to end of quotient
   
   % reverse digits to get result
   ReverseDigits( newVal );
   
   % make array of digits into number
   newValNumber = ArrayToNumber( newVal );
   
% display answer in new base (fprintf)
fprintf( '\nThe value %d converted to base %d is %d\n\n', decVal, ...
                                                     base, newValNumber );
                                                 
% End Program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
