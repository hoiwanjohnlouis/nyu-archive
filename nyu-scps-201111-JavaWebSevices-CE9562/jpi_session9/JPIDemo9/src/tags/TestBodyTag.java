package tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
public class TestBodyTag extends BodyTagSupport{
	private static final long serialVersionUID = 1L;


	public int doAfterBody()throws JspException{
		try{
			BodyContent bodyContent= getBodyContent();
			String bodytext = bodyContent.getString();
			bodytext=bodytext.toUpperCase();
			bodyContent.clear();
			bodyContent.print(bodytext);
			bodyContent.writeOut(getPreviousOut());
		}
		catch(IOException e){
			System.out.println(e);
		}
		return (SKIP_BODY);
	}
}
