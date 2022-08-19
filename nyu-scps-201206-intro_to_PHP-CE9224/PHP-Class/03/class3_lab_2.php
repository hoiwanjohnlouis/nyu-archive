<!--
//
// Class 3, Lab 3, Assignment #2
//
// Form handling basics
//
// Copy the HTML form located here to a file locally named class3_lab_2.php. Do not
// make any modifications to the HTML form and write PHP code that does the following:
//
//  1. Checks which type of HTTP method this request was sent using.
//  2. If the form was sent using HTTP POST, then handle the form by:
//      a. printing out a message: "The form was submitted successfully."
//      b. printing out the name and value of each field to the screen
//      c. The price should be in USD format: $2,000.00
//          (hint: see number_format function)
//      d. do not display the HTML form again
//  3. If the form was sent using HTTP GET, then do nothing except display the form.
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
function errorForm() {
?>
    <h2>Unsupported method, only GET and POST are supported at this time.</h2>
<?php
}
?>

<?php
function processForm() {
    if (isset($_POST['Submit'])) {
?>
        <h2>The form was submitted successfully.</h2>
        <br />
        <h3>product_name is [<?php if (isset($_POST['product_name'])) echo $_POST['product_name'] ?>]</h3>
        <h3>Unformatted price is [<?php if (isset($_POST['price']))  echo $_POST['price'] ?>]</h3>
        <h3>Formatted price is [<?php if (isset($_POST['price']))  echo number_format($_POST['price'],2) ?>]</h3>
        <h3>sku is [<?php if (isset($_POST['sku']))  echo $_POST['sku'] ?>]</h3>
        <h3>product_description is [<?php  if (isset($_POST['product_description'])) echo $_POST['product_description'] ?>]</h3>
        <br />
<?php
    }   //  close of [if (isset($_POST['Submit'])) {] statement
}   // close of [function processForm() {] statement
?>

<?php 
// used to display the form when GET method
function displayForm() {
?>
        <!-- only works by changing class3.php to class3_lab_2.php 
            <form action="class3.php" method="post">
        -->
        <form action="class3_lab_2.php" method="post">
            <ul>
                <li>
                    <label for="product_name">Product Name</label>
                    <input type="text" name="product_name" id="product_name" />
                </li>
                <li>
                    <label for="price">Price</label>
                    <input type="text" name="price" id="price" />
                </li>
                <li>
                    <label for="sku">SKU</label>
                    <input type="text" name="sku" id="sku" />
                </li>
                <li>
                    <label for="product_description">Product Description</label>
                    <textarea name="product_description" id="product_description"></textarea>
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

