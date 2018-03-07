<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.03.2018
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create new Task</title>
</head>
<body>
${requestScope.get("user")}

<form class="add_task_form" method="post" action="create_task">
    <input type="hidden" name="user" value="${requestScope.get("user")}"/>
    Name:<br>
    <input type="text" name="name">
    <br>
    Description:<br>
    <input type="text" name="description">
    <br>
    When to start in the format(yyyy-mm-dd)<br>
    <input type="date" name="start_date">
    <br>
    When to end in the format(yyyy-mm-dd)<br>
    <input type="date" name="end_date">
    <input type="submit" value="Add new Task">
</form>

</body>
</html>
