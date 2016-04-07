<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Devis en cours</title>
</head>
<body>
<form:form action="/wizard.form?_page=2" method="post" modelAttribute="modelWizard">
    <form:label path="step1">CrÃ©er un devis habitation - Ãtape 1 : </form:label>
    <div><label>Nom du devis : <input type="text" name="quoteName"/></label></div>
    <div><label>PrÃ©nom : <input type="text" name="firstname"/></label></div>
    <div><label>Nom : <input type="text" name="name"/></label></div>
    <div><label>Type habitation : <input type="text" name="houseType"/></label></div>
    <div><label>Surface : <input type="text" name="surface"/></label></div>
    <form:input path="step1" />
    <input type="submit" value="Aller Ã  l'Ã©tape 2" />
</form:form>
</body>
</html>