import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class DigraphAM extends Graph
{
    //Grafo con matriz
    int[][] mat;
    public DigraphAM(int size){
        super(size);
        mat = new int[size][size];

        for(int i=0; i<size; i++){
            mat[i][0] = i;
            mat[0][i] = i;
        }
    }

    public void addArc(int source, int destination, int weight){
        mat[source][destination] = weight;
    }

    public int getWeight(int source, int destination){
        return mat[source][destination];
    }

    public ArrayList<Integer> getSuccessors(int vertex)
    {
        ArrayList<Integer> np= new ArrayList<>();
        for(int i=1; i<=size; i++){
            if(mat[vertex][i]!=0){
                np.add(i);
            }
        }
        if(np.isEmpty())
            return null;
        return np;   
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
        return DFSp(g, source, destino, revicion);
    }

    private static boolean DFSp(Graph g, int source, int destino, boolean [] revicion){
        ArrayList<Integer> proximo = g.getSuccessors(source);
        boolean respuesta = false;
        revicion[source] = true;

        if(source == destino){
            respuesta = true;
        }

        for(int vecino : proximo){
            if(revicion[vecino] == false){
                respuesta = respuesta || DFSp(g, vecino, destino, revicion);
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
