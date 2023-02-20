
import java.util.ArrayList;
import java.util.Iterator;

public class LinkedBinarySearchTree <T extends Comparable<T>> extends BinaryTree{
    BTNode<T> root;
    int count;

    public LinkedBinarySearchTree(Comparable elem) {
        super(elem);
    }
    
   
    public void add(T elem) {
        BTNode <T> act = root;
        BTNode <T> newNode = new BTNode(elem);
        BTNode <T> dad = root;
        
        if (root == null) {
            root = newNode;
            return;
        }
        
        while (act != null){
            dad = act;
            
            if (elem.compareTo(act.getElem()) <= 0)
                act = act.getLeft();
            else
                act = act.getRight();
        }
        
        dad.hang(newNode);
        count++;
    }

    
    
    public T remove(T elem) {       // make every case a private method so we can call them on the third case
        BTNode<T> guide = search(elem);
        T temp = null;
        
        if (guide == null)
            throw new RuntimeException("null");
        
        if (guide.left == null && guide.right == null) {
            if (guide.equals(root)){
                temp = root.val;
                root = null;
                return temp;
            }
            temp = guide.val;
            
            if (guide.val.compareTo(guide.dad.val) > 0)
                guide.dad.right = null;
            else
                guide.dad.left = null;
        }
        
        if (guide.left == null || guide.right == null){
            BTNode<T> son;
            
            if (guide.left != null)
                son = guide.right;
            else
                son = guide.left;
            
            if (guide.equals(root))
                root = son;
            else
                guide.dad.hang(son);
            temp = son.val;
        }
        
        // case three 
        
        return temp;
    }

    
    public T findMin() {
        BTNode<T> act = root;
        
        if (act == null)
            throw new RuntimeException();
        
        while (act.getLeft() != null)
            act = act.getLeft();
        
        return act.getElem();
    }

   
    public T findMax() {
        BTNode<T> guide = root;
        
        if (guide == null)
            throw new RuntimeException("is null");
        
        while (guide.right != null)
            guide = guide.right;
        
        return guide.val;
    }
    
    
    public BTNode<T> searchBinary(T elem){
        BTNode<T> guide = root;
        
        while (guide != null && !guide.val.equals(elem))
            if (elem.compareTo(guide.val) <= 0)
                guide = guide.left;
            else
                guide = guide.right;
        
        
        return guide;
    }
}
