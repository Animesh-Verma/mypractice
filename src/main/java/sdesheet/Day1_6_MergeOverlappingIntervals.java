package sdesheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1_6_MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{8,9},{9,11},{15,8},{2,4},{16,17}};
        List<int[]> res = new ArrayList<>();

        if(intervals.length == 0 || intervals == null){
            System.out.println(res.toString());
        }

        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i : intervals){
            if(i[0]<=end){
                end = Math.max(end,i[1]);
            }
            else {
                res.add(new int[]{start,end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start,end});
        //res.toArray(new int[0][]); dont know why to use it
        for(int [] op : res){
            System.out.println(op[0]+","+op[1]);
        }
    }
}
