<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${applicationScope.accountant == null }">
		<c:redirect url="index.jsp" />
	</c:if>

	<table class="border table-bordered table table-striped">
		<tr>
			<th>Name</th>
			<th>Course</th>
			<th>Mobile</th>
			<th>Father</th>
			<th>Mother</th>
			<th>Qualification</th>
			<th>Date of Birth</th>
			<th>Status</th>
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
					<a href="edit?type=student&id=${student.id }">Edit</a> |
					<a href="delete?type=student&id=${student.id }">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>