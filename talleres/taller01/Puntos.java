
/**
 * Write a description of class g here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puntos
{
    // instance variables - replace the example below with your own
    private int x1;
    private int y1;
    private int y2;
    private int x2;

    /**
     * Constructor for objects of class g
     */
    public Puntos(int x1, int x2, int y1, int y2)
    {
        // initialise instance variables
        this.x1 = x1;
        this.y1 = y1;
        this.y2= y2;
        this.x2 = x2;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
   public String Pendiente(){
       
       int dy = (y2-y1);
       int dx = (x2-x1);
       int pendiente = dx/dy;
       String p = dy +" / "+ dx;
    
       return p;
   }
}
