// Code 8D
/** An Applet that loads picture on it.
* @version 1.0
*/

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
public class GraphicsApplet extends Applet
{

	/** override the paint method so that it loads an image.*/
	public void paint(Graphics g)
	{
		try
		{
			// instantiate URL object with the file name.
			URL url = new URL(getCodeBase().toString()+"bld.jpg");
			g.drawString(url.toString(),200,280);
			// get the image from the url
			Image image = getImage(url);
			// draw the image on the applet.
			g.drawImage(image,25,25,this);
		}
		catch(MalformedURLException e)
		{
			g.drawString("Bad URL",0,0);	
		}		
	}
}
