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
  <h2>${Message}</h2>
  <hr>
  <div class="form">
    <form action="login" method="post" onsubmit="return validate()">
      <table>
        <tr>
          <td>Enter Your email</td>
          <td><input id="email" name="email"></td>
        </tr>
       <tr>
          <td>Enter Your password</td>
          <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
          <td><input type="submit" value="Log In"></td>
        </tr>
      </table>
    </form>
    <form action="registration" method="post">
        <input type="submit" value="Sign Up">
    </form>
  </div>

</body>
</html>