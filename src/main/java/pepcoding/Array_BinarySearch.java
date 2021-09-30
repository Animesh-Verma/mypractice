package pepcoding;

import java.util.Scanner;

public class Array_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 70, 70, 70, 80, 90, 100};
        int data = 70;

        int first = 0;
        int last = arr.length - 1;
        boolean flag = true;

        while (first <= last) {
            int mid = (first + last) / 2;
            if (data > arr[mid]) {
                first = mid + 1;
            } else if (data < arr[mid]) {
                last = mid - 1;
            } else {
                System.out.println(mid);
                flag = false;
                return;
            }
        }
        if (flag) {
            System.out.println(-1);
        }
    }
}
