<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Création d'un devis d'habitation étape 4</title>
</head>
<body>
	<form:form action="/quote/home.form?_finish=1" method="post" modelAttribute="homeQuote">
        <div>
        	<form:label path="formula">Formule : </form:label>
        	<form:select path="formula">
        		<option value="A">Formule A</option>
        		<option value="B">Formule B</option>
        	</form:select>
        </div>
    	<input type="submit" value="Voir le résumé du devis" />
	</form:form>
	
	<form:form action="/quote/home.form/cancelHomeQuote" method="post" modelAttribute="homeQuote">
		<input type="submit" value="Annuler" />
	</form:form>
</body>
</html>