
import java.util.ArrayList;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        LinkedBinarySearchTree bt = new LinkedBinarySearchTree();
        
        bt.add(10);
        bt.add(12);
        bt.add(15);
        bt.add(25);
        bt.add(30);
        bt.add(36);
        
        BTNode guide = bt.root;
        ArrayList list = new ArrayList();
        
        bt.inOrder(guide, list);
        
        System.out.println(list.toString());
        System.out.println(bt.findMax());
    }
}
