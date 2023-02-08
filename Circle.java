import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0.  (15 July 2000) 
 */

public class Circle{

    public static final double PI=3.1416;
    
    private double perimeter;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    
    
    public Circle(){
        diameter = 30;
        perimeter = PI * diameter;
        xPosition = 100;
        yPosition = 130;
        color = "blue";
        isVisible = false;
    }

    
    /**
     * Shows the perimeter of the circle
     */
    public double perimeter()
    {
        perimeter = PI * diameter;
        return perimeter;
    }
       
    
    /**
     * Changes the perimeter in a 50% keeping proportions
     * @param c. More or less zoom on the circle. Valid symbols '+' or '-'
     */
    public void zoom(char c)
    {
        if(c == '+')
        {
            erase();
            diameter = diameter * 2;
            perimeter();
            draw();
        }
        else if(c == '-')
        {
            erase();
            diameter = diameter / 2;
            perimeter();
            draw();
        }
    }
    
    
    /**
     * Makes the circle jump the times that the user choose.
     * @param times. Number of times that the circle its going to jump.
     * Recieves an integer.
     */
    public void jump(int times)
    {
        if(times > 0)
        {
            int i;
            for(i = 0; i < times; i++)
            {
                slowMoveVertical(-50);
                slowMoveVertical(50);
            }
        }
    }
    
    
    /**
     * Makes the circle vibrate.
     */
    public void vibrate()
    {
        int i, times;
        times = 30;
        for(i = 0; i < times; i++)
        {
            slowMoveHorizontal(-2);
            slowMoveHorizontal(2);
        }
    }
    
    
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    

    public void makeInvisible(){
        erase();
        isVisible = false;
    }

    private void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, 
                new Ellipse2D.Double(xPosition, yPosition, 
                diameter, diameter));
            canvas.wait(10);
        }
    }

    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    /**
     * Move the circle a few pixels to the right.
     */
    public void moveRight(){
        moveHorizontal(20);
    }

    /**
     * Move the circle a few pixels to the left.
     */
    public void moveLeft(){
        moveHorizontal(-20);
    }

    /**
     * Move the circle a few pixels up.
     */
    public void moveUp(){
        moveVertical(-20);
    }

    /**
     * Move the circle a few pixels down.
     */
    public void moveDown(){
        moveVertical(20);
    }

    /**
     * Move the circle horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the circle vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance){
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the circle horizontally.
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the circle vertically
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        }else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size.
     * @param newDiameter the new size (in pixels). Size must be >=0.
     */
    public void changeSize(int newDiameter){
        erase();
        diameter = newDiameter;
        draw();
    }

    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        draw();
    }



}
