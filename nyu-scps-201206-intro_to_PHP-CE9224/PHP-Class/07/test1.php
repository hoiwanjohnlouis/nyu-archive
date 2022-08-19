<?php

$pattern = '/[a-z0-9]{3,10}/i';
$subject = 'dah16';

if ( preg_match($pattern, $subject) ) {
	echo "pattern matched";
} else {
	echo "pattern did not match";
}

?>