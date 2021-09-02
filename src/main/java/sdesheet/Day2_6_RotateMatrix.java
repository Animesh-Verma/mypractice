package sdesheet;

import java.util.Arrays;

public class Day2_6_RotateMatrix {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(mat));

        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat[0].length; j++) {
                int temp =0;
                temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length / 2; j++) {
                int temp = 0;
                temp = mat[i][j];
                mat[i][j] = mat[i][mat[i].length-1-j];
                mat[i][mat.length-1-j] = temp;
            }
        }
        System.out.println(Arrays.deepToString(mat));
    }
}
