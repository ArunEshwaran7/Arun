<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Core Tag Example</title>
</head>
<body>
	<h4>View All Data</h4>
	<br />
	<table border="1px">
		<tr>
			<th>Id</th>
			<th>Username</th>
			<th>Password</th>
			
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${viewdata}" var="j">
			<tr>
				<td><c:out value="${j.id}" /></td>
				<td><c:out value="${j.username}" /></td>
				<td><c:out value="${j.password}" /></td>
				
				<td><form action="updatelink">
						<button name="id" value="<c:out value="${j.id}"/>"> Edit
		
						</button>
					</form>
				</td>
				
				<td><form action="deletebyid">
						<button name="id" value="<c:out value="${j.id}"/>"> Delete
							
						</button>
					</form>
				</td>
		
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<a href="back">Back</a>
</body>
</html>
