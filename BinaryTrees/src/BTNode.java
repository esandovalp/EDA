
// clase auxiliar para todas
public class BTNode <T extends Comparable<T>> {
    T val;
    BTNode<T> left, right,dad;

    public BTNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.dad = null;
    }
    
    public int descendants(){
        int i=0;
        
        if (left != null)
            i = left.descendants() + 1;
        
        if (right != null)
            i += right.descendants() + 1;
        
        return i;
    }

    public T getElem() {
        return val;
    }

    public void setElem(T val) {
        this.val = val;
    }

    public BTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BTNode<T> left) {
        this.left = left;
    }

    public BTNode<T> getRight() {
        return right;
    }

    public void setRight(BTNode<T> right) {
        this.right = right;
    }

    public BTNode<T> getDad() {
        return dad;
    }

    public void setDad(BTNode<T> dad) {
        this.dad = dad;
    }
    
    public void hang(BTNode<T> son){
        if (son == null)
            return;
        
        if (son.getElem().compareTo(this.val) <=0)
            this.left = son;     // when to use this.left?
        else
            this.right = son;
        
        son.setDad(this);
    }
    
}
