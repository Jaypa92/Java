<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Your Car!</h1>
	<a href="/display" >DashBoard</a>
	<form:form action="/edit/car/${edittedCar.id}" method="post" modelAttribute="edittedCar" >
	<input type="hidden" name="_method" value="put"/>
	<form:hidden path="user"/>
		<div>
			<form:label path="year" >Car Year:</form:label>
			<form:errors path="year"/>
			<form:input type="number" path="year" />
		</div>
		<div>
			<form:label path="maker" >Maker:</form:label>
			<form:errors path="maker"/>
			<form:input path="maker"/>
		</div>
		<div>
			<form:label path="model" >Model:</form:label>
			<form:errors path="model"/>
			<form:input path="model"/>
		</div>
		<div>
			<form:label path="price" >Price:</form:label>
			<form:errors path="price"/>
			<form:input type="number" step="any" path="price"/>
		</div>
		<div>
			<form:label path="description" >Description:</form:label>
			<form:errors path="description"/>
			<form:textarea path="description" rows="6" />
		</div>
		<input type="submit" value="Edit"/>
	</form:form>
</body>
</html>