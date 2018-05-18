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
	<title>${task.taskName} Tasks</title>
	</head>
	<body>
		<h3>${task.taskName}</h3>
		Add items to your list: 
		
		<form:errors path="item.errors.*"></form:errors>
		<form:form method="POST" action="/tasks/${id}/item" modelAttribute="item">
		
			<form:label path="description">Description
				<form:input path="description"></form:input>
			</form:label>
				
			<input type="submit" value="Create Tasks!"/>
		</form:form>
		
		<c:forEach items="${task.getItems()}" var="item">
 			<p>Description: ${item.description}</p>
 		</c:forEach>
		
		
		
		
	</body>
</html>