
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author coron
 */
public class MainMovie {
    public static void main(String[] args) throws FileNotFoundException {
        File doc = new File("movie_titles");
        Scanner read = new Scanner(doc);
        String movie;
        int n;
        final int MAX = 5;      // Son 17770
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
        
        long start = System.nanoTime();
        sortArrays.selectionSort    (arrP);
        long end = System.nanoTime();
        long finalRunTime = end - start;
        
        System.out.println("\nSorted array: \n");
        for (Movie m : arrP) 
            System.out.println(m);
        System.out.println("\nFinal run time: " + finalRunTime);
    }
}
