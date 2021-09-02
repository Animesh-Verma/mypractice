package sdesheet;

public class Day1_2_FindMissisngEleArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 6, 3,1, 8, 9, 7, 3};
        int slow = arr[0];
        int fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
            System.out.printf("slow-%s , fast-%s \n",slow,fast);
        } while (slow != fast);
        fast = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
            System.out.printf("slow-%s , fast-%s \n",slow,fast);
        }
        System.out.println(fast);
    }
}
