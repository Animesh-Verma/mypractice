package sdesheet;

public class Day1_5_Subarray {
    public static void main(String[] args) {
       // betterSolutionO2();
        kadaneSolution();
    }

    static void kadaneSolution(){
        int[] arr = new int[]{-2,-3,-1,-2,-3};
        int sum =0;
        int maxi = arr[0];
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum > maxi){
                maxi = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        System.out.println(maxi);
    }

    static void betterSolutionO3(){
        int[] arr = new int[]{-2};
        int n = arr.length;
        int sum ;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n ; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + arr[k];
                }
                if (max <= sum) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }

    static void betterSolutionO2(){
        int[] arr = new int[]{-2,3,4,-1,-2,1,5,-3};
        int n = arr.length;
        int sum ;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n ; j++) {
                    sum = sum + arr[j];
            }
            if (max <= sum) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}
