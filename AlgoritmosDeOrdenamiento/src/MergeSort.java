public class MergeSort<T extends Comparable<T>> {
    
    private int compareToCount;
    
    public int sort(T[] arr, int left, int right) {
        compareToCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
        return compareToCount;
    }
    
    private void merge(T[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        T[] L = (T[]) new Comparable[n1];
        T[] R = (T[]) new Comparable[n2];
        
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            compareToCount++;
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
