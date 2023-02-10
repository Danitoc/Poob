
/**
 * Write a description of class Molecule here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Molecule
{
    // instance variables - replace the example below with your own
    private int x;
    private Rectangle rectangle = new Rectangle();
    private Rectangle rectangle1 = new Rectangle();
    
    public Molecule(String[] conectors)
    {
        // creacion rectangulo negro 
        rectangle.makeVisible();
        rectangle.changeSize(150, 150);
        rectangle.changeColor("black");
        // creacion rectangulo blanco 
        rectangle1.makeVisible();
        rectangle1.changeSize(140, 140);
        rectangle1.changeColor("white");
        rectangle1.moveHorizontal(4);
        rectangle1.moveVertical(4);
        
    }
    
    public void moveMolecule(int x , int y)
    {
         rectangle.moveHorizontal(x);
         rectangle.moveVertical(y);
         rectangle1.moveHorizontal(x);
         rectangle1.moveVertical(y);
    }
    
    /**
     * Constructor for objects of class Molecule
     */
    public Molecule()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
