<%
	pageContext.setAttribute("pageContextAttr", "page context attribute 1");
	request.setAttribute("requestAttr","request attribute 1");
	session.setAttribute("sessionAttr","session attribute 1");
	application.setAttribute("appAttr","application attribute 1");

%>
<html>
<body>
Servlet Name = ${pageContext.servletConfig.servletName}<br>
pageContextAttr = ${pageScope["pageContextAttr"]}<br>
requestAttr = ${requestScope["requestAttr"]}<br>
sessionAttr = ${sessionScope["sessionAttr"]}<br>
applicationAttr = ${applicationScope["appAttr"]}<br>
Host Header = ${header["host"]}<br>
Parameter message = ${param["message"]}<br>
Cookie JSESSIONID= ${cookie["JSESSIONID"].value}<br>

</br>
</body>
</html>
