import java.util.TreeSet;
import javafx.util.Pair;
/**
 * 
 * 
 * @author (Tomas Marin A, Juan Vera) 
 * @version (a version number or a date)
 */
public class Nodos
{
    public static Nodos izq;
    public static Nodos der;
    public static int alturaI;
    public static int alturaD;
    public  static Pair<Integer, String>val;
    static proyecto pro = new proyecto();

    public Nodos(Pair<Integer, String> val){
        this.val = val;
    }

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
