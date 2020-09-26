
/**
 * Write a description of class Nevera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nevera
{
    // instance variables - replace the example below with your own
    private int codigo;
    private String marca;
    public int getCodigo()   {
        return codigo;
    }

    public String getMarca() {
        return marca; 
    }

    public Nevera(int c, String m){
        codigo = c; 
        marca = m;
    }
    
    public String texto(){
        return "Nevera :"+ "Codigo :"+ codigo+ ", marca:"+ marca;
    }
}
