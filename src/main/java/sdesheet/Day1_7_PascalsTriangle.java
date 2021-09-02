package sdesheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1_7_PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, pre = null;
        for (int i = 0; i < 5; ++i) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if(j==0 || i==j){
                    row.add(1);
                }else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = row;
            res.add(row);
        }
        System.out.println(Arrays.toString(res.toArray()));
    }
}
