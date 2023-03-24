
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree(50);
 
        tree.add(25);
        tree.add(12);
        tree.add(30);
        tree.add(6);
        tree.add(15);
        tree.add(14);
        tree.add(18);
        tree.add(100);
        tree.add(75);
        tree.add(150);
        tree.add(175);
        tree.add(22);
        
            
        tree.print(tree.root);
                
        Integer toRemove = 50;
        
        tree.remove(toRemove);
        
        System.out.println("\nDespues de quitar el: " + toRemove);
        
        tree.print(tree.root);
        
//        AVLNode nD = tree.nodoDesbalanceado(tree.root) ;
//        
//        tree.desbalanceador(nD);
//        
//        System.out.println("\n");
//        
//        tree.print(tree.root);
    }
}
