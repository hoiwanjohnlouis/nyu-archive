<?php
require_once( "common.inc.php" );
require_once( "Member.class.php" );
require_once( "Message.class.php" );
checkLogin();


function sendMail($rowObject, $msgObject) {
    $boolResult  = false;

    // var_dump($row);

    $from = $_SESSION["member"]->getValue( "email" );
    $to   = $rowObject->getValue( "email" );

	// only send email to other people, skip oneself

	if ($from != $to) {
	    $subject = $msgObject->getValue( "subject" );
    	$message = $msgObject->getValue( "message_text" );
    	$message = wordwrap($message, 70);
	    $headers = array('From: ' . $from,'X-Priority: 2');
    	$headers = implode("\r\n", $headers);

	    //	var_dump('from:   ' . $from);
	    //	var_dump('to:     ' . $to);
    	//	var_dump('subject:' . $subject);
	    //	var_dump('message:' . $message);
    	//	var_dump('headers:' . $headers);

	    // email does not work in windows!
    	$boolResult  = mail($to, $subject, $message, $headers);
	} else {
		// echo "do NOT send email to yourself[$to]";
	}

    //	var_dump($boolResult);
    return $boolResult;
}

	// verify data and send tweet to all receipients.

    $isPost = (isset($_SERVER['REQUEST_METHOD']) && strtolower($_SERVER['REQUEST_METHOD']) == 'post') ?: false;

    if ( ( $isPost ) && ( $_POST ) && (isset($_POST['submit'])) ) {

		// moved from common.inc.php
    	$messageObject = new Message( array (
      		"member_id" => $_SESSION["member"]->getValue( "id" ),
      		"message_text" => (isset($_POST['message_text'])) ? htmlentities($_POST['message_text']) : '',
      		"subject" => (isset($_POST['subject']))   ? htmlentities($_POST['subject'])   : '',
    		) );


    	// DB save has problems with dupl id.  don't know why.  member_id is not restricted field.
    	$messageObject->record(); // save to db


		// get all email addresses and send the tweet to each email address
		$eList = Member::getMembers();
		$emails 	= $eList[0];
		$row_count 	= $eList[1];
		// var_dump($eList, $emails, $row_count);
		foreach ($emails as $row) {
			if (is_object($row)) {
				// echo "is object<br />";
				// var_dump($row);
				sendMail($row, $messageObject);
			} else if (is_array($row)) {
				echo "is array<br />";
				var_dump($row);
			} else {
				echo "is OTHER<br />";
				var_dump($row);
			}
		}

    	$messageObject = null;	// object no longer needed
	}

displayPageHeader( "Send Tweets" );
?>




<p>Fields marked with an asterisk (*) are required.</p>
<?php 
	echo  	"<strong>From:" . 
				$_SESSION["member"]->getValue( "first_name" ) . " "  .
	            $_SESSION["member"]->getValue( "last_name" )  . " (" .
	            $_SESSION["member"]->getValue( "email" )      . ")"  .
			"</strong>";
?>

<form action="send_tweets.php" method="post" style="margin-bottom: 50px;">
  <div style="width: 30em;">
    <input type="hidden" name="action" value="tweet" />

        <label for="Subject:">Subject *</label>
        <input type="text" name="subject" id="subject" value="" />

        <label for="message_text">Email Text *</label>
        <textarea name="message_text" id="message_text" rows="3" cols="50"></textarea>

        <div style="clear: both;">
          <input type="submit" name="submit" id="submit" value="Send Tweet" />
        </div>

  </div>
</form>


<p><a href="send_index.php">Members' area home page</a></p>

<?php displayPageFooter(); ?>
