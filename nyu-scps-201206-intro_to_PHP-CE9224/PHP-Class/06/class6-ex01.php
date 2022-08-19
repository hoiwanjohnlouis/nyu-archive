<?php
//  Lab 6
//
//	Ex #1
//  Email the script to dah16@nyu.edu
//
    $monthDayYearArray = array(
                    'mdy1'  => '5,12,2023', 
                    'mdy2'  => '2,29,1996', 
                    'mdy3'  => '2,29,2001', 
                    'mdy4'  => '9,31,1999', 
                    'mdy5'  => '15,27,2012'
    );

    $timeArray = array(
                    'time1' => 'today',
                    'time2' => 'two hours from now',
                    'time3' => 'February 29, 2012',
                    'time4' => 'February 29, 2011',
                    'time5' => 'September 31, 2012',
                    'time6' => '+3 Hours',
                    'time7' => '-2 Days',
                    'time8' => 'Forever Ago'
    );

//
//  Date Validation
//  Using php’s checkdate() function, print out which dates are valid and which dates are invalid:
//  Month: 5 Day: 12 Year: 2023
//  Month: 2 Day: 29 Year: 1996
//  Month: 2 Day: 29 Year: 2001
//  Month: 9 Day: 31 Year: 1999
//  Month: 15 Day: 27 Year: 2012
function processCheckDate( $monthDayYearArray ) {
    $ret = '';
    // print_r($monthDayYearArray);
    // echo '<br />';
    foreach( $monthDayYearArray as $items => $detail ) {
        // print_r($items, $detail);
        $nums = preg_split('/,/', $detail);
        $isValid = checkdate($nums[0], $nums[1], $nums[2]);
        $ret .= "<strong>$nums[0]/$nums[1]/$nums[2]:</strong>" . ' is a ' . (( $isValid ) ? 'valid date' : 'not a good date') . '<br />';
    }
    return $ret;
}

//
//  Using php’s strtotime() function, print out which dates are valid and which dates are invalid:
//  today
//  two hours from now
//  February 29, 2012
//  February 29, 2011
//  September 31, 2012
//  +3 Hours
//  -2 Days
//  Forever Ago
function processTime( $timeArray ) {
    $ret = '';
    // print_r($timeArray);
    // echo '<br />';
    foreach( $timeArray as $items => $detail ) {
        if (($timestamp = strtotime($detail)) === false) {
            $ret .= "The timestamp (<strong>$detail</strong>) is bogus<br />";
        } else {
            $ret .= "[<strong>$detail</strong>] is a valid timestamp<br />";
        }
    }
    return $ret;
}

//
//  Using php’s date() function, print out the valid dates from the strtotime() exercise is the
//  following formats (ignore the actual date below, it’s just an example):
//  March 23, 2012 HH:MM:SS AM/PM (12 hour time)
//  03-23-2012 HH:MM:SS (24 hour time)
//  2012-03-23 HH:MM:SS (24 hour time)
//
//  For this last exercise you may have to do a little research: http://php.net/date//
function processDateTime( $timeArray ) {
    $ret = '';
    // print_r($timeArray);
    // echo '<br />';
    foreach( $timeArray as $items => $detail ) {
        if (($timestamp = strtotime($detail)) === false) {
            $ret .= "The timestamp (<strong>$detail</strong>) is bogus<br />";
        } else {
            $ret .= "[<strong>$detail</strong>]<br />";
            $ret .= date('F d Y h:i:s A', $timestamp) . ' (12 hour time)<br />';
            $ret .= date('m-d-Y H:i:s'  , $timestamp) . ' (24 hour time)<br />';
            $ret .= date('Y-m-d H:i:s'  , $timestamp) . ' (24 hour time)<br />';
            $ret .= '<br />';
        }
    }
    return $ret;
}

?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Lab 6</title>
        <style>
            label {
                display: block;
            }
            ul {
                list-style-type: none;
            }
        </style>
    </head>
    <body id="home-page" class="">
        <h1>Lab 6</h1>

        <h3>Excercise 1-Date Validation</h3>
        <?php echo processCheckDate($monthDayYearArray) . '<br />'; ?>

        <h3>Excercise 2-Time Validation</h3>
        <?php echo processTime($timeArray) . '<br />'; ?>

        <h3>Excercise 3-DateTime Validation</h3>
        <?php echo processDateTime($timeArray) . '<br />'; ?>
    </body>
</html>