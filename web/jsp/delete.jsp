<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<jsp:useBean id="user" scope="request" type="model.User"/>
<form name="delete" method="post">
    <a href="read.jsp">Read</a>
    <a href="create.jsp">Create</a>
    <table>
        <c:if test="${user!=null}" >
            <input type="hidden" name="id" value="<c:out value='${user.id}'/> "/>
        </c:if>
        <tr>
            <th>Name</th>
            <td><c:out value="${user.name}"/></td>
        </tr>
        <tr>
            <th>Surname</th>
            <td><c:out value="${user.surname}"/></td>
        </tr>
        <tr>
            <th>Age</th>
            <td><c:out value="${user.age}"/></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="Delete"></td>
        </tr>
    </table>
</form>

</body>
</html>
