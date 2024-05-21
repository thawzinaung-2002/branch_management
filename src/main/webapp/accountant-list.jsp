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

	<c:if test="${ applicationScope.username == null }">
		<c:redirect url="index.jsp" />
	</c:if>

	<c:if test="${accountants.size() > 0 }" >
		<div class="container col-10 m-auto">
		<h3 class="text-center m-3">Accountant List</h3>
		<a href="logout" class="btn btn-danger">Log out</a>
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
						<a href="accountantEdit?id=${acc.id }">Edit</a> |
						<a href="accountantDelete?id=${acc.id }">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</c:if>
	<div class="col-10 m-auto">
		<a href="accountant-create.jsp" >Create Accountant</a>
	</div>
	
</body>
</html>