<?php

// DB connection variables

$username = 'root';
$password = '';
$driver   = 'mysql';
$host     = 'localhost';
$database = 'class9';

$dsn = sprintf(
  '%s:host=%s;dbname=%s',
  $driver,
  $host,
  $database
);

// print_r($dsn);
// echo '<br />';

?>