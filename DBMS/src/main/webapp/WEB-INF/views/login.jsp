<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Binghamton Blog's</title>
</head>
<body>
  <h1>Binghamton Blog's</h1>
  <hr>
  <h3>Welcome ${firstName}</h3>
  <h4>${Message}</h4>
  <a href='/t	rending'>Top 10 trending stories</a>
	<div class="form">
	    <form action="postBlog" method="post">
	        <tr>
	          <td><input type="submit" value="What's your story?"></td>
	        </tr>
	    </form>
  	</div>
  	<div class="form">
	    <form action="viewBlogs" method="post">
	        <tr>
	          <td><input type="submit" value="View my blogs"></td>
	        </tr>
	    </form>
  	</div>
  	<div class="form">
	    <form action="searchUserByEmail" method="post">
	        <tr>
	          <td><input id="email" name="email"></td>
	          <td><input type="submit" value="Search by email"></td>
	        </tr>
	    </form>
  	</div>
  	
  	
  	<div class="form">
	    <form action="searchUserByFirstName" method="post">
	        <tr>
	          <td><input id="firstName" name="firstName"></td>
	          <td><input type="submit" value="Search by firstName"></td>
	        </tr>
	    </form>
  	</div>
  	<div class="form">
	    <form action="findByGenre" method="post">
	        <tr>
	          <td><input id="genre" name="genre"></td>
	          <td><input type="submit" value="Search stories by genre"></td>
	        </tr>
	    </form>
  	</div>
  	
  	<div class="form">
	    <form action="findByTitle" method="post">
	        <tr>
	          <td><input id="blogTitle" name="blogTitle"></td>
	          <td><input type="submit" value="Search stories by Name"></td>
	        </tr>
	    </form>
  	</div>
  	
  	
  	<table width="100%">

	<c:forEach items="${Users}" var="Student" varStatus="status">
		<tr>
			<td>${Student.firstName}</td>
			<td>${Student.lastName}</td>
			<td>${Student.email}</td>
			<td><a href='/visitStudent?email=${Student.email}'>Visit ${Student.firstName}'s stories</a></td>	
		</tr>
	</c:forEach>
	</table>
	
	<table width="100%">
	<c:forEach items="${stories}" var="Story" varStatus="status">
		<tr>
			<td>${Story.blogTitle}</td>
			<td>${Story.email}</td>
			<td>${Story.genre}</td>
			<td>${Story.publishedOn}</td>
			<td><a href='/showStory?id=${Story.id}'>Show story</a></td>
		</tr>
		<br>
	</c:forEach>
	</table>
	<hr>
	Bloggers following you:
	<table width="100%">
	<c:forEach items="${followers}" var="email" varStatus="status">
		<tr>
			<td><a href='/visitStudent?email=${email}'>Visit ${email}'s stories</a></td>	
		</tr>
	</c:forEach>
	</table>
	<hr>
	Bloggers you are followers:
	<table width="100%">
	<c:forEach items="${followings}" var="email" varStatus="status">
		<tr>
			<td><a href='/visitStudent?email=${email}'>Visit ${email}'s stories</a></td>	
		</tr>
	</c:forEach>
	</table>
</body>
</html>