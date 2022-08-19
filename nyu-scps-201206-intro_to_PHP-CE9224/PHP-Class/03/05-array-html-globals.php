<?php

	if (isset($_GET['action'])) {
		print_r($_GET['action']);
		print('<br />');
	} else {
		print('Variable "action" is not set.<br />');
	}

?>