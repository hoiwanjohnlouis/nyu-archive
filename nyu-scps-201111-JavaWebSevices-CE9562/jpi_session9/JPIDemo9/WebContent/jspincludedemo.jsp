<%@ page import="java.util.Date" %>
<HTML>
<HEAD><TITLE> JSP Include Demo</TITLE></HEAD>
<BODY>
<jsp:include page="runtime.jsp" flush="true" />
<p>
This line is included at response time. 
<p>
The Current Server Date and Time is <%=new Date() %> (From jspincludedemo.jsp) 
</BODY>
</HTML>
