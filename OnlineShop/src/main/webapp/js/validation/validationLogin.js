jQuery(document).ready(function(){

   var name_pattern = new RegExp("^([A-Za-z0-9]{4,20})$");
   var password_pattern = new RegExp("^[A-z0-9]{4,20}$");
   
  $('#login').focusout(
    function () {
      var login = $('#login').val()
      if (!name_pattern.test(login)) {
        $('#error_login').text('Login is not correct');
      } else {
        $('#error_login').text('');
      }
    })

      $('#password').focusout(
        function () {
          var password = $('#password').val()
          if (!password_pattern.test(password)) {
            $('#error_password').text('Password is not correct');
          } else {
            $('#error_password').text('');
          }
        })
       
  $('#submitLog').on('click', function(event) {
    
    var login = $('#login').val()
    var password = $('#password').val()

     if (!name_pattern.test(login)) {
        $('#error_login').text('Login is not correct');
        event.preventDefault();
      } else if (!password_pattern.test(password)) {
        $('#error_login').text('');
        $('#error_password').text('Password is not correct');
        event.preventDefault();
      }
      });
    });