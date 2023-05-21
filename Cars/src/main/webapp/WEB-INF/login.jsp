<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register | Log In</title>
</head>
<body>
	<h1>Car Dealership</h1>
	<form:form action="/register" method="post" modelAttribute="newUser" >
		<div>
			<form:label path="name" >User Name:</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</div>
		<div>
			<form:label path="email" >Email:</form:label>
			<form:errors path="email"/>
			<form:input path="email"/>
		</div>
		<div>
			<form:label path="password" >Password:</form:label>
			<form:errors path="password"/>
			<form:input type="password" path="password"/>
		</div>
		<div>
			<form:label path="confirmPassword" >Confirm Password:</form:label>
			<form:errors path="confirmPassword"/>
			<form:input type="password" path="confirmPassword"/>
		</div>
		<input type="submit" value="Register" />
	</form:form>
	<h1>Log In</h1>
	<form:form action="/login" method="post" modelAttribute="oldUser" >
		<div>
			<form:label path="email" >Email:</form:label>
			<form:errors path="email"/>
			<form:input path="email"/>
		</div>
		<div>
			<form:label path="password" >Password:</form:label>
			<form:errors path="password"/>
			<form:input type="password" path="password"/>
		</div>
		<input type="submit" value="Log In"/>
	</form:form>
</body>
</html>