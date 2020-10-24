import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Daniel Mesa
 */

public class DigraphAL extends Digraph {

    private ArrayList<LinkedList<Pair<Integer,Integer>>> nodo;

    /**
     * Constructor para el grafo dirigido
     * @param vertices el numero de vertices que tendra el grafo dirigido
     *
     */
    public DigraphAL(int size) {
        super(size);
        nodo = new ArrayList<>();
        for (int i = 0; i < size + 1; i++) {
            nodo.add(new LinkedList<>());
        }

    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight el peso de la longitud entre source y destination
     */
    public void addArc(int source, int destination, int weight) {
        Pair<Integer,Integer> pair = new Pair<Integer,Integer>(destination,weight);
        nodo.get(source).add(pair);
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> n = new ArrayList<>();

        if(nodo.get(vertex).size() == 0 || nodo.get(vertex) == null){
            return null;
        }
        
        for(Pair<Integer,Integer> integerIntegerPair :nodo.get(vertex)){
            if(integerIntegerPair == null){
                break;
            }
            n.add(integerIntegerPair.first);

        }

        Collections.sort(n);

        return n;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     * 
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */	
    public int getWeight(int source, int destination) {		

        int result = 0;
        for(Pair<Integer,Integer> integerIntegerPair : nodo.get(source)){
            if(integerIntegerPair.first == destination){
                return integerIntegerPair.second;
            }
        }
        return result;

    }

}

