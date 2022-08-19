<?php

echo 'datetime default<br />';
$datetime = new DateTime();
print_r( $datetime );
echo '<br />';

echo 'datetime tomorrow<br />';
$datetime = new DateTime('tomorrow');
print_r( $datetime );
echo '<br />';

echo 'datetime now<br />';
$datetime = new DateTime('now');
// print_r( $datetime );
echo $datetime -> format('Y-m-d H:i:sP') . '<br />';

?>