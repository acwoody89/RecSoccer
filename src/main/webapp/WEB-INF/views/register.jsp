<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset =UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet">
<link href="js/script.css" rel="stylesheet">
</head>
<body>
	<h1>Register</h1>
	<br>

	<!--  make the fields required,  -->
	<form action="/registercomplete" method="post">
		<div id="box">
			First Name: <input type="text" name="memberName"> <br>
			Player Role: <input type="text" name="membersRole"> <br>
			
			<select name="teamselect">
				<c:forEach var="t" items="${teams}">
					<option value="${t}">${t}</option>
					<br>
				</c:forEach>
			</select>
		</div>
		<input type="submit" class="btn btn-dark btn-large" name="Submit"> <br>
	</form>


	<table border="1">
		<c:forEach var="m" items="${regist}">
			<tr>
				<!-- left out title on purpose -->
				<td>${m.id}</td>
				<td>${m.firstName}</td>
				<td>${m.lastName}</td>
				<td>${m.email}</td>
				<td>${m.phoneNum}</td>
				<td>${m.password}</td>
				<!-- this is url encoding and allows us to pass some data into the link for our controller method  -->
				<td><a class="btn btn-light bnt-small"
					href="/cust/${m.id}/update">Edit</a> <a
					class="btn btn-light bnt-small" href="/cust/${m.id}/delete">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
<a href="/cancel" class="btn btn-link">Cancel</a>

	<script src="js/script.js"></script>

</body>
</html>