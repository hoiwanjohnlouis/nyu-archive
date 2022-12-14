<?php
/**

products.php - This script should do the following:

    • Display a form, with fields for product name, description, price, and category.
        Category should be an HTML select.
    • When a user submits this form (to itself, using POST method), the data
        should be inserted into the products table.
    • Aside from the form and form handling, the products.php script should also
        display an HTML table with a list of the products that are in the database.
    • The logic for inserting the data on the form submission should come before
        the logic for retrieving the products in the database, so new products
        are shown after the form has been submitted. There are additional ways
        of doing this, it’s up to you how you achieve it.

    • EXTRA: Place a delete link next to each product, when someone clicks it,
        have that product be removed from the database.

*/
?>

<?php require_once "db_model.php" ?>

<?php

function good_data ($name, $description, $category, $price) {
    $is_good = false;
    if ($name        != '' ||
        $description != '' ||
        $price       != ''
       ) {
        $is_good = true;
    }

    // var_dump($name, $description, $category, $price, $is_good);

    return $is_good;
}

    $isPost = (isset($_SERVER['REQUEST_METHOD']) && strtolower($_SERVER['REQUEST_METHOD']) == 'post') ?: false;

    // verify input data and insert into products database

    if ( ( $isPost ) && ( $_POST ) && (isset($_POST['submit'])) ) {
        $product_name        = (isset($_POST['product_name']))        ? htmlentities($_POST['product_name'])        : '';
        $product_description = (isset($_POST['product_description'])) ? htmlentities($_POST['product_description']) : '';
        $product_category    = (isset($_POST['product_category']))    ? htmlentities($_POST['product_category'])    : '';
        $product_price       = (isset($_POST['price']))               ? htmlentities($_POST['price'])               : '';
        // var_dump($product_name, $product_description, $product_category, $product_price);
        if (good_data($product_name, $product_description, $product_category, $product_price)) {
            $sql  = 'insert into products ' .
                '(product_name, product_description, product_category, price) ' .
                'values (' .
                "'$product_name', " .
                "'$product_description', " .
                "'$product_category', " .
                "'$product_price' " .
                ')';
            // var_dump($sql);
            $data = db_exec_insert($sql);
        } else {
            echo "<strong>Please enter all fields correctly</strong>";
        }
    } else {
    }
    $results = array(
        "pageTitle" => "Products View",
    );
?>
<?php require_once "html_header.php" ?>

    <form action="products.php" method="post">
       <ul>
            <li>
                <label for="product_name">Product Name</label>
                <input type="text" name="product_name" id="product_name" />
            </li>
            <li>
                <label for="product_description">Product Description</label>
                <textarea name="product_description" id="product_description" ></textarea>
            </li>
            <li>
                <label for="product_category">Product Category</label>
                <select name="product_category">
                    <option value="book">Book</option>
                    <option value="movie">Movie</option>
                </select>
            </li>
            <li>
                <label for="price">Price</label>
                <input type="text" name="price" id="price" />
            </li>
            <li>
                <input type="submit" name="submit" id="submit" value="Add Product" />
            </li>
        </ul>
    </form>
    <br />


<?php
    $sql  = 'select product_name, product_description, product_category, price from products ';
//    $sql .= 'limit 2';
    $data = db_query($sql);
    echo '<p><strong>Products Listing</strong></p>';
    echo '<table border="1">';
    echo '<tr>';
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
<?php require_once "html_footer.php"; ?>
