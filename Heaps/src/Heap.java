public class Heap <T extends Comparable<T>> {
    T[] datos;
    int cont;

    public T findMin(){
            if (cont > 0)
                    return datos[1];
            return null;
    }

    public void inserta(T dato) {
            if (datos.length <= cont + 1)
                    expande(datos);
            cont++;
            datos[cont] = dato;
            int num = cont;

            while (num > 1 && datos[num].compareTo(datos[num>>1]) < 0){
                    swap(datos, num, num>>1);
                    num = num>>1;
            }
    }

    public void borra(T dato){
        boolean termine = true;
        int num = 1;
        int min = 0;
        
        while (!termine) {
            if(num*2 > cont)
                termine = true;
            else {
               if ((num*2)+1 > cont)   // no tengo hijo derecho
                    min = num*2;
               else if (datos[num*2].compareTo(datos[num*2+1]) < 0)
                    min = num*2;
               else
                    min = (num*2)+1;
            }
            
        }
        
    }
    
//    public void insertaEnlazado(T dato) {
//            NodoHeap<T> newNode = new NodoHeap(dato);
//            NodoHeap<T> actual = raiz;
//
//            int niveles = (int)log(cont)/log(2);
//            int mask = 1<<(niveles-1)
//
//            while (mask > 1){
//                    if ((cont & mask) == 0)
//                            actual = actual.izq;
//                    else
//                            actual = actual.der;
//
//                    mask = mask>>1;
//            }
//
//            cuelga(actual,nuevo);
//    }

    private void expande(T[] arr){
        Object[] newArr = new Object[arr.length * 2];
        
        for (int i = 0; i < newArr.length ; i++){
            arr[i] = (T) newArr[i];
        }
        
        arr = (T[]) newArr;
    }
    
    private void swap(T[] arr, int i, int j){
        T save = arr[i];
        
        arr[i] = arr[j];
        arr[j] = save;
    }

}