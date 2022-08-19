<?php

// DB exec

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
	$sql = 'delete from orders where id = -1';
	$data = $connection-> exec($sql);
	if ($data) {
		echo "SQL [$sql] exec delete successful<br />";
		print_r($data);
		echo '<br />';
		echo $data . 'rows were deleted<br />';
	} else {
		echo "SQL [$sql] exec delete failed<br />";
	}
} else {
	echo "connection to [$dsn] failed<br />";
}

?>