

/**
 * 
 * 
 * @author (Tomas Marin A, Juan Vera) 
 * @version (a version number or a date)
 */

import java.util.TreeSet;
import javafx.util.Pair;


public class Nodos
{
    public static Nodos izq;
    public static Nodos der;
    public static int alturaI;
    public static int alturaD;
    public  static Pair<Integer, String>val;
    static proyecto pro = new proyecto();

    /**
     * Constructor de la clase nodo
     * 
     * @param Pareja con la mejor columna y la condicion que lo hace
     */
    public Nodos(Pair<Integer, String> val){
        this.val = val;
    }

    /**
     * Crea el arbol de decicion 
     * 
     * @param m matriz con la cual se realizara el arbol.
     * @param alturaIz altura del arbol por elñ lado de la izquierda
     * @param alturaDe altura del arbol por derecha
     * 
     * @return el arbol 
     */
    public static Nodos crearArbol(String[][] m, int alturaIz, int alturaDe){
        Nodos node = new Nodos(MejorvalyVar1(m));

        int columnas = m.length;
        int var = 11;

        if((alturaIz + alturaDe) > var){
            return null;
        }

        if (columnas > 1) {
            String[][] Der = pro.positivos(m, MejorvalyVar3(m), MejorvalyVar2(m));
            String[][] Izq = pro.negativos(m, MejorvalyVar3(m), MejorvalyVar2(m)); 

            if (Der.length > 0){
                Nodos.der = crearArbol(Der, alturaIz, alturaDe + 1);
            }
            if (Der.length > 0){
                Nodos.izq = crearArbol(Izq, alturaIz + 1, alturaDe);
            }
        }

        return node;
    }

    /**
     * Crea una pareja de la columna de la mejor impureza y su valor
     * 
     * @param m es la matriz del archivo a procesar
     * 
     * @return la pareja con la columna y el valor
     */
    public static Pair<Integer,String> MejorvalyVar1(String[][] m){
        float MenorTotal = 1;
        String MejorTotal = "";
        int posMejVal = -1;

        for (int columna = 0; columna < m.length -1; columna++){
            TreeSet<String> valores = pro.enElConjuntoDePosiblesValores(m, columna);

            for (String unValor : valores){
                String[][] p = pro.positivos(m, unValor, columna);
                String[][] n = pro.negativos(m, unValor,columna);
                float ImpuPonde = pro.ImpurezaP(p, n);

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

    /**
     * Da el numero de la columna que tiene la mejor condicion 
     * 
     * @param m es la matriz del archivo a procesar
     * 
     * @return el valor de la columna 
     */
    public static int MejorvalyVar2(String[][] m){
        float MenorTotal = 1;
        String MejorTotal = "";
        int posMejVal = -1;

        for (int columna = 0; columna < m[0].length - 1; columna++){
            TreeSet<String> valores = pro.enElConjuntoDePosiblesValores(m, columna);

            for (String unValor : valores){
                String[][] p = pro.positivos(m, unValor, columna);
                String[][] n = pro.negativos(m, unValor,columna);

                float ImpuPonde = pro.ImpurezaP(p, n);

                if (ImpuPonde < MenorTotal){
                    MenorTotal = ImpuPonde;
                    MejorTotal = unValor;
                    posMejVal = columna;
                }
            }
        }

        return posMejVal;
    }

    /**
     * Da el valor de la mejor condicion del la mejor columna
     * 
     * @param m es la matriz del archivo a procesar
     * 
     * @return el valor de la mejor condicion del la mejor columna
     */
    public static String MejorvalyVar3(String[][] m){
        float MenorTotal = 1;
        String MejorTotal = "";
        int posMejVal = -1;

        for (int columna = 0; columna < m[0].length - 1; columna++){
            TreeSet<String> valores = pro.enElConjuntoDePosiblesValores(m, columna);

            for (String unValor : valores){
                String[][] p = pro.positivos(m, unValor, columna);
                String[][] n = pro.negativos(m, unValor,columna);
                float ImpuPonde = pro.ImpurezaP(p, n);

                if (ImpuPonde < MenorTotal){
                    MenorTotal = ImpuPonde;
                    MejorTotal = unValor;
                    posMejVal = columna;
                }
            }
        }

        return MejorTotal;
    }

    /**
     * Muestra true o false dependiendo de si el estudiante tendra exito o no
     * 
     * @param Nodos Arbol con el cual se va ha validar la informacicon 
     * @param m es la matriz del archivo a procesar
     * 
     * @return true o false dependiendo si el estudiante que se ingreso va a tener exito o no
     */
    public static boolean RevisarArbol(Nodos nodos,String[] m){
        int Key = nodos.val.getKey();
        String value = nodos.val.getValue();

        if(m[Key].equals(value)){
            if(nodos.der == null){
                return true;
            }else{
                RevisarArbol(nodos.der, m);
            }

            if(nodos.izq == null){
                return false;
            }else{
                return RevisarArbol(nodos.izq, m);

            }

        }

        if(nodos == null){
            return false;
        }
        else if(value == m[Key]){
            if(nodos.der == null){
                return true;
            }else{
                if(nodos.der.der == null && nodos.der.izq == null){
                    return true;
                }
                else{
                    return RevisarArbol(nodos.der, m);
                }       
            }
        } else{    
            if(nodos.izq == null){
                return false;
            }else{
                if(nodos.izq.izq == null && nodos.izq.der == null){
                    return false;
                }
                else{
                    return false;
                    //return RevisarArbol(nodos.izq, m);
                }                
            }
        }

    }

    /**
     * Muestra 1 o 0 dependiendo de si el estudiante tendra exito o no
     * 
     * @param Nodos Arbol con el cual se va ha validar la informacicon 
     * @param m es la matriz del archivo a procesar
     * 
     * @return 1 o 0 dependiendo si el estudiante que se ingreso va a tener exito o no
     */
    public static int RevisarArbol1(Nodos nodos,String[] m){
        int Key = nodos.val.getKey();
        String value = nodos.val.getValue();

        if(m[Key].equals(value)){
            if(nodos.der == null){
                return 1;
            }else{
                RevisarArbol1(nodos.der, m);
            }

            if(nodos.izq == null){
                return 0;
            }else{
                RevisarArbol1(nodos.izq, m);

            }

        }

        if(nodos == null){
            return 0;
        }
        else if(value == m[Key]){
            if(nodos.der == null){
                return 1;
            }else{
                if(nodos.der.der == null && nodos.der.izq == null){
                    return 1;
                }
                else{
                    RevisarArbol1(nodos.der, m);
                }       
            }
        } else{    
            if(nodos.izq == null){
                return 0;
            }else{
                if(nodos.izq.izq == null && nodos.izq.der == null){
                    return 0;
                }
                else{
                    return 0;
                    //RevisarArbol1(nodos.izq, m);
                }                
            }
        }
        return 1;
    }
}

