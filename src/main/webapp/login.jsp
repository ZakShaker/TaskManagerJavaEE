<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 18.04.2017
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Manager: Login</title>
    <style type="text/css">
        body {
            background: url(http://muzotkrytka.net/_ph/1/2/612853968.gif) repeat;
            text-align: center;
        }

        header h1 {
            font-size: 90px;
            color: white;
        }

        h2 {
            color: white;
        }
    </style>
</head>
<body>
<header>
    <h1>Login</h1>
</header>

<form class="login_form" method="post" action="login">
    <input type="text" name="login"/>
    <input type="text" name="password"/>
    <input type="submit" value="login"/>
</form>

</body>
</html>
