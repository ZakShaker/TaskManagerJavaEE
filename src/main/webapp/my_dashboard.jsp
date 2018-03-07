<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.03.2018
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>My dashboard</title>
</head>
<body>
${requestScope.get("userId")}

<h1>Here are your tasks:</h1>

<form method="get" action="create_task">
    <input type="hidden" name="user" value="${requestScope.get("userId")}"/>
    <input type="submit" value="Add new Task"/>
</form>

<table>
    <tr>
        <th>Task id</th>
        <th>Name of task</th>
        <th>Description</th>
        <th>When to Start</th>
        <th>When to Complete</th>
    </tr>
    <c:forEach items="${my_tasks}" var="task">
        <tr>
            <td><c:out value="${task.id}"></c:out></td>
            <td><c:out value="${task.name}"></c:out></td>
            <td><c:out value="${task.description}"></c:out></td>
            <td><c:out value="${task.startDate}"></c:out></td>
            <td><c:out value="${task.endDate}"></c:out></td>

            <td>
                <form method="post" action="my_dashboard">
                    <input type="hidden" name="user" value="${requestScope.get("userId")}"/>
                    <input type="hidden" name="idToDelete" value="${task.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
