    .data
scores: .word   100, 78, 63, 88, 52, 91, 75
unsorted_msg: .asciiz "The unsorted numbers are\n"
sorted_msg: .asciiz "The sorted numbers are\n"

main:
    b display_unsorted

sort:


display_unsorted:
    la $a0, unsorted_msg
	li $v0, 4
	syscall

display_sorted:
    la $a0, sorted_msg
	li $v0, 4
	syscall

swap:

