<?php

session_start();
session_destroy();

$_SESSION = array();
setcookie('firstName', null, time()-60);
setcookie('lastName', null, time()-60);
$_COOKIE = array();

header('Location: login.php');