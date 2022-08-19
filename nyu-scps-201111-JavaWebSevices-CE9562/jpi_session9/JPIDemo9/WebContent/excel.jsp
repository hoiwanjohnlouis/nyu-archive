<%@ page import="java.util.*" %>
<%
boolean excel=true;
String accept=request.getHeader("Accept");
if (accept==null){
	excel=false;
}
else{
	if (accept.indexOf("ms-excel")>= 0){
		excel=true;
	}
}
if (excel){
	response.setContentType("application/vnd.ms-excel");
}
%>
<HTML>
	<HEAD><TITLE>Excel JSP</TITLE></HEAD>
	<BODY>
		<TABLE BORDER="1">
			<TR><TH>&nbsp</TH><TH>Grades</TH><TH>&nbsp</TH></TR>
			<TR><TH>Name</TH><TH>Assignment 1</TH><TH>Assignment 2</TH></TR>
			<TR><TD>John Smith</TD><TD>10</TD><TD>9</TD></TR>
			<TR><TD>Bill Bond</TD><TD>10</TD><TD>10</TD></TR>
			<TR><TD>Sue Lee</TD><TD>9</TD><TD>10</TD></TR>
		</TABLE>
	</BODY>
</HTML>
