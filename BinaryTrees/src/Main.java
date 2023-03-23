
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree(25);
 
        tree.add(12);
        tree.add(50);
        tree.add(65);
        tree.add(70);
        tree.add(30);
        tree.add(60);
        
        tree.print(tree.root);
        
        System.out.println("\nDespues de rotacion derecha");
        tree.rotacionIzquierda(tree.root.getRight());
        tree.print(tree.root);
    }
}
