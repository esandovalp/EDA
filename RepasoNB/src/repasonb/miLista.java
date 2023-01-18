
package repasonb;

public class miLista <T>{
  Nodo <T> cabeza; 
  int cont; 
  
  public miLista(){
    cabeza = new  Nodo<T>(); 
    cont=0; 
  }

  public void inserta(T elem){
      Nodo<T> temp=cabeza.getSiguiente(), nuevo= new  Nodo<T>(elem);
      nuevo.setSiguiente(temp);
      cabeza.setSiguiente(nuevo);
      cont++;

    }

  //To string para hacer tus pruebas
  public String toString(){
    String cad="";
    Nodo<T> actual = cabeza.getSiguiente();
    while(actual != null){
      cad+=actual.getDato().toString()+" ";
      actual = actual.getSiguiente();
    }
    return cad.toString();
  }
  //Cuantos elementos hay recursivo
  private int cuantosHay(int cont, Nodo<T> actual){
      if (actual == null){
          return cont;
      }
      else{
          cont ++;
          actual = actual.getSiguiente();
          return cuantosHay(cont, actual);
      }
  }
  
  public int cuantosHay(){
      return cuantosHay(0, cabeza.getSiguiente());
  }
  //otra versión para contar elementos
  private int cuenta(Nodo<T> actual){
    if (actual==null)
      return 0;
    return cuenta(actual.getSiguiente())+1;
  }
  public int cuenta(){
    return cuenta(cabeza.getSiguiente());
  }
  
  public void invierte(){
      invierte(cabeza.getSiguiente());
  }
  private void invierte(Nodo<T> actual){
      if (actual == null)
          return;
      
      invierte(actual.getSiguiente());
      System.out.print(actual.getDato());
  }
  
  private Nodo<T> invierteDato(Nodo<T> actual){
      if (actual == null)
          return cabeza;
      
      Nodo<T> temp = invierteDato(actual.getSiguiente());
      System.out.println(temp.getDato() + " " + actual);
      
      return invierteDato(temp.getSiguiente());
  }
  
  public void invierteDato(){
      invierte(cabeza.getSiguiente());
  }
  
  public void invierteNod(){
      invierteNod(cabeza.getSiguiente());
  }
  
  private Nodo<T> invierteNod(Nodo<T> actual){
      if (actual != null){ 
          Nodo <T> temp = invierteNod(actual.getSiguiente());
          temp.setSiguiente(actual);
          actual.setSiguiente(null);
          return actual;
      }
      return cabeza;
  }
}
