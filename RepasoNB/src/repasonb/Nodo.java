
package repasonb;

public class Nodo <T>{
    private T dato;
    private Nodo<T> siguiente;
    
    public Nodo(){
        dato=null;
        siguiente = null;
    }
    
    public Nodo(T dato){;
        this.dato = dato;
        siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    public boolean equals(Nodo<T> nod){
        return this.getDato()== nod.getDato();
    }
}
