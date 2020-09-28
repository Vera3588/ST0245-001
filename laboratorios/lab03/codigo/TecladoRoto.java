/**
 * Write a description of class n here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class TecladoRoto{
    public static void teclado(String a){
        LinkedList<Character> texto = new LinkedList <>();
        int cont = 0;

        for(char l : a.toCharArray()){
            if(l == '['){
                cont = 0;
            }else if(l == ']'){
                cont = texto.size();
            }else
                texto.add(cont++, l);
        }

        StringBuilder t = new StringBuilder();
        for(char l : texto)
            t.append(l);

        System.out.println(t.toString()); 
    }
}