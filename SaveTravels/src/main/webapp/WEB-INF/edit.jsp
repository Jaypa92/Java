<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
</head>
<body>
	<h1>Edit Expense</h1>
	<a href="/" >Go Back</a>
	<form:form action="/edit/${newExpense.id}" method="post" modelAttribute="newExpense" >
		<input type="hidden" name="_method" value="put" />
		<div>
			<form:label path="expenseName" >Expense Name:</form:label>
			<form:errors path="expenseName"/>
			<form:input path="expenseName" />
		</div>
		<div>
			<form:label path="vendor" >Vendor:</form:label>
			<form:errors path="vendor" />
			<form:input path="vendor"/>
		</div>
		<div>
			<form:label path="amount" >Amount</form:label>
			<form:errors path="amount" />
			<form:input type="number" path="amount"/>
		</div>
		<div>
			<form:label path="description" >Description:</form:label>
			<form:errors path="description" />
			<form:textarea path="description" rows="4" />
		</div>
		<div>
			<input type="submit" value="Submit" />
		</div>
	</form:form>
</body>
</html>