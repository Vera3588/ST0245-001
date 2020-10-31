
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DigraphAL extends Graph
{
    private ArrayList<LinkedList<Pair<Integer,Integer>>> nodo;

    public DigraphAL(int size) {
        super(size);
        nodo = new ArrayList<>();
        for (int i = 0; i < size + 1; i++) {
            nodo.add(new LinkedList<>());
        }
    }

    public void addArc(int source, int destination, int weight){
        nodo.get(source).add(new Pair<>(destination,weight));
    }

    public int getWeight(int source, int destination) {
        int result = 0;
        for (Pair<Integer, Integer> integerIntegerPair : nodo.get(source)) {
            if (integerIntegerPair.getKey() == destination)
                result = integerIntegerPair.getValue();
        }
        return result;
    }

    public ArrayList<Integer> getSuccessors(int vertice){
        ArrayList<Integer> n = new ArrayList<>();
        nodo.get(vertice).forEach(i -> n.add(i.getKey()));
        return n;
    }

    public static boolean validarBFS(Graph g, int source, int destino){
        boolean [] revicion = new boolean [g.getSize()];
        return validarBFS(g, source, destino, revicion);

    }

    private static boolean validarBFS(Graph g, int source, int destino, boolean [] revicion){
        ArrayList<Integer> listaVisi = g.getSuccessors(source);
        Queue <Integer> lista = new LinkedList <Integer>();
        boolean respuesta = false;
        revicion[source] = true;

        /*for(int proxNode : listaVisi){
        lista.add(proxNode);
        }

        if(listaVisi == null)
        return false;*/

        if(!listaVisi.isEmpty()){
            for(int proxNode : listaVisi){
                lista.add(proxNode);
            }
        }

        if(source == destino){
            respuesta = true;
        }

        while(lista.size() != 0){
            int org = lista.poll();
            return validarBFS(g, org, destino, revicion);

        }
        return respuesta;
    }

    public static boolean validarDFS(Graph g, int source, int destino){
        boolean [] revicion = new boolean [g.getSize()+1];
        return validarDFS(g, source, destino, revicion);
    }

    private static boolean validarDFS(Graph g, int source, int destino, boolean [] revicion){
        ArrayList<Integer> proximo = g.getSuccessors(source);
        boolean respuesta = false;
        revicion[source] = true;

        if(source == destino){
            respuesta = true;
        }

        for(int vecino : proximo){
            if(revicion[vecino] == false){
                respuesta = respuesta || validarDFS(g, vecino, destino, revicion);
            }
        }
        return respuesta;
    } 

    public static void main(String []ags){
        DigraphAL graph = new DigraphAL(5);
        graph.addArc(1, 2, 1);
        graph.addArc(2, 4, 1);
        graph.addArc(1, 5, 1);
        System.out.println(validarBFS(graph, 1, 3));
        System.out.println(validarBFS(graph, 1, 5));
        System.out.println(validarBFS(graph, 2, 4));

        graph.addArc(1, 2, 0);        
        graph.addArc(2, 4, 0);
        graph.addArc(1, 5, 0);
        System.out.println(validarDFS(graph, 1, 3));
        System.out.println(validarDFS(graph, 1, 5));
        System.out.println(validarDFS(graph, 2, 4));
    }

}
