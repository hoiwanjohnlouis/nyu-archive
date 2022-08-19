<?php
//
// Class 3, Lab 3, Assignment #1
//
// Putting it all together
//
// Create a ?le locally named class3_lab_1.php. This script will do several things:
//  1. Look for a query parameter named ‘action’.
//  2. The action parameter is expected to be one of three things: home, bio, contact
//  3. Depending on the action, display HTML representing a:
//      a. home:    This will just display a welcome message of your choice
//                  (ex: “Hello, thanks for visiting my site!”)
//      b. bio:     A short bio of yourself or someone one your choosing.
//      c. contact: A link with your email address or, if you feeling
//                  con?dent, a contact form which does nothing but prints the
//                  information they insert to the screen.
//      d. If something other than the three actions mentioned above is entered,
//          display an error message.
//  4. Place navigation on every page, so you can click and get to different actions.
//
// Extra:
//  Look for another query parameter, name, on any page. If it’s present, display
//  a custom greeting. Test this out with different values, including values
//  that have a bit of HTMLembedded. For example: ?name=<strong>Dave</strong>.
//  What happens when you print it to the screen? Is this good? take a look
//  at PHP’s 'htmlentities' http://us3.php.net/htmlentities function and try
//  to implement it.
//

    $_action = '';
    $_name   = '';

    if (($_GET) && isset($_GET['action'])) {

        $_action = $_GET['action'];

        // extra credit
        if (isset($_GET['name'])) {
            $_name = $_GET['name'];
        } else {
            $_name = null;
        }

        switch($_action) {

            case 'home':
            ?>
                <h2>Hello</h2>
                <h3>thanks for visiting my site!</h3>
            <?php
                break;

            case 'bio':
            ?>
                <!-- extra credit, name is an argument -->
                <h2>Hi, I'm <?php echo (($_name) ? "$_name" : 'Hoi Wan Louis')?></h2>
                <h3>My background is writing computer software for the financial services industry.</h3>
            <?php
                break;

            case 'contact':
            ?>
                <!-- extra credit, name is an argument.  Did not change the email address -->
                <h2>Here is my contact information</h2>
                <h3><a href="hwjl8888@hotmail.com"><?php echo (($_name) ? "$_name" : 'Hoi Wan Louis')?></a></h3>
            <?php
                break;

            default:
            ?>
                <h2>Please specify one of these supported actions:</h2>
                <h3>home<br />bio<br />contact</h3>
            <?php
                break;
        }
    } else {
        ?>
        <h2>Unsupported method, only GET is supported at this time.</h2>
        <?php
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
        <h4>
            <br />
            <br />
            <a href="./class3_lab_1.php?action=home">HOME</a>
            <a href="./class3_lab_1.php?action=bio">BIO</a>
            <a href="./class3_lab_1.php?action=contact">CONTACT</a>
        </h4>
    </body>
</html>
