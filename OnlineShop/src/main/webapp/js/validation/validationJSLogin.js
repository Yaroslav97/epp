
var name_pattern = new RegExp("^([A-Za-z0-9]{4,20})$");
var password_pattern = new RegExp("^[A-z0-9]{4,20}$");

document.getElementById("login_form").addEventListener("submit", function(event) {
  
  var login = document.getElementById("login").value;
  var password = document.getElementById("password").value;
  
  if (!name_pattern.test(login)) {
      document.getElementById("error_login").innerHTML = 'Login is not correct';
      document.getElementById("error_login").innerHTML = '';
      event.preventDefault();
  }else if (!password_pattern.test(password)) {
      document.getElementById("error_password").innerHTML = 'Password is not correct';
      event.preventDefault();
  }
})