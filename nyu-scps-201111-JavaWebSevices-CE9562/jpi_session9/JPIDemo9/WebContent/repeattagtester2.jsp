<%@ taglib uri="/WEB-INF/tlds/testtaglib.tld" prefix="testlib" %>
<HTML>
<HEAD>
<TITLE>Tag Library Test</TITLE>
</HEAD>
<BODY>
<%
	String repeatValue=request.getParameter("repeat");
%>
<B><FONT color=blue>This line is before the tag.</FONT></B><BR>
<testlib:repeattag repeat="<%=repeatValue%>">
<B><FONT color=green>This line is in the body of the tag.</FONT></B><BR>
</testlib:repeattag>
<B><FONT color=blue>This line is after the tag.</FONT></B><BR>
</BODY>
</HTML>
