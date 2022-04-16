<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
		<div class="row">
			
			<div class="col-6">
				<h2>New Ninja</h2>
				<form:form method="post" action="/ninja/create" modelAttribute="ninja">
					
					<div class="form-group">
						<form:label path="dojo">Dojo:</form:label>
						<form:select path="dojo" class="form-control">
							<c:forEach var="dojo" items="${dojos}">
								<form:option value="${dojo}">${dojo.getName()}</form:option>
							</c:forEach>
							
						</form:select>
						
						<form:errors path="dojo" class="text-danger"/>
					</div>
					
					<div class="form-group">
						<form:label path="first_name">First_name:</form:label>
						<form:input path="first_name" class="form-control"/>
						<form:errors path="first_name" class="text-danger"/>
					</div>
					
					<div class="form-group">
						<form:label path="last_name">Last_name:</form:label>
						<form:input path="last_name" class="form-control"/>
						<form:errors path="last_name" class="text-danger"/>
					</div>
					
					<div class="form-group">
						<form:label path="age">Age:</form:label>
						<form:input path="age" class="form-control"/>
						<form:errors path="age" class="text-danger"/>
					</div>
					<input type="submit" value="Create" class="btn btn-primary">
				</form:form>
			</div>
		</div>
	</div>
	
</body>
</html>