<HTML>
<HEAD><TITLE>Color JSP</TITLE></HEAD>
<%
	String color=request.getParameter("color");
	boolean found=true;
	if (color==null){
			color="white";
			found=false;
	}
%>
<BODY bgColor="<%= color %>">
<%
if (found){
	out.println("<H3>Here is your backcolor: " + color + "<H3>");
}
else{
	out.println("<H3>Using default white backcolor</H3>");
}
%>
<FORM method="GET">
<TABLE>
<TR><TD>Backgroud Color Please</TD><TD><INPUT type="text" name="color" value=<%= color %> size=20></TD></TR>
</TABLE>
<BR><BR>     
<INPUT type="submit" value="Send"> <input type="reset" value="Clear">
</FORM>
</BODY>
</HTML>
