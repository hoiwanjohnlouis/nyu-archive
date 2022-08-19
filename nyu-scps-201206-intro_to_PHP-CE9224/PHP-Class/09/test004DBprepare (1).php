<?php

// DB prepare

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
	$sql = 'select * from orders where id = :id';
	$statement = $connection-> prepare($sql);
	if ($statement) {
		echo "SQL [$sql] prepare successful<br />";
		$statement -> execute(array(
			':id' => 1)
		);
		print_r($statement);
		echo '<br />';
		$data = $statement -> fetchAll();
//		print_r($data);
//		echo '<br />';

		foreach($data as $row) {
			print_r($row);
			echo '<br />';
			echo '<br />';
			echo 'order_id[' . $row["order_id"] . ']<br />';
			echo '<br />';
		}
	} else {
		echo "SQL [$sql] prepare failed<br />";
	}
} else {
	echo "connection to [$dsn] failed<br />";
}

?>