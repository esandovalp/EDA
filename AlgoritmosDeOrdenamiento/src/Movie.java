
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Movie implements Comparable{
    // atributos
    private int id;
    private int year;
    private String title;
    
    public Movie(int id, int year, String title) {
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
        return "Title: " + title + ", Movie ID: "  + id + ", Year of Release: " + year;
    }
    
     @Override
    public int compareTo(Object o) {
        return this.year - ((Movie)o).year;
    }

    
}
