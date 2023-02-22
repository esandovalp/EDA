public class QuickSortWithCounter<T extends Comparable<T>> {

    private int numComparisons;

    public void sort(T[] array) {
        numComparisons = 0;
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private int partition(T[] array, int left, int right) {
        T pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            numComparisons++;
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

    public int getNumComparisons() {
        return numComparisons;
    }

}

