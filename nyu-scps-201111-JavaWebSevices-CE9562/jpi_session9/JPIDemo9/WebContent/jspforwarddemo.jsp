<%@ page import="java.util.Date" %>
<HTML>
<HEAD><TITLE> JSP Forward Demo</TITLE></HEAD>
<BODY>
This is the original page.<br/>
The Current Server Date and Time is <%=new Date() %> (From jspforwarddemo.jsp) 
<jsp:forward page="next.jsp" />
</BODY>
</HTML>
