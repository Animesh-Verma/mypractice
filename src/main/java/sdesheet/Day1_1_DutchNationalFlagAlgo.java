package sdesheet;

import java.util.Arrays;

public class Day1_1_DutchNationalFlagAlgo {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,0,2,0,1,2};
        System.out.println(Arrays.toString(arr));
        int lo = 0;
        int hi = arr.length-1;
        int mid = 0;
        int temp;

        while (mid<=hi){
            switch (arr[mid]){
                case 0:
                 temp = arr[lo];
                 arr[lo] = arr[mid];
                 arr[mid]=temp;
                 lo++;
                 mid++;
                 break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[hi];
                    arr[hi] = arr[mid];
                    arr[mid] = temp;
                    hi--;
                    break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
