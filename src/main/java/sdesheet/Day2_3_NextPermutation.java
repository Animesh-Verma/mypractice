package sdesheet;

import javax.print.event.PrintEvent;
import java.util.Arrays;

public class Day2_3_NextPermutation {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 4, 2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] arr) {
        if (arr == null || arr.length <= 1){
            return;
        }
        int i = arr.length-2;
        while (i>=0 && arr[i] >=arr[i+1]) {
            i--;
        }
        System.out.println("Value of i "+i);
        if(i>=0){
            int j = arr.length -1 ;
            while (arr[j]<=arr[i]) {
                j--;
            }
            System.out.println("Value of j "+j);
            swap(arr,i,j);
        }
        reverse(arr,i+1,arr.length-1);
    }

    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int arr[], int i,int j){
        while (i<j){
            System.out.println("reverse "+Arrays.toString(arr));
            swap(arr,i++,j--);
        }
    }
}
