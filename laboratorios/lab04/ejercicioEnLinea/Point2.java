
import java.util.ArrayList;
public class Point2
{
    public class Node {
        public Node left;
        public Node right;
        public int data;
        public Node (int data) {
            this.data=data;
        }
    }

    public Node root;

    public void buildingTree (int [] preOrden) {
        
        root = new Node(preOrden[0]);
        for(int i = 1; i < preOrden.length; i++){
            insert(root, preOrden[i]);
        }
    }

    public void insert (Node node, int data) {
        
        if(data <= node.data){
            
            if(node.left == null) {
                node.left = new Node(data);//bueno

            } else if(node.left != null) {
                insert(node.left, data);//creo que bien 

            } 
        }else {
            if(node.right == null) {
                node.right = new Node(data);//bueno

            } else if(node.right != null) {
                insert(node.right,data);//creo que bien 

            }
            
        }
        
    }

    public void preOrden(Node node) {
        if(node != null){
            System.out.println(node.data);
            preOrden(node.left);
            preOrden(node.right);
        }
    }

    public void posOrder(Node node) {
        if(node != null){
            posOrder(node.left);
            posOrder(node.right);
            System.out.println(node.data);
        }
    }

    public void exercise21 (int [] input) {
        buildingTree(input);
        System.out.println("PosOrder");
        posOrder(root);
        System.out.println();
    }

    public static void main (String [] args) {
        int [] test = {50,30,24,5,28,45,98,52,60};
        Point2 testing = new Point2();
        testing.exercise21(test);
    }
}
