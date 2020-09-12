import java.lang.IndexOutOfBoundsException; 
// Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListTJ{
    private Node first;
    private int size;
    public LinkedListTJ() 
    {
        size = 0;
        first = null;   
    }      //complejidad O(1)

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    } //complejidad O(n)

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return temp.data;
    } //complejidad O(n)

    // Retorna el tamaño actual de la lista
    public int size()
    {
        return size;
    } //complejidad O(1)

    // Inserta un dato en la posición index
    public void insert(int data, int index)throws IndexOutOfBoundsException {
        if (index == 0) {
            Node otro = new Node(data);
            otro.next = null;
            first = otro;
            size++;
        } else if(index != 0){
            Node temp = getNode(index - 1);
            Node otro = new Node(data);
            otro.next = temp.next;
            temp.next = otro;
            size++;
        }else 
        {
            throw new IndexOutOfBoundsException();
        }
        //complejidad O(1)
    }

    // Borra el dato en la posición index
    public void remove(int index)
    {
        try {
            if (index == 0) {
                Node temp = first;
                first = temp.next;
                index--;
            } else if (index == size - 1) {
                Node temp = getNode(size - 2);
                temp.next = null;
                index--;
            } else {
                Node temp = getNode(index - 1);
                temp.next = temp.next.next;
                index--;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("no se ha encontrado la posicion");
        }
    } //complejidad O(1)

    // Verifica si está un dato en la lista
    public boolean contains(int data)
    {
        Node temp = first;
        while(first != null){ 
            if(first.data == data){
                return true;
            }
            return false;
        }
        return false;
    } 
    //complejidad O(n)
    //para el peor de los casos es de O(n)
}