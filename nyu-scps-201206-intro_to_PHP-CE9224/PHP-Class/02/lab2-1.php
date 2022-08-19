<?php

// Assignment #1
//
// Basic assignment, arithmetic, and type casting.
// Create and instantiate a variable with an integer value. 
// Add 1 to that integer value 3 times using a different 
// operator each time. 
//
// Use PHP’s var_dump() method to print it to
// the screen twice. First, so that var_dump shows that it’s an integer,
// next so that var_dump shows that it’s a string.

	// adding 1 to a variable using four different ways
	$var = 1;
	echo '$var=' . $var . "<br />";
	$var++;
	echo '$var=' . $var . "<br />";
	$var += 1;
	echo '$var=' . $var . "<br />";
	$var = $var + 1;
	echo '$var=' . $var . "<br />";

	// var_dump 
	var_dump($var);
	var_dump((string)$var);

?>