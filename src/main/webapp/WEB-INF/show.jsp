<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${dojo.getName()}"/></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Dojo : <c:out value="${dojo.getName()}"/></h1>
		<table class="table ">
			<thead>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninja" items="${ninjas}">
					<tr>
						<td>
						<c:out value="${ninja.getFirst_name()}"/>
						</td>
						<td>
						<c:out value="${ninja.getLast_name()}"/>
						</td>
						<td>
						<c:out value="${ninja.getAge()}"/>
						</td>
					</tr>
				</c:forEach>			
			
			</tbody>
			
		</table>
	</div>
	
</body>
</html>