
//Homework:
//Reading:
//
//Just Java:
//Chapter 17 – GUI Basics and Event Handling
//Chapter 20 – Graphics Programming
//
//Programming Assignment:
//
//This homework is easy and therefore, carries only 5 points.
//
//Coding Policy:
//
//1.  You must follow a naming convention.
//2.  You must have enough comments in your code.
//
//1.  Create a Frame that will allow the user to draw sketches
//  as he drags the mouse (Mouse Dragged event) over the Frame.
//  Please make sure that you don’t draw dots as the user is
//  dragging the mouse.
//
//2.  Convert it to an Applet.
//
//Sample Output:
//
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class DrawShape_save extends DrawShape
{

    public DrawShape_save()
    {
        setSize(500,500);
        addMouseMotionListener(new DrawShape_save.InnerMouseMotionListener());
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
        }
    }

    public static void main(String[] args)
    {
        DrawShape_save drawShape = new DrawShape_save();
        drawShape.setVisible(true);
    }

}
