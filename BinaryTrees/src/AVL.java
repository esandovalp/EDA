
// Al terminar hacer un repo en github con todos los métodos con comentarios 

public class AVL <T extends Comparable<T>> extends BinaryTree {
    private class AVLNode <T extends Comparable<T>> {
        T val;
        AVLNode<T> left, right,dad;
        int fe;

        public AVLNode(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.dad = null;
            this.fe = 0;
        }

        public int getFE() {
            return fe;
        }

        public void setFE(int fe) {
            this.fe = fe;
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

        public AVLNode<T> getLeft() {
            return left;
        }

        public void setLeft(AVLNode<T> left) {
            this.left = left;
        }

        public AVLNode<T> getRight() {
            return right;
        }

        public void setRight(AVLNode<T> right) {
            this.right = right;
        }

        public AVLNode<T> getDad() {
            return dad;
        }

        public void setDad(AVLNode<T> dad) {
            this.dad = dad;
        }

        public void hang(AVLNode<T> son){
            if (son == null)
                return;

            if (son.getElem().compareTo(val) <=0)
                left = son;     // when to use this.left?
            else
                right = son;

            son.setDad(this);
        }
    }
    
    AVLNode<T> root;
    
    public AVL(Comparable elem) {
        super(elem);
    }
    
    // Agregar metodos de insertar, borrar y buscar 
    // Imprimir elemento almacenado de cada nodo y el factor de equilibrio
    // calcula FE
    public AVLNode<T> searchAVL(T elem){
        AVLNode<T> guide = root;
        
        while (guide != null && !guide.val.equals(elem))
            if (elem.compareTo(guide.val) <= 0)
                guide = guide.left;
            else
                guide = guide.right;
        
        
        return guide;
    }
    
    public void add(T elem) {
        AVLNode <T> act = root;
        AVLNode <T> newNode = new AVLNode(elem);
        AVLNode <T> dad = root;
        
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
        
        
    }
    
    private void rota (AVLNode alfa) {
	AVLNode<T> papa = alfa.dad;
	AVLNode<T> A,B,C,D,beta,gamma;

	if (alfa.getFE() == -2) {
		beta = alfa.left;
		if (beta.getFE() <= 0) {
			gamma = beta.left;
			A = gamma.right;
			B = gamma.right;
			C = beta.right;
			D = alfa.right;
			
			gamma.hang(A);
			gamma.hang(B);
			alfa.hang(C);
			alfa.hang(D);
			beta.hang(gamma);
			beta.hang(alfa);
			papa.hang(beta);
			
			// ActualizaFE
			gamma.setFE(altura(B) - altura(A));
			alfa.setFE(altura(D) - altura(C));
			beta.setFE(altura(alfa) - altura(gamma));
		}
	}
    }
    
    public int altura(AVLNode<T> act){
        return altura(act, 0);
    }
    
    private int altura(AVLNode<T> act, int n){
        if (act == null)
            return n;
        
        n++;
        int f1 = altura(act.left,n);
        int f2 = altura(act.right,n);
        
        if (f1 < f2)
            return f2;
        else
            return f1;
    }
}