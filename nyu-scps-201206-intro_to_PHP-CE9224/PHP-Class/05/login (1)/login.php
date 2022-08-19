<?php

session_start();
if (isset($_SESSION['username'])) {
    header('Location: profile.php');
}

if(strtolower($_SERVER['REQUEST_METHOD']) == 'post') {
    $username = isset($_POST['username']) ? $_POST['username'] : null;
    $password = isset($_POST['password']) ? $_POST['password'] : null;
    $user     = getUser($username);

    if ($user && validateUser($user, $password)) {
        $_SESSION['username'] = $username;

        setcookie('firstName', $user['firstName'], time() + 60*60);
        setcookie('lastName', $user['lastName'], time() + 60*60);

        header('Location: profile.php');
    } else {
        $error = 'Could not log user in';
    }
}
?>
<? if(isset($error)) { ?>
<p><?= $error ?></p>
<? } ?>
<form action="<?= $_SERVER['PHP_SELF'] ?>" method="post">
    <input type="text" name="username" />
    <input type="password" name="password" />
    <input type="submit" value="Submit" />
</form>





































<?php
function getUser($username)
{
    $users = array(
        'aeinstein' => array(
            'password'  => '123abc',
            'firstName' => 'Albert',
            'lastName'  => 'Einstein',
        ),
        'bfranklin' => array(
            'password'  => '321zyx',
            'firstName' => 'Ben',
            'lastName'  => 'Franklin',
        ),
        'nchomsky' => array(
            'password'  => '987lmno',
            'firstName' => 'Noam',
            'lastName'  => 'Chomsky',
        ),
    );
    return isset($users[$username]) ? $users[$username] : null;
}

function validateUser(array $user, $password)
{
    if($user['password'] != $password) {
        return false;
    }

    return true;
}
?>