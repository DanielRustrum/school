	.data
welcome_msg:	    .asciiz "Welcome to the guessing game!\n\n"
lower_bound_prompt: .asciiz "Please enter a lower bound:\n\t"
upper_bound_prompt: .asciiz "Please enter an upper bound:\n\t"
begin_msg:          .asciiz "Alright, let's begin!\n"
guess1_msg:         .asciiz "Is your number "
guess2_msg:         .asciiz "? (y/l/h)\n\t"
correct_guess_msg:  .asciiz "Woo, I guessed it!\n"


# This program stores the lower bound in s0
#                     the upper bound in s1
#                   the current guess in s2
#          the user's latest response in s3
	.text
	.globl main
main:
	# Print welcome message
	la $a0, welcome_msg
	li $v0, 4
	syscall

initialization:	
	# Print out the lower bound prompt
	la $a0, lower_bound_prompt
	li $v0, 4
	syscall

	# Get the lower bound from the user
	li $v0, 5
	syscall
	move $s0, $v0 # store the lower bound in $s0

	# Print out the upper bound prompt
	la $a0, upper_bound_prompt
	li $v0, 4
	syscall

	# Get the upper bound from the user
	li $v0, 5
	syscall
	move $s1, $v0 # store the upper bound in $s1

	# Print out the begin message
	la $a0, begin
	li $v0, 4
	syscall

	
guessing: # This is the start of a new guess
	
	# Calculate current guess
	addu $t0, $s0, $s1 # Add lower and upper bounds
	li   $t1, 2        # Load two for averaging
	div  $t0, $t1      # Average the bounds
	mflo $s2           # Move the quotient into $s2

	# Print out first half of the guess text
	la $a0, guess1
	li $v0, 4
	syscall

	# Print out guessed number
	move $a0, $s2 # moves our guess into a0
	li   $v0, 1
	syscall

	# Print 2nd half of guess text
	la $a0, guess2
	li $v0, 4
	syscall

	# Get the user's one character response
	li $v0, 12
	syscall       # The character is now in $v0
	move $t0, $v0 # Save the character to $t0 

	# Print out a newline or formatting get's weird because
	# of the above syscall to get 1 char
	li $a0, '\n'
	li $v0, 11
	syscall

	# Branch based on the user's response
	beq $t0, 'l', too_low  # Jump to the 'too low' section
	nop                    # Branch delay slot
	beq $t0, 'h', too_high # Jump to the 'too high' section
	nop                    # Branch delay slot

	# If neither branch statement executes, default to the 'correct guess'
	# and end the game
correct_guess: 
	# print the correct guess message
	la $a0, correct
	li $v0, 4
	syscall
	jr $ra # Exit

too_low:
	move $s0, $s2 # Move the current guess into the lower bound
	addiu $s0, $s0, 1 # Add 1 to the lower bound
	b guessing

too_high:
	move $s1, $s2     # Move the current guess into the upper bound
	b guessing
