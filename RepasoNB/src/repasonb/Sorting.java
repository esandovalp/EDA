
package repasonb;

import java.util.Arrays;

public class Sorting  {
    // Selection Sort O(n^2)
    public static <T extends Comparable<T>> void selectionSort(T[] arr){  
        
        for (int i=0; i < arr.length; i++) {
            int min = i;
            for (int j=i+1; j < arr.length; j++)
                if (arr[min].compareTo(arr[j]) >=0)
                    min = j;
            swap(arr,i,min);
        }
    }
    
    private static <T> void swap(T[] arr, int i, int j){
        T copy = arr[i];
        arr[i] = arr[j];
        arr[j] = copy;        
    }
    
    // Insertion Sort O(n)
    public static <T extends Comparable<T>> void insertionSort(T[] arr, int n){
        
        for (int i = 1; i < n; i++){    
            int j = i;
            
            while( j>=1 && arr[j].compareTo(arr[j-1]) < 0){
                swap(arr, j, j-1);
                j--;
            }
            
        }
    }
    
    // Bubble sort O(n^2)
    public static <T extends Comparable<T>> void bubbleSort(T[] arr, int n){
        for (int i=0; i < n; i++)
            for (int j = i+1; j < n; j++)
                if (arr[i].compareTo(arr[j]) >= 0)
                    swap (arr,i,j);
    }
    
    // Quick sort O(n^2)
    public static <T extends Comparable<T>> void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
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
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }
    
    private static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    
    private static <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
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
    
    public static <T extends Comparable<T>> void merge(int leftFirst, int leftLast, int rightFirst, int rightLast, T[] array){
        T[] tempArray = Arrays.copyOf(array,array.length);
        int index = leftFirst;
        int saveFirst = leftFirst;

        while((leftFirst <= leftLast) && (rightFirst <= rightLast)){
            if(array[leftFirst].compareTo(array[rightFirst]) < 0){
                tempArray[index] = array[leftFirst];
                leftFirst++;
            }else{
                tempArray[index] = array[rightFirst];
                rightFirst++;
            }
            index++;
        }
        while(leftFirst <= leftLast){
            tempArray[index] = array[leftFirst];
            leftFirst++;
            index++;
        }
        while(rightFirst <= rightLast){
            tempArray[index] = array[rightFirst];
            rightFirst++;
            index++;
        }
        for(index = saveFirst; index <= rightLast;index++){
            array[index] = tempArray[index];
        }
    }
    
    private static <T extends Comparable<T>> int partitioning(T[] arr, int start, int end) {
        T pivot = arr[end];
        int balancePoint = start; // everything that's smaller to the left of this, the rest to the right

        for (int i = start; i < end; i++) {
            if(arr[i].compareTo(pivot)<=0) {
                swap(arr, i, balancePoint);
                balancePoint++;
            }
        }

        swap(arr, end, balancePoint);

        return balancePoint;
    }
    
    public static void main(String[] args) {
        System.out.println("Selection Sort: ");
        Double[] selectionSortArray = {2.0,7.0,13.0,1.0,6.0,-7.0,4.0,0.0,1800.0,3.14,0.075};
        System.out.println(Arrays.toString(selectionSortArray));
        selectionSort(selectionSortArray);
        System.out.println(Arrays.toString(selectionSortArray));
        
        System.out.println("\nInsertion Sort: ");
        Integer[] insertionSortArray = {4,2,6,0};
        System.out.println(Arrays.toString(insertionSortArray));
        insertionSort(insertionSortArray,insertionSortArray.length);
        System.out.println(Arrays.toString(insertionSortArray));
        
        System.out.println("\nBubble Sort: ");
        Integer[] bubbleSortArray = {5, 1, 4, 2, 8};
        System.out.println(Arrays.toString(bubbleSortArray));
        bubbleSort(bubbleSortArray,bubbleSortArray.length);
        System.out.println(Arrays.toString(bubbleSortArray));
        
        System.out.println("\nQuick Sort: ");
        Integer[] quickSortArray = {6,9,2,5,1};
        System.out.println(Arrays.toString(quickSortArray));
        quickSort(quickSortArray);
        System.out.println(Arrays.toString(quickSortArray));
        
        System.out.println("\nMerge Sort: ");
        Integer[] mergeSortArray = {23, 50, 8, 28, 3, 50, 36,48,47,22,8};
        System.out.println(Arrays.toString(mergeSortArray));
        mergeSort(mergeSortArray);
        System.out.println(Arrays.toString(mergeSortArray));
    }
}
