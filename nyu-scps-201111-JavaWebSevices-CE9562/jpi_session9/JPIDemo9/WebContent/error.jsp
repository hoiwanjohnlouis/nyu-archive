<%@ page language="Java" session="true" buffer="12kb" autoFlush="true"  isThreadSafe="true" 
info="'My error page" isErrorPage="true" contentType="text/html;CHARSET=ISO-8859-1"%>
<HTML>
	<HEAD><TITLE>Error JSP</TITLE></HEAD>
	<BODY>
	<H3>Error:  <%=exception.toString() %></H3>
	</BODY>
</HTML>
