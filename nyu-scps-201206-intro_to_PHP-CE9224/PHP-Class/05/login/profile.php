<?php

session_start();

if (!isset($_SESSION['username'])) {
    header('Location: login.php');
}
?>
<p>
    Hi, <?= $_SESSION['username'] ?>
</p>
<p>
    Your name is <?= $_COOKIE['firstName'] ?> <?= $_COOKIE['lastName'] ?>
</p>
<p>
    <a href="logout.php">Log out</a>
</p>