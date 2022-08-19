package tags;
import javax.servlet.jsp.tagext.*;
public class RepeatTag extends TagSupport{
	private static final long serialVersionUID = 1L;
	private int repeat = 1;
	private int i =1 ;
	public void setRepeat(String repeatValue)
	{
		try{
			repeat= Integer.parseInt(repeatValue);
		}
		catch(NumberFormatException e){
			System.out.println(e);
		}
	}
	public int doStartTag(){
		if (repeat <=0){
			repeat=1;
			return SKIP_BODY;
		}
		else
		{
			return (EVAL_BODY_INCLUDE);
		}
	}

	public int doAfterBody(){
		if (i < repeat){
			i++;
			return (EVAL_BODY_AGAIN);
		}
		else{
			i=1;
			return (SKIP_BODY);
		}
	}

	public int doEndTag()
	{
		return (EVAL_PAGE);
	}
}
