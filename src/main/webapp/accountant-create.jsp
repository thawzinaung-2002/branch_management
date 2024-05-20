<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accountant Creation</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" />
</head>
<body>

	<header class="text-center m-2 text-info">
        <h3>Payment Billing System</h3>
    </header>

	<div class="container">
		<c:if test="${ msg != null}">
		<div class="text-center text-danger">
			<c:out value="${msg }" />
		</div>
	</c:if>
	<h3 class="text-center m-3">Accountant Creation</h3>
	<form action="accountant" method="post" class="col-5 m-auto border p-3">
		<div class="container">
			<div class="m-1">
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
			<div class="mb-1">
				<label for="username" class="form-label">Username</label>
				<input type="text" id="username" name="username" class="form-control" />
			</div>
			<div class="mb-1">
				<label for="password" class="form-label">Password</label>
				<input type="password" id="password" name="password" class="form-control" />
			</div>
			<div class="mb-1">
				<label for="dob" class="form-label">Date of Birth</label>
				<input type="text" id="dob" name="dob" class="form-control" />
			</div>
			<div class="mb-1">
				<label for="joindate" class="form-label">Date of Joining</label>
				<input type="text" id="joindate" name="joindate" class="form-control" />
			</div>
			<div class="mb-1">
				<label for="salary" class="form-label">Salary</label>
				<input type="text" id="salary" name="salary" class="form-control" />
			</div>
			<div class="m-3">
				<input type="submit" value="Create"  class="btn btn-success"/>
				<a href="accountant-list.jsp" class="btn btn-link ml-3">Home</a>
			</div>
		</div>
	</form>		
	</div>


</body>
</html>