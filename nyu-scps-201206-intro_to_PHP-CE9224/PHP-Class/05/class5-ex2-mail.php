<?php

/**
 Exercises 5

Send an Email
Using PHP’s mail function, send an email to yourself. Verify in your inbox that the email
was actually sent.

*/

/**
*/

$to = 'hoiwanjohnlouis@gmail.com';
$subject = 'email test';
$message = 'heello using email';
$message = wordwrap($message, 70);
$headers = array('From: PHP-hoi-wan <me@xyz.com>','X-Priority: 1 (highest)');
$headers = implode("\r\n", $headers);

// var_dump($headers);

$result  = mail($to, $subject, $message, $headers);

// var_dump($result);
if ($result) {
	echo "<p>Success! Mail sent to $to></p>";
} else {
	echo "<p>**** FAILURE! Mail not sent to $to></p>";
}
?>