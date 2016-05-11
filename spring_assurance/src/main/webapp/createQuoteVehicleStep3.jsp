<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Création d'un devis de véhicule étape 3</title>
</head>
<body>
	<form:form action="/quote/vehicule.form?_page=4" method="post" modelAttribute="vehiculeQuote">
    	<div>
        	<form:label path="second_driver">Second conducteur : </form:label>
        	<form:input path="second_driver"/>
        </div>
        <div>
        	<form:label path="in_garage">Dans un garage? : </form:label>
        	<form:radiobutton path="in_garage" value="true"/>Oui
        	<form:radiobutton path="in_garage" value="false"/>Non
        </div>
        <div>
        	<form:label path="garage_address">Addresse du garage ou adresse de stationnement : </form:label>
        	<form:input path="garage_address" />
        </div>
	    <input type="submit" value="Aller à  l'étape 4" />
	</form:form>
	
	<form:form action="/quote/vehicule.form/cancelVehiculeQuote" method="post" modelAttribute="vehiculeQuote">
		<input type="submit" value="Annuler" />
	</form:form>
</body>
</html>