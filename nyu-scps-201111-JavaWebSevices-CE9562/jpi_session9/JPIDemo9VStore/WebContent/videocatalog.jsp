<%@page import="model.Video,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<c:choose>
    <c:when test="${(empty param.title)}">
        No video category selected
    </c:when>
    <c:when test="${(not empty param.title)}">
        <c:choose>
            <c:when test="${(empty videoList)}">
                No video found for title: ${param.title}
            </c:when>
            <c:when test="${(not empty videoList)}">
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Stock Quantity</th>
                        <TH>Rating</TH>
                        <TH>Director</TH>
                        <TH>Actors</TH>
                        <th>  </th>
                    </tr>
                    <c:forEach var="entry" items="${videoList}">
                        <tr>
                            <td>${entry.id}</td>
                            <td>${entry.title}</td>
                            <td>${entry.price}</td>
                            <td>${entry.stockCount}</td>
                            <td>${entry.rating}</td>
                            <td>${entry.director.name}</td>
                            <td>
                            <c:forEach var="actor" items="${entry.actors}">
                                ${actor.name}
                            </c:forEach>    
                            </td>
                            <td><A HREF='./AddToShoppingCartServlet?price=${entry.price}&type=video&id=${entry.id}'>Buy</A></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
        </c:choose>
    </c:when>
</c:choose>
</body>
</html>
