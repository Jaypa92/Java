<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
</head>
<body>
	<h1>Expense Details</h1>
	<a href="/" >Go Back</a>
	<h2>Expense: <c:out value="${expense.expenseName}"/></h2>
	<h2>Expense Description: <c:out value="${expense.description}"/></h2>
	<h2>Vendor: <c:out value="${expense.vendor}"/></h2>
	<h2>Amount: $<c:out value="${expense.amount}"/></h2>
</body>
</html>