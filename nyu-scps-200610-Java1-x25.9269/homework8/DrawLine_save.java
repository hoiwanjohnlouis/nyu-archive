
//  Homework:
//  Reading:
//
//  Just Java:
//  Chapter 17 – GUI Basics and Event Handling
//  Chapter 20 – Graphics Programming
//
//  Programming Assignment:
//
//  This homework is easy and therefore, carries only 5 points.
//
//  Coding Policy:
//
//  1.  You must follow a naming convention.
//  2.  You must have enough comments in your code.
//
//  1.  Create a Frame that will allow the user to draw sketches
//      as he drags the mouse (Mouse Dragged event) over the Frame.
//      Please make sure that you don’t draw dots as the user is
//      dragging the mouse.
//
//  2.  Convert it to an Applet.
//
//  Sample Output:
//
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class DrawLine_save extends DrawShape
{

    public DrawLine_save()
    {
        setSize(500,500);
        addMouseMotionListener(new DrawLine_save.InnerMouseMotionListener());
    }


    // inner listener class
    private class InnerMouseMotionListener  implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent p1)
        {
            // get the graphics object of this frame.
            Graphics graphics=getGraphics();
            // set the color to black.
            graphics.setColor(Color.black);
            // draw circle using 50X50 rectangle.
//          graphics.drawOval(p1.getX()-25,p1.getY()-25,50,50);
            graphics.drawLine(p1.getX()-50,p1.getY()-50,100,100);
        }

        /** This method draws Circle and fills them will random color.*/
        public void mouseMoved(MouseEvent p1)
        {
            // get random number between 0-255 for red,green and blue.
            int red = (int) (Math.random()*255);
            int green = (int) (Math.random()*255);
            int blue = (int) (Math.random()*255);

            // get the graphics object of the frame.
            Graphics graphics=getGraphics();

            // set the color to black and draw circle using 100x1000 rectangle.
            graphics.setColor(Color.black);
//          graphics.drawOval(p1.getX()-50,p1.getY()-50,100,100);

            // set the color to random color using red, green and blue.
//          Color color=new Color(red,green,blue);
//          graphics.setColor(color);

            // fill the circle drawn before with color.
//          graphics.fillOval(p1.getX()-50,p1.getY()-50,100,100);
        }
    }

    public static void main(String[] args)
    {
            DrawLine_save drawLine = new DrawLine_save();
            drawLine.setVisible(true);
    }

}
