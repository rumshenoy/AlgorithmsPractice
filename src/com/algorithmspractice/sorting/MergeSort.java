package com.algorithmspractice.sorting;

public class MergeSort {
    public static void main(String args[]){
        int[] input = {3, 1, 9, 2, 8, 7};
        mergeSort(input, 0, input.length-1);
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

    public static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int i, j, k;
        int n1 = mid - start +1;
        int n2 = end - mid;

        int[] L= new int[n1];
        int[] R = new int[n2];

        for (i = 0; i < n1; i++)
            L[i] = arr[start + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[mid + 1+ j];

        i=0;
        j=0;
        k=start;

        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k++] = L[i++];
            }else{
                arr[k++] = R[j++];
            }
        }

        while(i < n1){
            arr[k++] = L[i++];
        }

        while(j < n2){
            arr[k++] = R[j++];
        }
    }
}
