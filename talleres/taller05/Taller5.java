public class Taller5 {  
    /**
     * @param array es una arreglo de numeros enteros.
     * El método suma tiene la intención de hacer el proceso de suma
     * mediante una funcion cíclica (while/for/...)
     * @return la suma de todos los numeros sumados.
     */
    public static int suma (int[]array){
        int sum=0; //c1
        for(int i=0;i< array.length ;i++){//c2 + c3*n, siendo c1 = 1
            sum+=array[i]; //c4*n
        }
        return sum;         //c5
        //T(n)= c1 + c2 + c3*n + c4*n + c5 es O(n)

    }

    /**
     * @param num es el numero el cual se utiliza para ser multiplicado.
     * El método mul tiene la intención de hacer la multiplicación
     * de 1 a n por el numero mul
     * mediante una funcion cíclica (while/for/...)
     * 
     */
    public static void mul (int num){
        for(int i = 0; i<=5; i++){//c1 
            System.out.println(num +" + "+ i +" = "+ (num-1) ); //c2+ c3(n-1)
        }               
        //T(n)= c1 + c2 +c3(n-1)
    }

    /**
     * @param array es un arreglo de números desordenados
     * El método insertionSort tiene la intención ordenar los números
     * del arreglo array por el método insertion:
     * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
     * mediante la anidación de funciones cíclicas (while/for/...)
     * 
     */
    public static int[] insertionSort (int[] array){
        int j=0;    //c1
        int temp=0;    //c2 
        for(int i=0; i<array.length ; i++){//c3+ c4*n
            j = i - 1;              //c5
            temp = array[i];        //c6*n
            while(j >= 0 && array[ j ] > temp) //c7 + c8*n
                array[j+1] = array[j--]; //c9*n
            //j --;
            array[j+1] = temp; //c10*n
        }
        return array;  //c11
    }    //T(n)= c1 + c2 + c3 + c4*n+ c5+ c6*n+ c7+c8*n+c9*n+c10*n+c11
}    
