<?php

// DB query

$username = 'root';
$password = '';
$driver   = 'mysql';
$host     = 'localhost';
$db       = 'class9';
$dsn = sprintf(
	'%s:host=%s;dbname=%s',
	$driver,
	$host,
	$db
);
//print_r($dsn);
//echo '<br />';

$connection = new PDO($dsn, $username, $password);
if ($connection) {
	echo "connection to [$dsn] successful<br />";
	$sql = 'select * from products limit 2';
	$data = $connection-> query($sql);
	if ($data) {
		echo "SQL [$sql] query successful<br />";
		foreach($data as $row) {
			print_r($row);
			echo '<br />';
		}
	} else {
		echo "SQL [$sql] query failed<br />";
	}
} else {
	echo "connection to [$dsn] failed<br />";
}

?>