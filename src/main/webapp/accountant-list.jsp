<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>

	<form >
		<div class="container">
			<div class="m-3">
				<label for="branch" class="form-label">Branch</label>
				<select id="branch" name="branch" class="form-control">
					<option>Select a Branch</option>
					<c:forEach items="${initParam['branch'] }" delims=";" var="branch">
						<option value="${branch }">
							<c:out value="${branch } " />
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</form>
	<table class="mt-4">
		<tr>
			<th>Branch</th>
			<th>Username</th>
			<th>Password</th>
			<th>Date of Joining</th>
			<th>Date of Birth</th>
			<th>Salary</th>
		</tr>
	</table>
	<a href="accountant-create.jsp">Create Accountant</a>
</body>
</html>