<HTML>
<HEAD>
<TITLE>Message Bean Demo2</TITLE>
</HEAD>
<BODY>
<jsp:useBean id="messagebean" class="bean.MessageBean" />
<jsp:setProperty name="messagebean" property="message" param="mymessage" />
Here is the message:
<P>
<B><jsp:getProperty name="messagebean" property="message"/></B>
</BODY>
</HTML> 
