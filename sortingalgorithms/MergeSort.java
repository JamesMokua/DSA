package sortingalgorithms;

public class MergeSort {
    public void merge(int[] A, int left, int middle, int right) {
        int[] leftTmpArray = new int[middle - left + 2];// +2 is to avoid out of index array exceptions
        int[] rightTmpArray = new int[right - middle + 1];// +1 is to avoid out of index array exceptions
        for (int i = 0; i <= middle - left; i++) {//loop for copying elements to the temporary left array until the middle element
            leftTmpArray[i] = A[left + i];
        }
        for (int i = 0; i < right - middle; i++) {//loop for copying elements to the temporary right array until the middle element
            rightTmpArray[i] = A[middle + 1 + i];
        }
        //merge the two arrays into array A
        leftTmpArray[middle - left + 1] = Integer.MAX_VALUE;
        rightTmpArray[right - middle] = Integer.MAX_VALUE;

        int i = 0, j = 0;//i is for left temp array and j is for right temp array
        for (int k = left; k <= right; k++) {
            if (leftTmpArray[i] < rightTmpArray[j]) {
                A[k] = leftTmpArray[i];//add it to the left array if its smaller
                i++;
            } else {
                A[k] = rightTmpArray[j];//add it to the right array if its bigger
                j++;
            }

        }

    }

    public void mergeSort(int[] Array, int left, int right) {
        if (right > left) {
            int m = (left + right) / 2;//calculate the middle
            mergeSort(Array, left, m);//recursively call mergesort for left array
            mergeSort(Array, m + 1, right);//recursively call mergesort for right array
            merge(Array, left, m, right);//now merge the array
        }
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int array[] = {10,3,2,5,8,4,3,1,2,9,7,8};
        ms.mergeSort(array, 0, array.length-1);
        ms.printArray(array);
    }
}
