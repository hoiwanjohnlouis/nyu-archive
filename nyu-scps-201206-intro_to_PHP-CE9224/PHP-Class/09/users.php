<?php
/**
users.php - This script should do the following:

    List the users in the database and their information.
    The username should be a link to user.php?username=name_here
*/
?>

<?php require_once "db_model.php" ?>

<?php

    $isPost = (isset($_SERVER['REQUEST_METHOD']) && strtolower($_SERVER['REQUEST_METHOD']) == 'post') ?: false;

    $results = array(
        "pageTitle" => "Users View",
    );
?>


<?php require_once "html_header.php"; ?>
<?php
    $sql  = 'select ';
    $sql .= 'users.`username`                   as USERNAME,    ';
    $sql .= 'users.`first_name`                 as LAST_NAME,   ';
    $sql .= 'users.`last_name`                  as FIRST_NAME,  ';
    $sql .= 'users.`email`                      as EMAIL        ';
    $sql .= 'from users ';
//    $sql .= 'limit 2';
    $data = db_query( $sql );
?>


<?php
    echo '<p><strong>Users Listing</strong></p>';
    echo '<table border="1">';
    echo '<tr>';
    echo '<td><strong>Username</strong></td>';
    echo '<td><strong>First Name</strong></td><td><strong>Last Name</strong></td><td><strong>Email</strong></td>';
    echo '</tr>';
    foreach($data as $row) {
        if (is_array($row)) {
            echo '<tr>';
            foreach($row as $key => $field) {
                if ($key === 'USERNAME') {
                    echo "<td><a href=user.php?username=$field>$field</a></td>";
                }
                else if (is_int($key) && $key > 0) {
                    echo "<td>$field</td>";
                }
            }
            echo '</tr>';
        }
    }
    echo '</table>';
    echo '<br />';
?>
<?php require "html_footer.php"; ?>
