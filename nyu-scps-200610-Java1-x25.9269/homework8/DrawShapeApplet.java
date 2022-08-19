
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
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class DrawShapeApplet extends Applet
{

    // new private vars to initialize the stating position of
    // line segment before drawing.
    // MOUSE_PRESS event will initialize thie
    private int origin_x;
    private int origin_y;
    private boolean drawable = false;

    /**
     * @return the origin_x
     */
    public int getOrigin_x() {
        return origin_x;
    }

    /**
     * @param origin_x the origin_x to set
     */
    public void setOrigin_x(int origin_x) {
        this.origin_x = origin_x;
    }

    /**
     * @return the origin_y
     */
    public int getOrigin_y() {
        return origin_y;
    }

    /**
     * @param origin_y the origin_y to set
     */
    public void setOrigin_y(int origin_y) {
        this.origin_y = origin_y;
    }

    /**
     * @return the drawable
     */
    public boolean getDrawable() {
        return drawable;
    }

    /**
     * @param drawable the drawable to set
     */
    public void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    /** No-argument constructor that adds window listener
    * and sets size, location and title by default.
    */
    public DrawShapeApplet()
    {
        // call the Frame() constructor.
        super();
        // add an instance of inner window listener.
//        addWindowListener(new DrawShapeApplet.InnerWindowListener());

        // add an instance of inner mouse listener.
        // we need to track down the mouse button pressed to initialize
        // the origin_x and origin_y
        addMouseListener(new DrawShapeApplet.InnerMouseListener());

        // add an instance of inner mouse motion listener.
        addMouseMotionListener(new DrawShapeApplet.InnerMouseMotionListener());

        // give it a default title.
//        setTitle(getClass().getName());

        // set size and location.
        setSize(400,300);
        
        // set gray backgroud
        setBackground(Color.lightGray);
    }

    //inner window listener class
    private class InnerWindowListener extends WindowAdapter
    {
        public void windowClosing(WindowEvent p1)
        {
            System.exit(0);
        }
    }

    // inner mouse listener class
    class InnerMouseListener implements MouseListener
    {

        public void mouseClicked(MouseEvent p1)
        {
            //System.out.println(p1.toString());
        }

        public void mousePressed(MouseEvent p1)
        {
            System.out.println(p1.toString());
            //System.out.println("\tbutton     " + p1.getButton());
            //System.out.println("\tmodifers   " + p1.getModifiers());
            //System.out.println("\texmodifers " + p1.getModifiersEx());

            // use MouseEvent[button=1,modifiers=Button1,extModifiers=Button1
            if (p1.getButton() == MouseEvent.BUTTON1) {
                // get the start point to draw
                setOrigin_x(p1.getX());
                setOrigin_y(p1.getY());
                setDrawable(true);  // there's probable a better way of doing this.
            }
            else {
                setDrawable(false); // there's probable a better way of doing this.
            }
        }

        public void mouseReleased(MouseEvent p1)
        {
            //System.out.println(p1.toString());
        }

        public void mouseEntered(MouseEvent p1)
        {
            //System.out.println(p1.toString());
        }

        public void mouseExited(MouseEvent p1)
        {
            //System.out.println(p1.toString());
        }

    }

    // inner mouse motion listener class
    private class InnerMouseMotionListener  implements MouseMotionListener
    {

        public void mouseDragged(MouseEvent p1)
        {
            System.out.println(p1.toString());
            //System.out.println("\tbutton     " + p1.getButton());
            //System.out.println("\tmodifers   " + p1.getModifiers());
            //System.out.println("\texmodifers " + p1.getModifiersEx());

            // use MouseEvent[button=1,modifiers=Button1,extModifiers=Button1
            // there's probable a better way of doing this than using a boolean.
            if  ((getDrawable()==true) &&
                 (p1.getButton() == MouseEvent.NOBUTTON)) {
                // get the start point to draw
                // get the graphics object of this frame.
                Graphics graphics=getGraphics();
                // set the color to black.
                graphics.setColor(Color.MAGENTA);
                // draw the line.
                graphics.drawLine(p1.getX(),p1.getY(),getOrigin_x(),getOrigin_y());
                // update start point to current position
                // so it looks like a contious shape
                setOrigin_x(p1.getX());
                setOrigin_y(p1.getY());
            }
        }

        /**
         *  implement mouseMoved even though no action is required.
         *  Abastract requires us to define a null method.
         */
        public void mouseMoved(MouseEvent p1)
        {
            // redefine the p.X and p.Y values.
        }
    }

//    /** Main method to test the class.*/
//    public static void main(String[] args)
//    {
//        // instantiate a object of this class.
//        DrawShape frame = new DrawShape();
//
//        // make it visible.
//        frame.setVisible(true);
//    }

}
