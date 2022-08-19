<?php

// 	Hoi Wan Louis
// 	Class 7, Exercises

//	Exercise 1
//  Simple Validation using Regular Expressions
//  Validate strings using the following rules:
//	• must only contain letters and numbers
//	• must be at least 5 characters long
//	• must be at most 15 characters long

$pattern = '/[a-z0-9]{3,10}/i';
$subject = 'dah16';
if ( preg_match($pattern, $subject) ) {
	echo "pattern matched";
} else {
	echo "pattern did not match";
}

//	Exercise 2
//  Complex Validation using Regular Expressions
//	You’ve been tasked with building a file uploader. Your boss is very particular about how
//	she wants the files that are uploaded to be named. She gave you the following
//	requirements. The file name must:
//	• cannot contain capital letters
//	• can contain numbers, but cannot start with a number
//	• the only special characters allowed are underscore and hyphen
//	• cannot be shorter than 5 characters
//	• cannot be longer than 20 characters
//	• must only contain one dot, which is what separates the name from the extension
//	• can only have the following extensions: txt, doc, rtf
//	Valid Names:
//	document-1.txt
//	document_34.rtf
//	some-doc_2010.doc
//	Invalid Names:
//	Document-1.txt
//	01-doc.txt
//	very-very-long-document-name.doc
//	01-doc.html
//	some(doc).txt


?>