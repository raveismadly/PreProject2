<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read</title>
</head>
<body>
<a href="create">Create</a>
<table>
    <th>ID</th>
    <th>Name</th>
    <th>Surname</th>
    <th>Age</th>
    <th>Actions</th>
    <jsp:useBean id="allUsers" scope="request" type="java.util.List"/>
    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.surname}"/></td>
            <td><c:out value="${user.age}"/></td>
            <td><a href="update? id=<c:out value='${user.id}'/>">Update</a></td>
            <td><a href="delete? id=<c:out value='${user.id}'/>">Delete</a></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
