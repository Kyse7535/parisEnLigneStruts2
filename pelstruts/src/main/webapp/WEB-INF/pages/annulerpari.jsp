<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ktevot
  Date: 27/02/2022
  Time: 07:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation annulation</title>
</head>
<body>
  <h3><s:property value="user.login" /> </h3>
  <p>
      La mise <s:property value="pariAnnule.montant" /> euros sur le resultat
  <s:property value="pariAnnule.vainqueur" /> pour le match: <s:property value="pariAnnule.equipe1" /> vs
  <s:property value="pariAnnule.equipe2" /> le <s:property value="pariAnnule.quand" /> a bien été annulé
  </p>
    <s:a action="menu">retour au menu</s:a>
</body>
</html>
