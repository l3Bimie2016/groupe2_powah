<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Opération terminée</title>
</head>
<body>
	<p>Votre devis de véhicule a bien été traîté.</p>
	<h1>Résumé</h1>
	<form:form modelAttribute="vehiculeQuote">
		<h1><c:out value="${ vehiculeQuote.name }"></c:out></h1>
		<form:label path="brand">Marque : </form:label>
		<c:out value="${ vehiculeQuote.brand }"></c:out>
		<form:label path="model">Modèle : </form:label>
		<c:out value="${ vehiculeQuote.model }"></c:out>
		<form:label path="fiscal_horse_power">Chevaux fiscaux : </form:label>
		<c:out value="${ vehiculeQuote.fiscal_horse_power }"></c:out>
		<form:label path="type_fuel">Carburant : </form:label>
		<c:out value="${ vehiculeQuote.type_fuel }"></c:out>
		<form:label path="bonus_malus">Bonus/Malus : </form:label>
		<c:out value="${ vehiculeQuote.bonus_malus }"></c:out>
		<form:label path="second_driver">Second conducteur : </form:label>
		<c:out value="${ vehiculeQuote.second_driver }"></c:out>
		<form:label path="in_garage">Dans garage? : </form:label>
		<c:out value="${ vehiculeQuote.in_garage }"></c:out>
		<form:label path="garage_address">Adresse garage : </form:label>
		<c:out value="${ vehiculeQuote.garage_address }"></c:out>
		<form:label path="contract_type">Type de contrat : </form:label>
		<c:out value="${ vehiculeQuote.contract_type }"></c:out>
		<form:label path="total_price">Prix total : </form:label>
		<c:out value="${ vehiculeQuote.total_price }"></c:out>
	</form:form>
	<a href="/">Retour accueil</a>
</body>
</html>