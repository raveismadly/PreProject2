<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>

<a href="create">Create</a>
<a href="read">Read</a>
<jsp:useBean id="haveThisUser" scope="request" type="model.User"/>
<c:if test="${haveThisUser!=null}">
<form action="update" METHOD="post">
    </c:if>
    <table>
        <c:if test="${haveThisUser!=null}">
            <input type="hidden" name="id" value="<c:out value='${haveThisUser.id}'/>"/>
        </c:if>
        <tr>
            <th>Name</th>
            <td><input name="name" type="text" value="<c:out value='${haveThisUser.name}'/>"/></td>

            <th>Surname</th>
            <td><input name="surname" type="text" value="<c:out value='${haveThisUser.surname}'/>"/></td>
            <th>Age</th>
            <td><input name="age" type="number" value="<c:out value='${haveThisUser.age}'/>"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Save">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
