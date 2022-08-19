<!--
//
// Homework
//
// 	• Assignment #1
// 		• Create an “About Me” form that meets the following criteria:
// 		• Form collections “First Name”, “Last Name”, “Age”, “Email Address”, “Short Bio”.
// 		• Form submits to PHP script using the HTTP POST method.
// 		• PHP Script prints the submitted form data back out to the page.
// 		• Email the script to dah16@nyu.edu
//
-->
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
    if ($_POST) {
        processForm();
    } else {
        displayForm();
    }
?>


<?php
function displayField( $_fieldName ) {
    echo (isset($_POST["$_fieldName"]) && $_POST["$_fieldName"] != "") ? $_POST["$_fieldName"] : "N/A";
}
?>


<?php
function processForm() {
    if (isset($_POST['Submit'])) {
//echo $_POST['first_name'] . "<br />";
//echo $_POST['last_name'] . "<br />";
//echo $_POST['age'] . "<br />";
//echo $_POST['email'] . "<br />";
//echo $_POST['Submit'] . "<br />";
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
        <form action="hlouis-hw1.php" method="post">
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
