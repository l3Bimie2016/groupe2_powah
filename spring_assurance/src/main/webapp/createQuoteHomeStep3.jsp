<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Création d'un devis d'habitation étape 3</title>
</head>
<body>
	<form:form action="/quote/home.form?_page=4" method="post" modelAttribute="homeQuote">
        <div>
        	<form:label path="garden_area">Surface du jardin : </form:label>
        	<form:input path="garden_area" />
        </div>
        <div>
        	<form:label path="terrace_area">Surface de la terrasse : </form:label>
        	<form:input path="terrace_area"/>
        </div>
        <div>
        	<form:label path="heating_type">Type de chauffage : </form:label>
        	<form:select path="heating_type">
        		<option value="gaz">Gaz</option>
        		<option value="electricity">Electricité</option>
        		<option value="fuel">Fuel</option>
        		<option value="Focile">Focile</option>
        	</form:select>
        </div>
    	<input type="submit" value="Aller Ã  l'étape 4" />
	</form:form>
	
	<form:form action="/quote/home.form/cancelHomeQuote" method="post" modelAttribute="homeQuote">
		<input type="submit" value="Annuler" />
	</form:form>
</body>
</html>