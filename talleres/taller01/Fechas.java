import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Fechas {
    
    //Hicimos esta clase para que ordenara fechas de la mas vieja a la mas nueva.
    //complemento segundo punto 
    
   public static void main (String[] args) {
       
      List<String> fecha = new ArrayList<String>();
      
      fecha.add("2020-07-26");
      fecha.add("2020-03-25");
      fecha.add("2019-08-27");
      fecha.add("2020-03-26");
      fecha.add("1999-06-29");
      fecha.add("2020-02-26"); 
      fecha.add("2003-04-21");
      fecha.add("2014-10-24");
      fecha.add("2014-10-23");
      
      System.out.println("Antes : "+ fecha);
      
      Collections.sort(fecha);
      
      System.out.println(); 
      System.out.println("Despues : "+ fecha);
   }
}
