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
		<a href="logout" class="btn btn-danger my-3">Log out</a>
		<h3 class="my-3">Accountant List</h3>
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
						<a href="edit?type=accountant&id=${acc.id }">Edit</a> |
						<a href="delete?type=accountant&id=${acc.id }">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</c:if>
	<div class="col-10 m-auto my-3">
		<a href="accountant-create.jsp" >Create Accountant</a>
	</div>
	
	<c:if test="${students.size() > 0 }">
		<div class="col-10 m-auto">
		<h2 class="my-3">Student List</h2>
		<table class="border table-bordered table table-striped">
		<tr>
			<th>Name</th>
			<th>Course</th>
			<th>Mobile</th>
			<th>Father</th>
			<th>Mother</th>
			<th>Qualification</th>
			<th>Date of Birth</th>
			<th>Branch</th>
		</tr>
		<c:forEach items="${students }" var="student">
			<tr>
				<td>
					<c:out value="${student.name }" />
				</td>
				<td>
					<c:out value="${student.course }" />
				</td>
				<td>
					<c:out value="${student.mobile }" />
				</td>
				<td>
					<c:out value="${student.father }" />
				</td>
				<td>
					<c:out value="${student.mother }" />
				</td>
				<td>
					<c:out value="${student.qualification }" />
				</td>
				<td>
					<c:out value="${student.dob }" />
				</td>
				<td>
					<c:out value="${student.branch }" />
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</c:if>
	
</body>
</html>