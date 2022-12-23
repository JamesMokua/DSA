package sortingalgorithms;

public class SelectionSort {
  public void selectionSort(int[] a) {
    for (int j = 0; j < a.length; j++) {
      int minimumIndex = j;
      for (int i = j + 1; i < a.length; i++) {// find minimum element
        if (a[i] < a[minimumIndex]) {
          minimumIndex = i;
        }
      }
      if (minimumIndex != j) {// swap minimum element with the left edge element
        int temp = a[j];
        a[j] = a[minimumIndex];
        a[minimumIndex] = temp;
      }
    }
  }

  public void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }

  }

  public static void main(String[] args) {
    SelectionSort ss = new SelectionSort();
    int arr[] = { 10, 3, 2, 5, 8, 4, 1, 9 };
    ss.selectionSort(arr);
    ss.printArray(arr);
  }
}
