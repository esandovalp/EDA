
public class Sort {
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
    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            // choose pivot index
            int pivotIndex = partition(arr, low, high);
            
            // sort the left sub-array
            quickSort(arr, low, pivotIndex - 1);
            
            // sort the right sub-array
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        // choose pivot value
        T pivotValue = arr[high];
        int i = low - 1;    // partition index 
        
        for (int j = low; j <= high - 1; j++) {
            if (arr[j].compareTo(pivotValue) <= 0) {
                i++;
                
                // swap arr[i] and arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // swap arr[i + 1] and arr[high]
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    // Merge Sort
    public static <T extends Comparable<T>> void mergeSort(T[] array, int start, int end)
    {
        // base case
        if (start < end) {
            // find the middle point
            int middle = (start + end) / 2;

            mergeSort(array, start, middle); // sort first half
            mergeSort(array, middle + 1, end);  // sort second half

            // merge the sorted halves
            merge(array, start, middle, end);
        }
    }

    // merges two subarrays of array[].
    private static <T extends Comparable<T>> void merge(T[] array, int start, int middle, int end) {
        T[] leftArray  = (T[]) new Comparable[middle - start + 1];
        T[] rightArray = (T[]) new Comparable[end - middle];

        // fill in left array
        for (int i = 0; i < leftArray.length; ++i)
            leftArray[i] = array[start + i];

        // fill in right array
        for (int i = 0; i < rightArray.length; ++i)
            rightArray[i] = array[middle + 1 + i];

        /* Merge the temp arrays */

        // initial indexes of first and second subarrays
        int leftIndex = 0, rightIndex = 0;

        // the index we will start at when adding the subarrays back into the main array
        int currentIndex = start;

        // compare each index of the subarrays adding the lowest value to the currentIndex
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0){
                array[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            }
            else {
                array[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            
            currentIndex++;
        }

        // copy remaining elements of leftArray[] if any
        while (leftIndex < leftArray.length) 
            array[currentIndex++] = leftArray[leftIndex++];

        // copy remaining elements of rightArray[] if any
        while (rightIndex < rightArray.length) 
            array[currentIndex++] = rightArray[rightIndex++];
    }
}
