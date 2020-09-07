import java.util.Arrays;

public class Laboratorio2
{

    /**
     * Laboratorio 2 de Estructuras de Datos 1
     * 
     * @author 
     * @version 1
     */
    public static void InsertionSort(int[] A)
    {
        int j=0;
        int temp=0;     //T(0)= c1, donde c1 = 4
        for(int i=0; i<A.length ; i++){
            j = i - 1;
            temp = A[i];
            while(j >= 0 && A[ j ] > temp)
                A[j+1] = A[j--];
            A[j+1] = temp;
        }
        System.out.println(A);
    }
   
    public static void mergeSort(int [] a)
    {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }

    private static void mergeSort(int [] a, int [] tmp, int left, int right)
    {
        if (left < right) { 
            int m = (left + right) / 2; 
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }
    
    private static void merge(int[] a, int[] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int p = left;
        int Val = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right] )
                tmp[p++] = a[left++];
            else
                tmp[p++] = a[right++];

        while(left <= leftEnd)    
            tmp[p++] = a[left++];

        while(right <= rightEnd)  
            tmp[p++] = a[right++];

        for(int i = 0; i < Val; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
            
    }

    public static void main(String[] args)
    {
        int[] A = {1,5,3,2,6};
        int[] B = {1,5,3,2};
        int[] C = {1,5,2,6};
        int[][] Arrays = {A,B,C};  
        for (int[] X : Arrays)
        {        
            Laboratorio2.mergeSort(X);
            Laboratorio2.InsertionSort(X);     
        }

          for(int n = 5000; n <= 25000; n = n + 1000){
            int[] arreglo = new int[n];
            for (int i = 0; i < n; i++)
                arreglo[i] = n-i;
            long ti = System.currentTimeMillis();
            Laboratorio2.InsertionSort(arreglo);
            long tf = System.currentTimeMillis();
            System.out.println(tf - ti);
        }
        
        System.out.println();
        
        for(int n = 10000000; n <= 200000000; n = n + 10000000){
            long ti = System.currentTimeMillis();
            Laboratorio2.mergeSort(new int[n]);
            long tf = System.currentTimeMillis();
            System.out.println(tf - ti);
        }
       
    }

}