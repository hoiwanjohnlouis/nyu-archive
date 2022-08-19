<%@page import="model.Music,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<c:choose>
<c:when test="${(empty sessionScope.cart) || (empty sessionScope.cart.iterator)}">
	shopping cart is empty
</c:when>
<c:when test="${(not empty sessionScope.cart.iterator)}">
		<table border="1">
		<tr>
		<th>Id</th>
		<th>Type</th>
		<th>Title</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Artists</th>
		<th>  </th>
		</tr>
		<c:forEach var="entry" items="${cart.iterator	}">
		<tr>
		<td>${entry.id}</td>
		<td>${entry.type}</td>
		<td>${entry.title}</td>
		<td>${entry.price}</td>
		<td>${entry.quantity}</td>
		<td>${entry.artists}</td>
		</tr>
		</c:forEach>
		</table>
</c:when>
</c:choose>
</body>
</html>
