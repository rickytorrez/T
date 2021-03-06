<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	    <c:if test="${errors != null}">
	    		<c:forEach items="${errors}" var="err">
	    			<p>${err.defaultMessage}</p>
	    		</c:forEach>
	    </c:if>
 		
 		<form:form action="/users/newUser" method="post" modelAttribute="user">
 			<p>
 				<form:label path="firstName">First Name
 					<form:errors path="firstName"></form:errors>
 					<form:input type="text" path="firstName"></form:input>
 				</form:label>
 			</p>
 			<p>
 				<form:label path="lastName">Last Name
 					<form:errors path="lastName"></form:errors>
 					<form:input type="text" path="lastName"></form:input>
 				</form:label>
 			</p>
 			<p>
 				<form:label path="email">Email
 					<form:errors path="email"></form:errors>
 					<form:input type="text" path="email"></form:input>
 				</form:label>
 			</p>
 			<p>
 				<form:label path="password">Password
 					<form:errors path="password"></form:errors>
 					<form:input type="password" path="password"></form:input>
 				</form:label>
 			</p>
 			<input type="submit" value="Register"/>
 		</form:form>
 		
 		<c:if test="${error !=null}">
 				<p>${ error }</p>
 		</c:if>
 		
 		<form action="/users/loginUser" method="post">
 			<p>
 				<label>Email
 					<input type="text" name="email"/>
 				</label>		
 			</p>
 			<p>
 				<label>Password	
 					<input type="password" name="password"/>
 				</label>		
 			</p>
 			<input type="submit" value="Login"/>
 		</form>
	</body>
</html>