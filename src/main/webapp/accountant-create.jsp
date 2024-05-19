<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accountant Creation</title>
</head>
<body>

	<c:if test="${ msg != null}">
		<div class="text-center text-danger">
			<c:out value="${msg }" />
		</div>
	</c:if>

	<form action="accountant" method="post">
		<div class="container">
			<div class="mt-4 mb-3">
				<label for="branch" class="form-label">Branch</label>
	            <select id="branch" name="branch" class="form-control">
	                <option>Select a Branch</option>
	                <c:forTokens var="tempItem" items="${initParam['branch'] }" delims=";">
	                	<option value="${tempItem }">
	                		<c:out value="${tempItem }" />
	                	</option>
	                </c:forTokens>
	            </select>
			</div>
			<div class="mb-3">
				<label for="username" class="form-label">Username</label>
				<input type="text" id="username" name="username" class="form-control" />
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label>
				<input type="password" id="password" name="password" class="form-control" />
			</div>
			<div class="mb-3">
				<label for="dob" class="form-label">Date of Birth</label>
				<input type="text" id="dob" name="dob" class="form-control" />
			</div>
			<div class="mb-3">
				<label for="joindate" class="form-label">Date of Joining</label>
				<input type="text" id="joindate" name="joindate" class="form-control" />
			</div>
			<div class="mb-3">
				<label for="salary" class="form-label">Salary</label>
				<input type="text" id="salary" name="salary" class="form-control" />
			</div>
		</div>
	</form>

</body>
</html>