<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/spacelab/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Member List</title>
</head>
<body>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Type</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${members}">
					<tr>
						<td>${m.memberId}</td>
						<td>${m.memberName}</td>
						<td>${m.membersRole}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-dark btn-largee" href="items/add">Add</a>
		<a href="/cancel" class="btn btn-link">Cancel</a>
	</div>
</body>
</html>