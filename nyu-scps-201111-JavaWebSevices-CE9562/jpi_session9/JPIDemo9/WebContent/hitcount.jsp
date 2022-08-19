<HTML>
	<HEAD><TITLE>JSP Declaration Demo</TITLE></HEAD>
	<%! private int count=0; %>
	<%
		++count;
	%>
	<BODY><H3>This page has been visited: <%= count %> times </H3>
	</BODY>
</HTML>
