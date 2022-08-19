<?php

// Assignment #3
//
// Geometry 101 - Find the perimeter, area, and volume of each of the following shapes.
// 1. A circle (sphere for volume) with a radius of 7.4
// 2. A square (cube for volume) with sides of 14
// 3. A right triangle (ignore volume) with sides a (height) = 7, b (base) = 24, c = 25
//
// Perimeter formulas
// ! circle: 2 * pi * radius
// ! square: 4 * side
// ! triangle: side1 + side2 + side3
// 
// Area formulas
// ! circle: pi * radius^2
// ! square: side^2
// ! Triangle: base * height / 2
//
// Volume formulas
// ! sphere: (4/3) * pi * radius^3
// ! cube: side^3
//
// Needed info:
// ! use php’s pow() function to square and cube values: pow(42, 2); // 42^2
// ! use php’s built in Pi constant: M_PI or define your own constant for Pi
//
// Output:
// A circle with a radius of 7.4 has a perimeter of {answer}.
// A circle with a radius of 7.4 has an area of {answer}.
// A sphere with a radius of 7.4 has a volume of {answer}.
// A square with sides equal to 14 has a perimeter of {answer}.
// A square with sides equal to 14 has an area of {answer}.
// A cube with sides equal to 14 has a volume of {answer}.
// A right triangle with a height of 3, base of 4, 
// 		and hypotenuse of 5 has a perimeter of {answer}.
// A right triangle with a height of 3, base of 4, 
// 		and hypotenuse of 5 has an area of {answer}.

	$_radius              = 7.4;
	$_side                = 14;
	$_triangle_height     = 7;
	$_triangle_base       = 24;
	$_triangle_hypotenuse = 25;

	$_perimeter_circle    = 2 * M_PI * $_radius;
	$_area_circle         = M_PI * pow( $_radius, 2 );
	$_volume_sphere       = (4/3) * M_PI * pow( $_radius, 3 );

	$_perimeter_square    = 4 * $_side;
	$_area_square         = pow( $_side, 2 );
	$_volume_cube         = pow( $_side, 3 );

	$_perimeter_triangle  = $_triangle_height + $_triangle_base + $_triangle_hypotenuse;
	$_area_triangle       = ( $_triangle_height * $_triangle_base ) / 2;

	
	echo "A circle with a radius of ${_radius} has a perimeter of ${_perimeter_circle}.<br />";
	echo "A circle with a radius of ${_radius} has an area of ${_area_circle}.<br />";
	echo "A sphere with a radius of ${_radius} has a volume of ${_volume_sphere}.<br />";

	echo "A square with sides equal to ${_side} has a perimeter of ${_perimeter_square}.<br />";
	echo "A square with sides equal to ${_side} has an area of ${_area_square}.<br />";
	echo "A cube with sides equal to ${_side} has a volume of ${_volume_cube}.<br />";

	echo "A right triangle with a height of ${_triangle_height}, base of ${_triangle_base}, and hypotenuse of ${_triangle_hypotenuse} has a perimeter of ${_perimeter_triangle}.<br />";
	echo "A right triangle with a height of ${_triangle_height}, base of ${_triangle_base}, and hypotenuse of ${_triangle_hypotenuse} has an area of ${_area_triangle}.<br />";


?>
