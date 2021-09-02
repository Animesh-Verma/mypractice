package sdesheet;

public class Day3_2_PowXN {
    public static void main(String[] args) {
        double x = 2;
        double ans = 1.0;
        int no = -3;
        long nn = no;
        if (nn < 0) {
            nn = -1 * nn;
        }
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn/2;
            }
        }
        if(no < 0){
            ans = (double)0.1/(double)ans;
        }
        System.out.println("Answer "+ans);
    }
}
