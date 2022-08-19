<?php

/**
    MODEL

Database Access

*/


/**
*/
function db_query($sql) {
    include(getcwd() . '/db_config.php');
    $data = null;
    $connection = new PDO($dsn, $username, $password);
    if ($connection) {
        // echo "connection to [$dsn] query successful<br />";
        $data = $connection-> query($sql);
        $connection = null;
        if ($data) {
            // echo "SQL [$sql] query successful<br />";
        } else {
            echo "SQL [$sql] query failed<br />";
        }
    } else {
        echo "connection to [$dsn] query failed<br />";
    }
    return $data;
}


/**
*/
function db_exec_insert($sql) {
    include(getcwd() . '/db_config.php');
    $data = null;
    $connection = new PDO($dsn, $username, $password);
    if ($connection) {
        // echo "connection to [$dsn] exec insert successful<br />";
        $data = $connection-> exec($sql);
        $connection = null;
        if ($data) {
            // echo "SQL [$sql] exec insert successful<br />";
            echo $data . ' rows inserted<br />';
        } else {
            echo "SQL [$sql] exec insert failed<br />";
        }
    } else {
        echo "connection to [$dsn] exec insert failed<br />";
    }
}

/**
*/
function db_exec_delete($sql) {
    include(getcwd() . '/db_config.php');
    $data = null;
    $connection = new PDO($dsn, $username, $password);
    if ($connection) {
        echo "connection to [$dsn] exec delete successful<br />";
        $data = $connection-> exec($sql);
        $connection = null;
        if ($data) {
            echo "SQL [$sql] exec delete successful<br />";
            echo $data . ' rows deleted<br />';
        } else {
            echo "SQL [$sql] exec delete failed<br />";
        }
    } else {
        echo "connection to [$dsn] exec delete failed<br />";
    }
}

/**
*/
function db_exec_update($sql) {
    include(getcwd() . '/db_config.php');
    $data = null;
    $connection = new PDO($dsn, $username, $password);
    if ($connection) {
        echo "connection to [$dsn] exec update successful<br />";
        $data = $connection-> exec($sql);
        $connection = null;
        if ($data) {
            echo "SQL [$sql] exec update successful<br />";
            echo $data . ' rows updated<br />';
        } else {
            echo "SQL [$sql] exec update failed<br />";
        }
    } else {
        echo "connection to [$dsn] exec update failed<br />";
    }
}

/**
*/
function db_prepare($sql) {
    include(getcwd() . '/db_config.php');
    $data = null;
    $connection = new PDO($dsn, $username, $password);
    if ($connection) {
        echo "connection to [$dsn] successful<br />";
        $statement = $connection-> prepare($sql);
        if ($statement) {
            echo "SQL [$sql] prepare successful<br />";
            $statement -> execute();
            $connection = null;
            print_r($statement);
            echo '<br />';
            $data = $statement -> fetchAll();
            print_r($data);
            echo '<br />';

            foreach($data as $row) {
                print_r($row);
                echo '<br />';
                echo '<br />';
                echo 'order_id[' . $row["order_id"] . ']<br />';
                echo '<br />';
            }
        } else {
        echo "SQL [$sql] prepare failed<br />";
        }
    } else {
        echo "connection to [$dsn] failed<br />";
    }
    return $data;
}

?>
