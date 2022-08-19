<?php
// Homework
//
//	Assignment #2 (changes are in red *)
//
//  Modify your “About Me” form in the following way:
//  Form collections “First Name”, “Last Name”, “Age”, “Email Address”, “Short Bio”.
//  Form submits to PHP script using the HTTP POST method.
//
// Start of NEW
//  The PHP script that handles the form should do the following:
//  * Send an email to the address from the form
//  * The subject should be: “Notification: Your bio was just updated”
//  * The body of the email should say:
//  * “Your bio was updated on {date} at {time}” -- followed by two new lines
//  * Then each field and it’s value should be printed in the email
//  * After the email is sent, the page should redirect the user to a generic “Thank You” page.
// End of NEW
//
//  Email the script to dah16@nyu.edu
?>

<?php

//function getFieldValue($fieldName) {
//    $strResult = (isset($_POST["$fieldName"]))
//                ? htmlentities($_POST["$fieldName"])
//                : '';
//    return $strResult;
//}

include 'helper_functions.php';

define("MY_EMAIL", "hoiwanjohnlouis@gmail.com");

$action = (isset($_GET['action'])) ? $_GET['action'] : false;
$isPost = (isset($_SERVER['REQUEST_METHOD']) && strtolower($_SERVER['REQUEST_METHOD']) == 'post') ?: false;
$title  = '';

switch ($action) {
    case 'bio':
        $title      = "Bio";
        $contents   = "Hello, I'm Hoi Wan and I'm a software developer.";
        break;

    case 'contact':
        $title      = "Contact";
        $contents   = 'Email me at ' . MY_EMAIL;
        $firstName  = getFieldValue('firstName');
        $lastName   = getFieldValue('lastName');
        $age        = getFieldValue('age');
        $email      = getFieldValue('email');
        $shortBio   = getFieldValue('shortBio');
        break;

    default:
        $title      = "Home Page";
        $contents   = "Welcome to my site!";
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
        <h1><?php echo $title; ?></h1>
        <ul>
            <li><a href="<?php echo $_SERVER['PHP_SELF']; ?>">Home</a></li>
            <li><a href="<?php echo $_SERVER['PHP_SELF']; ?>?action=bio">Bio</a></li>
            <li><a href="<?php echo $_SERVER['PHP_SELF']; ?>?action=contact">Contact</a></li>
        </ul>
        <?php echo $contents; ?>

        <?php if ($action == 'contact') { ?>
            <?php if (!$isPost) { ?>
        <p>
            Or fill out the form below.
        </p>
        <form action="hlouis-hw2.php?action=contact" method="post">
            <ul>
                <li>
                    <label for="firstName">First Name</label>
                    <input type="text" name="firstName" id="firstName" />
                </li>
                <li>
                    <label for="lastName">Last Name</label>
                    <input type="text" name="lastName" id="lastName" />
                </li>
                <li>
                    <label for="age">Age</label>
                    <input type="text" name="age" id="age" />
                </li>
                <li>
                    <label for="email">Your Email</label>
                    <input type="text" name="email" id="email" />
                </li>
                <li>
                    <label for="shortBio">Short Bio</label>
                    <textarea name="shortBio" id="shortBio"></textarea>
                </li>
                <br />
                <li>
                    <input type="submit" name="Submit" value="Submit" id="submit" />
                </li>
        </form>
            <?php } else { ?>
<!--
 replace with email and re-directed thank you.
        <ul>
            <li><strong>First Name:</strong>      <?php echo $firstName; ?></li>
            <li><strong>Last Name: </strong>      <?php echo $lastName; ?></li>
            <li><strong>Age:       </strong>      <?php echo $age; ?></li>
            <li><strong>Email:     </strong>      <?php echo $email; ?></li>
            <li><strong>Short Bio: </strong><br /><?php echo $shortBio; ?></li>
        </ul>
-->

        <?php 
            global $firstName;
            $boolSendMail = sendMail();
            //$boolSendMail = true;
            if ($boolSendMail) {
                header("Location: ./success.php?firstName=$firstName&lastName=$lastName&age=$age&email=$email&shortBio=$shortBio");
            } else {
                header("Location: ./failure.php?firstName=$firstName&lastName=$lastName&age=$age&email=$email&shortBio=$shortBio");
            }
        ?>

            <?php } ?>
        <?php } ?>
    </body>
</html>