<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
  session.invalidate(); // destroy the user's session
  response.sendRedirect("userLogin.jsp"); // redirect to the login page
%>

<html>

<head>

	<meta charset="UTF-8">
	<title>Logout</title>

</head>

<body>

	<h1>You have been logged out!!</h1>

</body>

</html>