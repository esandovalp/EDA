
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Pelicula implements Comparable{
    // atributos
    private int id;
    private int year;
    private String title;

    public Pelicula() {
    }

    public Pelicula(int id, int year, String title) {
        this.id = id;
        this.year = year;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", movie ID: "  + id + ", year of release: " + year;
    }
    
     @Override
    public int compareTo(Object o) {
        return this.year - ((Pelicula)o).year;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        File doc = new File("movie_titles");
        Scanner read = new Scanner(doc);
        String movie;
        int n;
        ArrayList arr = new ArrayList();
        
        while (read.hasNextLine()){
            // luego un arreglo que almacene datos del tipo de esa clase.
            movie = read.nextLine();
            n = movie.indexOf(",");
            
            String id = movie.substring(0,n);
            String yearOfRelease = movie.substring(n+1,n+5);
            String title = movie.substring(n+6);
            
            Pelicula p = new Pelicula(Integer.parseInt(id), Integer.parseInt(yearOfRelease), title);
            arr.add(p);
           
        }
    }

    
}
