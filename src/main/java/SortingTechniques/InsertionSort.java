package SortingTechniques;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        int element = 0;
        for (int i = 1; i < arr.length; i++) {
            element = arr[i];
            int j;
            for (j = i-1 ; j > -1 && arr[j] > element; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = element;
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));

//        for (int i = 1; i < arr.length; i++) {
//            element = arr[i];
//            int j;
//            for (j = i; j > 0 && arr[j-1] > element; j--) {
//                arr[j] = arr[j-1];
//            }
//            arr[j]=element;
//        }
//        System.out.println(Arrays.toString(arr));

    }
}
