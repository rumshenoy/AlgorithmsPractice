package com.algorithmspractice.sorting;

public class QuickSort {
    public static void main(String args[]){
        int[] input = {3, 1, 9, 2, 8, 7};
        quickSort(input, 0, input.length-1);
        printArray(input);
    }

    private static void printArray(int[] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(anArray[i]);
        }
    }

    private static void quickSort(int[] array, int p, int r){
        if(p < r){
            int q = partition(array, p, r);
            quickSort(array, p, q-1);
            quickSort(array, q+1, r);
        }
    }

    private static int partition(int[] array, int p, int r) {
        int q = p;
        for(int j = p; j < r; j++){
            if(array[j] <= array[r]){
                swap(array, j, q);
                q++;
            }
        }

        swap(array, r, q);
        return q;
    }


    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
