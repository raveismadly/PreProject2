<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>



    <a href="create">Create   </a>
    <a href="read">  Read</a>
    <jsp:useBean id="user" scope="request" type="model.User" />
    <form name="delete" method="post">
        <table>
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}'/>"/>
            </c:if>
            <tr>
                <th>Name</th>
                <td><c:out value="${user.name}"/></td>


                <th>Surname</th>
                <td><c:out value="${user.surname}"/></td>


                <th>Age</th>
                <td><c:out value="${user.age}"/></td>

            </tr>
            <tr>
                <td>
                <input type="submit" value="Delete">
            </td>
            </tr>
        </table>
    </form>
</body>
</html>
