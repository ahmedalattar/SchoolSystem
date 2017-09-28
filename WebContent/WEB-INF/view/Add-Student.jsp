<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>home page</title>

<link type="text/css" rel="stylesheet"
	href="resources/css/Add-Student.css" />
</head>
<body>

	<div class="form">
		<form:form action="savestudent" modelAttribute="student">
			<table>
				<form:hidden path="id" />
				<tr>

					<td><form:input path="first_name"
							placeholder="First Student Name" cssClass="firstname" /></td>


				</tr>

				<tr>

					<td><form:input path="last_name"
							placeholder="Last Student Name" cssClass="lastname" /></td>

				</tr>

				<tr>

					<td><form:input path="classes" placeholder="Student Class"
							cssClass="Studentclass" /></td>

				</tr>

				<tr>

					<td><form:input path="age" placeholder="Student Age"
							cssClass="age" /></td>

				</tr>

			</table>


			<input type="submit" value="Save The Student" class="add-button">
			<div class="error">
				<form:errors path="first_name" cssClass="error1" />
				<form:errors path="last_name" cssClass="error2" />
				<form:errors path="classes" cssClass="error3" />
				<form:errors path="age" cssClass="error4" />
			</div>
		</form:form>

	</div>


</body>

</html>