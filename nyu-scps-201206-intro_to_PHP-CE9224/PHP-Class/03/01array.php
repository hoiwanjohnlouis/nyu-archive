<?php
	$dog = array(
		'type' => 'Labrador',
		'name' => 'Max',
		'color' => 'brown',
	);

	foreach($dog as $key => $val) {
		echo $key . ': ' . $val . '<br />';
	}
?>