<?php
	$city = array(
		'name' => 'New York',
		'country' => 'USA',
		'population' => 8391881,
	);

	print_r($city);
	print('<br />');

	$city['area'] = '468.48 sq miles';
	$city[] = 'the big apple';
	$city[7] = 'Hello, NYC';

	print_r($city);
	print('<br />');

	$city[] = 'Go Yankees!';
	print_r($city);
	print('<br />');

?>