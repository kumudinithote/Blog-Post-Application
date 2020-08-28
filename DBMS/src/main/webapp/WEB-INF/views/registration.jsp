<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Spring Boot</title>
</head>
<body>
  <h1>Binghamton Blog's</h1>
  <hr>

  <div class="form">
    <form action="registerUser" method="post" onsubmit="return validateRegistration()">
      <table>
      	<tr>
          <td>First Name</td>
          <td><input id="firstName" name="firstName"></td>
        </tr>
        <tr>
          <td>Last Name</td>
          <td><input id="lastName" name="lastName"></td>
        </tr>
        <tr>
          <td>Email</td>
          <td><input id="email" name="email"></td>
        </tr>
       <tr>
          <td>Password</td>
          <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
          <td><input type="submit" value="Register"></td>
        </tr>
      </table>
    </form>
  </div>

</body>
</html>