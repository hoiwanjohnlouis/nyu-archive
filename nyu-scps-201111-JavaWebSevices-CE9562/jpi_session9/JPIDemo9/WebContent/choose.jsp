<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Music"%><html>
<%
	Music music  =new Music();
	music.setTitle("BreathLess");
	music.setPrice(50.99);
	session.setAttribute("music", music);

%>

<body>
Original Price: <c:out value="${sessionScope.music.price}" />
<br></br>
Param Price: <c:out value="${param.price}" />
<c:if test="${(not empty param.price)}">
	<c:set target="${sessionScope.music}" property="price" value="${param.price}" />
</c:if>
<br></br>
New Price: <c:out value="${sessionScope.music.price}" />
<br/>
<c:choose>
<c:when test="${sessionScope.music.price<10}">
The new price is really cheap.
</c:when>
<c:when test="${sessionScope.music.price>=10 and sessionScope.music.price<20}">
The new price is still reasonable.
</c:when>
<c:otherwise>
The new price is really high.
</c:otherwise>
</c:choose>


<c:remove var="music" scope="session" />
<br>
<br>
After removal, Price: <c:out value="${sessionScope.music.price}" /> 
</body>
</html>
