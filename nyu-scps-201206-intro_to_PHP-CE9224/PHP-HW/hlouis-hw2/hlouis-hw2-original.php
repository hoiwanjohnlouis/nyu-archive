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

if ($_POST) {
    processForm();
} else {
    displayForm();
}

function displayField( $_fieldName ) {
    echo (isset($_POST["$_fieldName"]) && $_POST["$_fieldName"] != "") ? $_POST["$_fieldName"] : "N/A";
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

<?php
function processForm() {
    if (isset($_POST['Submit'])) {
?>

        <h2>The form was submitted successfully.</h2>
        <br />
        <h3>
        	First Name:    [<?php displayField('first_name') ?>]<br />
        	Last Name:     [<?php displayField('last_name')  ?>]<br />
        	Age:           [<?php displayField('age')        ?>]<br />
        	Email Address: [<?php displayField('email')      ?>]<br />
        	Short Bio:     [<?php displayField('short_bio')  ?>]<br />
        </h3>
        <br />

<?php
    }   //  close of [if (isset($_POST['submit'])) {] statement
}   // close of [function processForm() {] statement

?>

<?php 
// used to display the form when GET method
function displayForm() {
?>
        <!-- name the about_me form as hlouis-hw1.php
        -->
        <form action="hlouis-hw2.php" method="post">
            <ul>
                <li>
                    <label for="first_name">First Name</label>
                    <input type="text" name="first_name" id="first_name" />
                </li>
                <li>
                    <label for="last_name">Last Name</label>
                    <input type="text" name="last_name" id="last_name" />
                </li>
                <li>
                    <label for="age">Age</label>
                    <input type="text" name="age" id="age" />
                </li>
                <li>
                    <label for="email">E-Mail</label>
                    <input type="text" name="email" id="email" />
                </li>
                <li>
                    <label for="short_bio">Short Bio</label>
                    <textarea name="short_bio" id="short_bio"></textarea>
                </li>
                <li>
                    <input type="submit" name="Submit" value="Submit" id="submit" />
                </li>
        </form>
<?php 
}   // end of [function displayForm() {] statement
?>

    </body>
</html>
