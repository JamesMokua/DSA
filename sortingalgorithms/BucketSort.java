package sortingalgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    int arr[];

    public BucketSort(int arr[]) {
        this.arr = arr;
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    // Print Buckets(not compulsory)
    public void printBucket(ArrayList<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("\nBucket#" + i + ":");
            for (int j = 0; j < buckets[i].size(); j++) {
                System.out.print(buckets[i].get(j) + " ");
            }
        }
    }

    // BucketSorting
    public void bucketSort() {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int value : arr) {
            int bucketNumber = (int) Math.ceil(((float) value * numberOfBuckets) / (float) maxValue);
            buckets[bucketNumber - 1].add(value);
        }
        // not compulsory
        System.out.println("\n\nPrinting buckets before sorting....");
        printBucket(buckets);

        /// needed
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        // not compulsory
        System.out.println("\n\nPrinting buckets after sorting....");
        printBucket(buckets);

        // needed
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index] = value;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 9, 7, 5, 4, 2, 1, 3, 6, 8 };
        BucketSort bs = new BucketSort(arr);
        bs.printArray(arr);
        bs.bucketSort();
        System.out.println();
        bs.printArray(arr);
    }
}
