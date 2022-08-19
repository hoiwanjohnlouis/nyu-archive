<?php

// return the value of a defined field
function getFieldValue($fieldName) {
    $strResult = (isset($_POST["$fieldName"]))
               ? htmlentities($_POST["$fieldName"])
               : '';
    return $strResult;
}


// mail doesn't work in windows7
function sendMail() {
    $to      = getFieldValue('email');
    $subject = 'Notification: Your bio was just updated';
    $message = 'Your bio was updated on ' . date('o-m-d') . ' at ' . date('H:m:s') . "\r\n";
    $message .= 'First Name: ' . getFieldValue('firstName') . "\r\n";
    $message .= 'Last Name: '  . getFieldValue('lastName') . "\r\n";
    $message .= 'Age: '        . getFieldValue('age') . "\r\n";
    $message .= 'Email: '      . $to . "\r\n";
    $message .= 'Short Bio: '  . getFieldValue('shortBio') . "\r\n";
    $message = wordwrap($message, 70);
    $headers = array('From: ' . MY_EMAIL,'X-Priority: 1 (highest)');
    $headers = implode("\r\n", $headers);

    var_dump('$to:' . $to);
    var_dump('$subject:' . $subject);
    var_dump('$message:' . $message);
    var_dump('$headers:' . $headers);

    // email does not work in windows!
    $boolResult  = mail($to, $subject, $message, $headers);
    var_dump($boolResult);

    return $boolResult;
}

?>