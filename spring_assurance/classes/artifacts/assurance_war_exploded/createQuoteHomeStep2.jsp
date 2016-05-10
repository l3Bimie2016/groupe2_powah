<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Création d'un devis d'habitation étape 2</title>
</head>
<body>
	<form:form action="/quote/home.form?_page=3" method="post" modelAttribute="homeQuote">
        <div>
        	<form:label path="nb_rooms">Nombre de pièces : </form:label>
        	<form:input path="nb_rooms" />
        </div>
        <div>
        	<form:label path="floor">Etage : </form:label>
        	<form:input path="floor"/>
        </div>
        <div>
        	<form:label path="nb_bathrooms">Nombre de salles de bain : </form:label>
        	<form:input path="nb_bathrooms" />
        </div>
        <div>
        	<form:label path="garage">Garage? : </form:label>
        	<form:checkbox path="garage" />
        </div>
    	<input type="submit" value="Aller Ã  l'étape 3" />
	</form:form>
</body>
</html>