package sortingalgorithms;

public class InsertionSort {
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i], j = i;
            while (j > 0 && arr[j - 1] > temp) {// if previoud element is greater than next element swap them
                // j-1 == prevous element
                arr[j] = arr[j - 1];
                j--;

            }
            arr[j] = temp;

        }
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int arr[] = { 10, 3, 2, 5, 8, 4, 3, 1 };
        is.insertionSort(arr);
        is.printArray(arr);
    }
}
