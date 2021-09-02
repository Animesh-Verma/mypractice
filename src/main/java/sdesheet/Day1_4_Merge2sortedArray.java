package sdesheet;

import java.util.Arrays;

public class Day1_4_Merge2sortedArray {
    public static void main(String[] args) {
        int[] x = new int[]{1, 4, 7, 8, 10};
        int[] y = new int[]{2, 3, 9};
        int i, k;
        for (i = 0; i < x.length; i++) {
            if (x[i] > y[0]) {
                int temp = x[i];
                x[i] = y[0];
                y[0] = temp;
                int first = y[0];
                for (k = 1; k < y.length && y[k]<first ;k++){
                    y[k-1] = y[k];
                }
                y[k-1] = first;
            }
        }
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));

    }
}
