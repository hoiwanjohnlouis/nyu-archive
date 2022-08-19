<?php

//  Class 4, Lab 4, Assignment #2
//  Class review: looping, user defined functions, and multi-dimensional
//  array basics.
//
//  Putting it all together: what we’ve learned in class up to now
//  See this url to obtain the form for the assignment:
//  http://davehauenstein.com/nyu/INFO1-CE9224-2012-Summer/labs/class4/a2Template.txt.
//  You’ll notice that it’s very similar to the form that was used last week
//  in class. For this assignment, please write code to do the following:
//
//    1.  Create two user defined functions:
//        a.  one for generating the HTML for text inputs
//        b.  one for generating the HTML for textarea inputs
//    2.  Each of these functions should take in the following arguments:
//        a.  label: the text for the label
//        b.  name: the name attribute of the field
//        c.  id: the id attribute of the field
//        d.  value: a default value, this should be optional
//    3.  Create a multidimensional array that contains the data for
//        generating this form.
//        a.  Loop over the multidimensional array
//        b.  Call the appropriate form function to generate the HTML
//    4.  Note: The functions should return the html, not echo it.
//    5.  When handling the form, don’t print out each field individually.
//        Do the following:
//        a.  Write a loop to iterate over the $POST array.
//        b.  Replace the underscores in the keys with spaces,
//            and make sure the keys have uppercase first letters.
//        c.  Display the value after the key, for example
//            i.  the form field is named: product_description
//            ii. it should display: Product Descriptions: value here
//    6. If it’s a POST request, do not display the form again, only the values.
//    7. Ensure that there are no errors or warnings.
//
//  Please let me know if you have any questions or these instructions are unclear.

	$fields = array(
		array(
    			'label'  	=> 'Product Name',
      		'type'   	=> 'text',
      		'name'   	=> 'product_name',
      		'id'   		=> 'product_name',
          'value'   => '',
    	),
    	array(
      		'label'  	=> 'Price',
      		'type'   	=> 'text',
      		'name'   	=> 'price',
      		'id'   		=> 'price',
          'value'   => '',
    	),
    	array(
      		'label'  	=> 'SKU',
      		'type'   	=> 'text',
      		'name'   	=> 'sku',
      		'id'   		=> 'sku',
          'value'   => '',
    	),
    	array(
          'label'  	=> 'Product Description',
      		'type'   	=> 'textarea',
      		'name'   	=> 'product_description',
      		'id'   		=> 'product_description',
          'value'   => '',
    	),
    	array(
	    	  'label'  	=> '',
      		'type'   	=> 'submit',
      		'name'   	=> 'Submit',
      		'id'   		=> 'submit',
      		'value'		=> 'Submit',
    	),
  	);


	// var_dump($fields);


/**
*/
function getTextInput( $label, $name, $id, $val = "" ) 
{

  //  <label for="sku">SKU</label>
  //  <input type="text" name="sku" id="sku" />

	$ret = null;
	if ( isset( $label ) && isset( $name ) && isset( $id ) ) {
      $template  = '<label for="%s">%s</label>' . "\n";
      $template .= '<input type="text" name="%s" id="%s" value="%s" /><br />';
    	$ret = sprintf(
			        $template,
              $id,
              $label,
    	    		$name,
        			$id,
        			$val
    			);
	}
	else {
		$ret = false;
	}

  // var_dump( $ret );

	return $ret;
}

/**
*/
function getTextArea( $label, $name, $id, $val = "" ) 
{

	//	<label for="product_description">Product Description</label>
  //  <textarea name="product_description" id="product_description"></textarea>

	$ret = null;
	if ( isset( $label ) && isset( $name ) && isset( $id ) ) {
      $template  = '<label for="%s">%s</label>' . "\n";
      $template .= '<textarea name="%s" id="%s">%s</textarea><br />';
    	$ret = sprintf(
			        $template,
              $id,
              $label,
		    	    $name,
        			$id,
			        $val
			    );
	}
	else {
		$ret = false;
	}

  // var_dump( $ret );

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

/**
*/
function createHTML( $fields ) 
{
  $results = '';

  if (is_array($fields)) {
    foreach($fields as $items => $detail) {
      $field = '';
      switch( $detail['type'] ) {
        case 'text':;
          $field = getTextInput(
                      $detail['label'],
                      $detail['name'],
                      $detail['id'],
                      $detail['value']
                   );
        break;

        case 'textarea':;
          $field = getTextArea(
                      $detail['label'],
                      $detail['name'],
                      $detail['id'],
                      $detail['value']
                   );
        break;

        case 'submit':;
          $field = getSubmitInput(
                      $detail['name'],
                      $detail['id'],
                      $detail['value']
                   );
        break;
      }

      if ($field) {
        $results = $results . '<li>' . $field . '</li>' . "\n"; 
      }
    }
  }

  // var_dump( $results );

  return $results;

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
        <form action="class4_lab_2.php" method="post">
            <ul>
         	    <?php echo createHTML( $fields ); ?>
            </ul>
        </form>
    </body>
</html>
