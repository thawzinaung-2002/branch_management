<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Creation</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" />
</head>
<body>

	<div class="container">
		<h3 class="text-center">Student Registration</h3>
			<c:if test="${msg != null }">
				<div class="text-center text-danger">
					<c:out value="${msg }" />
				</div>		
			</c:if>
		<form action="student" class="col-8 m-auto" method="post">
			<div class="mt-3">
				<label for="name" class="form-label">Name</label>
				<input type="text" id="name" name="username" class="form-control"/>
			</div>
			<div>
				<label for="course" class="form-label">Course</label>
				<input type="text" id="course" name="course" class="form-control"/>
			</div>
			<div>
				<label for="mobile" class="form-label">Mobile</label>
				<input type="tel" id="mobile" name="mobile" class="form-control"/>
			</div>
			<div>
				<label for="father" class="form-label">Father's Name</label>
				<input type="text" id="father" name="father" class="form-control"/>
			</div>
			<div>
				<label for="mother" class="form-label">Mother's Name</label>
				<input type="text" id="mother" name="mother" class="form-control"/>
			</div>
			<div>
				<label for="qf" class="form-label">Qualification</label>
				<input type="text" id="qf" name="qualification" class="form-control"/>
			</div>
			<div>
				<label for="dob" class="form-label">Date of Birthday</label>
				<input type="text" id="dob" name="dob" class="form-control"/>
			</div>
			<div class="my-3">
				<input type="submit" value="Create" class="btn btn-success">
				<a href="accountant-home.jsp" class="btn btn-link mx-3">Cancel</a>
			</div>
		</form>
	</div>

</body>
</html>