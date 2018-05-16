<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Admin Dashboard</title>
	</head>
	<body>
		<form action="/users/logout" method="get">
 			<p>
 				<input type="submit" value="logout" />
 			</p>
 		</form>
 		<h2>Dashboard</h2>
 		<hr>
 		
 		<c:forEach items="${users}" var="user">
 			<p>${ user.id }</p>
 			<p>${ user.firstname }</p>
 			<p>${ user.lastname }</p>
 			<p>${ user.email }</p>
 			<p>${ user.password }</p>
 		</c:forEach>
		
	</body>
</html>