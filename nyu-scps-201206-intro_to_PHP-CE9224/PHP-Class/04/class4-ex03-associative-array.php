<?php

// Exercise
// city: New York
// nickname: The Big Apple
// population: 8391881
// size: 468.48 sq mi
// city: Chicago
// nickname: The Windy City
// population: 2853114
// size: 234.0 sq mi
// city: Los Angeles
// nickname: L.A.
// population: 9830420
// size: 502.693 sq mi
//
// Now create an associative array using the city name as the key where the value will be
// an array with the remaining data. Loop over it and print it out so that it looks the same
// as the output from the first version of this exercise.

	$cities = array(
		'New York' => array(
 			'nickname' => 'The Big Apple',
 			'population' => '8391881',
 			'size' => '468.48 sq mi',
 		),
		'Chicago' => array(
 			'nickname' => 'The Windy City',
 			'population' => '2853114',
 			'size' => '234.0 sq mi',
 		),
		'Los Angeles' => array(
 			'nickname' => 'L.A.',
 			'population' => '9830420',
 			'size' => '502.693 sq mi',
		),
	);

	foreach($cities as $items => $detail) {
		print('<strong>city: </strong>' . $items . '<br />');
		foreach($detail as $key => $value) {
			print('<strong>' . $key . ': </strong>' . $value . '<br />');
		}
		print('<br /><br />');
	}

?>