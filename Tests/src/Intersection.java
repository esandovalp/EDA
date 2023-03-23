
import java.lang.reflect.Array;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author coron
 */
public class Intersection {
   public static int[] interseccion(int[] arr1, int[] arr2){
       int[] res = new int[arr1.length];
       int x = 0;
       
       for (int i=0; i < arr1.length; i++){
           for (int j=0; j < arr2.length; j++)
               if (arr1[i] == arr2[j]){
                   res[x] = arr1[i];
                   x++;
               }
       }
       
       return res;
   }
   
   public static int[] multipleIntersection(int[][] arrs){
       int[] res = arrs[0];
       
       for (int i = 0; i < arrs.length; i++){
           res = interseccion(res, arrs[i]) ;
       }
       
       return res;
   }
   
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {2,3,5};
        
        System.out.println("Interseccion: " + interseccion(arr1,arr2).toString());
    }
}
