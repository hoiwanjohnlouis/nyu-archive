package tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
public class TestTag extends TagSupport{
	private static final long serialVersionUID = 1L;

	public int doStartTag(){
		try{
			JspWriter out = pageContext.getOut();
			out.println("<B><FONT color=red>This line is from doStartTag method.</FONT></B><BR>");
		}
		catch(IOException e){
			System.out.println(e);
		}
		return (EVAL_BODY_INCLUDE);
	}
	public int doEndTag(){
		try{
			JspWriter out = pageContext.getOut();
			out.println("<B><FONT color=red>This line is from doEndTag method.</FONT></B><BR>");
		}
		catch(IOException e){
			System.out.println(e);
		}
		return (EVAL_PAGE);
	}
	public int doAfterBody(){
		try{
			JspWriter out = pageContext.getOut();
			out.println("<B><FONT color=black>This line is from doAfterBody method.</FONT></B><BR>");
		}
		catch(IOException e){
			System.out.println(e);
		}
		return (SKIP_BODY);
	}
}
