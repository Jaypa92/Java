<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In | Register</title>
 <link rel="stylesheet" href="/style.css"> 
</head>
<body class="index" >
	<h1 class="index-head" >WELCOME TO THE BOOK CLUB!</h1>
	<h1>Register</h1>
	<form:form action="/process/new" method="post" modelAttribute="newUser" >
		<div class="red" >
			<form:label path = "name" >Name:</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</div>
		<div class="red" >
			<form:label path="email" >Email:</form:label>
			<form:errors path="email"/>
			<form:input path="email"/>
		</div>
		<div class="red" >
			<form:label path="password" >Password:</form:label>
			<form:errors path="password" />
			<form:input type="password" path="password"/>
		</div>
		<div class="red" >
			<form:label path="confirmPassword" >Confirm Password:</form:label>
			<form:errors path="confirmPassword"/>
			<form:input type="password" path="confirmPassword"/>
		</div>
		<input type="submit" value="Submit"/>
	</form:form>
	<h1>Log In</h1>
	<form:form action="/process/user" method="post" modelAttribute="prevUser">
		<div class="red" >	
			<form:label path="email" >Email:</form:label>
			<form:errors path="email"/>
			<form:input path="email"/>
		</div>
		<div class="red" >
			<form:label path="password" >Password:</form:label>
			<form:errors path="password"/>
			<form:input type="password" path="password"/>
		</div>
		<input type="submit" value="Submit" />		
	</form:form>	
</body>
</html>