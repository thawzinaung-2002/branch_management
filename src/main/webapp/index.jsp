<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" />
</head>
<body>

	<c:set var="username" scope="application" value="${username } " />
	<c:remove var="username" scope="application"/>

    <header class="text-center m-2">
        <h3>Payment Billing System</h3>
    </header>

    <main>
    	<div class="container">
        	<div class="col-6 m-auto">
            	<a href="admin-login-form.jsp">
            		<input type="submit" value="Log in as Admin" class="btn btn-link m-2"/>
            	</a>
        	</div>
       </div>
       <c:if test="${msg!= null }">
       	<div class="text-center text-danger">
       		<c:out value="${msg }" />
       	</div>
       </c:if>
        <form action="accLogin" class="container mt-5">
            <div class="col-6 m-auto">
            	<div class="mb-3">
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
    </main>

</body>
</html>