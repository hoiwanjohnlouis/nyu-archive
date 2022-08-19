<?php

//  Class 4, Lab 4, Assignment #1
//  Class review: looping, user defined functions, and multi-dimensional
//  array basics.
//
//  See the following file:
//  http://davehauenstein.com/nyu/INFO1-CE9224-2012-Summer/labs/class4/a1Output.txt
//  This file defines HTML that is the expected output.
//
//  Please meet the following criteria:
//  1.  Define a multidimensional array where the keys are the top level
//      navigation, and the values are arrays that define second level navigation.
//  2.  Define a function that takes in the array from step 1,
//      and returns the navigation as an HTML formatted string.
//
//  There are many ways to solve this problem.
//  If you get done with this, and you feel like there may be a better way, let
//  me know. I can help you architect the solution until you feel happy with it.
//
//  Hint:
//      If you’re having a hard time getting started, see the following URL
//      for the array that I’ve started for you. Add the remaining values
//      yourself, and use that. Here’s the hint:
//  http://davehauenstein.com/nyu/INFO1-CE9224-2012-Summer/labs/class4/a1Hint.txt
//
//  Advanced:
//      User defined functions and loops are great, but what if this
//      problem had an unknown number of nested levels of navigation?
//      Do you need a nested loop for each nesting in the multidimensional
//      array? The solution to this problem is advanced, and it’s called
//      recursion. A recursive function calls itself inside of a loop
//      until a particular condition is met. If you finish the lab early,
//      and would like to work on this, let me know and I can get you started.

  $navigation = array(
    'Tech' => array(
      'Tools'      => 'tools.php',
      'Media'      => 'media.php',
      'Enterprise' => 'enterprise.php',
    ),
    'Finance' => array(
      'Markets'       => 'markets.php',
      'Your Money'    => 'money.php',
      'Broker Center' => 'broker.php',
    ),
    'Politics' => array(
      'Politics Home' => 'politics.php',
      'Defense'       => 'defense.php',
    ),
    'Contact' => 'contact.php',
  );


//  build HTML file using $navigation array
function makeHTML($nav)
{

    echo '<!DOCTYPE html>';
    echo '<html lang="en">';
    echo '<head>';
    echo '    <meta charset="utf-8" />';
    echo '    <title>Lab</title>';
    echo '</head>';
    echo '<body id="home-page" class="">';
    echo '    <ul>';
    echo '        <li>';

    if (is_array($nav)) {
      //  build HTML file using $navigation array
      foreach($nav as $items => $detail) {
        echo '<strong>city: </strong>' . $items . '<br />';

        //  make sure we don't cause error when traversing the tree/array.
        //  since the last element is a single key,value pair.
        if (is_array($detail)) {
          foreach($detail as $key => $value) {
            echo '<strong>' . $key . ': </strong>' . $value . '<br />';
          }
          echo '<br /><br />';
        }
        else {
        }
      } //  foreach($nav as $items => $detail) {
    } //  if (is_array($nav)) {

    echo '        </li>';
    echo '    </ul>';
    echo '</body>';
    echo '</html>';
  
} //  end of function makeHTML($nav);



  makeHTML($navigation);

?>