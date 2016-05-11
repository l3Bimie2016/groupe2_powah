<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Création d'un devis de véhicule étape 2</title>
</head>
<body>
	<form:form action="/quote/vehicule.form?_page=3" method="post" modelAttribute="quote">
	    <div>
        	<form:label path="id">
        		<c:out value="${ quote.id }"></c:out>
        	</form:label>
        </div>
	    <div>
        	<form:label path="bonus_malus">Bonus - Malus : </form:label>
        	<form:input path="bonus_malus"/>
        </div>
	    <input type="submit" value="Aller Ã  l'étape 3" />
	</form:form>
	
	<form:form action="/quote/vehicule.form/cancelVehiculeQuote" method="post" modelAttribute="quote">
		<input type="submit" value="Annuler" />
	</form:form>
</body>
</html>