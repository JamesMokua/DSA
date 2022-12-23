package sortingalgorithms;

public class QuickSort {
    public int partition(int[] array, int start, int end) {
        int pivot = end;//for simplicity set the rightmost number
        int i = start - 1;//to take into account zero index we use -1
        for (int j = start; j <= end; j++) {
            if (array[j] <= array[pivot]) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        return i;//returns new pivot
    }

    public void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);//call recursively for left sub array
            quickSort(array, pivot + 1, end);//call recursively for right sub array
        }
    }

    public  void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int array[] = {10,3,2,7,7,5,8,4,1,2,9,7,8,11};
        qs.quickSort(array, 0, array.length-1);
        qs.printArray(array);
    }
}
