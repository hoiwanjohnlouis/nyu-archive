<HTML>
<HEAD>
<TITLE>Message Bean Demo4</TITLE>
</HEAD>
<BODY>
<jsp:useBean id="messagebean" class="bean.MessageBean" />
Here is the default message:<B> <%= messagebean.generateDefaultMessage() %></B>
</BODY>
</HTML>
