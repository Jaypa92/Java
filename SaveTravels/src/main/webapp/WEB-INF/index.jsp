<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Save Travels</h1>
		<table>
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
				<c:forEach var="expense" items="${newExpenses}" >			
					<tr>
						<td><a href="/expenses/${expense.id}"><c:out value="${expense.expenseName}" /></a></td>
						<td><c:out value="${expense.vendor}" /></td>
						<td>$<c:out value="${expense.amount}" /></td>
						<td><a href="/${expense.id}">Edit</a>
							<form action="/expenses/delete/${expense.id}" method="post">
								<input type="hidden" name="_method" value="delete"> 
								<input type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>
		</table>
		<h1>Add An Expense</h1>
		<form:form action="/addExpense" method="post" modelAttribute="newExpense">
			<div>
				<form:label path="expenseName">Expense Name:</form:label>
				<form:errors path="expenseName" />
				<form:input path="expenseName" />
			</div>
			<div>
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor" />
				<form:input path="vendor" />
			</div>
			<div>
				<form:label path="amount">Amount:</form:label>
				<form:errors path="amount" />
				<form:input type="number" path="amount" />
			</div>
			<div>
				<form:label path="description">Description:</form:label>
				<form:errors path="description" />
				<form:textarea path="description" rows="4" />
			</div>
			<div>
				<input type="submit" value="Submit" />
			</div>
		</form:form>
	</div>
</body>
</html>