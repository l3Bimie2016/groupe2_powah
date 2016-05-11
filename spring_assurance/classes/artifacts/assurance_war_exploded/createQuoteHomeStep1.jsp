<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Création d'un devis d'habitation étape 1</title>
</head>
<body>
	<form:form action="/quote/home.form?_page=2" method="post" modelAttribute="quote">
        <div>
        	<form:label path="name">Nom du devis : </form:label>
        	<form:input path="name" />
        </div>
        <div>
        	<form:label path="house_type">Type habitation : </form:label>
        	<form:select path="house_type">
        		<option value="house">Maison</option>
        		<option value="appartment">Appartement</option>
        		<option value="studio">Studio</option>
        	</form:select>
        </div>
        <div>
        	<form:label path="surface">Surface : </form:label>
        	<form:input path="surface"/>
        </div>
    	<input type="submit" value="Aller Ã  l'étape 2" />
	</form:form>
	
	<form:form action="/quote/home.form/cancelHomeQuote" method="post" modelAttribute="quote">
		<input type="submit" value="Annuler" />
	</form:form>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="../js/listVehicule.js"></script>
</body>
</html>