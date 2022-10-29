<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Expenses</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-5 mb-5">
<h1>Save Travels</h1>
<table class="table table-striped">
	<thead>
		<th>Expense</th>
		<th>Vendor</th>
		<th>Amount</th>
		<th>Actions</th>
	</thead>
	<tbody>
	<c:forEach var="exp" items="${allExpenses}">
		<tr>
			<td><c:out value="${exp.name}"/></td>
			<td><c:out value="${exp.vendor}"/></td>
			<td><c:out value="${exp.amount}"/></td>
			<td><a href="/expense/${exp.id}/edit" class="btn btn-warning">Edit</a> <a href="expense/${exp.id}/delete" class="btn btn-danger">Delete</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
<div class="container col-4">
	<h2>Edit Expense</h2>
	<form:form class="form" action="expense/{id}/edit" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
		<div class="form-group mb-3">
			<form:label path="name">Expense Name:</form:label>
			<form:input path="name" class="form-control"/>
			<form:errors path="name" class="text-danger"/>
		</div>
		<div class="form-group mb-3">
			<form:label path="vendor">Vender:</form:label>
			<form:input path="vendor" class="form-control"/>
			<form:errors path="vendor" class="text-danger"/>
		</div>
		<div class="form-group mb-3">
			<form:label path="amount">Amount:</form:label>
			<form:input path="amount" class="form-control"/>
			<form:errors path="amount" class="text-danger"/>
		</div>
		<div class="form-group mb-3">
			<form:label path="description">Description:</form:label>
			<form:input path="description" class="form-control"/>
			<form:errors path="description" class="text-danger"/>
		</div>
		<button class="btn btn-primary">Submit</button>
	</form:form>

</div>
   
</body>
</html>