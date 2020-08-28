function validate() {
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	if (email == '') {
		alert('Email can\'t be empty.');
		return false;
	}else if (password == '') {
		alert('password can\'t be empty');
		return false;
	} else {
		return true;
	}
}

function validateRegistration() {
	var firstName = document.getElementById("firstName").value;
	var lastName = document.getElementById("lastName").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	if (email == '') {
		alert('Email can\'t be empty.');
		return false;
	}else if (password == '') {
		alert('Password can\'t be empty');
		return false;
	} 
	else if (firstName == '') {
		alert('First Name can\'t be empty');
		return false;
	}
	else if (lastName == '') {
		alert('Last Name can\'t be empty');
		return false;
	}else {
		return true;
	}
}