<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.*, model.*"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
The following response is coming from musics.jsp
<table border='1'>
<tr>
<th>Id</th>
<th>Title</th>
<th>Price</th>
<th>Stock Quantity</th>
<th># of Tracks</th>
<th>Artist</th>
<th>  </th>
</tr>

<%

List<Music> musics = (List<Music>) request.getAttribute("myMusic");
Iterator<Music> iteratorMusics = musics.iterator();
while(iteratorMusics.hasNext()){
	Music music = iteratorMusics.next();
	out.println("<tr>");
	out.println("<td>" + music.getId() + "</td>");
	out.println("<td>" + music.getTitle() + "</td>");
	out.println("<td>" + music.getPrice() + "</td>");
	out.println("<td>" + music.getStockCount() + "</td>");
	out.println("<td>" + music.getNumberOfTracks() + "</td>");
	out.println("<td>" + music.getArtist().getName() + "</td>");
	out.println("<td><A HREF='./AddToShoppingCartServlet?price="+music.getPrice()+"&type=music&id=" + music.getId() + "'>Buy</A></td>");
	out.println("</tr>");
}
%>
</table>
</body>
</html>