
import java.util.Arrays;


public class Sort {

// Selection Sort O(n^2)
//    private int compareSS =0;
    
    public <T extends Comparable<T>> void selectionSort(T[] arr){  
        for (int i=0; i < arr.length; i++) {
            int min = i;
            for (int j=i+1; j < arr.length; j++)
                if (arr[min].compareTo(arr[j]) >=0) {
                    min = j;
                }
            swap(arr,i,min);
        }
    }
    
    // Insertion Sort O(n)
    public <T extends Comparable<T>> void insertionSort(T[] arr, int n){
        
        for (int i = 1; i < n; i++){    
            int j = i;
            
            while( j>=1 && arr[j].compareTo(arr[j-1]) < 0){
                swap(arr, j, j-1);
                j--;
            }
            
        }
    }
    
    // Bubble sort O(n^2)
    public <T extends Comparable<T>> void bubbleSort(T[] arr, int n){
        for (int i=0; i < n; i++)
            for (int j = i+1; j < n; j++)
                if (arr[i].compareTo(arr[j]) >= 0) {
                    swap (arr,i,j);
                }
                    
    }
    
    // Quick sort O(n^2) es el unico recursivo
    public  <T extends Comparable<T>> void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        T pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;
        return i + 1;
    }
    
    // Merge Sort O(nlog(n))
    public <T extends Comparable<T>> void mergeSort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }
    
    private <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    
    private <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        T[] leftArray = (T[]) new Comparable[leftSize];
        T[] rightArray = (T[]) new Comparable[rightSize];
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = array[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    private <T> void swap(T[] arr, int i, int j){
        T copy = arr[i];
        arr[i] = arr[j];
        arr[j] = copy;        
    }
}
