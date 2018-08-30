<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Login Page</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Reference Bootstrap files -->

	 <%--new bootstrap local path --%>

	<link href="webjars/jquery/3.3.1/jquery.min.js">
    <link href="webjars/bootstrap/4.1.2/css/bootstrap.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="resources/css/style.css" rel="stylesheet">

</head>

<body>

<div class="container">

	<!-- Login Form -->
	<form  action="${pageContext.request.contextPath}/authenticateTheUser"
		   method="post" class="form-signin">
		<h2 class="form-signin-heading">Please sign in</h2>

		<div>

			<!-- Check for login error -->

			<c:if test="${param.error != null}">

				<div class="alert alert-danger col-xs-offset-1 col-xs-10">
					Invalid username and password.
				</div>

			</c:if>

			<!-- Check for logout -->

			<c:if test="${param.logout != null}">

				<div class="alert alert-success col-xs-offset-1 col-xs-10">
					You have been logged out.
				</div>

			</c:if>

		</div>

		<%--username--%>
		<label for="inputEmail" class="sr-only">Email address</label>
		<input type="email" name="username" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
		<label for="inputPassword" class="sr-only">Password</label>
		<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
		<div class="checkbox">
			<label>
				<input type="checkbox" value="remember-me"> Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

		<input type="hidden"
		        name="${_csrf.parameterName}"
				value="${_csrf.token}">
		<div class="nav-link">
			<a href="${pageContext.request.contextPath}/employee/registerEmployee">Register New User</a>
		</div>

	</form>
</div> <!-- /container -->


<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.2/js/bootstrap.min.js"></script>
</body>
</html>