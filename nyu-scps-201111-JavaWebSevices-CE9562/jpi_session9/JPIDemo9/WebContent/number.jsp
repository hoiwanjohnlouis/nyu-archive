<%@ page language="Java" import="java.util.*,java.math.*" session="true" buffer="12kb" 
autoFlush="true"  isThreadSafe="true" info="'My test page" errorPage="./error.jsp"
isErrorPage="false" contentType="text/html;CHARSET=ISO-8859-1"%>
<HTML>
<HEAD><TITLE>Number JSP</TITLE></HEAD>
<%
	String number = request.getParameter("number");
	boolean found=true;
	if (number==null){
		found=false;
		number="";
	}
	
%>
<BODY>
<%
if (found){
	int num=0;
	num=Integer.parseInt(number);
	
	// If I make it here - no number format exception.
	out.println("<H3>Here is your number: " + num + "<H3>");
}
%>
<FORM method="GET">
<TABLE>
<TR>
<TD>Please enter a number</TD>
<TD><INPUT type="text" name="number" value="<%= number %>" size=20></TD>
</TR>
</TABLE>
<BR><BR>     
<INPUT type="submit" name="send" value="Send"> <input type="reset" value="Clear">
</FORM>
</BODY>
</HTML>
