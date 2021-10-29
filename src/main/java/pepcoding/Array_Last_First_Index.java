package pepcoding;

import java.util.Scanner;

public class Array_Last_First_Index {
 //   public static void main(String[] args) {
//        int[] arr = {10, 20, 30, 40, 50, 60, 70, 70, 70, 70, 80, 90, 100};
//        int data = 70;
//
//        int first = 0;
//        int last = arr.length - 1;
//        boolean flag = true;
//        int li = -1;
//        int fi = -1;
//
//        while (first <= last) {
//            int mid = (first + last) / 2;
//            if (data > arr[mid]) {
//                first = mid + 1;
//            } else if (data < arr[mid]) {
//                last = mid - 1;
//            } else {
//                li = mid;
//                first = mid + 1;
//            }
//        }
//        System.out.println(li);
//
//        first = 0;
//        last = arr.length - 1;
//        while (first <= last) {
//            int mid = (first + last) / 2;
//            if (data > arr[mid]) {
//                first = mid + 1;
//            } else if (data < arr[mid]) {
//                last = mid - 1;
//            } else {
//                fi = mid;
//                last = mid - 1;
//            }
//        }
//        System.out.println(fi);
//        System.out.println(34%10);
//    }

    public static void main(String[] args) throws Exception {
        int n = 3;
        int m = 3;
        int[][] arr = {{11,12,13},{21,22,23},{31,32,33}};
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = scn.nextInt();
//            }
//        }

        int i=-1;
        int j=0;

        while(i<=n || j<=m){

            if(j%2 == 0){
                System.out.println(i+"-"+j);
                if(j==m && i==-1){
                    break;
                }
                i = i+1;
                System.out.println(arr[i][j]);
                if(i==(n-1)){
                    j++;
                    i++;
                }
            }
            else if(j%2 == 1){
                if(j==(m-1) && i==n){
                    break;
                }
                System.out.println(i+"-"+j);

                i--;

                System.out.println(i+"-"+j);
                System.out.println(arr[i][j]);
                if(i==0){
                    j++;
                    i--;
                }
            }
        }
    }

}
