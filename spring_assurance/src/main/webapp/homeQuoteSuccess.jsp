<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Résumé de votre devis</title>
</head>
<body>
	<p>Votre devis d'habitation a bien été enregistré.</p>
	
	<form:form modelAttribute="quote">
		<h1><c:out value="${ quote.name }"></c:out></h1>
		<div>
        	<form:label path="id">
        		<c:out value="${ quote.id }"></c:out>
        	</form:label>
        </div>
		<form:label path="house_type">Type d'habitation : </form:label>
		<c:out value="${ quote.house_type }"></c:out><br />
		<form:label path="surface">Surface de l'habitation : </form:label>
		<c:out value="${ quote.surface }"></c:out><br />
		<form:label path="nb_rooms">Nombre de pièces : </form:label>
		<c:out value="${ quote.nb_rooms }"></c:out><br />
		<form:label path="floor">Etage : </form:label>
		<c:out value="${ quote.floor }"></c:out><br />
		<form:label path="nb_bathrooms">Nombre de salles de bain : </form:label>
		<c:out value="${ quote.nb_bathrooms }"></c:out><br />
		<form:label path="garage">Garage? : </form:label>
		<c:out value="${ quote.garage }"></c:out><br />
		<form:label path="garden_area">Surface du jardin : </form:label>
		<c:out value="${ quote.garden_area }"></c:out><br />
		<form:label path="terrace_area">Surface de la terrasse : </form:label>
		<c:out value="${ quote.terrace_area }"></c:out><br />
		<form:label path="heating_type">Type de chauffage : </form:label>
		<c:out value="${ quote.heating_type }"></c:out><br />
		<form:label path="formula">Formule : </form:label>
		<c:out value="${ quote.formula }"></c:out>
	</form:form>
	
</body>
</html>