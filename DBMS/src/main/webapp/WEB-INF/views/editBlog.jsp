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
  	<form action="updateBlog" method="post">
  <input id="id" name="id" value="${Story.id}" readonly/><br>
  Title of story:<br>
  <textarea rows="1" cols="50" id="title" name="title">${Story.blogTitle}</textarea>
  <br>
  Story:<br>
  <textarea rows="20" cols="100" id="story" name="story">${Story.story}</textarea>
  <br>
  Genre:<br>
  <select id = "genre" name = "genre" >
	  <option value="Entertainment" ${Story.genre == "Entertainment" ? 'selected="selected"' : ''} >Entertainment</option>
	  <option value="Sports" ${Story.genre == "Sports" ? 'selected="selected"' : ''}>Sports</option>
	  <option value="Education" ${Story.genre == "Education" ? 'selected="selected"' : ''}>Education</option>
	  <option value="Politics" ${Story.genre == "Politics" ? 'selected="selected"' : ''}>Politics</option>
	  <option value="Economy" ${Story.genre == "Economy" ? 'selected="selected"' : ''}>Economy</option>
	  <option selected  value="Other" ${Story.genre == "Other" ? 'selected="selected"' : ''}>other</option>
  </select> 
  <br><br>
  <input type="submit" value="Update your story">
</form> 
</body>
</html>