<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>home page</title>

<link type="text/css" rel="stylesheet"
	href="resources/css/students-list.css" />

</head>
<body>

	<div class="container">

		<table>
			<tr>
				<th>number</th>
				<th>First_Name</th>
				<th>Last_Name</th>
				<th>Class</th>
				<th>Age</th>
				<th>Action</th>
				<th>Details</th>
				<th>Average Insert</th>
			</tr>
			<c:forEach items="${students}" var="tempstudent">
				<c:url value="/studentaverage" var="detail">
					<c:param name="studentid" value="${tempstudent.id}" />
				</c:url>

				<c:url value="/deletestudent" var="delete">
					<c:param name="studentid" value="${tempstudent.id}" />
				</c:url>

				<c:url value="/updatestudent" var="update">
					<c:param name="studentid" value="${tempstudent.id}" />
				</c:url>

				<c:url value="/NewAverage" var="Average">
					<c:param name="studentid" value="${tempstudent.id}" />
				</c:url>
				<tr>
					<td>${tempstudent.id}</td>
					<td>${tempstudent.first_name}</td>
					<td>${tempstudent.last_name}</td>
					<td>${tempstudent.classes}</td>
					<td>${tempstudent.age}</td>
					<td><a href="${delete}"
						onclick="return confirm('Are you sure you want to delete this Student?');">Delete</a>|<a
						href="${update}">Update</a></td>
					<td><a href="${detail}">Student_average</a></td>
					<td><a href="${Average}">Add</a></td>

				</tr>



			</c:forEach>



		</table>

		<div>
			<form:form action="newstudent">

				<input type="submit" value="Add New Student" class="add-button" />

			</form:form>


		</div>

	</div>


</body>

</html>