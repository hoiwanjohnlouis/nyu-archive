<?php

//  Lab 6
//
//  Assignment #1
//  Email the script to dah16@nyu.edu (optional)
//
//  Using the template, validate each field. 
//  http://davehauenstein.com/nyu/INFO1-CE9224-2012-Summer/labs/class6/template.txt
//  
//  Each field should be validated based on the following criteria:
//  • username: alphanumeric and no longer than 15 characters long
//  • first_name: only letters 
//  (in reality, there are additional characters that are ok, but ignore this requirement for now).
//  • last_name: only letters 
//  (in reality, there are additional characters that are ok, but ignore this requirement for now).
//  • email: Using a regular expression, validate this field. This will require you to read
//  about preg_match() at http://php.net/preg_match. You can write your own regular
//  expression for this by reading ahead in the book, or you can find one online to use.
//
//  If the fields are invalid redisplay the form and print a message
//  next to each field that’s invalid. Otherwise print the results to
//  the screen and don’t display the form again.  Optional
//  requirements: • If the form is valid, use an HTTP redirect to
//  display the results. • Write functions to validate each field,
//  taking the value of the field as the  first argument and an array
//  as the second argument. The second argument should be  passed as
//  reference and should contain the error messages. • Add a third,
//  optional parameter called $filter, which is a callback. The
//  callback should be expected to take in the value as an argument,
//  and then  return the value back. In the meantime, it should run a
//  filter on the value  BEFORE the validation takes place. For
//  example, the last name may have single quotes that we want to
//  strip out before validating that it is alpha-numeric.

$isPost = (isset($_SERVER['REQUEST_METHOD']) && strtolower($_SERVER['REQUEST_METHOD']) == 'post') ?: false;

if ($isPost) { 

    //
    $userName     = (isset($_POST['username']))   ? $_POST['username']   : '';
    $firstName    = (isset($_POST['first_name'])) ? $_POST['first_name'] : '';
    $lastName     = (isset($_POST['first_name'])) ? $_POST['last_name']  : '';
    $emailAddress = (isset($_POST['email']))      ? $_POST['email']      : '';
            
    //
    $userMessage  = '';
    $firstMessage = '';
    $lastMessage  = '';
    $emailMessage = '';

    //
    validateUserName($userName,  $userMessage);
    validateFirstName($firstName,$firstMessage);
    validateLastName($lastName,  $lastMessage);
    validateEmail($emailAddress, $emailMessage);

    echo $userMessage  . '<br />';
    echo $firstMessage . '<br />';
    echo $lastMessage  . '<br />';
    echo $emailMessage . '<br />';
}

//  • username: alphanumeric and no longer than 15 characters long
function validateUserName($name, &$message) {
    $message   = '';
    $validData = ctype_alnum($name) && (strlen($name) <= 15);
    if ($validData) {
        $message = "$name is valid user name";
    } else {
        $message = "$name is a bogus user name";
    }
    return $validData;
}

//  • first_name: only letters 
//  (in reality, there are additional characters that are ok, but ignore this requirement for now).
function validateFirstName($name, &$message) {
    $message   = '';
    $validData = ctype_alpha($name);
    if ($validData) {
        $message = "$name is valid first name";
    } else {
        $message = "$name is a bogus first name";
    }
    return $validData;
}

//  • last_name: only letters 
//  (in reality, there are additional characters that are ok, but ignore this requirement for now).
function validateLastName($name, &$message) {
    $message   = '';
    $validData = ctype_alpha($name);
    if ($validData) {
        $message = "$name is valid last name";
    } else {
        $message = "$name is a bogus last name";
    }
    return $validData;
}

//  • email: Using a regular expression, validate this field. This will require you to read
//  about preg_match() at http://php.net/preg_match. You can write your own regular
//  expression for this by reading ahead in the book, or you can find one online to use.
function validateEmail($name, &$message) {
    $message   = '';
    $pattern   = '\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b';  // from http://www.regular-expressions.info/email.html
    $pattern   = '[A-Z0-9]+@[A-Z0-9]+\.[A-Z]+';
    $matches   = array();
    
    $validData = preg_match($pattern, $name, $matches);

    print_r('validData=' . $validData . "<br />");
    print_r('pattern='   . $pattern   . "<br />");
    print_r('name='      . $name      . "<br />");
    print_r('matches='   . $matches   . "<br />");
    echo "<br />";

    if ($validData) {
        $message = "$name is valid email address";
    } else {
        $message = "$name is a bogus email address";
    }
    return $validData;
}

?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Lab 2 Form</title>
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

    <?php if ($isPost) { ?>


    <?php } else { ?>
        <form action="register.php" method="post">
            <ul>
                <li>
                    <label for="username">Username:</label>
                    <input type="text" name="username" id="username" />
                </li>
                <li>
                    <label for="first_name">First Name</label>
                    <input type="text" name="first_name" id="first_name" />
                </li>
                <li>
                    <label for="last_name">Last Name</label>
                    <input type="text" name="last_name" id="last_name" />
                </li>
                <li>
                    <label for="email">Email Address</label>
                    <textarea name="email" id="email"></textarea>
                </li>
                <li>
                    <input type="submit" name="Submit" value="Submit" id="submit" />
                </li>
        </form>
    <?php } ?>

    </body>
</html>