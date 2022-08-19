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
<c:set target="${sessionScope.music}" property="price" value="${param.price}" />
<br></br>
New Price: <c:out value="${sessionScope.music.price}" />
<c:remove var="music" scope="session" />
<br>
<br>
After removal, Price: <c:out value="${sessionScope.music.price}" /> 
</body>
</html>
