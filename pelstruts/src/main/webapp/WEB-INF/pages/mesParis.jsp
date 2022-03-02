<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ktevot
  Date: 23/02/2022
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mesParis</title>
</head>
<body>
    <h1><s:property value="user.login" /> </h1>
    <ul>
        <s:iterator value="mesparis">

            <s:url var="urlMatch" action="annulerpari">
                <s:param name="id"><s:property value="idPari" /></s:param>
            </s:url>
            <li>
                Sport : <s:property value="match.sport" /> - <s:property value="match.equipe1" /> vs
                <s:property value="match.equipe2" /> - le <s:property value="match.quand" />, Mise de
                <s:property value="montant" /> sur <s:property value="vainqueur" />
                <a href="<s:property value="#urlMatch" />">Annuler</a>
            </li>
        </s:iterator>
    </ul>

    <s:a action="menu">Retour au menu</s:a>
</body>
</html>
