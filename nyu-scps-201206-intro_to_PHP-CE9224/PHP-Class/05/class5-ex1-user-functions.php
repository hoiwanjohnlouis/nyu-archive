<?php
/**
 Exercises 5

User Defined Functions
Define 2 functions that do the following:
1. getTextInput with two required values (name, id), and one optional value (val). This
shoud return the HTML element for an input type=”text” field.
2. getTextArea with two required values (name, id), and one optional value (val). This
shoud return the HTML element for a textarea field.
3. Create an HTML form using these functions.

*/

/**
*/
function getTextInput ( $name, $id, $val = "" ) 
{
	$ret = null;
	if ( isset( $name ) && isset( $id ) ) {
        $template  = '<label for="%s">%s</label>' . "\n";
    	$template .= '<input type="text" name="%s" id="%s" value="%s" /><br />';
    	$ret = sprintf(
			        $template,
                    $id,
                    $name,
                    $name,
                    $id,
        			$val
    			);
	}
	else {
		$ret = false;
	}
	return $ret;
}

/**
*/
function getTextArea ( $name, $id, $val = "" ) 
{
	$ret = null;
	if ( isset( $name ) && isset( $id ) ) {
        $template  = '<label for="%s">%s</label>' . "\n";
	    $template .= '<textarea type="text" name="%s" id="%s">%s</textarea><br />';
    	$ret = sprintf(
			        $template,
                    $id,
                    $name,
                    $name,
                    $id,
			        $val
			    );
	}
	else {
		$ret = false;
	}
	return $ret;
}

/**
*/
function getSubmitInput( $name, $id, $val = "" ) 
{

  //  <input type="submit" name="Submit" value="Submit" id="submit" />

  $ret = null;
  if ( isset( $name ) && isset( $id ) ) {
      $template = '<input type="submit" name="%s" value="%s" id="%s" /><br />' . "\n";
      $ret = sprintf(
              $template,
              $name,
              $val,
              $id
          );
  }
  else {
    $ret = false;
  }

  // var_dump( $ret );

  return $ret;
}
?>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Lab 5 Form</title>
        <style>
            label {
                display: block;
            }
            ul {
                list-style-type: none;
            }
		    body {
		        background-color:#CCC;
		        color:#000;
		        font:12px Verdana, Geneva, sans-serif;
		        margin:20px auto;
		    }
        </style>
    </head>
    <body id="home-page" class="">
        <form action="" method="post">
            <?php echo getTextInput("Subject", "subj", ""); ?><br />
            <?php echo getTextArea("Comment", "comm", ""); ?><br />
            <?php echo getSubmitInput("Submit", "submit", "Submit"); ?>
        </form>
    </body>
</html>