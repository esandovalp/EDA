
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
    
    public int getAlturaGeneral(){
        int leftCount = this.altura;
        int rightCount = this.altura;
        AVLNode left = this;
        AVLNode right = this;
        
        
        while (left.getLeft() != null){
            leftCount++;
            left = left.getLeft();
        }
        
        while (right.getRight() != null){
            rightCount++;
            right = right.getRight();
        }
        
        if (rightCount > leftCount)
            return rightCount;
        else
            return leftCount;
    }
    
    public int getFE(){
        AVLNode guide = this;
        AVLNode leftNode = guide.getLeft();
        AVLNode rightNode = guide.getRight();
        
        if (leftNode == null && rightNode == null)
            return 0;
        
        int leftCount = 0;
        int rightCount = 0;
        
        while (leftNode != null || rightNode != null){
            if (leftNode != null){
                leftCount+=1;
                leftNode = leftNode.getLeft();
            }
            
            if (rightNode != null) {
                rightCount+=1;
                rightNode = rightNode.getRight();
            }
        }
        
        this.FE = rightCount - leftCount;
        
        return rightCount - leftCount;
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
        return this.getValor() + " (" + this.getFE() + ")";
    }
    
    
}
