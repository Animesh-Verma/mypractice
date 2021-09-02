package sdesheet;

public class Day3_1_SearchIn2DMatrix {
    public static void main(String[] args) {
        betterApproach();
    }

    public static void betterApproach() {
        int[][] mat = new int[][]{{10, 20, 30, 40}, {11, 21, 36, 43}, {25, 29, 39, 50}};
        int n = 3; // number of rows
        int x = 25;
        int i = 0, j = mat.length - 1;
        while (i < n && j >= 0) {
            System.out.println(i+","+j);
            if (mat[i][j] == x) {
                System.out.println("found at " + i + "-" + j);
                return;
            }
            if (mat[i][j] > x)
                j--;
            else
                i++;
        }
    }
}
