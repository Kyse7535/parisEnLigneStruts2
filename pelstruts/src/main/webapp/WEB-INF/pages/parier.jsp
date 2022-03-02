<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ktevot
  Date: 27/02/2022
  Time: 09:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>parier</title>
</head>
<body>
<h3><s:property value="user.login" /> </h3>
<s:set var="vainqueur" value="vainqueur" />
<s:if test="%{#vainqueur == null}">
    <s:iterator value="pari">
        <p>
            Vous essayez de parier sur le match: <s:property value="match.sport" />
        </p>
    </s:iterator>
    <s:form action="confirmationPari">
        <s:select list="listVerdict" name="vainqueur" label="Verdict du match" />
        <s:textfield name="montant" label="montant" />
        <s:submit />
    </s:form>
</s:if>
<s:else>
    <s:iterator value="pari">
        <p>
            Vous avez parié <s:property value="montant" /> euros
            sur le resultat <s:property value="vainqueur" /> pour le match  ...
        </p>
        <s:a action="menu">retour au menu</s:a>
    </s:iterator>
</s:else>
</body>
</html>
