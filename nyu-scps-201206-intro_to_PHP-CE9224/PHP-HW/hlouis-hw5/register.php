<?php

require_once( "common.inc.php" );

if ( isset( $_POST["action"] ) and $_POST["action"] == "register" ) {
  processForm();
} else {
  displayForm( array(), array(), new Member( array() ) );
}

function displayForm( $errorMessages, $missingFields, $member ) {
  displayPageHeader( "Sign up for the twitter club!" );

  if ( $errorMessages ) {
    foreach ( $errorMessages as $errorMessage ) {
      echo $errorMessage;
    }
  } else {
?>
    <p>Thanks for choosing to join our twitter club.</p>
    <p>To register, please fill in your details below and click Send Details.</p>
    <p>Fields marked with an asterisk (*) are required.</p>
<?php } ?>

    <form action="register.php" method="post" style="margin-bottom: 50px;">
      <div style="width: 30em;">
        <input type="hidden" name="action" value="register" />

        <label for="username"<?php validateField( "username", $missingFields ) ?>>Username *</label>
        <input type="text" name="username" id="username" value="<?php echo $member->getValueEncoded( "username" ) ?>" />

        <label for="first_name"<?php validateField( "first_name", $missingFields ) ?>>First name *</label>
        <input type="text" name="first_name" id="first_name" value="<?php echo $member->getValueEncoded( "first_name" ) ?>" />

        <label for="last_name"<?php validateField( "last_name", $missingFields ) ?>>Last name *</label>
        <input type="text" name="last_name" id="last_name" value="<?php echo $member->getValueEncoded( "last_name" ) ?>" />

        <label for="email"<?php validateField( "email", $missingFields ) ?>>Email address *</label>
        <input type="text" name="email" id="email" value="<?php echo $member->getValueEncoded( "email" ) ?>" />

        <div style="clear: both;">
          <input type="submit" name="submitButton" id="submitButton" value="Save User" />
          <input type="reset" name="resetButton" id="resetButton" value="Reset Form" style="margin-right: 20px;" />
        </div>

      </div>
    </form>
<?php
  displayPageFooter();
}

function processForm() {

  $requiredFields = array( "username", "first_name", "last_name", "email" );
  $missingFields = array();
  $errorMessages = array();

  $member = new Member( array( 
    "username" => isset( $_POST["username"] ) ? preg_replace( "/[^ \'\-a-zA-Z0-9]/", "", $_POST["username"] ) : "",
    "first_name" => isset( $_POST["first_name"] ) ? preg_replace( "/[^ \'\-a-zA-Z0-9]/", "", $_POST["first_name"] ) : "",
    "last_name" => isset( $_POST["last_name"] ) ? preg_replace( "/[^ \'\-a-zA-Z0-9]/", "", $_POST["last_name"] ) : "",
    "email" => isset( $_POST["email"] ) ? preg_replace( "/[^ \@\.\-\_a-zA-Z0-9]/", "", $_POST["email"] ) : "",
    "update_timestamp" => date( "Y-m-d H:i:s" ),
    "create_timestamp" => date( "Y-m-d H:i:s" )
  ) );

  foreach ( $requiredFields as $requiredField ) {
    if ( !$member->getValue( $requiredField ) ) {
      $missingFields[] = $requiredField;
    }
  }

  if ( $missingFields ) {
    $errorMessages[] = '<p class="error">There were some missing fields in the form you submitted. Please complete the fields highlighted below and click Send Details to resend the form.</p>';
  }

  if ( Member::getByEmailAddress( $member->getValue( "email" ) ) ) {
    $errorMessages[] = '<p class="error">A member with that email address already exists in the database. Please choose another email address, or contact the webmaster to retrieve your password.</p>';
  }

  if ( $errorMessages ) {
    var_dump($member);
    var_dump($requiredFields);
    var_dump($missingFields);
    displayForm( $errorMessages, $missingFields, $member );
  } else {
    $member->insert();
    displayThanks();
  }
}

function displayThanks() {
  displayPageHeader( "Thanks for registering!" );
?>
    <p>Thank you, you are now a registered member of the book club.</p>
    <p>Register another user <a href="register.php">members' area</a>.</p>
    <p>Proceed to the <a href="send_index.php">members' area</a>.</p>

<?php
  displayPageFooter();
}
?>
