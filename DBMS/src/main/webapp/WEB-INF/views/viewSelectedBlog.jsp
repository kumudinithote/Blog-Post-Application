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
  <input id="id" name="id" value="${Story.id}" readonly/><br>
  Title of story:<br>
  <textarea rows="1" cols="50" id="title" name="title" readonly>${Story.blogTitle}</textarea>
  <br>
  Story:<br>
  <textarea rows="20" cols="100" id="story" name="story" readonly>${Story.story}</textarea>
  <br>
  Genre:<br>
  <textarea rows="1" cols="50" id="genre" name="genre" readonly>${Story.genre}</textarea>
  <br>
  <a href='/upvoteStory?id=${Story.id}'>Upvotes </a>:${Story.upvotes.size()}
  <br><br>
</body>
</html>