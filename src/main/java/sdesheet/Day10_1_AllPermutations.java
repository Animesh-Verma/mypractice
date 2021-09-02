package sdesheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day10_1_AllPermutations {
    // APPROACH - 2
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    public static void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }

    private static void swap(int i, int index, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

//*************************************************************************
//    APPROACH - 1
//    public static int k;
//    public static void main(String[] args) {
//        k=0;
//        int[] nums = new int[]{0, 1, 2};
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> ds = new ArrayList<>();
//        boolean[] freq = new boolean[nums.length];
//        recurPermute(nums, ds, ans, freq);
//        //System.out.println(Arrays.toString(ans.toArray()));
//    }
//
//    private static void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
//        k+=1;
//        if (ds.size() == nums.length) {
//            ans.add(new ArrayList<>(ds));
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(Arrays.toString(ans.toArray()) + " " + k);
//            if (!freq[i]) {
//                freq[i] = true;
//                ds.add(nums[i]);
//                recurPermute(nums, ds, ans, freq);
//                System.out.println("After call");
//                ds.remove(ds.size()-1);
//                freq[i] = false;
//            }
//        }
//    }
}
