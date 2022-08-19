<%@ taglib uri="/WEB-INF/tlds/testtaglib.tld" prefix="testlib" %>
<HTML>
<HEAD>
<TITLE>Tag Library Test</TITLE>
</HEAD>
<BODY>
<B><FONT color=blue>This line is before the start tag.</FONT></B><BR>
<testlib:testtag>
<B><FONT color=green>This line is in the body of the tag.</FONT></B><BR>
</testlib:testtag>
<B><FONT color=blue>This line is after end tag.</FONT></B><BR>
</BODY>
</HTML>
