package SortingTechniques;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomNumber(1, 50);
        }

        Arrays.stream(arr).forEach(value -> {
            System.out.print(" "+value);
        });

        System.out.println();

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
               if (arr[j] > arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
            }
        }
        Arrays.stream(arr).forEach(value -> {
            System.out.print(" "+value);
        });    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
