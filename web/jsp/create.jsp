<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form method="post">
    <a href="read">Read</a>
    <table>
        <tr>
            <th>
                Name
            </th>
            <td><input name="name" type="text">
            </td>
        </tr>
        <tr>
            <th>Surname</th>
            <td>
                <input name="surname" type="text">
            </td>
        </tr>
        <tr>
            <th>Age</th>
            <td>
                <input name="age" type="number">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Submit">
            </td>
        </tr>
    </table>
</form>
</body>
        </html>
