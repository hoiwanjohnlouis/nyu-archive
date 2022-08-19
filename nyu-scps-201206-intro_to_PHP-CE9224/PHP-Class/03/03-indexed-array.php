<?php
	$cities = array (
		'New York',
		'Chicago',
		'Philadelphia',
	);

	print_r($cities);
	print('<br />');

	$cities[3] = 'Los Angles';
	$cities[] = 'New Orleans';
	$cities[7] = 'Detroit';
	$cities[] = 'Atlanta';

	print_r($cities);
	print('<br />');

?>