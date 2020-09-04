
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase Taller6 tiene la intención de representar dos ejercicios opcionales
 * sea hace uso de las clases ya implementadas "ArrayList" y "Scanner"
 * 
 * Para más información de las clases:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html"> Ver documentacion ArrayList </a>
 * 
 * @author 
 * @version 1
 */
public class Taller6 {

    /**
     * Se puede leer los elementos por consola con la ayuda de la clase index.
     * luego solo se agregan a un objeto arraylist y se imprime.
     * el arreglo tiene que estar de forma inversa
     * ejemplo, para las entras 1 , 2 , 6, -1
     * el arreglo tendría este orden [ 6, 2, 1].
     * @return un arraylist con todos los elementos ingresados de forma invertida
     */
    public static ArrayList<Integer> opcinal2 (){
        
        ArrayList<Integer> array = new ArrayList<>();
        Scanner to = new Scanner(System.in);
        int n = to.nextInt();
        while (n != -1 ) {
            array.add(n);
            n = to.nextInt();
        }
        
        ArrayList<Integer> arreglo = new ArrayList<>();
        
        for(int i = 0; i < array.size() ; i++) {
            arreglo.add(array.get(array.size()-1-i));
        }
        return arreglo;
    }

    /**
     * @param n el numero hasta el cual se llevara acabo el patrón siguiente
     * vamos a implementar un nuevo nuevo a la vez no antes de haber 
     * contado desde el inicio ejemplo n=4 entonces el arreglo sería
     * [ 1,1,2,1,2,3,1,2,3,4] de modo que siempre que se ingresa uno nuevo
     * comienza la cuenta desde 1.
     * @return un arraylist con todos los elementos ingresados
     */
    public static ArrayList<Integer> opcinal3 (int n){

        ArrayList<Integer> secuencia = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                secuencia.add(j);
            }
        }

        return secuencia;

    }
}
