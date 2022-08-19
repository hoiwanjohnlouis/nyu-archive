<%@page import="model.Music,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<c:choose>
<c:when test="${(empty param.category)}">
	No music category selected
</c:when>
<c:when test="${(not empty param.category)}">
	<c:choose>
	<c:when test="${(empty musicList)}">
	No music found for category: ${param.category}
	</c:when>
	<c:when test="${(not empty musicList)}">
		<table border="1">
		<tr>
		<th>Id</th>
		<th>Title</th>
		<th>Price</th>
		<th>Stock Quantity</th>
		<th># of Tracks</th>
		<th>Artists</th>
		<th>  </th>
		</tr>
		<c:forEach var="entry" items="${musicList}">
		<tr>
		<td>${entry.id}</td>
		<td>${entry.title}</td>
		<td>${entry.price}</td>
		<td>${entry.stockCount}</td>
		<td>${entry.numberOfTracks}</td>
		<td>${entry.artist.name}</td>
		<td><A HREF='./AddToShoppingCartServlet?price=${entry.price}&type=music&id=${entry.id}'>Buy</A></td>
		</tr>
		</c:forEach>
		</table>
	</c:when>
	</c:choose>
</c:when>
</c:choose>
</body>
</html>
