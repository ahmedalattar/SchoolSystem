<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>home page</title>

<link type="text/css" rel="stylesheet"
	href="resources/css/student-subject.css" />
</head>
<body>

	<div class="container">

		<table>
			<c:forEach var="tempsubject" items="${subject}">
				<tr>
					<th>Math</th>
					<th>Arabic</th>
					<th>Science</th>
				</tr>

				<tr>
					<td>${tempsubject.math }</td>
					<td>${tempsubject.arabic }</td>
					<td>${tempsubject.science }</td>
				</tr>
			</c:forEach>
		</table>


	</div>


</body>

</html>