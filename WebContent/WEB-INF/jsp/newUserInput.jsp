<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>New User - Spring</title>
    </head>
 
    <body>
        <h1>New User - Spring</h1>
        
		<form:form action="newUser" method="POST" modelAttribute="userForm">
            Name: <form:input path="name"/><br/>
            Login: <form:input path="login"/><br/>
            Password: <form:input path="password"/><br/>
            Email: <form:input path="email"/><br/>
            Is admin: <form:input path="is_admin"/><br/>
            Url photo: <form:input path="url_photo"/><br/>
            Gps latitude: <form:input path="gps_latitude"/><br/>
            Gps longitude: <form:input path="gps_longitude"/><br/>
            Gps location: <form:input path="gps_location"/><br/>
            <form:input type="hidden" value="html" path="format"/><br/>
	        <input type="submit" value="Create user" class="btn-danger" />
		</form:form>
		
    </body>
</html>
