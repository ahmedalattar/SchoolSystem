<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>home page</title>

<link type="text/css" rel="stylesheet"
	href="resources/css/New-Average.css" />
</head>
<body>
	<div class="form">

		<c:url value="/saveaverage" var="idstudent">
			<c:param name="id" value="${id}" />
		</c:url>
		<form:form action="${idstudent}" modelAttribute="subject">
			<form:hidden path="id" />
			<table>
				<tr>

					<td><form:input path="math" placeholder="Math" cssClass="Math" /></td>

				</tr>

				<tr>

					<td><form:input path="arabic" placeholder="Arabic"
							cssClass="Arabic" /></td>

				</tr>

				<tr>

					<td><form:input path="science" placeholder="Science"
							cssClass="Science" /></td>

				</tr>

			</table>

			<input type="submit" value="Save The Average" class="add-button">
			<div class="error">
				<form:errors path="math" cssClass="error1" />
				<form:errors path="arabic" cssClass="error2" />
				<form:errors path="science" cssClass="error3" />
			</div>
		</form:form>

	</div>


</body>

</html>