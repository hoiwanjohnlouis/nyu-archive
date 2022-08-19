<?php

/**

orders.php - This script should do the following:

  • Display a list of orders along with all product data and user data.
  • The orders table in the database is called a “join table”
    or “pivot table” which means it requires joins to retrieve most of the data.
  • Each order should be displayed in it’s own HTML table. Please see the
    appendix of this assignment for an example.

  • EXTRA: The orders table doesn’t have a flag specifying whether or not this
    order has been fulfilled. Add a column called fulfilled, 0 means it’s
    not been fulfilled, 1 means it’s been fulfilled. Have the column
    default to 0. Add this column to the orders.php script. Create a
    link next to each order to change the status from 0 to 1 and vice-versa.

*/
?>

<?php require_once "db_model.php" ?>

<?php

    $isPost = (isset($_SERVER['REQUEST_METHOD']) && strtolower($_SERVER['REQUEST_METHOD']) == 'post') ?: false;

    $results = array(
        "pageTitle" => "Products View",
    );
?>


<?php require_once "html_header.php"; ?>
<?php
    $sql  = 'select ';
    $sql .= 'orders.`order_id`                  as OID,         ';
    $sql .= 'products.`product_name`            as PRODNAME,    ';
    $sql .= 'products.`product_description`     as PRODDESC,    ';
    $sql .= 'products.`product_category`        as PRODCAT,     ';
    $sql .= 'products.`price`                   as PRODPRICE,   ';
    $sql .= 'users.`username`                   as USERNAME,    ';
    $sql .= 'users.`first_name`                 as LAST_NAME,   ';
    $sql .= 'users.`last_name`                  as FIRST_NAME,  ';
    $sql .= 'users.`email`                      as EMAIL        ';
    $sql .= 'from orders ';
    $sql .= 'inner join products  on products.`id` = orders.`product_id` ';
    $sql .= 'inner join users     on users.`id`    = orders.`user_id` ';
    $sql .= 'order by orders.`order_id` ';
//    $sql .= 'limit 2';
    $data = db_query( $sql );
?>


<?php
    echo '<p><strong>Orders Listing</strong></p>';
    echo '<table border="1">';
    echo '<tr>';
    echo '<td><strong>Order Id</strong></td>';
    echo '<td><strong>Product Name</strong></td><td><strong>Product Description</strong></td><td><strong>Product_Category</strong></td><td><strong>Price</strong></td>';
    echo '<td><strong>UserName</strong></td><td><strong>First Name</strong></td><td><strong>Last Name</strong></td><td><strong>Email</strong></td>';
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
