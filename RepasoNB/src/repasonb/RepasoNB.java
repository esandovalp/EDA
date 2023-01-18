
package repasonb;

public class RepasoNB {

    public static void main(String[] args) {
        miLista<Integer> lista1 = new miLista<Integer>();
        
        lista1.inserta(1);
        lista1.inserta(2);
        lista1.inserta(3);
        
        System.out.println(lista1.toString() + " \n");
        
        lista1.invierteNod();
        
        System.out.println(lista1.toString());
        
        
        
    }
    
}
