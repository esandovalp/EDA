
import java.util.ArrayList;
import java.util.Iterator;


public interface BinaryTreeADT <T extends Comparable <T>> {
    public boolean isEmpty();
    public int size();
    public boolean contains(T elem);
    public Iterator<T> preOrderIterative();
    public void postOrder(BTNode<T> act, ArrayList<T> list);
    public void inOrder(BTNode<T> act, ArrayList<T> list);
    public void preOrder(BTNode<T> act, ArrayList<T> list);
    public Iterator<T> byLevelIterative();
    public BTNode<T> search(T toSearch);
}
