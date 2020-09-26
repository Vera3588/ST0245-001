
/**
 * Write a description of class Solicitud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Solicitud
{
    // instance variables - replace the example below with your own
    String primera;
    int numero;
    
    public Solicitud(String primera, int numero){
        this.primera = primera;
        this.numero = numero;
    }
    
    public String texto(){
        return "Solicitud: "+" Local ="+ primera +" -> "+ "cantidad= "+  numero;
    }
    
}
