<?php
require_once( "common.inc.php" );
checkLogin();
displayPageHeader( "Welcome to the Members' Area");

// var_dump($_SESSION["member"]); 
?>


<p>Welcome, <?php echo $_SESSION["member"]->getValue( "first_name" ) ?>! Please choose an option below:</p>

<ul>
  <li><a href="send_tweets.php">Send Tweets</a></li>
  <li><a href="logout.php">Logout</a></li>
</ul>

<?php displayPageFooter(); ?>
