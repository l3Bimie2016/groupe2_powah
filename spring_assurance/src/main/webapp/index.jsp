<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script type="text/javascript" src="../js/jquery.js"></script>
    <meta charset="UTF-8">
    <title>Devis en cours</title>
</head>
<body>
<h1>Devis en cours</h1>
    <div>
        <a href="/quote/vehicule.form">Nouveau devis pour véhicule</a>
        <br />
        <a href="/quote/house">Nouveau devis pour habitation</a>
    </div>
    <div id="test" style="width:100px; height:100px; background-color:red;" ></div>
    
    <script type="text/javascript">
    $( document ).click(function() {
    	  $( "#test" ).toggle( "explode" );
    	});
    </script>
</body>
</html>
