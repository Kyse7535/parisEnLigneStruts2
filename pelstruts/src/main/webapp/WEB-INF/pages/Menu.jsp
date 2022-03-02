<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ktevot
  Date: 23/02/2022
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
    <p>Menu</p>
    <ul>
        <li><s:a action="parisouverts" >Afficher les matchs sur lesquels parier</s:a> </li>
        <li><s:a action="mesParis">Afficher mes paris</s:a> </li>
        <li><s:a action="logout">Deconnexion</s:a> </li>
    </ul>
</body>
</html>
