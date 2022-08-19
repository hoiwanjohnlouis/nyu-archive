<?php
    $firstName  = ucwords((isset($_GET['firstName'])) ? $_GET['firstName'] : '');
    $lastName   = ucwords((isset($_GET['lastName']))  ? $_GET['lastName']  : '');
    $age        =         (isset($_GET['age']))       ? $_GET['age']       : '';
    $email      =         (isset($_GET['email']))     ? $_GET['email']     : '';
    $shortBio   =         (isset($_GET['shortBio']))  ? $_GET['shortBio']  : '';
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
        <h1>Failure</h1>
        <h3>Sorry <?php print $firstName ?>, but your registration request has failed.  Please try again later.</h3>
        <br />
        <h4>First Name: <?php print $firstName ?></h4>
        <h4>Last Name: <?php print $lastName ?></h4>
        <h4>Age: <?php print $age ?></h4>
        <h4>Email: <?php print $email ?></h4>
        <h4>Short Bio: <?php print $shortBio ?></h4>
        <br />
        <br />
        <a href='./hlouis-hw2.php'>Back</a>
    </body>
</html>