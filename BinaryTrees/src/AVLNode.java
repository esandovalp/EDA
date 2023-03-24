
/**
 *
 * @author coron
 */
public class AVLNode <T extends Comparable<T>> {
    private T valor;
    private int FE, altura;
    private AVLNode left, right;
    private AVLNode papa;

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public AVLNode(T valor) {
        this.valor = valor;
        this.FE = 0;
        this.left = null;
        this.right = null;
        this.altura = 1;
    }
       
    public AVLNode getPapa(){ 
        return this.papa;
    }
    
    private int getHeight(AVLNode<T> node) {
    if (node == null) 
        return -1; 
    
    return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())); 
    }
    
    public int getFE(AVLNode<T> node) {
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return rightHeight - leftHeight;
    }
    
    public void hang(AVLNode<T> son){
        if (son == null)
            return;
        
        if (son.getValor().compareTo(this.getValor()) <= 0)
            this.setLeft(son);     
        else
            this.setRight(son);
        
        son.setPapa(this);
    }

    public void setPapa(AVLNode papa) {
        this.papa = papa;
    }

    @Override
    public String toString() {
        return this.getValor() + " (" + getFE(this) + ")";
    }
    
    
}
