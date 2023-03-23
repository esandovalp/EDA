
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
    public AVLNode<T> searchAVL(T elem){
        AVLNode<T> guide = root;
        
        while (guide != null && !guide.getValor().equals(elem))
            if (elem.compareTo(guide.getValor()) <= 0)
                guide = guide.getLeft();
            else
                guide = guide.getRight();
        
        
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
            
            if (elem.compareTo(act.getValor()) <= 0)
                act = act.getLeft();
            else
                act = act.getRight();
        }
        
        dad.hang(newNode);
    }
    
    public void rotacionDerecha(AVLNode gamma) {
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
    
    public void rotacionIzquierda(AVLNode<T> gamma){
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
    
    public void rotaciones(){
        AVLNode<T> guide = root;
        
        while (guide.getLeft() != null || guide.getRight() != null){
            if (guide.getLeft().getFE() == -2){ // caso izquierda algo
                
            }
        }
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