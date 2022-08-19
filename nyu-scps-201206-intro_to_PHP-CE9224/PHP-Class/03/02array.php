<?php
	$dog = array(
		'type' => 'Labrador',
		'name' => 'Max',
		'color' => 'brown',
		'weight' => '65lbs',
	);

	foreach($dog as $key => $val) {
		echo $key . ': ' . $val . '<br />';
	}
?>