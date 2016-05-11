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
        	<!--<form:select path="brand"></form:select>-->
			<select id="brand" name="brand" onchange="selectBrand(this.value)"><option /></select>
        </div>
        <div>
        	<form:label path="model">Modèle : </form:label>
			<!--<form:select path="model"></form:select>-->
			<select id="model" name="model" onchange="selectModel(this.value)"><option /></select>
        </div>
        <div>
        	<form:label path="fiscal_horse_power">Chevaux fiscaux : </form:label>
        	<!--<form:select path="fiscal_horse_power"></form:select>-->
			<select id="fiscal_horse_power" name="fiscal_horse_power" onchange="selectHorse(this.value)"><option /></select>
        </div>
		<div>
			<form:label path="type_fuel">Type Carburant : </form:label>
			<!--<form:select path="type_fuel"></form:select>-->
			<select id="type_fuel" name="type_fuel" ><option /></select>
		</div>
    	<input type="submit" value="Aller Ã  l'étape 2" />
	</form:form>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="../js/listVehicule.js"></script>
</body>
</html>