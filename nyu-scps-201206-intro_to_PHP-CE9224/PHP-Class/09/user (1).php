<?php
/**
user.php

• This script should only display information if a valid $_GET[‘username’] has
been specified.
• If $_GET[‘username’] is a valid username, display all of their orders
underneath.
• If $_GET[‘username’] is not specified or is not valid, redirect back to the
users.php script.
*/
?>

<?php
/**
users.php - This script should do the following:

    List the users in the database and their information.
    The username should be a link to user.php?username=name_here
*/
?>

<?php require_once "db_model.php" ?>

<?php

    $isPost   = (isset($_SERVER['REQUEST_METHOD']) && strtolower($_SERVER['REQUEST_METHOD']) == 'post') ?: false;
    $username = (isset($_GET['username'])) ? $_GET['username'] : false;
    if (!$username) {
        header("Location: ./users.php");
    }


    $results  = array(
        "pageTitle" => "Single User View",
    );
?>


<?php require_once "html_header.php"; ?>
<?php
    $sql  = 'select ';
    $sql .= 'users.`username`                   as USERNAME,    ';
    $sql .= 'users.`first_name`                 as LAST_NAME,   ';
    $sql .= 'users.`last_name`                  as FIRST_NAME,  ';
    $sql .= 'users.`email`                      as EMAIL,       ';
    $sql .= 'orders.`order_id`                  as OID,         ';
    $sql .= 'products.`product_name`            as PRODNAME,    ';
    $sql .= 'products.`product_description`     as PRODDESC,    ';
    $sql .= 'products.`product_category`        as PRODCAT,     ';
    $sql .= 'products.`price`                   as PRODPRICE    ';
    $sql .= 'from users ';
    $sql .= 'inner join orders    on users.`id`    = orders.`user_id` ';
    $sql .= 'inner join products  on products.`id` = orders.`product_id` ';
    $sql .= 'where users.`username` = ' . "'$username'";

// $sql .= 'order by orders.`order_id` ';
//    $sql .= 'limit 2';

    $data = db_query( $sql );

?>


<?php
    echo '<p><strong>Single Users Listing</strong></p>';
    echo '<table border="1">';
    echo '<tr>';
    echo '<td><strong>Username</strong></td>';
    echo '<td><strong>First Name</strong></td><td><strong>Last Name</strong></td><td><strong>Email</strong></td>';
    echo '<td><strong>Order Id</strong></td>';
    echo '<td><strong>Product Name</strong></td><td><strong>Product Description</strong></td><td><strong>Product Category</strong></td><td><strong>Price</strong></td>';
    echo '</tr>';
    foreach($data as $row) {
        if (is_array($row)) {
            echo '<tr>';
            foreach($row as $key => $field) {
                if (is_int($key)) {
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
