package com.huanglei.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Leetcode1 {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String args[]) {
        int[] ret = twoSum(new int[]{1, 2, 3, 4, 5, 7}, 9);
        if (ret != null)
            System.out.println(ret[0] + "," + ret[1]);
        else
            System.out.println("null");

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int var = nums[i];
            int target2 = target - var;
            if (m.containsKey(target2) && m.get(target2) != i) {
                return new int[]{i, m.get(target2)};
            }
            m.put(var, i);
        }
        return null;
    }
}
