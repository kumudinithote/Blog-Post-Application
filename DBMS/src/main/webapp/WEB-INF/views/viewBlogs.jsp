<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/css/style.css">
<title>Binghamton Blog's</title>
</head>
<body>
  <h1>Binghamton Blog's</h1>
  <hr>
	<form action="home" method="post">
	          <input type="submit" value="Home">
	</form>
	<br>
	
    <table width="100%">
	<tr>
		<th>BlogTitle</th>
		<th>Email</th>
		<th>Genre</th>
		<th>Published On</th>
	</tr>
	<c:forEach items="${ListBlogs}" var="Story" varStatus="status">
		<tr>
			<td>${Story.blogTitle}</td>
			<td>${Story.email}</td>
			<td>${Story.genre}</td>
			<td>${Story.publishedOn}</td>
			<td><a href='/showStory?id=${Story.id}'>Show story</a></td>
			<td><a href='/editStory?id=${Story.id}'>Edit</a></td>
			<td><a href='/deleteBlog?id=${Story.id}'>Delete</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>