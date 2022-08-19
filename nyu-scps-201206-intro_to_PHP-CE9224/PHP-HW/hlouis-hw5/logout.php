<?php
require_once( "common.inc.php" );
session_start();
var_dump($_SESSION["member"]);
session_destroy();
// $_SESSION["member"] = null;
var_dump($_SESSION["member"]);
displayPageHeader( "Logged out" );
?>
    <p>Thank you, you are now logged out. <a href="login.php">Login again</a>.</p>
<?php
  displayPageFooter();
?>
