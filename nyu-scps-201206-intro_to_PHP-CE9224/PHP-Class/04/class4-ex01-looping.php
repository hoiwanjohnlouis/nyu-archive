<?php

// Exercise
// Looping: Write a script that counts from 1 to 10 in steps of 1. 
// For each number print whether it’s even or odd.

$_LMT = 10;
$_idx = 0;
for ($_idx = 0; $_idx < $_LMT; $_idx++) {

	// print if even or odd
	if ( ($_idx % 2) > 0 ) {
		print '$_idx [' . $_idx . '] is odd.<br />'; 
	} else {
		print '$_idx [' . $_idx . '] is even.<br />'; 
	}
}

?>