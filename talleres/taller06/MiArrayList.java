
import java.util.Arrays;

public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 

    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
        size = 0; 
        elements = new int[DEFAULT_CAPACITY]; 
    }  

    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return size;
    }   

    /** 
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(int e) {       
        if (size == elements.length) { //Equivalente a Arrays.copyOf(...) que es O(n);
            int[] otroArreglo = new int[elements.length*2];
            for (int i = 0; i < elements.length; i++) // O(n)
                otroArreglo[i] = elements[i];
            elements = otroArreglo;
        }
        elements[size] = e;
        size++;
    }  

    /** 
     * @param i es un íncide donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) throws Exception{
        if (i > size || i < 0)
            throw new Exception("index: " + i);
        for (int index = 0; index < elements.length; index++) // O(n)
            if (index == i)
                return elements[index];
        return elements[i];// T(n) = O(n) !!
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, int e) throws Exception {
        if (index > size || index < 0)   // O(1)
            throw new Exception("index: " + index); // O(1)
        int[] copyArray; // O(1)
        if (size == elements.length) // O(1)
            copyArray = new int[elements.length*2]; // O(1)
        else
            copyArray = new int[elements.length]; // O(1)

        for(int i = 0; i < index; i++){ // O(n)
            copyArray[i] = elements[i]; // O(n)

            copyArray[index] = e; // O(1)
            for(i = index; i < copyArray.length; i++){ // O(n)
                copyArray[i+1] = elements[i]; // O(n)
            }
            size++; // O(1)
            elements = copyArray; // O(1)
        }                        // T(n) = O(n) !!
    }

    /**
     * @param index es la posicion en la cual se va eliminar el elemento
     *
     * ELimina el elemento  en la posición index de la lista
     *
     */
    public void del(int index){
        for(int i=index; i < size; i++){ //O(n)
            elements[i] = elements[i+1];
        }
        elements[size] = 0;
        size--;// T(n) = O(n) !!
    }
}

