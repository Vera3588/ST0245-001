import java.io.*;
import java.io.FileReader; 
import java.util.ArrayList; 
public class ObtDatos{
    public static void main(String[] args) {
        File archivo = null;
        FileReader lectorA = null;
        BufferedReader lectorB = null;
        try {
            archivo = new File("datos.csv"); 
            lectorA = new FileReader(archivo.toString());
            lectorB = new BufferedReader(lectorA);
            String linea;
            String separador = ";"; 

            String matriz[][] = new String[5001][78]; 

            int numlinea=0;

            while (((linea = lectorB.readLine()) != null)) {

                String a[]=linea.split(separador);

                for (int l = 0; l < a.length; l++) {
                    matriz[numlinea][l] = a[l];
                }
                numlinea++;
            }
            System.out.println("MATRIZ");
            System.out.println("------");
            for (int filas = 0; filas < matriz.length; filas++) {
                for (int colum = 0; colum < matriz[filas].length; colum++) {
                    System.out.print(matriz[filas][colum]+" | ");
                }
                System.out.println(" | ");   
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
