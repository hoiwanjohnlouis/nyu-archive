<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Lab 2 Form</title>
        <style>
            label {
                display: block;
            }
            ul {
                list-style-type: none;
            }
        </style>
    </head>
    <body id="home-page" class="">
        <form action="register.php" method="post">
            <ul>
                <li>
                    <label for="username">Username:</label>
                    <input type="text" name="username" id="username" />
                </li>
                <li>
                    <label for="first_name">First Name</label>
                    <input type="text" name="first_name" id="first_name" />
                </li>
                <li>
                    <label for="last_name">Last Name</label>
                    <input type="text" name="last_name" id="last_name" />
                </li>
                <li>
                    <label for="email">Email Address</label>
                    <textarea name="email" id="email"></textarea>
                </li>
                <li>
                    <input type="submit" name="Submit" value="Submit" id="submit" />
                </li>
        </form>
    </body>
</html>