<HTML>
<HEAD>
<TITLE>Message Bean Demo3</TITLE>
</HEAD>
<BODY>
<jsp:useBean id="messagebean" class="bean.MessageBean" />
<jsp:setProperty name="messagebean" property="*" />
Here is the message:
<P>
<B><jsp:getProperty name="messagebean" property="message"/></B>
</BODY>
</HTML> 
