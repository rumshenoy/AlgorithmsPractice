package com.algorithmspractice.sorting;

public class InsertionSort {
    public static void main(String args[]){
        int[] arr = {10, 9, 7, 2, 3, 11};
        printArray(insertionSort(arr, arr.length));
    }

    private static void printArray(int[] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(anArray[i]);
        }
    }
    public static int[] insertionSort(int arr[], int n) {
        int i, key, j;

        for (i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }

        return arr;
    }
}
