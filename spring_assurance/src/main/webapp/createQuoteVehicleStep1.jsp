<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Création d'un devis de véhicule étape 1</title>
</head>
<body>
	<form:form action="/quote/vehicule.form?_page=2" method="post" modelAttribute="vehiculeQuote">
        <div>
        	<form:label path="name">Nom du devis : </form:label>
        	<form:input path="name"/>
        </div>
        <div>
        	<form:label path="street">Nom Rue : </form:label>
        	<form:input path="street"/>
        </div>
        <div>
        	<form:label path="zip_code">Code Postal : </form:label>
        	<form:input path="zip_code"/>
        </div>
        <div>
        	<form:label path="city">Ville : </form:label>
        	<form:input path="city"/>
        </div>
        <div>
        	<form:label path="brand">Marque : </form:label>
        	<form:select path="brand"></form:select>
        </div>
        <div>
        	<form:label path="model">Modèle : </form:label>
        	<form:select path="model"></form:select>
        </div>
        <div>
        	<form:label path="type_fuel">Type Carburant : </form:label>
        	<form:select path="type_fuel"></form:select>
        </div>
        <div>
        	<form:label path="fiscal_horse_power">Chevaux fiscaux : </form:label>
        	<form:select path="fiscal_horse_power"></form:select>
        </div>
    	<input type="submit" value="Aller Ã  l'étape 2" />
	</form:form>
</body>
</html>