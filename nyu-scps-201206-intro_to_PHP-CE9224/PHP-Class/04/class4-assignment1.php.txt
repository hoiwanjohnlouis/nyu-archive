<?php

$nav = array(
    'Finance' => array(
        'Markets'    => 'markets.php',
        'Your Money' => 'money.php',
    ),
    'Politics' => array(
        'Defense'     => 'defense.php',
        'Politicians' => array(
            'Obama' => 'obama.php',
            'Democrats' => array(
                'Obama'   => 'obama.php',
                'Clinton' => 'clinton.php',
            ),
        ),
    ),
	'Contact' => 'contact.php',
);

function nav(array $data)
{
    $nav = "<ul>";
    foreach($data as $key => $val) {
        if(is_array($val)) {
            $nav .= "<li>$key" . nav($val) . "</li>";
        } else {
            $nav .= "<li><a href='$val'>$key</a></li>";
        }
    }
    return $nav . "</ul>";
}

echo nav($nav);