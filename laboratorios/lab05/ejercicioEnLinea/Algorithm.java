import java.util.LinkedList;

public class Algorithm {
    final static int V = 4;

    public static boolean DFSColorFC(DigraphAM1 A) {
        return DFSColorFCAux(A, 1);
    }

    private static boolean DFSColorFCAux(DigraphAM1 A , int color) {

        int D[][] = DigraphAM1.getM();
        int colorArray[] = new int[V]; 
        for (int i = 0; i < V; ++i) 
            colorArray[i] = -1; 

        colorArray[color] = 1; 

        LinkedList<Integer> L = new LinkedList<Integer>(); 
        L.add(color); 

        while (L.size() != 0) 
        { 
            int u = L.poll(); 

            if (D[u][u] == 1) 
                return false;  

            for (int t = 0; t < V; t++) 
            { 
                if (D[u][t] == 1 && colorArray[t] == -1) 
                { 
                    colorArray[t] = 1-colorArray[u]; 
                    L.add(t); 
                } 
                else if (D[u][t] == 1 && colorArray[t] == colorArray[u]) 
                    return false; 
            } 
        } 
        return true;
    }
}
