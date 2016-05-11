<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${ quotesList }" var="quote">
		<c:if test="${ quote.type  == 'VehiculeQuote'}">
			<form:form action='/quote/resume?idQuote=${ quote.id }' method="post" modelAttribute="quote">
				<input type="submit" value="Reprendre"/>
			</form:form>
			${ quote.id }
		</c:if>
	</c:forEach>
</body>
</html>