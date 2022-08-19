<%@page import="model.Music,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	List<Music> musicList = new ArrayList<Music>();
	Music music1  =new Music();
	music1.setTitle("BreathLess");
	music1.setPrice(50.99);
	Music music2  =new Music();
	music2.setTitle("Just An Illusion");
	music2.setPrice(30.99);
	musicList.add(music1);
	musicList.add(music2);
	request.setAttribute("musicList", musicList);
%>
<html>
<body>
<table border="1">
<c:forEach var="entry" items="${musicList}">
<tr>
<td>${entry.title}</td>
<td>${entry.price}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
