import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;


/**
 * Write a description of class Molecule here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Molecule
{
    // instance variables - replace the example below with your own
    private int x = 0;
    private int y = 0;
    private Rectangle rectangle = new Rectangle();
    private Rectangle rectangle1 = new Rectangle();
    private List <String> conectors = new ArrayList<>();
    private List<Rectangle> rectangles = new ArrayList<>();
    private List<Triangle> triangles = new ArrayList<>();
    private List<Circle> circles = new ArrayList<>();
    private boolean isVisible;
    
    // miniciclo 1 
    public Molecule(String[] conectorss)
    {
        // constructor mo tiene retorno 
        // creacion rectangulo negro 
        isVisible = false;
        
        for (int i = 0; i < conectorss.length; i++){
            conectors.add(conectorss[i]);
        }
        createShapes();
    }
    
    public String getConnector(int position){
        if (position == 12 ){
            return conectors.get(0);
        }
        else if (position == 3 ){
            return conectors.get(1);
        }
        else if (position == 6 ){
            return conectors.get(2);
        }
        else if (position == 9 ){
            return conectors.get(3);
        }
        return null; 
    }
    
    // miniciclo 2 
    public Molecule (){
        List <String> conectorsList = Arrays.asList("A+","A-","B+","B-","C+",
        "C-","D+","D-","E+","E-","F+","F-","G+","G-","00","**");
        Random random = new Random();
        for (int i = 0; i < 4; i++){
            conectors.add(conectorsList.get(random.nextInt(conectorsList.size())));
        }
        // constructor no tiene retorno 
        // creacion rectangulo negro 
        isVisible = false;
        createShapes();
    }
    
    private void createShapes(){
        rectangle.changeSize(150, 150);
        rectangle.changeColor("black");
        rectangle.movePosition(x, y);
        // creacion rectangulo blanco 
        rectangle1.changeSize(140, 140);
        rectangle1.changeColor("white");
        rectangle1.movePosition(x, y);
        rectangle1.moveHorizontal(4);
        rectangle1.moveVertical(4);
        String color = "";
        rectangles = new ArrayList<>();
        triangles = new ArrayList<>();
        circles = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            if (conectors.get(i).charAt(0)=='A'){
                color = "yellow"; 
            }
            else if (conectors.get(i).charAt(0)=='B'){
                color = "blue"; 
            }
            else if (conectors.get(i).charAt(0)=='C'){
                color = "green"; 
            }
            else if (conectors.get(i).charAt(0)=='D'){
                color = "black"; 
            }
            else if (conectors.get(i).charAt(0)=='E'){
                color = "magenta"; 
            }
            else if (conectors.get(i).charAt(0)=='F'){
                color = "red"; 
            }
            else if (conectors.get(i).charAt(0)=='G'){
                color = "pink";    
            }
            else if (conectors.get(i).equals("00")){
                color = "orange"; 
            }
            else if (conectors.get(i).equals("**")){
                color = "gray"; 
            }
            
            
            if (conectors.get(i).charAt(1) == '+'){
                Rectangle rectangle3 = new Rectangle();
                rectangle3.changeColor(color);
                rectangle3.changeSize(20, 20);
                rectangle3.movePosition(x,y);
                if (i == 0){
                    rectangle3.moveHorizontal(60);
                    rectangle3.moveVertical(5);
                }
                else if (i == 1){
                    rectangle3.moveHorizontal(120);
                    rectangle3.moveVertical(60);
                }
                else if (i == 2){
                    rectangle3.moveHorizontal(60);
                    rectangle3.moveVertical(120);
                }
                else if (i == 3){
                    rectangle3.moveHorizontal(5);
                    rectangle3.moveVertical(60);
                }
                rectangles.add(rectangle3);   
            }
            
            // acomodar los triagulos pos 
            if (conectors.get(i).charAt(1) == '-'){
                Triangle triangle1 = new Triangle();
                triangle1.changeColor(color);
                triangle1.changeSize(15, 20);
                triangle1.movePosition(x, y);
                if (i == 0){
                    triangle1.moveHorizontal(60);
                    triangle1.moveVertical(5);
                }
                else if (i == 1){
                    triangle1.moveHorizontal(100);
                    triangle1.moveVertical(70);
                }
                else if (i == 2){
                    triangle1.moveHorizontal(70);
                    triangle1.moveVertical(100);
                }
                else if (i == 3){
                    triangle1.moveVertical(70);
                }
                triangles.add(triangle1);
            }
            
            if (conectors.get(i).equals("00") || conectors.get(i).equals("**")){
                Circle circle1 = new Circle();
                circle1.changeColor(color);
                circle1.changeSize(20);
                circle1.movePosition(x,y);
                if (i == 0){
                    circle1.moveHorizontal(60);
                    circle1.moveVertical(5);
                }
                else if (i == 1){
                    circle1.moveHorizontal(120);
                    circle1.moveVertical(60);
                }
                else if (i == 2){
                    circle1.moveHorizontal(60);
                    circle1.moveVertical(120);
                }
                else if (i == 3){
                    circle1.moveHorizontal(5);
                    circle1.moveVertical(60);
                }
                circles.add(circle1);   
            }
        }    


    }
    
    public void change (){
        List <String> conectorsList = Arrays.asList("A+","A-","B+","B-","C+",
        "C-","D+","D-","E+","E-","F+","F-","G+","G-");
        for (int i = 0; i < 4; i++){
            if (! (conectors.get(i).equals("00") || conectors.get(i).equals("**"))){ 
                int pos = conectorsList.indexOf(conectors.get(i));
                if (pos + 2 >= conectorsList.size()){
                    pos = pos - conectorsList.size();             
                }
                conectors.set(i,conectorsList.get(pos + 2));   
            }
        }
    }
    
    // miniciclo 3
    public void makeVisible(){
        isVisible = true;
        createShapes();
        rectangle.makeVisible();
        rectangle1.makeVisible();
        for (Rectangle i: rectangles){
            i.makeInvisible();
            i.makeVisible();  
        }
        
        for (Triangle i: triangles){
            i.makeInvisible();
            i.makeVisible();
        }
        
        for (Circle i: circles){
            i.makeInvisible();
            i.makeVisible();
        }
    }
    
    public void makeInvisible(){
        isVisible = false;
        rectangle.makeInvisible();
        rectangle1.makeInvisible();
        for (Rectangle i: rectangles){
            i.makeInvisible();  
        }
        
        for (Triangle i: triangles){
            i.makeInvisible();
        }
            
        for (Circle i: circles){
            i.makeInvisible();
        }
    }
    
    // miniciclo 4 
    public void reflect(){
        String temporalCon = conectors.get(1);
        conectors.set(1, conectors.get(3));
        conectors.set(3, temporalCon);
        if (isVisible){
            makeInvisible();
            makeVisible();            
        }
    }
    
    public void rotate(){
        String tempc1 = conectors.get(0);
        String tempc2 = conectors.get(1);
        String tempc3 = conectors.get(2);
        String tempc4 = conectors.get(3);
        // sebs mode
        //conectors = Arrays.asList(tempc4, tempc1, tempc2, tempc3);
        conectors.set(0, tempc4);
        conectors.set(1, tempc1);
        conectors.set(2, tempc2);
        conectors.set(3, tempc3);
        if (isVisible){
            makeInvisible();
            makeVisible();            
        }        
    }
    
    public void moveTo(int x , int y){
        this.x = x;
        this.y = y;
        rectangle.moveHorizontal(x);
        rectangle.moveVertical(y);
        rectangle1.moveHorizontal(x);
        rectangle1.moveVertical(y);
        for (Rectangle i: rectangles){
            i.moveHorizontal(x);  
            i.moveVertical(y);
        }
        
        for (Triangle i: triangles){
            i.moveHorizontal(x);  
            i.moveVertical(y);
        }
        
        for (Circle i: circles){
            i.moveHorizontal(x);  
            i.moveVertical(y);
        }        
        
        if (isVisible){
            makeInvisible();
            makeVisible();            
        }        
    }
}