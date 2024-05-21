<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" />
</head>
<body>
	<c:if test="${applicationScope.username == null }">
		<c:redirect url="index.jsp" />
	</c:if>
	
	<c:if test="${students.size() > 0}">
		<h3 class="text-center">Student List</h3>
		<div class="col-10 m-auto">
			<jsp:include page="student-list.jsp"/>
		</div>
	</c:if>
	
	<div class="col-8 m-auto">
		<a href="create-student.jsp">Create Student</a>
	</div>
	
	
</body>
</html>