<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Binghamton Blog's</title>
</head>
<body>
  <h1>Binghamton Blog's</h1>
  <hr>
  <form action="home" method="post">
	          <input type="submit" value="Home">
	</form>
	<br>
  	<form action="publishBlog" method="post">
  Title of story:<br>
  <textarea rows="1" cols="50" id="title" name="title"></textarea>
  <br>
  Story:<br>
  <textarea rows="20" cols="100" id="story" name="story"></textarea>
  <br>
  Genre:<br>
  <select id = "genre" name = "genre" >
	  <option value="Entertainment">Entertainment</option>
	  <option value="Sports">Sports</option>
	  <option value="Education">Education</option>
	  <option value="Politics">Politics</option>
	  <option value="Economy">Economy</option>
	  <option selected  value="Other">other</option>
  </select> 
  <br><br>
  <input type="submit" value="Publish your story">
</form> 
</body>
</html>