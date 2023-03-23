
import java.util.ArrayList;
import java.util.Iterator;

public class LinkedBinarySearchTree <T extends Comparable<T>> extends BinaryTree{
    BTNode<T> root;
    int count;

    public LinkedBinarySearchTree(Comparable elem) {
        super(elem);
    }

    public LinkedBinarySearchTree() {
        super(null);
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

    
    
    public T remove(T elem) {       
        BTNode<T> guide = search(elem);
        
        if (guide == null)
            throw new RuntimeException("null");
        
        if (guide.left == null && guide.right == null) 
            return caseOneRemove(guide);
        
        if (guide.left == null || guide.right == null)
            return caseTwoRemove(guide);
        
        if (guide.getRight() != null && guide.getLeft() != null)
            guide = sucesorInOrder(guide);
        
        return guide.getElem();
    }
    
    public BTNode<T> sucesorInOrder(BTNode<T> guide){
        if (guide == null || guide.getRight() == null)
            return null;
        
        BTNode<T> inOrd = guide.getRight();
        
        while (inOrd.getLeft() != null){
            inOrd = inOrd.getLeft();
        }
        
        return inOrd;
    }
    
    private T caseOneRemove(BTNode guide) {
        T temp = null;
        
        if (guide.equals(root)){
                temp = root.val;
                root = null;
                return temp;
        }
        
        temp = (T) guide.val;

        if (guide.val.compareTo(guide.dad.val) > 0)
            guide.dad.right = null;
        else
            guide.dad.left = null;

        return temp;
    }
    
    private T caseTwoRemove(BTNode guide){
        T temp = null;
        
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

    @Override
    public String toString() {
        return root.getElem() + " ";
    }
    
    public void preOrderBS(BTNode<T> act, ArrayList<T> list){
        if (act == null)
            return;
        
        list.add(act.val);
        preOrder(act.left,list);
        preOrder(act.right,list);
    }
    
    public void inOrderBS(BTNode<T> act, ArrayList<T> list){
        if (act == null)
            return;
        
        inOrder(act.left, list);
        list.add(act.val);
        inOrder(act.right,list);
    }
    
    public void postOrderBS(BTNode<T> act, ArrayList<T> list){
        if (act == null)
            return;
        
        postOrder(act.left,list);
        postOrder(act.right,list);
        list.add(act.val);
    }
   
}
