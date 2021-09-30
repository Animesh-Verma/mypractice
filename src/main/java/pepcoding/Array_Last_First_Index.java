package pepcoding;

public class Array_Last_First_Index {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 70, 70, 70, 80, 90, 100};
        int data = 70;

        int first = 0;
        int last = arr.length - 1;
        boolean flag = true;
        int li = -1;
        int fi = -1;

        while (first <= last) {
            int mid = (first + last) / 2;
            if (data > arr[mid]) {
                first = mid + 1;
            } else if (data < arr[mid]) {
                last = mid - 1;
            } else {
                li = mid;
                first = mid + 1;
            }
        }
        System.out.println(li);

        first = 0;
        last = arr.length - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (data > arr[mid]) {
                first = mid + 1;
            } else if (data < arr[mid]) {
                last = mid - 1;
            } else {
                fi = mid;   
                last = mid - 1;
            }
        }
        System.out.println(fi);
    }
}
