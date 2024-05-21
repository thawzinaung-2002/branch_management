<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" />
</head>
<body>
	
	<header class="text-center m-2">
        <h3>Payment Billing System</h3>
    </header>
	
	<h3 class="text-center m-3">Administrator</h3>	

	<c:if test="${ msg!=null }">
		<div class="text-center text-danger m-2">
			<c:out value="${msg }" />
		</div>
	</c:if>

	 <form action="adminLogin" class="container mt-5">
            <div class="col-6 m-auto">
	            <div class="mb-3">
		            <label for="username" class="form-label">User Name</label>
		            <input type="text" id="username" name="username" class="form-control"/>
	            </div>
	            <div class="mb-3">
		            <label for="password" class="form-label">Password</label>
		            <input type="password" id="password" name="password" class="form-control"/>
	            </div>
	            <div class="mb-3">
            		<input type="submit" value="Log in" class="btn btn-success"/>
	            </div>
	        </div>
        </form>
</body>
</html>