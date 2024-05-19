<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<body>

    <header>
        <h3>Payment Billing System</h3>
    </header>

    <main>
        <form>
            <label for="branch" class="form-label">Branch</label>
            ${application.getInitParameter('branch')}
            <c:out value="${application.getInitParameter('branch') }"/>
            <select id="branch" name="branch">
                <option value="">Select a Branch</option>
                <c:forTokens var="tempItem" items="${application.getInitParameter('branch') }" delims=";">
                	<option value="${tempItem }">
                		<c:out value="${tempItem }" />
                	</option>
                </c:forTokens>
            </select>
        </form>
    </main>

</body>
</html>