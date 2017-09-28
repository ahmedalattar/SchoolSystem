<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>home page</title>
<link type="text/css" rel="stylesheet"
	href="resources/css/home-page.css">
</head>
<body>

	<div class="form">
		<h1 class="sign">Login</h1>


		<form:form modelAttribute="admin" action="accesspage">

			<div class="error">

				<form:errors path="username" cssClass="errorusername" />
				<form:errors path="password" cssClass="errorpassword" />


			</div>
			<table>

				<tr>

					<td><form:input path="username" class="email"
							placeholder="AdminName" /></td>

				</tr>

				<tr>

					<td><form:password  path="password" class="Password"
							placeholder="Password" /></td>

				</tr>



			</table>

			<input type="submit" value="Submit" class="submit">




		</form:form>



	</div>


</body>

</html>