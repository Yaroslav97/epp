jQuery(document).ready(function(){
  var name_pattern =  new RegExp("^([A-Z][a-z]+)$");
  var email_pattern = new RegExp("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
  var password_pattern = new RegExp("^[A-z0-9]{4,20}$");
  var login_pattern = new RegExp("^([A-z0-9]{4,20})$");

    $('#firstname').focusout(
      function () {
        var firstname = $('#firstname').val()
        if (!name_pattern.test(firstname)) {
          $('#error_first_name').text('First name is not correct');
        } else {
          $('#error_first_name').text('');
        }
      })

      $('#lastname').focusout(
        function () {
          var last_name = $('#lastname').val()
          if (!name_pattern.test(last_name)) {
            $('#error_last_name').text('Last name is not correct');
          } else {
            $('#error_last_name').text('');
          }
        })

		$('#login').focusout(
    function () {
      var login = $('#login').val()
      if (!login_pattern.test(login)) {
        $('#error_reg_login').text('Login is not correct');
      } else {
        $('#error_reg_login').text('');
      }
    })

        $('#email').focusout(
      function () {
        var email = $('#email').val()
        if (!email_pattern.test(email)) {
          $('#error_email').text('Email is not correct');
        }
        else {
          $('#error_email').text('');
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
        $('#password_conf').focusout(
               function () {
                   var password = $('#password').val()
                   var password_conf = $('#password_conf').val()
                   if (password != password_conf) {
                       $('#error_password_conf').text('Password is not equals');
                   } else {
                       $('#error_password_conf').text('');
                   }

               })

  $('#submit1').on('click', function(event) {
    
    var firstname = $('#firstname').val()
    var last_name = $('#lastname').val()
    var email = $('#email').val()
    var password = $('#password').val()
    var password_conf = $('#password_conf').val()

     if (!name_pattern.test(firstname)) {
        $('#error_login').text('');
        $('#error_first_name').text('First name is not correct');
        event.preventDefault();
      } else if (!name_pattern.test(last_name)) {
        $('#error_first_name').text('');
        $('#error_last_name').text('Last name is not correct');
        event.preventDefault();
      }else if (!email_pattern.test(email)) {
        $('#error_email').text('Email is not correct');
        event.preventDefault();
      } else if (!password_pattern.test(password)) {
        $('#error_email').text('');
        $('#error_password').text('Password is not correct');
        event.preventDefault();
      }else if (password != password_conf) {
        $('#error_password').text('');
        $('#error_password_conf').text('Passwords are not equals');
        event.preventDefault();}
      });
    });