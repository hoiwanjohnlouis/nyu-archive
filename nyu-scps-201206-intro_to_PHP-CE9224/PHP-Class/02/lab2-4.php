<?php

// Assignment #4
//
// String Handling and Manipulation
//
// Given the information in the Class 2 slides and presentation, perform the following tasks:
//
// 1. Assign your first and last name to a single variable. Jumble up the caseing (ex: DavE
// HaUENsTein). Run string manipulation functions on them so that it reads like ‘Dave
// Hauenstein’.

	$_myName = "hOi waN lOuIs";
	$_lcName = strtolower($_myName);
	$_ucWordName = ucwords($_lcName);

	echo "Original Name[<b>${_myName}</b>]<br />";
	echo "Lowercase Name[<b>${_lcName}</b>]<br />";
	echo "Upper Case Word Name[<b>${_ucWordName}</b>]<br />";
	echo "<br />";

// 2. Take a look at PHP’s str_pad function (http://us2.php.net/str_pad). Ignore all
// arguments but the first two $input and $pad_length. Using sprintf (or printf), emulate
// the functionality and print it to the screen.

	$_text = "brown jug";
	printf("[%s]<br />", $_text);
	printf("[%'#15s]<br />", $_text);
	printf("<br />");

// 3. Given the following paragraph, take this list of words and replace them with
// something else... MadLibs style! Then print out how long the original paragraph was,
// how long the new paragraph is, and the difference between the two
// (programmatically of course).
//
// find: entrepreneurs, resources, businesses, Brooklyn Public Library, competition, Citi
// Foundation, prizes
//
// Replace them with whatever you’d like.
//
// Brooklyn is filled with entrepreneurs, and a ton of great resources to launch homegrown
// businesses. But the most exciting opportunity of all is Brooklyn Public Library’s annual
// competition! For the past nine years the six-month competition, sponsored by Citi
// Foundation, has allowed hundreds of Brooklynites to vie for prizes from $500 to $15,000
// to make their vision a reality.

	$_paragraph = "Brooklyn is filled with entrepreneurs, and a ton of great resources to launch homegrown businesses. But the most exciting opportunity of all is Brooklyn Public Library's annual competition! For the past nine years the six-month competition, sponsored by Citi Foundation, has allowed hundreds of Brooklynites to vie for prizes from $500 to $15,000 to make their vision a reality.";

	printf("Original paragraph[<b>%s</b>]<br />", $_paragraph);
	printf("Original paragraph has [<b>%d</b>] characters.<br />", strlen($_paragraph));
	printf("<br />");

	printf("<b>");
	printf("replacing:<br />");
	printf("	entrepreneurs -> penguins<br />");
	printf(" 	resources -> supplies<br />");
	printf(" 	businesses - zoos<br />");
	printf("	Brooklyn Public Library -> African Zoo<br />");
	printf(" 	competition -> contest<br />");
	printf(" 	Citi Foundation -> Wildlife Organization<br />");
	printf("	prizes -> grants<br />");
	printf("</b>");
	printf("<br />");

	$_work = str_replace('entrepreneurs', 'penguins', $_paragraph);
	$_work = str_replace('resources', 'supplies', $_work);
	$_work = str_replace('businesses', 'zoos', $_work);
	$_work = str_replace('Brooklyn Public Library', 'African Zoo', $_work);
	$_work = str_replace('competition', 'contest', $_work);
	$_work = str_replace('Citi Foundation', 'Wildlife Organization', $_work);
	$_work = str_replace('prizes', 'grants', $_work);

	printf("Replaced paragraph [<b>%s</b>]<br />", $_work);
	printf("Replaced paragraph has [<b>%d</b>] characters.<br />", strlen($_work));
	printf("<br />");

?>
