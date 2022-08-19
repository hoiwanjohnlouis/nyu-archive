<%@page import="cart.ShoppingCart,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<c:set var="cumQty" value="0" scope="session" />
<c:set var="cumSum" value="0.0" scope="session" />
<c:choose>
    <c:when test="${(empty lineItemList)}">
        shopping cart is empty
    </c:when>
    <c:when test="${(not empty lineItemList)}">
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
            <c:forEach var="entry" items="${lineItemList}">
                <tr>
                    <td>${entry.id}</td>
                    <td>${entry.type}</td>
                    <td>${entry.title}</td>
                    <td>${entry.price}</td>
                    <td>${entry.quantity}</td>
                    <td>${entry.artists}</td>
                    <td><A HREF='./RemoveFromShoppingCartServlet?price=${entry.price}&type=${entry.type}&id=${entry.id}'>Remove</A></td>
                </tr>
            </c:forEach>
            <tr>
                <th> </th>
                <th> </th>
                <th> </th>
                <th>${cart.cummCost}</th>
                <th>${cart.cummQuantity}</th>
                <th> </th>
                <th> </th>
            </tr>
        </table>
    </c:when>
</c:choose>
</body>
</html>
