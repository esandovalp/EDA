
package repasonb;

public class ejerciciosRepaso {
    
    // Método para ver cuantas permutaciones se puede hacer dada una cadena 
    public static void permutacionesString(String cadena){
        permutacionesString(cadena, " ");
    }
    private static void permutacionesString(String cadena, String ans) {
        
        // estado base 
        if (cadena.length() == 0) {
            System.out.print(ans + " "); 
            return;
        }
 
        for (int i = 0; i < cadena.length(); i++) {
 
            // character el cual sirve como "fija" 
            char ch = cadena.charAt(i);
 
            // "fija" + resto de la cadena 
            String resto = cadena.substring(0, i) + cadena.substring(i + 1); 
            
            permutacionesString(resto, ans + ch);
        }
    }
    
    // Escriba (piense cómo hacer) un método recursivo para calcular la distancia entre dos cadenas S1 y S2
    
    // Hamming distance
    public static double hammingDistance(String s1, String s2) {
        if (s1.length() != s2.length())
            return -1;
        
        char ch1, ch2;
        double dif = 0;
        
        for (int i=0; i < s1.length(); i++){
            ch1 = s1.charAt(i);
            ch2 = s2.charAt(i);
            
            if (ch1 == ch2)
                dif++;
        }
        
        return dif/s1.length();     // forma normalizada de regresar una hamming distance 
    }
    
    // Levenshtein distance (es la que pide el profesor) 
    
    
    
    public static void main(String[] args) {
        
        String cadena1 = "abc";
        System.out.println("Prueba cadena como se vio en clase: " + cadena1);
        permutacionesString(cadena1);
        
        System.out.println("\nPrueba cadena vacia: ");
        
        String cadenaVacia = "";
        permutacionesString(cadenaVacia);
        
        System.out.println("\nHamming distance: ");
        String hdS1 = "time", hdS2 = "mine";
        System.out.println(hammingDistance(hdS1, hdS2));    // 50% de estos caracteres no son similares
        
        System.out.println("\nLevenshtein Distance: ");
        
    }
}
