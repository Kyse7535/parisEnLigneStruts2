<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ktevot
  Date: 23/02/2022
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <s:form action="connexion">
        <s:textfield label="Pseudo" name="login" />
        <s:textfield label="Password" name="password" />
        <s:submit value="connexion !" />
    </s:form>
</body>
</html>
