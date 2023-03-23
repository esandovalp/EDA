
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


public class BinaryTree <T extends Comparable <T>> implements BinaryTreeADT<T> {
    BTNode<T> root;
    int i;

    public BinaryTree(T elem) {
        root = new BTNode<T>(elem);
        i = 1;
    }

    @Override
    public boolean isEmpty() {
        return i == 0;
    }

    @Override
    public int size() {
        return i;
    }
    
    @Override
    public void preOrder(BTNode<T> act, ArrayList<T> list){
        if (act == null)
            return;
        
        list.add(act.val);
        preOrder(act.left,list);
        preOrder(act.right,list);
    }
    
    @Override
    public void inOrder(BTNode<T> act, ArrayList<T> list){
        if (act == null)
            return;
        
        inOrder(act.left, list);
        list.add(act.val);
        inOrder(act.right,list);
    }
    
    @Override
    public void postOrder(BTNode<T> act, ArrayList<T> list){
        if (act == null)
            return;
        
        postOrder(act.left,list);
        postOrder(act.right,list);
        list.add(act.val);
    }
    
    public Iterator<T> preOrderIterative(){
        ArrayList<T> list = new ArrayList<T>();
        Stack<BTNode> stack = new Stack<BTNode>();
        stack.push(root);
        BTNode<T> act;
        
        while(!stack.isEmpty()){
            act = stack.pop();
            list.add(act.getElem());
            
            if (act.getRight() != null)
                stack.add(act.getRight());
            
            if (act.getLeft() != null)
                stack.add(act.getLeft());
            
        }
        return list.iterator();
    }

    @Override
    public Iterator<T> byLevelIterative() {
        QueueADT<BTNode> queue ;
        queue = new Queue<BTNode>();
        ArrayList<T> list = new ArrayList<T>();
        queue.agrega(root);
        BTNode<T> act;
        
        while(!queue.estaVacia()){
            act = queue.saca();
            list.add(act.getElem());
            
            if (act.getRight() != null)
                queue.agrega(act.getRight());
            
            if (act.getLeft() != null)
                queue.agrega(act.getLeft());
            
        }
        return list.iterator();
    }
    
    public int treeHeight(){
        return treeHeight(root, 0);
    }
    
    private int treeHeight(BTNode<T> act, int n){
        if (act == null)
            return n;
        
        n++;
        int f1 = treeHeight(act.left,n);
        int f2 = treeHeight(act.right,n);
        
        if (f1 < f2)
            return f2;
        else
            return f1;
    }
    
    @Override
    public BTNode<T> search(T toSearch){
        return search(root,toSearch);
    }
    
    private BTNode<T> search(BTNode<T> act, T toSearch) {
        if (act == null)
            return null;
        if (act.getElem().equals(toSearch))
            return act;
        
        BTNode<T> ans = search(act.getLeft(),toSearch);
        
        if (ans == null)
            ans = search(act.getRight(),toSearch);
        
        return ans;
    }

    @Override
    public boolean contains(T elem) {
        return search(elem) == null;
    }
    
    public boolean isBST(BTNode guide, T min, T max) {
        if (guide == null)
            return true;
        
        if (guide.val.compareTo(guide.left) <= 0)
            return false;
        
        if (guide.val.compareTo(guide.right.val) >= 0)
            return false;
        
        return isBST(guide.right, (T) guide.val, max) && isBST(guide.left, min,(T) guide.val);
    }
    
    @Override 
    public String toString(){
        return this.root.val + "";
    }
}
