<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" />
</head>
<body>

	<div class="container col-10 m-auto">
	<h3 class="text-center m-3">Accountant List</h3>
	<table class="mt-4 table table-striped">
		<tr>
			<th>Branch</th>
			<th>Username</th>
			<th>Password</th>
			<th>Date of Joining</th>
			<th>Date of Birth</th>
			<th>Salary</th>
			<th>Edit</th>
		</tr>
		<c:forEach items="${accountants }" var="acc">
			<tr>
				<td>
					<c:out value="${acc.branch }" />
				</td>
				<td>
					<c:out value="${acc.username }" />
				</td>
				<td>
					<c:out value="${acc.password }" />
				</td>
				<td>
					<c:out value="${acc.join_date }" />
				</td>
				<td>
					<c:out value="${acc.dob }" />
				</td>
				<td>
					<c:out value="${acc.salary }" />
				</td>
				<td>
					<a href="">Edit</a> |
					<a href="">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="accountant-create.jsp">Create Accountant</a>
	</div>
	
</body>
</html>