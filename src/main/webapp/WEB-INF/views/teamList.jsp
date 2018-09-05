<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/spacelab/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form method="post">
			<table class="table">
				<thead>
					<tr>
						<th>${h1}</th>
						<th>${h2}</th>
						<th>${h3}</th>
						<th>${h4}</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="team" items="${teamlist}">
						<tr>
							<td>${team.teamName}</td>
							<td><a class="btn btn-light bnt-small"
								href="/memberList/${team.teamId}">View</a></td>
							<td><a class="btn btn-light bnt-small"
								href="/teamEdit/${team.teamId}">Edit</a></td>
							<td><a class="btn btn-light bnt-small" href="/delete/${team.teamId}">Delete</a></td>
						</tr>
					</c:forEach>
					<c:forEach var="m" items="${memberlist}">
						<tr>
							<td>${m.memberName}</td>
							<td>${m.memberId}</td>
							<td>${m.membersRole}</td>
							<td>${m.team.teamName}</td>
							<td><a class="btn btn-light bnt-small"
								href="/memberEdit/${m.memberId}/${m.team.teamId}">Edit</a></td>
							<td><a class="btn btn-light bnt-small" href="/delete/${team.teamId}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/cancel" class="btn btn-link">Cancel</a>
		</form>
	</div>
</body>
</html>