<?php

// Assignment #2
//
// Write a script that creates three variables 
// and assigns a different integer value to the
// first two, and the string value of the first 
// in the third. Write a script that tests and outputs
// whether the first value is:
// 1. equal to the second value
// 2. equal to the third value
// 3. identical to the third value
// 4. greater than the second value
// 5. less than or equal to the second value
// 6. not equal to the second value

	$a = 22;
	$b = 7;
	$c = "$a";

	echo '$a=' . $a . ' and is of type ' . gettype($a) . "<br />";
	echo '$b=' . $b . ' and is of type ' . gettype($b) . "<br />";
	echo '$c=' . $c . ' and is of type ' . gettype($c) . "<br />";
	echo '<br />';

	echo '1. ( $a == $b )  is '  . (( $a ==  $b ) ? 'TRUE' : 'FALSE') . '<br />';
	echo '2. ( $a == $c )  is '  . (( $a ==  $c ) ? 'TRUE' : 'FALSE') . '<br />';
	echo '3. ( $a === $c ) is '  . (( $a === $c ) ? 'TRUE' : 'FALSE') . '<br />';
	echo '4. ( $a > $b )   is '  . (( $a >   $b ) ? 'TRUE' : 'FALSE') . '<br />';
	echo '5. ( $a <= $b )  is '  . (( $a <=  $b ) ? 'TRUE' : 'FALSE') . '<br />';
	echo '6. ( $a != $b )  is '  . (( $a !=  $b ) ? 'TRUE' : 'FALSE') . '<br />';


?>