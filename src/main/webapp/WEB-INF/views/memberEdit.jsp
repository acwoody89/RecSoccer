<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/spacelab/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<h1>$Edit Member</h1>
		
		<!-- A form without an action submits back to the same URL, which is what we want here. -->
		<form method="post">
			<div class="form-group">
			    <label for="name">Member's Name</label>
			    <!-- pre-populate the input value from the existing food (if any) -->
			     <input class="form-control" id="name" name="memberName" value="${m.memberName}" required minLength="2" autocomplete="off">
			     
			</div>
			<div class="form-group">
			    <label for="type">Member's Role</label>
			     <input class="form-control" id="type" name="membersRole" value="${m.membersRole}" required minLength="2" autocomplete="off">
			</div>
			<div class="form-group">
			    <label for="type">Member's Team ID</label>
			     <input class="form-control" id="teamid" name="teamId" value="${m.team.teamId}" required minLength="1" autocomplete="off">
			</div>
			
			
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="/cancel" class="btn btn-link">Cancel</a>
		</form>
	</div>
</body>
</html>