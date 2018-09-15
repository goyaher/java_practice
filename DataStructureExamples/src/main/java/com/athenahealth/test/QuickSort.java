package com.athenahealth.test;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int length = Integer.parseInt(s.nextLine());
        int[] arr = new int[length];
        for (int i=0; i<length; i++)
        {
            arr[i] = s.nextInt();
        }
        quickSort(arr, 0, length-1);
//        printArray(arr);
    }
    
    static void quickSort(int[] arr, int start, int end)
    {
        if (start < end)
        {
            int p = partition(arr, start, end);
            printArray(arr);
            quickSort(arr, start, p-1);
            quickSort(arr, p+1, end);
        }
    }
    
    static void printArray(int[] arr)
    {
        Arrays.stream(arr).forEach(x->System.out.print(x+ " "));
        System.out.println();
    }
    
    static int partition(int[] arr, int start, int end)
    {
        int pivot = arr[end];
        int left = start;
        int right = end-1;
        
        while (left < right)
        {
            while (arr[left] < pivot) left++;
            while (right> 0 && arr[right] > pivot) right--;
            
            if (left < right)
            {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        
        if (arr[left]>pivot)
        {
        	arr[end] = arr[left];
        	arr[left] = pivot;
        }
        return left;
    }
}