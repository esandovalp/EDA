
import com.sun.nio.sctp.AssociationChangeNotification;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author coron
 */
public class MainMovie {
    
     static <T extends Comparable<T>> void reverse(T a[], int n)
    {
        T t;
        int i, k;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }
     
     static<T extends Comparable<T>> void shuffleArray(T[] ar)
  {
    // If running on Java 6 or older, use `new Random()` on RHS here
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      T a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }
     
    public static void main(String[] args) throws FileNotFoundException {
        File doc = new File("movie_titles");
        Scanner read = new Scanner(doc);
        String movie;
        int n;
        final int MAX = 17770;      // Son 17770
        Sort sortArrays = new Sort();
        Movie[] arrP = new Movie[MAX];
        int count = 0;
        
        while (read.hasNextLine() && count < MAX){
            // luego un arreglo que almacene datos del tipo de esa clase.
            movie = read.nextLine();
            n = movie.indexOf(",");
            
            String id = movie.substring(0,n);
            String yearOfRelease = movie.substring(n+1,n+5);
            String title = movie.substring(n+6);
            
            Movie p = new Movie(Integer.parseInt(id), Integer.parseInt(yearOfRelease), title);
            arrP[count] = p;
            count++;
        }
        
        System.out.println("Movies in array (Currently: " + MAX + "): ");
        for (Movie m : arrP) 
            System.out.println(m);
        
        MergeSort msCC = new MergeSort();
        QuickSortWithCounter qsCC = new QuickSortWithCounter();
        
        


        long average = 0;
        int ncc = 0;
        
//        for (int i = 0; i <= 30; i++){
//            shuffleArray(arrP);
//            ncc += msCC.sort(arrP, 0, arrP.length-1);
//            
//        }
        
        average = ncc/30;
        
        
        long start = System.nanoTime();
 for (int i = 0; i <= 30; i++){
            shuffleArray(arrP);
            ncc += msCC.sort(arrP, 0, arrP.length-1);
            
        }
        long end = System.nanoTime();
        long finalRunTime = end - start;
        
        

        
        System.out.println("\nRandom Shuffle array: \n");
        for (Movie m : arrP) 
            System.out.println(m);
//        System.out.println( "\nAverage compareTos: " + average);
        System.out.println("\nFinal run time: " + finalRunTime);
    }
}
