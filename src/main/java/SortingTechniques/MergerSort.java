package SortingTechniques;

public class MergerSort {
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        int[] arr1 = {1,2,1,3};
        boolean[] arrbool = {false,false,false,false};
        int count = 0;
        int m=4;
        int y=0;
        int i=0;
        while(true){
            i = i%4;
            arr1[i] += y;
            y++;
            if(arr1[i] % 3 == 0){
                arrbool[i] = true;
            }
            if(count == m){
                System.out.println(m);
                return;
            }
        }
    }

    public static void sort(){

    }

    public static void merge(){

    }


}
