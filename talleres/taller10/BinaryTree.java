/**
 * La clase BinaryTree intenta dar un conocimiento a los
 * estudiantes acerca del manejo de un arbol binario de enteros.
 * Aquí se espera crear una estrcutura concreta del árbol binario,
 * cabe aclarar que esta estrucutra ya esta implementada.
 * @see <a href="https://docs.oracle.com/javase/9/docs/api/jdk/nashorn/api/tree/BinaryTree.html"> Árbol Binario</a>
 * @author Mauricio Toro, Andres Paez
 *
 */

public class BinaryTree {
    // Sirve como raíz del árbol
    public Node root;

    /**
     * @param n el dato del nodo que se busca buscar
     *          Metodo auxiliar de insetarAux.
     */
    public void insertar(int n) {
        insertarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n    el data del nodo que se busca insertar
     *             nota: metodo recursivo.
     *             Inserta un dato respetando claro las desigualdades en el árbol
     */
    private static void insertarAux(Node node, int n) {
        if (node == null) {
            return;
        } else if (n > node.data) {
            if (node.right == null) {
                node.right = new Node(n);
            } else {
                insertarAux(node.right, n);
            }
        } else {
            if (node.left == null) {
                node.left = new Node(n);
            } else {
                insertarAux(node.left, n);
            }
        }
    }


    /**
     * @param n el dato del nodo que se busca.
     *          Metodo auxiliar de buscarAux.
     * @return true si el metodo buscarAux es true
     */
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n    el data del nodo que se busca
     *             nota: metodo recursivo.
     *             Inserta un dato respetando claro las desigualdades en el árbol
     * @return true si se encuentra el elemento en el árbol, false de lo contrario
     */

    private static boolean buscarAux(Node node, int n) {
        if (node.data == n) {
            return true;
        }
        if (node == null) {
            return false;
        }
        if (n > node.data) {
            return buscarAux(node.right, n);
        }
        return buscarAux(node.left, n);
    }

    /**
     * @param n el dato del nodo que se busca borrar.
     *          Metodo auxiliar de buscarAux.
     */
    public void borrar(int n) {
        borrarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n    el data del nodo que se busca borrar
     *             nota: metodo recursivo.
     *             borra un dato respetando claro las desigualdades en el árbol
     */
    private Node borrarAux(Node node, int n) {
        if (node.data == n) {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            } else {
                node.data = encontrarNodoReemplazo(node.left);
            }
        }
        if (n > node.data) {
            node.right = borrarAux(node.right, n);
            return node;
        }
        node.left = borrarAux(node.left, n);
        return node;
    }

    /*

	 Los metodos posteriores son para imprimir el arbol de manera
	 que sirven para debuggeo
    */

    /**
     * @param node el nodo desde el cual se imprimirá
     *             imprime el arbol desde el nodo node
     */
    private void recursivePrintAUX(Node node) {
        if (node != null) {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }

    }

    /**
     * Metodo auxiliar de recursivePrintAUX
     */
    public void recursivePrint() {
        recursivePrintAUX(root);
    }

    private int encontrarNodoReemplazo(Node n) {
        if (n.right == null) {
            int res = n.data;
            n = null;
            return res;
        }
        return encontrarNodoReemplazo(n.right);
    }


    public String Estructurar(){
        return "diagraph G { \n"+ Estructurar(root) + "\n";
    }
    public String Estructurar(Node node) {

        String info = "";

        if(node == null){
            return info;
        }else{
            if(node.left != null){
                info = info + " / " + node.toString() + " / " + "->";
                info = info + "/ " + node.left.toString() + " / " + "\n";
            }
            if(node.right != null){
                info = info + " / " + node.toString() + " / " + "->";
                info = info + "/ " + node.right.toString() + " / " + "\n";
            }
        }
        info = info + Estructurar(node.left) + Estructurar(node.right);
        return info;
    }

    public static void main(String[] args){
        BinaryTree arbol= new BinaryTree();
        arbol.insertar(4);
        arbol.insertar(3);
        arbol.insertar(5);
        //borrar(3);
        System.out.println(arbol.buscar(3));
        System.out.println(arbol.Estructurar());
    }
}
