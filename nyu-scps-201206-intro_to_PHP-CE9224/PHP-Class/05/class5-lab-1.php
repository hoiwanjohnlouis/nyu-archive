<?php

/**
 Lab 5, Assignment #1

Log-in form: This assignment will force you to put together a lot of concepts that we’ve
	learned in class so far: form submission handling, multidimensional array traversal,
	setting HTTP headers, and setting and getting session and cookie data. Complete the
	following:

1. Create two files: login.php and profile.php

2. In the login.php file, create a multidimensional array with a list of at least 3 elements.
	The username should be the key, and the value should be an array. The array value
	should be an associative array with the following keys: password, first name, last
	name (this is essentially mimicking a database).

3. In the login.php file, write an HTML form with two elements: username and password.
	The form should submit a POST request to itself. It should search the
	multidimensional array for the submitted username and compare the submitted
	password to what it finds.
	a. If the password does not match or the username could not be found, display an
		error message and the form again.
	b. If the username is found and the password matches, log the user in:
		i. Save the username in session
		ii. Save the first name and last name in cookie variables
		iii.do an HTTP redirect to profile.php

4. If login.php is loaded with a session variable ‘username’ already set, do an HTTP
	redirect to profile.php

5. In the profile.php file
	a. Check that the user is logged in by verifying the username is set in session
	b. Display the First Name and Last Name from the cookie variables
	6. In the profile.php file, if the user is not logged in, redirect to the login.php file.

Please ask me if you need help with this.

*/

/**
*/


?>
