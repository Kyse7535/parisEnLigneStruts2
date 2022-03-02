<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ktevot
  Date: 25/02/2022
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Paris Ouverts</title>
</head>
<body>
    <h2><s:property value="user.login" /> </h2>
    <ul>
        <s:iterator value="allParis">
            <s:url action="parier" var="urlPari">
                <s:param name="id"><s:property value="idPari" /> </s:param>
            </s:url>
            <li>
                Sport : <s:property value="match.sport" /> - <s:property value="match.equipe1" /> vs
                <s:property value="match.equipe2" /> ,
                <a href="<s:property value="#urlPari" />"> parier</a>
            </li>
        </s:iterator>
    </ul>
</body>
</html>
