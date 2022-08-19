<?php
 
// Exercise
// Multidimensional Arrays: Create an indexed multidimensional array with the following
// data and the loop over it printing out the keys (city name) in bold and the values next to
// it. Separate each city by two lines:
//
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

	$cities = array(
		array(
			'city' => 'New York',
 			'nickname' => 'The Big Apple',
 			'population' => '8391881',
 			'size' => '468.48 sq mi',
 		),
		array(
			'city' => 'Chicago',
 			'nickname' => 'The Windy City',
 			'population' => '2853114',
 			'size' => '234.0 sq mi',
 		),
		array(
 			'city' => 'Los Angeles',
 			'nickname' => 'L.A.',
 			'population' => '9830420',
 			'size' => '502.693 sq mi',
		),
	);

	foreach($cities as $items => $detail) {
		// print('<strong>' . $items . ': </strong>' . $detail . '<br />');
		foreach($detail as $key => $value) {
			print('<strong>' . $key . ': </strong>' . $value . '<br />');
		}
		print('<br /><br />');
	}

?>