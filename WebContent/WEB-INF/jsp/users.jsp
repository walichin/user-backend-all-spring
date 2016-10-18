<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Users List</h1>
	
	<h2><a href="./">Menu Principal</a></h2>

	<c:if test="${not empty users}">

		<ul>
			<c:forEach var="listValue" items="${users}">
				<li>name: ${listValue.name} - login: ${listValue.login} - password: ${listValue.password}</li>
			</c:forEach>
		</ul>

	</c:if>
</body>
</html>
