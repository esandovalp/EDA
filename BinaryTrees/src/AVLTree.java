
import java.util.ArrayList;
import java.util.List;


public class AVLTree <T extends Comparable<T>>  {
    AVLNode root;

    public AVLTree(T elem) {
        this.root = new AVLNode(elem);
    }
    
    // Agregar metodos de insertar, borrar y buscar 
    // Imprimir elemento almacenado de cada nodo y el factor de equilibrio
    // calcula FE
    public AVLNode<T> nodoDesbalanceado(AVLNode<T> root) {
        if (root == null) 
            return null; 
        
        int fe = root.getFE(root);
        if (Math.abs(fe) > 1) 
            return root; 
        
        AVLNode<T> izqDesbalanceado = nodoDesbalanceado(root.getLeft());
        
        if (izqDesbalanceado != null)
            return izqDesbalanceado; 
        
        AVLNode<T> derDesbalanceado = nodoDesbalanceado(root.getRight());
        
        if (derDesbalanceado != null) 
            return derDesbalanceado;
        
        return null; 
    }
    
    public void desbalanceador(AVLNode<T> guide){ // el guia es el nodo desbalanceado  
        if (root == null)
            return;
        
        if (guide.getFE(guide) == -2) { // gamma o alpha
            AVLNode<T> alpha = guide.getLeft();
            
            if (alpha.getFE(alpha) == -1 ||
                    alpha.getFE(alpha) == 0)
                rotacionDerechaDerecha(guide);
            if(alpha.getFE(alpha) == 1)
                rotacionIzquierdaDerecha(guide);    // checar si si se manda ese 
        }
        
        if (guide.getFE(guide) == 2){   // gamma
            AVLNode<T> alpha = guide.getRight();
            if(alpha.getFE(alpha) == 1 || 
                    alpha.getFE(alpha) == 0)
                rotacionDerechaDerecha(guide);
            if (alpha.getFE(alpha) == -1)
                rotacionDerechaIzquierda(guide);
        }
            
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
            
            if (elem.compareTo(act.getValor()) <= 0)
                act = act.getLeft();
            else
                act = act.getRight();
        }
        
        dad.hang(newNode);
    }
    
    public T remove(T elem) {       
        AVLNode<T> guide = searchBinary(elem);
        
        if (guide == null)
            throw new RuntimeException("null");
        
        if (guide.getLeft() == null && guide.getRight() == null) 
            return caseOneRemove(guide);
        
        if (guide.getLeft() == null || guide.getRight() == null)
            return caseTwoRemove(guide);
        
        if (guide.getRight() != null && guide.getLeft() != null){
            AVLNode<T> sucesor = sucesorInOrder(guide); 
            guide.setValor(sucesor.getValor());
            caseOneRemove(sucesor);
        }
            
        
        return guide.getValor();
    }
    
    public AVLNode<T> searchBinary(T elem){
        AVLNode<T> guide = root;
        
        while (guide != null && !guide.getValor().equals(elem))
            if (elem.compareTo(guide.getValor()) <= 0)
                guide = guide.getLeft();
            else
                guide = guide.getRight();
        
        
        return guide;
    }
    
    public AVLNode<T> sucesorInOrder(AVLNode<T> guide){
        if (guide == null || guide.getRight() == null)
            return null;
        
        AVLNode<T> inOrd = guide.getRight();
        
        while (inOrd.getLeft() != null){
            inOrd = inOrd.getLeft();
        }
        
        return inOrd;
    }
    
    private T caseOneRemove(AVLNode<T> guide) {
        T temp = null;
        
        if (guide.equals(root)){
                temp = (T) root.getValor();
                root = null;
                return temp;
        }
        
        temp = (T) guide.getValor();

        if (temp.compareTo((T)guide.getPapa().getValor()) > 0)
            guide.getPapa().setRight(null);
        else
            guide.getPapa().setLeft(null);

        return temp;
    }
    
    private T caseTwoRemove(AVLNode<T> guide){
        T temp = null;
        
        AVLNode<T> son;
            
        if (guide.getLeft() != null)
            son = guide.getRight();
        else
            son = guide.getLeft();

        if (guide.equals(root))
            root = son;
        else
            guide.getPapa().hang(son);
        temp = son.getValor();
        
        return temp; 
    }
    
    public void rotacionDerechaDerecha(AVLNode gamma) {
        AVLNode<T> papa = gamma.getPapa();
        AVLNode<T> A,B,C,D,beta,alpha;
            
        alpha = gamma.getLeft();
        beta = alpha.getLeft();
        C = alpha.getRight();
        D = gamma.getRight();
        
        alpha.setRight(gamma);
        gamma.setLeft(C);
        gamma.setRight(D);
        papa.hang(alpha);
    }
    
    public void rotacionIzquierdaIzquierda(AVLNode<T> gamma){
        AVLNode<T> papa = gamma.getPapa();
        AVLNode<T> A,B,C,D,alpha,beta;
        
        alpha = gamma.getRight();
        beta = alpha.getRight();
        A = gamma.getLeft();
        B = alpha.getLeft();
        
        alpha.setLeft(gamma);
        gamma.setRight(B);
        papa.hang(alpha);
    }
    
    public void rotacionIzquierdaDerecha(AVLNode<T> alpha){
        AVLNode<T> beta, gamma,B,C;
        AVLNode<T> papa = alpha.getPapa();
        
        beta = alpha.getLeft();
        gamma = beta.getRight();
        B = gamma.getLeft();
        C = gamma.getRight();
        
        gamma.setLeft(beta);
        gamma.setRight(alpha);
        beta.setRight(B);
        alpha.setLeft(C);
        papa.hang(gamma);
    }
    
    public void rotacionDerechaIzquierda(AVLNode<T> alpha){
        AVLNode<T> beta,gamma,B,C;
        AVLNode<T> papa = alpha.getPapa();
        
        beta = alpha.getRight();
        gamma = beta.getLeft();
        B = gamma.getLeft();
        C = gamma.getRight();
        
        gamma.setLeft(alpha);
        gamma.setRight(beta);
        alpha.setRight(B);
        beta.setLeft(C);
        papa.hang(gamma);
    }
    
    public void print(AVLNode<T> root) {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<AVLNode<T>> level = new ArrayList<AVLNode<T>>();
        List<AVLNode<T>> next = new ArrayList<AVLNode<T>>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (AVLNode<T> n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.toString();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }
            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<AVLNode<T>> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }
        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
}