import java.io.*;
import java.io.FileReader; 
import java.util.ArrayList; 
import java.lang.Math;
import java.util.TreeSet;
import javafx.util.Pair;
import javax.crypto.spec.PSource;
import java.awt.desktop.SystemEventListener;

public class proyecto{
    public static void main(String[] args) {
        File archivo = null;
        FileReader lectorA = null;
        BufferedReader lectorB = null;

        try {
            archivo = new File("lite.csv"); 
            lectorA = new FileReader(archivo.toString());
            lectorB = new BufferedReader(lectorA);
            String linea;
            String separador = ";"; 
            String[][] matriz = new String[16][78]; 

            int numlinea=0;
            while (((linea = lectorB.readLine()) != null)) {
                String a[]=linea.split(separador);
                for (int l = 0; l < a.length; l++) {
                    matriz[numlinea][l] = a[l];
                }
                numlinea++;
            }
            System.out.println("MATRIZ");

            int filas = 0;
            /*for ( filas = 0; filas < matriz.length; filas++) {
            for (int colum = 0; colum < matriz[filas].length; colum++) {
            System.out.print(matriz[filas][colum]+" | ");
            }
            System.out.println("  ");   
            }*/

            System.out.println("\nPruebas");

            int cont0 = 0; int cont1 = 0;
            for ( filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][77].equals("0")){
                        cont0++;
                    }
                    else{
                        cont1++;
                    }
                }
            }
            System.out.println("-------------------------------");

            long TInicio, TFin, tiempo; 
            TInicio = System.currentTimeMillis();

            float impurezaGini = impurezaDatos(matriz);
            System.out.println("impureza Gini exito = "+ impurezaGini);

            System.out.println("-------------------------------");

            /*for ( filas = 0; filas < matriz.length; filas++) {
            for (int colum = 77; colum < matriz[filas].length; colum++) {
            System.out.print(matriz[filas][4]+" | ");
            }
            System.out.println("  ");   
            }*/

            /*for ( filas = 0; filas < positivos(matriz,"NO", 1).length; filas++) {
            for (int colum = 0; colum < positivos(matriz,"NO", 1)[filas].length; colum++) {
            System.out.print(positivos(matriz,"NO", 1)[filas][colum]+" | ");
            }
            System.out.println("  ");   
            }*/

            System.out.println("ALGUNAS PRUEBAS DE GINI PONDERADO\n");

            float Impu = ImpurezaP(positivos(matriz,"1", 77), negativos(matriz, "0", 77));
            //System.out.println("impu ponderada 77: "+ Impu);

            float Impu2 = ImpurezaP(positivos(matriz,"NO", 1), negativos(matriz, "", 1));
            System.out.println("impu ponderada  1: "+ Impu2);

            float Impu3 = ImpurezaP(positivos(matriz,"No", 3), negativos(matriz, "", 3));
            System.out.println("impu ponderada 3: "+ Impu3);

            float Impu4 = ImpurezaP(positivos(matriz,"", 4), negativos(matriz, "No", 4));
            System.out.println("impu ponderada 4: "+ Impu4);

            float Impu17 = ImpurezaP(positivos(matriz,"M", 17), negativos(matriz, "F", 17));
            System.out.println("impu ponderada nueva 1: "+ Impu17);

            float Impu37= ImpurezaP(positivos(matriz,"Si", 38), negativos(matriz, "No", 38));
            System.out.println("impu ponderada fami_tienemicroondas: "+ Impu37);

            float Impu40= ImpurezaP(positivos(matriz,"Si", 40), negativos(matriz, "No", 40));
            System.out.println("impu ponderada fami_tieneautomovil.1: "+ Impu37);   

            float total = MejorvalyVar(matriz);
            System.out.println("Mejor Ipureza en general: "+ total);//mejor impureza ponderada

            Pair ColumVal = MejorvalyVar1(matriz);
            System.out.println("Mejor Ipureza columna + valor : "+ ColumVal);//Pair de columna y valor    

            Nodos nodo = new Nodos(MejorvalyVar1(matriz));
            nodo.crearArbol(matriz, 5, 5);//creaccion arbol

            for(int i = 1; i < matriz.length; i++){
                System.out.println(nodo.RevisarArbol1(nodo, matriz[i]));
            }//Analizador estudiantes

            int verdaderosPositivos = 0;
            int falsosPositivos = 0;
            int verdaderosNegativos = 0;
            int falsosNegativos = 0;
            for(int i = 0; i < matriz.length; i++){
                if(matriz[i][77] == "1" && nodo.RevisarArbol(nodo, matriz[i]) == true){
                    verdaderosPositivos += 1;
                }
                else if(matriz[i][77] == "1" && nodo.RevisarArbol(nodo, matriz[i]) == false){
                    falsosPositivos+= 1;
                }
                else if(matriz[i][77] == "0" && nodo.RevisarArbol(nodo, matriz[i]) == true){
                    verdaderosNegativos+= 1;
                }
                else if(matriz[i][77] == "0" && nodo.RevisarArbol(nodo, matriz[i]) == false){
                    falsosNegativos+= 1;
                } 
            }//presicion, exactitud y sensibilidad
            
            System.out.println("vp: "+verdaderosPositivos+"\n"+
                "fp: "+falsosPositivos+"\n"+
                "vn: "+verdaderosNegativos+"\n"+
                "fn: "+falsosNegativos+"\n"
            );

            TFin = System.currentTimeMillis(); 
            tiempo = TFin - TInicio; 
            System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);

            //memoria en una "bola o nodo del arbol" O(N*M*NumeroBolas) 
            //funcion que resiva m,n = 2^m   complejidad es O(N*M*2^M) es 2^m porque va de a dos porque cada piso del arbol tiene minimo 2 y por eso 2^m
            //En tiempo O(IporNodo*n)
            //IporNodo = 2^m

            System.out.println("-------------------------------");
        }catch (IOException e){
            System.out.println(e);
        }

    }

    public static float impurezaDatos(String[][] m){
        float exito = 0;
        float noExito = 0;
        for(int fila = 0; fila <m.length; fila++){
            if(m.length == 0){
                return 0.5f;
            }else if(m[fila][m[0].length-1].equals("1")){
                exito++;
            }else if(m[fila][m[0].length-1].equals("0")){
                noExito++;
            }   
        }

        float mediaSi = exito/(m.length-1);
        float mediaNo = noExito/(m.length-1);
        float impureza = 1 - ((mediaSi * mediaSi) + (mediaNo * mediaNo));
        return impureza;
    }

    public static float ImpurezaPonderada(String[][] m, int posVariable, String valor){
        int Cumplen = 0;
        for (int fila = 0; fila < m.length; fila++){
            if (m[fila][posVariable].equals(valor)){
                Cumplen++;
            }
        }
        int NoCumplen = m.length - Cumplen;

        String[][] VarIgual = new String[Cumplen][m[0].length];
        String[][] VarDif = new String[NoCumplen][m[0].length];

        int fila = 0;
        int filaN1 = 0;
        int filaN2 = 0;
        while(fila < m.length)
        {
            if(m[fila][posVariable].equals(valor)){
                VarIgual[filaN1] = m[fila];
                fila++;
                filaN1++;
            }else{
                VarDif[filaN2] = m[fila];
                fila++;
                filaN2++;  
            }
        }

        float totaldatos= fila; 
        float impurezaPonderada = (filaN1*VarIgual.length + (filaN2-1)*(VarDif.length-1)) /  (VarIgual.length + (VarDif.length-1));// Hacer impurezas

        return impurezaPonderada;
    }

    public static TreeSet<String> enElConjuntoDePosiblesValores(String[][] m, int j){
        TreeSet<String> conjunto = new TreeSet<String>();
        for (int i = 0; i < m.length; i++)
            conjunto.add(m[i][j]);

        return conjunto;
    }

    public static Pair<Integer,String> MejorvalyVar1(String[][] m){
        float MenorTotal = 1;
        String MejorTotal = "";
        int posMejVal = -1;

        for (int columna = 0; columna < m[0].length - 1; columna++){
            TreeSet<String> valores = enElConjuntoDePosiblesValores(m, columna);

            for (String unValor : valores){
                String[][] p = positivos(m, unValor, columna);
                String[][] n = negativos(m, unValor,columna);
                float ImpuPonde = ImpurezaP(p, n);

                if (ImpuPonde < MenorTotal){
                    MenorTotal = ImpuPonde;
                    MejorTotal = unValor;
                    posMejVal = columna;
                }
            }
        }

        Pair<Integer,String> respuesta = new Pair(posMejVal, MejorTotal);
        return respuesta;
    }

    public static float MejorvalyVar(String[][] m){
        float MenorTotal = 1;
        String MejorTotal = "";
        int posMejVal = -1;
        for (int columna = 0; columna < m[0].length - 1; columna++){
            TreeSet<String> valores = enElConjuntoDePosiblesValores(m, columna);

            for (String unValor : valores){
                String[][] p = positivos(m, unValor, columna);
                String[][] n = negativos(m, unValor,columna);
                float ImpuPonde = ImpurezaP(p, n);

                if (ImpuPonde < MenorTotal){
                    MenorTotal = ImpuPonde;
                    MejorTotal = unValor;
                    posMejVal = columna;
                }
            }
        }

        float  respuesta = Math.min(MenorTotal, posMejVal);
        return respuesta;
    }

    public static float hacerloParaTodasLasColumnasYTodosLosValores(String m[][]){
        float elMejorGiniDeGinis = 1;
        for (int j = 0; j < m[0].length - 1; j++){
            for (String valor: enElConjuntoDePosiblesValores(m,j)){
                String[][] p = positivos(m, valor, j);
                String[][] n = negativos(m, valor, j);
                /* for(String number : enElConjuntoDePosiblesValores(m,j)){
                System.out.println(number);
                }*/ 

                // System.out.println("Positivos "+ p.length);
                // System.out.println("Negativos "+ n.length);

                float giniDelExito = ImpurezaP(p, n);
                elMejorGiniDeGinis = Math.min(elMejorGiniDeGinis, giniDelExito);
            }
        }
        return elMejorGiniDeGinis;
    }

    public static float sacarElGiniDeUnaMatriz(String[][] m){ 
        int enCuantasFilasElExitoEsFalsoEsDecir0 = cuantosSonPositivos(m,"0", m[0].length-1);
        int enCuantasFilasElExitoEsVerdaderoEsDecir1 = m.length - enCuantasFilasElExitoEsFalsoEsDecir0;
        //float gini = 1 - Math.pow(enCuantasFilasElExitoEsFalsoEsDecir0/m.length,2) - Math.pow(enCuantasFilasElExitoEsVerdaderoEsDecir1/m.length,2);
        float gini = 0.8f;
        return gini; 
    }

    public static int cuantosSonPositivos(String m[][], String valor, int pos){
        int cuantosSon = 0;

        for(int i = 0; i < m.length; i++){
            if(m[i][pos].equals(valor)){
                cuantosSon++;
            }
        }

        return cuantosSon;
    }

    public static String[][] positivos(String m[][], String valor, int pos){
        String y[][] = new String[cuantosSonPositivos(m, valor, pos)][m[0].length];
        int contador = 0;      

        for(int i = 0; i < m.length; i++){
            if(m[i][pos].equals(valor)){
                y[contador++] = m[i];
            }
        }

        return y;
    }

    public static String[][] negativos(String m[][], String valor, int pos){        
        String y[][] = new String[m.length - cuantosSonPositivos(m,valor,pos)][m[0].length];
        int contador = 0;
        for(int i = 0; i < m.length; i++)
            if(!m[i][pos].equals(valor))
                y[contador++] = m[i];

        return y;
    }

    public static float ImpurezaP(String Der[][], String Izq[][]){
        float Cumple = impurezaDatos(Der);
        float noCumple = impurezaDatos(Izq);

        float Ponderado = (Cumple * Der.length + noCumple * Izq.length) /  (Der.length + Izq.length);

        return Ponderado;
    }

}

