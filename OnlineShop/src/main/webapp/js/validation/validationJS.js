
var name_pattern = new RegExp("^([A-z]{4,20})$");
var login_pattern = new RegExp("^([A-z0-9]{4,20})$");
var email_pattern = new RegExp("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
var password_pattern = new RegExp("^[A-z0-9]{4,20}$");

document.getElementById("register_form").addEventListener("submit", function(event) {

  var first_name = document.getElementById("firstname").value;
  var last_name = document.getElementById("lastname").value;
  var login = document.getElementById("login").value;
  var email = document.getElementById("email").value;
  var passwords = document.getElementById("password").value;
  var pass_conf = document.getElementById("password_conf").value;

  if (!name_pattern.test(first_name)) {
      document.getElementById("error_first_name").innerHTML = 'First name is not correct';
      document.getElementById("error_first_name").innerHTML = '';
      event.preventDefault();
  } else if (!name_pattern.test(last_name)) {

      document.getElementById("error_last_name").innerHTML = 'Last name is not correct';
      document.getElementById("error_last_name").innerHTML = '';
      event.preventDefault();
  } else if (!login_pattern.test(login)) {
      document.getElementById("error_reg_login").innerHTML = 'Login is not correct';
      document.getElementById("error_reg_login").innerHTML = '';
      event.preventDefault();
  } else if (!email_pattern.test(email)) {
      document.getElementById("error_email").innerHTML = 'Email is not correct';
      document.getElementById("error_email").innerHTML = '';
      event.preventDefault();
  } else if (!password_pattern.test(passwords)) {
      document.getElementById("error_password").innerHTML = 'Password is not correct';
      document.getElementById("error_password").innerHTML = '';
      event.preventDefault();
  }else if (!password_pattern.test(pass_conf)) {
      document.getElementById("error_password").innerHTML = 'Password is not correct';
      document.getElementById("error_password").innerHTML = '';
      event.preventDefault();
  } else if (passwords != pass_conf) {;
      document.getElementById("error_password_conf").innerHTML = 'Password is not equal';
      document.getElementById("error_password_conf").innerHTML = '';
    event.preventDefault();
  }
})