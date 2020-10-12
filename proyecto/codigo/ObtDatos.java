import java.io.*;
import java.io.FileReader; 
import java.util.ArrayList; 
import java.lang.Math;
public class ObtDatos{
    public static void main(String[] args) {
        File archivo = null;
        FileReader lectorA = null;
        BufferedReader lectorB = null;
        try {
            archivo = new File("vera.csv"); 
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
            int filas = 0;
            /*for ( filas = 0; filas < matriz.length; filas++) {
            for (int colum = 77; colum < matriz[filas].length; colum++) {
            System.out.print(matriz[filas][77]+" | ");
            }
            System.out.println("  ");   
            }*/
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
            System.out.println("0: "+ cont0+"\n1: "+cont1);
            float suma = cont0 + cont1;
            float p0= cont0/suma;
            float p1= cont1/suma;        
            impureza(p0, p1);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(cont0, cont1, p0, p1)+ "\n");
            /*for ( filas = 0; filas < matriz.length; filas++) {
            for (int colum = 77; colum < matriz[filas].length; colum++) {
            System.out.print(matriz[filas][1]+" | ");
            }
            System.out.println("  ");   
            }*/
            int IZColumsi1 = 0;    int DEColumsi1 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][1].equals("Si")){
                        DEColumsi1++;
                    }
                    else{
                        IZColumsi1++;
                    }
                }
            }
            System.out.println("Estudio exterior 'si' por derecha : "+ DEColumsi1 + " Por Izquierda : "+ IZColumsi1);
            impureza(DEColumsi1, IZColumsi1);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumsi1, IZColumsi1, p0(DEColumsi1,IZColumsi1), p1(IZColumsi1, DEColumsi1))+ "\n");

            int IZColumno1 = 0;    int DEColumno1 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][1].equals("NO")){
                        DEColumno1++;
                    }
                    else{
                        IZColumno1++;
                    }
                }
            }
            System.out.println("Estudio exterior 'no' por derecha : "+ DEColumno1 + " Por Izquierda : "+ IZColumno1);
            impureza(DEColumno1, IZColumno1);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumno1, IZColumno1, p0(DEColumno1,IZColumno1), p1(IZColumno1, DEColumno1))+ "\n");

            int IZColumva1 = 0;         int DEColumva1 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][1].equals("")){
                        DEColumva1++;
                    }
                    else{
                        IZColumva1++;
                    }
                }
            }
            System.out.println("Estudio exterior ' ' por derecha : "+ DEColumva1 + " Por Izquierda : "+ IZColumva1);
            impureza(DEColumva1, IZColumva1);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumva1, IZColumva1, p0(DEColumva1,IZColumva1), p1(IZColumva1, DEColumva1))+ "\n");

            System.out.println("___________________________________________________");

            int IZColumsi3 = 0;      int DEColumsi3 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][3].equals("Si")){
                        DEColumsi3++;
                    }
                    else {
                        IZColumsi3++;
                    }                                     
                }
            }
            System.out.println("Etnias por derecha : "+ DEColumsi3 + " Por Izquierda : "+ IZColumsi3);
            impureza(DEColumsi3, IZColumsi3);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumsi3, IZColumsi3, p0(DEColumsi3,IZColumsi3), p1(IZColumsi3, DEColumsi3))+ "\n");

            int IZColumno3 = 0;      int DEColumno3 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][3].equals("No")){
                        DEColumno3++;
                    }
                    else{
                        IZColumno3++;
                    }
                }
            }
            System.out.println("Etnias por derecha : "+ DEColumno3 + " Por Izquierda : "+ IZColumno3);
            impureza(DEColumno3, IZColumno3);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumno3, IZColumno3, p0(DEColumno3,IZColumno3), p1(IZColumno3, DEColumno3))+ "\n");

            int IZColumva3 = 0;      int DEColumva3 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][3].equals("")){
                        DEColumva3++;
                    }
                    else{
                        IZColumva3++;
                    }
                }
            }
            System.out.println("Etnias por derecha : "+ DEColumva3 + " Por Izquierda : "+ IZColumva3+"\n");
            impureza(DEColumva3, IZColumva3);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumva3, IZColumva3, p0(DEColumva3,IZColumva3), p1(IZColumva3, DEColumva3))+ "\n");

            System.out.println("___________________________________________________");

            int IZColumsi4 = 0;     int DEColumsi4 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][4].equals("Si")){
                        DEColumsi4++;
                    }
                    else {
                        IZColumsi4++;
                    }
                }
            }
            System.out.println("Curso de preparacion por derecha : "+ DEColumsi4 + " Por Izquierda : "+ IZColumsi4);
            impureza(DEColumsi4, IZColumsi4);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumsi4, IZColumsi4, p0(DEColumsi4,IZColumsi4), p1(IZColumsi4, DEColumsi4))+ "\n");

            int IZColumno4 = 0;       int DEColumno4 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][4].equals("No")){
                        DEColumno4++;
                    }
                    else{
                        IZColumno4++;
                    }
                }
            }
            System.out.println("Curso de preparacion por derecha : "+ DEColumno4 + " Por Izquierda : "+ IZColumno4);
            impureza(DEColumno4, IZColumno4);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumno4, IZColumno4, p0(DEColumno4,IZColumno4), p1(IZColumno4, DEColumno4))+ "\n");

            int IZColumva4 = 0;      int DEColumva4 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][4].equals("")){
                        DEColumva4++;
                    }
                    else{
                        IZColumva4++;
                    }
                }
            }
            System.out.println("Curso de preparacion por derecha : "+ DEColumva4 + " Por Izquierda : "+ IZColumva4);
            impureza(DEColumva4, IZColumva4);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumva4, IZColumva4, p0(DEColumva4,IZColumva4), p1(IZColumva4, DEColumva4))+ "\n");

            System.out.println("___________________________________________________");

            int IZColum15 = 0;      int DEColum15 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][5].equals("No toma Curso")){
                        DEColum15++;
                    }else {
                        IZColum15++;
                    }
                }
            }
            System.out.println("estu_cursodocentesies por derecha : "+ DEColum15 + " Por Izquierda : "+ IZColum15);
            impureza(DEColum15, IZColum15);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum15, IZColum15, p0(DEColum15,IZColum15), p1(IZColum15, DEColum15))+ "\n");

            int IZColum25 = 0;       int DEColum25 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][5].equals("Entre 20 y 30 horas")){
                        DEColum25++;
                    }
                    else{
                        IZColum25++;
                    }
                }
            }
            System.out.println("estu_cursodocentesies por derecha : "+ DEColum25 + " Por Izquierda : "+ IZColum25);
            impureza(DEColum25, IZColum25);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum25, IZColum25, p0(DEColum25,IZColum25), p1(IZColum25, DEColum25))+ "\n");

            int IZColum35 = 0;      int DEColum35 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][5].equals("Mas de 30 horas")){
                        DEColum35++;
                    }
                    else{
                        IZColum35++;
                    }
                }
            }
            System.out.println("estu_cursodocentesies por derecha : "+ DEColum35 + " Por Izquierda : "+ IZColum35);
            impureza(DEColum35, IZColum35);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum35, IZColum35, p0(DEColum35,IZColum35), p1(IZColum35, DEColum35))+ "\n");

            int IZColum45 = 0;       int DEColum45 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][5].equals("Menos de 20 horas")){
                        DEColum45++;
                    }
                    else{
                        IZColum45++;
                    }
                }
            }
            System.out.println("estu_cursodocentesies por derecha : "+ DEColum45 + " Por Izquierda : "+ IZColum45);
            impureza(DEColum45, IZColum35);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum45, IZColum45, p0(DEColum45,IZColum45), p1(IZColum45, DEColum45))+ "\n");

            System.out.println("___________________________________________________");

            int IZColum16 = 0;     int DEColum16 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][6].equals("No toma Curso")){
                        DEColum16++;
                    }else {
                        IZColum16++;
                    }
                }
            }
            System.out.println("estu_cursoiesapoyoexterno por derecha : "+ DEColum16 + " Por Izquierda : "+ IZColum16);
            impureza(DEColum16, IZColum16);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum16, IZColum16, p0(DEColum16,IZColum16), p1(IZColum16, DEColum16))+ "\n");

            int IZColum26 = 0;       int DEColum26 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][6].equals("Entre 20 y 30 horas")){
                        DEColum26++;
                    }
                    else{
                        IZColum26++;
                    }
                }
            }
            System.out.println("estu_cursoiesapoyoexterno por derecha : "+ DEColum26 + " Por Izquierda : "+ IZColum26);
            impureza(DEColum26, IZColum26);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum26, IZColum26, p0(DEColum26,IZColum26), p1(IZColum26, DEColum26))+ "\n");

            int IZColum36 = 0;       int DEColum36 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][6].equals("Mas de 30 horas")){
                        DEColum36++;
                    }
                    else{
                        IZColum36++;
                    }
                }
            }
            System.out.println("estu_cursoiesapoyoexterno por derecha : "+ DEColum36 + " Por Izquierda : "+ IZColum36);
            impureza(DEColum36, IZColum36);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum36, IZColum36, p0(DEColum36,IZColum36), p1(IZColum36, DEColum36))+ "\n");

            int IZColum46 = 0;      int DEColum46 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][6].equals("Menos de 20 horas")){
                        DEColum46++;
                    }
                    else{
                        IZColum46++;
                    }
                }
            }
            System.out.println("estu_cursoiesapoyoexterno por derecha : "+ DEColum46 + " Por Izquierda : "+ IZColum46);
            impureza(DEColum46, IZColum46);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum46, IZColum46, p0(DEColum46,IZColum46), p1(IZColum46, DEColum46))+ "\n");

            System.out.println("___________________________________________________");

            int IZColum17 = 0;       int DEColum17 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][7].equals("No toma Curso")){
                        DEColum17++;
                    }else {
                        IZColum17++;
                    }
                }
            }
            System.out.println("estu_cursoiesexterna por derecha : "+ DEColum17 + " Por Izquierda : "+ IZColum17);
            impureza(DEColum17, IZColum17);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum17, IZColum17, p0(DEColum17,IZColum17), p1(IZColum17, DEColum17))+ "\n");

            int IZColum27 = 0;      int DEColum27 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][7].equals("Entre 20 y 30 horas")){
                        DEColum27++;
                    }
                    else{
                        IZColum27++;
                    }
                }
            }
            System.out.println("estu_cursoiesexterna por derecha : "+ DEColum27 + " Por Izquierda : "+ IZColum27);
            impureza(DEColum27, IZColum27);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum27, IZColum27, p0(DEColum27,IZColum27), p1(IZColum27, DEColum27))+ "\n");

            int IZColum37 = 0;       int DEColum37 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][7].equals("Mas de 30 horas")){
                        DEColum37++;
                    }
                    else{
                        IZColum37++;
                    }
                }
            }
            System.out.println("estu_cursoiesexterna por derecha : "+ DEColum37 + " Por Izquierda : "+ IZColum37);
            impureza(DEColum37, IZColum37);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum37, IZColum37, p0(DEColum37,IZColum37), p1(IZColum37, DEColum37))+ "\n");

            int IZColum47 = 0;       int DEColum47 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][7].equals("Menos de 20 horas")){
                        DEColum47++;
                    }
                    else{
                        IZColum47++;
                    }
                }
            }
            System.out.println("estu_cursoiesexterna por derecha : "+ DEColum47 + " Por Izquierda : "+ IZColum47);
            impureza(DEColum47, IZColum47);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum47, IZColum47, p0(DEColum47,IZColum47), p1(IZColum47, DEColum47))+ "\n");

            System.out.println("___________________________________________________");

            int IZColumsi8 = 0;      int DEColumsi8 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][8].equals("Si")){
                        DEColumsi8++;
                    }
                    else {
                        IZColumsi8++;
                    }
                }
            }
            System.out.println("estu_simulacrotipoicfes por derecha : "+ DEColumsi8 + " Por Izquierda : "+ IZColumsi8);
            impureza(DEColumsi8, IZColumsi8);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumsi8, IZColumsi8, p0(DEColumsi8,IZColumsi8), p1(IZColumsi8, DEColumsi8))+ "\n");

            int IZColumno8 = 0;        int DEColumno8 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][8].equals("No")){
                        DEColumno8++;
                    }
                    else{
                        IZColumno8++;
                    }
                }
            }
            System.out.println("estu_simulacrotipoicfes por derecha : "+ DEColumno8 + " Por Izquierda : "+ IZColumno8);
            impureza(DEColumno8, IZColumno8);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumno8, IZColumno8, p0(DEColumno8,IZColumno8), p1(IZColumno8, DEColumno8))+ "\n");

            int IZColumva8 = 0;      int DEColumva8 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][8].equals("")){
                        DEColumva8++;
                    }
                    else{
                        IZColumva8++;
                    }
                }
            }
            System.out.println("estu_simulacrotipoicfes por derecha : "+ DEColumva8 + " Por Izquierda : "+ IZColumva8);
            impureza(DEColumva8, IZColumva8);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumva8, IZColumva8, p0(DEColumva8,IZColumva8), p1(IZColumva8, DEColumva8))+ "\n");

            System.out.println("___________________________________________________");

            int IZ = 0;        int DE = 0;
            String conjunto[] = {"Si","No",""};
            for(filas = 0; filas<matriz.length; filas++){
                if(matriz[filas][8].equals(conjunto[0])){
                    DE++;
                }else{
                    IZ++;
                }
            }
            System.out.println("estu_simulacrotipoicfes por derecha : "+ DE + " Por Izquierda : "+ IZ);

            System.out.println("___________________________________________________");
            int IZColumsi9 = 0;      int DEColumsi9 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][9].equals("Si")){
                        DEColumsi9++;
                    }
                    else {
                        IZColumsi9++;
                    }
                }
            }
            System.out.println("estu_actividadrefuerzoareas por derecha : "+ DEColumsi9 + " Por Izquierda : "+ IZColumsi9);
            impureza(DEColumsi9, IZColumsi9);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumsi9, IZColumsi9, p0(DEColumsi9,IZColumsi9), p1(IZColumsi9, DEColumsi9))+ "\n");

            int IZColumno9 = 0;      int DEColumno9 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][9].equals("No")){
                        DEColumno9++;
                    }
                    else{
                        IZColumno9++;
                    }
                }
            }
            System.out.println("estu_actividadrefuerzoareas por derecha : "+ DEColumno9 + " Por Izquierda : "+ IZColumno9);
            impureza(DEColumno9, IZColumno9);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumno9, IZColumno9, p0(DEColumno9,IZColumno9), p1(IZColumno9, DEColumno9))+ "\n");

            int IZColumva9 = 0;       int DEColumva9 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][9].equals("")){
                        DEColumva9++;
                    }
                    else{
                        IZColumva9++;
                    }
                }
            }
            System.out.println("estu_actividadrefuerzoareas por derecha : "+ DEColumva9 + " Por Izquierda : "+ IZColumva9);
            impureza(DEColumva9, IZColumva9);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumva9, IZColumva9, p0(DEColumva9,IZColumva9), p1(IZColumva9, DEColumva9))+ "\n");

            System.out.println("___________________________________________________");

            int IZColumsi10 = 0;      int DEColumsi10 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][10].equals("Si")){
                        DEColumsi10++;
                    }
                    else {
                        IZColumsi10++;
                    }
                }
            }
            System.out.println("estu_actividadrefuerzogeneric por derecha : "+ DEColumsi10 + " Por Izquierda : "+ IZColumsi10);
            impureza(DEColumsi10, IZColumsi10);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumsi10, IZColumsi10, p0(DEColumsi10,IZColumsi10), p1(IZColumsi10, DEColumsi10))+ "\n");

            int IZColumno10 = 0;       int DEColumno10 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][10].equals("No")){
                        DEColumno10++;
                    }
                    else{
                        IZColumno10++;
                    }
                }
            }
            System.out.println("estu_actividadrefuerzogeneric por derecha : "+ DEColumno10 + " Por Izquierda : "+ IZColumno10);
            impureza(DEColumno10, IZColumno10);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumno10, IZColumno10, p0(DEColumno10,IZColumno10), p1(IZColumno10, DEColumno10))+ "\n");

            int IZColumva10 = 0;      int DEColumva10 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][10].equals("")){
                        DEColumva10++;
                    }
                    else{
                        IZColumva10++;
                    }
                }
            }
            System.out.println("estu_actividadrefuerzogeneric por derecha : "+ DEColumva10 + " Por Izquierda : "+ IZColumva10);
            impureza(DEColumva10, IZColumva10);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumva10, IZColumva10, p0(DEColumva10,IZColumva10), p1(IZColumva10, DEColumva10))+ "\n");

            System.out.println("___________________________________________________fami_trabajolaborpadre");

            int IZColum111 = 0;     int DEColum111 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Es dueño de un negocio grande, tiene un cargo de nivel directivo o gerencial")){
                        DEColum111++;
                    }else {
                        IZColum111++;
                    }
                }
            }
            System.out.println("fami_trabajolaborpadre por derecha : "+ DEColum111 + " Por Izquierda : "+ IZColum111);
            impureza(DEColum111, IZColum111);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum111, IZColum111, p0(DEColum111,IZColum111), p1(IZColum111, DEColum111))+ "\n");

            int IZColum211 = 0;     int DEColum211 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Es agricultor, pesquero o jornalero")){
                        DEColum211++;
                    }
                    else{
                        IZColum211++;
                    }
                }
            }
            System.out.println("fami_trabajolaborpadre por derecha : "+ DEColum211 + " Por Izquierda : "+ IZColum211);
            impureza(DEColum211, IZColum211);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum211, IZColum211, p0(DEColum211,IZColum211), p1(IZColum211, DEColum211))+ "\n");

            int IZColum311 = 0;     int DEColum311 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Trabaja como profesional (por ejemplo medico, abogado, ingeniero)")){
                        DEColum311++;
                    }
                    else{
                        IZColum311++;
                    }
                }
            }
            System.out.println("fami_trabajolaborpadre por derecha : "+ DEColum311 + " Por Izquierda : "+ IZColum311);
            impureza(DEColum311, IZColum311);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum311, IZColum311, p0(DEColum311,IZColum311), p1(IZColum311, DEColum311))+ "\n");

            int IZColum411 = 0;       int DEColum411 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Trabaja por cuenta propia (por ejemplo plomero, electricista)")){
                        DEColum411++;
                    }
                    else{
                        IZColum411++;
                    }
                }
            }
            System.out.println("fami_trabajolaborpadre por derecha : "+ DEColum411 + " Por Izquierda : "+ IZColum411);
            impureza(DEColum411, IZColum411);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum411, IZColum411, p0(DEColum411,IZColum411), p1(IZColum411, DEColum411))+ "\n");

            int IZColum511 = 0;       int DEColum511 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Trabaja como personal de limpieza, mantenimiento, seguridad o construccion")){
                        DEColum511++;
                    }else {
                        IZColum511++;
                    }
                }
            }
            System.out.println("fami_trabajolaborpadre por derecha : "+ DEColum511 + " Por Izquierda : "+ IZColum511);
            impureza(DEColum511, IZColum511);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum511, IZColum511, p0(DEColum511,IZColum511), p1(IZColum511, DEColum511))+ "\n");

            int IZColum611 = 0;         int DEColum611 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Tiene un trabajo de tipo auxiliar administrativo (por ejemplo, secretario o asistente)")){
                        DEColum611++;
                    }
                    else{
                        IZColum611++;
                    }
                }
            }
            System.out.println("fami_trabajolaborpadre por derecha : "+ DEColum611 + " Por Izquierda : "+ IZColum611);
            impureza(DEColum611, IZColum611);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum611, IZColum611, p0(DEColum611,IZColum611), p1(IZColum611, DEColum611))+ "\n");

            int IZColum711 = 0;      int DEColum711 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("No aplica")){
                        DEColum711++;
                    }
                    else{
                        IZColum711++;
                    }
                }
            }
            System.out.println("fami_trabajolaborpadre por derecha : "+ DEColum711 + " Por Izquierda : "+ IZColum711);
            impureza(DEColum711, IZColum711);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum711, IZColum711, p0(DEColum711,IZColum711), p1(IZColum711, DEColum711))+ "\n");

            int IZColum811 = 0;     int DEColum811 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Pensionado")){
                        DEColum811++;
                    }
                    else{
                        IZColum811++;
                    }
                }
            }
            System.out.println("fami_trabajolaborpadre por derecha : "+ DEColum811 + " Por Izquierda : "+ IZColum811);
            impureza(DEColum811, IZColum811);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum811, IZColum811, p0(DEColum811,IZColum811), p1(IZColum811, DEColum811))+ "\n");

            int IZColum911 = 0;      int DEColum911 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("")){
                        DEColum911++;
                    }
                    else{
                        IZColum911++;
                    }
                }
            }
            System.out.println("fami_trabajolaborpadre por derecha : "+ DEColum911 + " Por Izquierda : "+ IZColum911);
            impureza(DEColum911, IZColum911);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum911, IZColum911, p0(DEColum911,IZColum911), p1(IZColum911, DEColum911))+ "\n");

            System.out.println("___________________________________________________");

            int IZColumM111 = 0;     int DEColumM111 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Es dueño de un negocio grande, tiene un cargo de nivel directivo o gerencial")){
                        DEColumM111++;
                    }else {
                        IZColumM111++;
                    }
                }
            }
            System.out.println("fami_trabajolabormadre por derecha : "+ DEColumM111 + " Por Izquierda : "+ IZColumM111);
            impureza(DEColumM111, IZColumM111);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumM111, IZColumM111, p0(DEColumM111,IZColumM111), p1(IZColumM111, DEColumM111))+ "\n");

            int IZColumM211 = 0;      int DEColumM211 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Es agricultor, pesquero o jornalero")){
                        DEColumM211++;
                    }
                    else{
                        IZColumM211++;
                    }
                }
            }
            System.out.println("fami_trabajolabormadre por derecha : "+ DEColumM211 + " Por Izquierda : "+ IZColumM211);
            impureza(DEColumM211, IZColumM211);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumM211, IZColumM211, p0(DEColumM211,IZColumM211), p1(IZColumM211, DEColumM211))+ "\n");

            int IZColumM311 = 0;     int DEColumM311 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Trabaja como profesional (por ejemplo medico, abogado, ingeniero)")){
                        DEColumM311++;
                    }
                    else{
                        IZColumM311++;
                    }
                }
            }
            System.out.println("fami_trabajolabormadre por derecha : "+ DEColumM311 + " Por Izquierda : "+ IZColumM311);
            impureza(DEColumM311, IZColumM311);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumM311, IZColumM311, p0(DEColumM311,IZColumM311), p1(IZColumM311, DEColumM311))+ "\n");

            int IZColumM411 = 0;        int DEColumM411 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Trabaja por cuenta propia (por ejemplo plomero, electricista)")){
                        DEColumM411++;
                    }
                    else{
                        IZColumM411++;
                    }
                }
            }
            System.out.println("fami_trabajolabormadre por derecha : "+ DEColumM411 + " Por Izquierda : "+ IZColumM411);
            impureza(DEColumM411, IZColumM411);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumM411, IZColumM411, p0(DEColumM411,IZColumM411), p1(IZColumM411, DEColumM411))+ "\n");

            int IZColumM511 = 0;            int DEColumM511 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Trabaja como personal de limpieza, mantenimiento, seguridad o construccion")){
                        DEColumM511++;
                    }else {
                        IZColumM511++;
                    }
                }
            }
            System.out.println("fami_trabajolabormadre por derecha : "+ DEColumM511 + " Por Izquierda : "+ IZColumM511);
            impureza(DEColumM511, IZColumM511);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumM511, IZColumM511, p0(DEColumM511,IZColumM511), p1(IZColumM511, DEColumM511))+ "\n");

            int IZColumM611 = 0;            int DEColumM611 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Tiene un trabajo de tipo auxiliar administrativo (por ejemplo, secretario o asistente)")){
                        DEColumM611++;
                    }
                    else{
                        IZColumM611++;
                    }
                }
            }
            System.out.println("fami_trabajolabormadre por derecha : "+ DEColumM611 + " Por Izquierda : "+ IZColumM611);
            impureza(DEColumM611, IZColumM611);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumM611, IZColumM611, p0(DEColumM611,IZColumM611), p1(IZColumM611, DEColumM611))+ "\n");

            int IZColumM711 = 0;            int DEColumM711 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("No aplica")){
                        DEColumM711++;
                    }
                    else{
                        IZColumM711++;
                    }
                }
            }
            System.out.println("fami_trabajolabormadre por derecha : "+ DEColum711 + " Por Izquierda : "+ IZColum711);
            impureza(DEColumM711, IZColumM711);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumM711, IZColumM711, p0(DEColumM711,IZColumM711), p1(IZColumM711, DEColumM711))+ "\n");

            int IZColumM811 = 0;            int DEColumM811 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("Pensionado")){
                        DEColumM811++;
                    }
                    else{
                        IZColumM811++;
                    }
                }
            }
            System.out.println("fami_trabajolabormadre por derecha : "+ DEColumM811 + " Por Izquierda : "+ IZColumM811);
            impureza(DEColumM811, IZColumM811);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumM811, IZColumM811, p0(DEColumM811,IZColumM811), p1(IZColumM811, DEColumM811))+ "\n");

            int IZColumM911 = 0;            int DEColumM911 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][11].equals("")){
                        DEColumM911++;
                    }
                    else{
                        IZColumM911++;
                    }
                }
            }
            System.out.println("fami_trabajolabormadre por derecha : "+ DEColumM911 + " Por Izquierda(12) : "+ IZColumM911);
            impureza(DEColumM911, IZColumM911);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumM911, IZColumM911, p0(DEColumM911,IZColumM911), p1(IZColumM911, DEColumM911))+ "\n");

            System.out.println("___________________________________________________");

            int IZColum113 = 0;           int DEColum113 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][13].equals("26 A 100 LIBROS")){
                        DEColum113++;
                    }
                    else {
                        IZColum113++;
                    }
                }
            }
            System.out.println("fami_numlibros por derecha : "+ DEColum113 + " Por Izquierda : "+ IZColum113);
            impureza(DEColum113, IZColum113);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum113, IZColum113, p0(DEColum113,IZColum113), p1(IZColum113, DEColum113))+ "\n");

            int IZColum213 = 0;           int DEColum213 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][13].equals("0 A 10 LIBROS")){
                        DEColum213++;
                    }
                    else{
                        IZColum213++;
                    }
                }
            }
            System.out.println("fami_numlibros por derecha : "+ DEColum213 + " Por Izquierda : "+ IZColum213);
            impureza(DEColum213, IZColum213);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum213, IZColum213, p0(DEColum213,IZColum213), p1(IZColum213, DEColum213))+ "\n");

            int IZColum313 = 0;           int DEColum313 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][13].equals("11 A 25 LIBROS")){
                        DEColum313++;
                    }
                    else{
                        IZColum313++;
                    }
                }
            }
            System.out.println("fami_numlibros por derecha : "+ DEColum313 + " Por Izquierda : "+ IZColum313);
            impureza(DEColum313, IZColum313);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum313, IZColum313, p0(DEColum313,IZColum313), p1(IZColum313, DEColum313))+ "\n");

            int IZColumno413 = 0;           int DEColumno413 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][13].equals("MAS DE 100 LIBROS")){
                        DEColumno413++;
                    }
                    else{
                        IZColumno413++;
                    }
                }
            }
            System.out.println("fami_numlibros por derecha : "+ DEColumno413 + " Por Izquierda : "+ IZColumno413);
            impureza(DEColumno413, IZColumno413);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumno413, IZColumno413, p0(DEColumno413,IZColumno413), p1(IZColumno413, DEColumno413))+ "\n");

            int IZColum513 = 0;           int DEColum513 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][13].equals("")){
                        DEColum513++;
                    }
                    else{
                        IZColum513++;
                    }
                }
            }
            System.out.println("fami_numlibros por derecha : "+ DEColum513 + " Por Izquierda : "+ IZColum513);
            impureza(DEColum513, IZColum513);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum513, IZColum513, p0(DEColum513,IZColum513), p1(IZColum513, DEColum513))+ "\n");

            System.out.println("___________________________________________________");

            int IZColumnoM17 = 0;           int DEColumnoM17 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][17].equals("M")){
                        DEColumnoM17++;
                    }
                    else{
                        IZColumnoM17++;
                    }
                }
            }
            System.out.println("estu_genero.1 por derecha : "+ DEColumnoM17 + " Por Izquierda : "+ IZColumnoM17);
            impureza(DEColumnoM17, IZColumnoM17);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumnoM17, IZColumnoM17, p0(DEColumnoM17,IZColumnoM17), p1(IZColumnoM17, DEColumnoM17))+ "\n");

            int IZColumF17 = 0;           int DEColumF17 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][17].equals("F")){
                        DEColumF17++;
                    }
                    else{
                        IZColumF17++;
                    }
                }
            }
            System.out.println("estu_genero.1 por derecha : "+ DEColumF17 + " Por Izquierda : "+ IZColumF17);
            impureza(DEColumF17, IZColumF17);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColumF17, IZColumF17, p0(DEColumF17,IZColumF17), p1(IZColumF17, DEColumF17))+ "\n");

            System.out.println("__________________________________________________");

            int IZColum126 = 0;           int DEColum126 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][26].equals("Cabecera Municipal")){
                        DEColum126++;
                    }
                    else{
                        IZColum126++;
                    }
                }
            }
            System.out.println("Area Rural por derecha : "+ DEColum126 + " Por Izquierda : "+ IZColum126);
            impureza(DEColum126, IZColum126);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum126, IZColum126, p0(DEColum126,IZColum126), p1(IZColum126, DEColum126))+ "\n");

            int IZColum226 = 0;           int DEColum226 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][26].equals("Area Rural")){
                        DEColum226++;
                    }
                    else{
                        IZColum226++;
                    }
                }
            }
            System.out.println("Area Rural por derecha : "+ DEColum226 + " Por Izquierda : "+ IZColum226);
            impureza(DEColum226, IZColum226);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum226, IZColum226, p0(DEColum226,IZColum226), p1(IZColum226, DEColum226))+ "\n");

            int IZColum326 = 0;           int DEColum326 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][26].equals("")){
                        DEColum326++;
                    }
                    else{
                        IZColum326++;
                    }
                }
            }
            System.out.println("Area Rural por derecha : "+ DEColum326 + " Por Izquierda : "+ IZColum326);
            impureza(DEColum326, IZColum326);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum326, IZColum326, p0(DEColum326,IZColum326), p1(IZColum326, DEColum326))+ "\n");

            System.out.println("__________________________________________________");

            int IZColum127 = 0;           int DEColum127 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][27].equals("250.000 o mas")){
                        DEColum127++;
                    }
                    else{
                        IZColum127++;
                    }
                }
            }
            System.out.println("estu_valorpensioncolegio 250.000 o mas por derecha : "+ DEColum127 + " Por Izquierda : "+ IZColum127);
            impureza(DEColum127, IZColum127);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum127, IZColum127, p0(DEColum127,IZColum127), p1(IZColum127, DEColum127))+ "\n");

            int IZColum227 = 0;           int DEColum227 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][27].equals("No paga Pension")){
                        DEColum227++;
                    }
                    else{
                        IZColum227++;
                    }
                }
            }
            System.out.println("estu_valorpensioncolegio No paga Pension por derecha : "+ DEColum227 + " Por Izquierda : "+ IZColum227);
            impureza(DEColum227, IZColum227);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum227, IZColum227, p0(DEColum227,IZColum227), p1(IZColum227, DEColum227))+ "\n");

            int IZColum327 = 0;           int DEColum327 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][27].equals("Entre 87.000 y menos de 120.000")){
                        DEColum327++;
                    }
                    else{
                        IZColum327++;
                    }
                }
            }
            System.out.println("estu_valorpensioncolegio Entre 87.000 y menos de 120.000 por derecha : "+ DEColum327 + " Por Izquierda : "+ IZColum327);
            impureza(DEColum327, IZColum327);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum327, IZColum327, p0(DEColum327,IZColum327), p1(IZColum327, DEColum327))+ "\n");

            int IZColum427 = 0;           int DEColum427 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][27].equals("Entre 150.000 y menos de 250.000")){
                        DEColum427++;
                    }
                    else{
                        IZColum427++;
                    }
                }
            }
            System.out.println("estu_valorpensioncolegio Entre 150.000 y menos de 250.000 por derecha : "+ DEColum427 + " Por Izquierda : "+ IZColum427);
            impureza(DEColum427, IZColum427);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum427, IZColum427, p0(DEColum427,IZColum427), p1(IZColum427, DEColum427))+ "\n");

            int IZColum527 = 0;           int DEColum527 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][27].equals("Menos de 87.000")){
                        DEColum527++;
                    }
                    else{
                        IZColum527++;
                    }
                }
            }
            System.out.println("estu_valorpensioncolegio Menos de 87.000 por derecha : "+ DEColum527 + " Por Izquierda : "+ IZColum527);
            impureza(DEColum527, IZColum527);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum527, IZColum527, p0(DEColum527,IZColum527), p1(IZColum527, DEColum527))+ "\n");

            System.out.println("__________________________________________________fami_educacionpadre.1");

            int IZColum128 = 0;           int DEColum128 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][28].equals("Secundaria (Bachillerato) completa")){
                        DEColum128++;
                    }
                    else{
                        IZColum128++;
                    }
                }
            }
            System.out.println("fami_educacionpadre.1 Secundaria (Bachillerato) completa por derecha : "+ DEColum128 + " Por Izquierda : "+ IZColum128);
            impureza(DEColum128, IZColum128);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum128, IZColum128, p0(DEColum128,IZColum128), p1(IZColum128, DEColum128))+ "\n");

            int IZColum228 = 0;           int DEColum228 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][28].equals("Postgrado")){
                        DEColum228++;
                    }
                    else{
                        IZColum228++;
                    }
                }
            }
            System.out.println("fami_educacionpadre.1Postgrado por derecha : "+ DEColum228 + " Por Izquierda : "+ IZColum228);
            impureza(DEColum228, IZColum228);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum228, IZColum228, p0(DEColum228,IZColum228), p1(IZColum228, DEColum228))+ "\n");

            int IZColum328 = 0;           int DEColum328 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][28].equals("Secundaria (Bachillerato) incompleta")){
                        DEColum328++;
                    }
                    else{
                        IZColum328++;
                    }
                }
            }
            System.out.println("fami_educacionpadre.1 Secundaria (Bachillerato) incompleta por derecha : "+ DEColum328 + " Por Izquierda : "+ IZColum328);
            impureza(DEColum328, IZColum328);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum328, IZColum328, p0(DEColum328,IZColum328), p1(IZColum328, DEColum328))+ "\n");

            int IZColum428 = 0;           int DEColum428 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][28].equals("Tecnica o tecnologica completa")){
                        DEColum428++;
                    }
                    else{
                        IZColum428++;
                    }
                }
            }
            System.out.println("fami_educacionpadre.1 Tecnica o tecnologica completa por derecha : "+ DEColum428 + " Por Izquierda : "+ IZColum428);
            impureza(DEColum428, IZColum428);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum428, IZColum428, p0(DEColum428,IZColum428), p1(IZColum428, DEColum428))+ "\n");

            int IZColum528 = 0;           int DEColum528 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][28].equals("Educacion profesional completa")){
                        DEColum528++;
                    }
                    else{
                        IZColum528++;
                    }
                }
            }
            System.out.println("fami_educacionpadre.1 Educacion profesional completa por derecha : "+ DEColum528 + " Por Izquierda : "+ IZColum528);
            impureza(DEColum528, IZColum528);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum528, IZColum528, p0(DEColum528,IZColum528), p1(IZColum528, DEColum528))+ "\n");

            int IZColum628 = 0;           int DEColum628 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][28].equals("Primaria completa")){
                        DEColum628++;
                    }
                    else{
                        IZColum628++;
                    }
                }
            }
            System.out.println("fami_educacionpadre.1 Primaria completa completa por derecha : "+ DEColum628 + " Por Izquierda : "+ IZColum628);
            impureza(DEColum628, IZColum628);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum628, IZColum628, p0(DEColum628,IZColum628), p1(IZColum628, DEColum628))+ "\n");

            int IZColum728 = 0;           int DEColum728 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][28].equals("Educacion profesional incompleta")){
                        DEColum728++;
                    }
                    else{
                        IZColum728++;
                    }
                }
            }
            System.out.println("fami_educacionpadre.1 Educacion profesional completa por derecha : "+ DEColum728 + " Por Izquierda : "+ IZColum728);
            impureza(DEColum728, IZColum728);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum728, IZColum728, p0(DEColum728,IZColum728), p1(IZColum728, DEColum728))+ "\n");

            System.out.println("__________________________________________________");

            int IZColum129 = 0;           int DEColum129 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][29].equals("Secundaria (Bachillerato) completa")){
                        DEColum129++;
                    }
                    else{
                        IZColum129++;
                    }
                }
            }
            System.out.println("fami_educacionmadre.1 Secundaria (Bachillerato) completa por derecha : "+ DEColum129 + " Por Izquierda : "+ IZColum129);
            impureza(DEColum129, IZColum129);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum129, IZColum129, p0(DEColum129,IZColum129), p1(IZColum129, DEColum129))+ "\n");

            int IZColum229 = 0;           int DEColum229 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][29].equals("Postgrado")){
                        DEColum229++;
                    }
                    else{
                        IZColum229++;
                    }
                }
            }
            System.out.println("fami_educacionmadre.1 Postgrado por derecha : "+ DEColum229 + " Por Izquierda : "+ IZColum229);
            impureza(DEColum229, IZColum229);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum229, IZColum229, p0(DEColum229,IZColum229), p1(IZColum229, DEColum229))+ "\n");

            int IZColum329 = 0;           int DEColum329 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][29].equals("Secundaria (Bachillerato) incompleta")){
                        DEColum329++;
                    }
                    else{
                        IZColum329++;
                    }
                }
            }
            System.out.println("fami_educacionmadre.1 Secundaria (Bachillerato) incompleta por derecha : "+ DEColum329 + " Por Izquierda : "+ IZColum329);
            impureza(DEColum329, IZColum329);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum329, IZColum329, p0(DEColum329,IZColum329), p1(IZColum329, DEColum329))+ "\n");

            int IZColum429 = 0;           int DEColum429 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][29].equals("Tecnica o tecnologica completa")){
                        DEColum429++;
                    }
                    else{
                        IZColum429++;
                    }
                }
            }
            System.out.println("fami_educacionmadre.1 Tecnica o tecnologica completa por derecha : "+ DEColum429 + " Por Izquierda : "+ IZColum429);
            impureza(DEColum429, IZColum429);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum429, IZColum429, p0(DEColum429,IZColum429), p1(IZColum429, DEColum429))+ "\n");

            int IZColum529 = 0;           int DEColum529 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][29].equals("Educacion profesional completa")){
                        DEColum529++;
                    }
                    else{
                        IZColum529++;
                    }
                }
            }
            System.out.println("fami_educacionmadre.1 Educacion profesional completa por derecha : "+ DEColum529 + " Por Izquierda : "+ IZColum529);
            impureza(DEColum529, IZColum529);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum529, IZColum529, p0(DEColum529,IZColum529), p1(IZColum529, DEColum529))+ "\n");

            int IZColum629 = 0;           int DEColum629 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][29].equals("Primaria completa")){
                        DEColum629++;
                    }
                    else{
                        IZColum629++;
                    }
                }
            }
            System.out.println("fami_educacionmadre.1 Primaria completa completa por derecha : "+ DEColum629 + " Por Izquierda : "+ IZColum629);
            impureza(DEColum629, IZColum629);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum629, IZColum629, p0(DEColum629,IZColum629), p1(IZColum629, DEColum629))+ "\n");

            int IZColum729 = 0;           int DEColum729 = 0;
            for (filas = 0; filas < matriz.length; filas++) {
                for (int colum = 77; colum < matriz[filas].length; colum++) {
                    if(matriz[filas][29].equals("Educacion profesional incompleta")){
                        DEColum729++;
                    }
                    else{
                        IZColum729++;
                    }
                }
            }
            System.out.println("fami_educacionmadre.1 Educacion profesional completa por derecha : "+ DEColum729 + " Por Izquierda : "+ IZColum729);
            impureza(DEColum729, IZColum729);
            System.out.println("impureza de gini ponderada : "+ impurezaPonde1(DEColum729, IZColum729, p0(DEColum729,IZColum729), p1(IZColum729, DEColum729))+ "\n");

            System.out.println("__________________________________________________");
        }catch (IOException e){
            System.out.println(e);
        }

    }

    public static void impureza(float C1, float C2){
        float IG;
        float p0 = C1/(C1+C2);
        float p1 = C2/(C1+C2);
        IG = 1 - ((p0*p0)+(p1*p1));
        System.out.println("Impureza de gini : "+ IG);
    }

    public static float impureza1(float C1, float C2){
        float IG;
        float p0 = C1/(C1+C2);
        float p1 = C2/(C1+C2);
        IG = 1 - ((p0*p0)+(p1*p1));
        return IG;
    }

    public static void impurezaPonde(float Ni, float Nd, float Ii, float Id){
        //Impureza ponderada
        float Ip;
        Ip = (Ni*Ii +Nd*Id)/(Ni+Nd);
        System.out.println("Impureza ponderada : "+ Ip);

    }

    public static float impurezaPonde1(float Ni, float Nd, float Ii, float Id){
        //Impureza ponderada
        float Ip;
        Ip = (Ni*Ii +Nd*Id)/(Ni+Nd);
        return Ip;

    }

    public static float p1(float C1, float C2){
        float p1 = C2/(C1+C2);
        return p1;
    }

    public static float p0(float C1, float C2){
        float p0 = C2/(C1+C2);
        return p0;
    }
}