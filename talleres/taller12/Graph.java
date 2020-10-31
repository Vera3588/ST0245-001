import java.util.ArrayList;
//CODIGO BASE DADO POR EL PROFESOR
public abstract class Graph
{
    protected int size;
    public  Graph(int vertices) 
    {
        size = vertices;
    }

    public  abstract void addArc(int source, int destination, int weight);

    public abstract ArrayList<Integer> getSuccessors(int vertice);

    public abstract int getWeight(int source, int destination);

    public  int getSize() {
        return size;
    }
    
    boolean dfsAuxMalo(Graph g, int v, boolean[] vi, int buscando){
        vi[v] = true;
        if(v == buscando) return true;
        ArrayList<Integer> vecinos = g.getSuccessors(v);
        for(Integer vecino : vecinos)
            if(!vi[vecino])
                dfsAuxMalo(g, vecino, vi, buscando);
           return false;     
    
    }
}
