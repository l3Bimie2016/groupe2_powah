<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Création d'un devis de véhicule étape 4</title>
</head>
<body>
	<form:form action="/quote/vehicule.form?_finish=1" method="post" modelAttribute="vehiculeQuote">
    	<div>
        	<form:label path="contract_type">Type de contrat : </form:label>
        	<form:select path="contract_type">
        		<option value="A">Contrat A</option>
        		<option value="B">Contrat B</option>
        	</form:select>
        </div>
	    <input type="submit" value="Finaliser" />
	</form:form>

	<form:form action="/quote/vehicule.form/cancelVehiculeQuote" method="post" modelAttribute="vehiculeQuote">
		<input type="submit" value="Annuler" />
	</form:form>
</body>
</html>