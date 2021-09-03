package com.huanglei.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Leetcode15_1 {

    public static void main(String args[]) {
        System.out.println(threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{3, 0, -2, -1, 1, 2}));

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int i = 0, j = nums.length - 1;
        for (int k = 1; k < nums.length - 1; ) {
            if (j <= k || i >= k) {
                if (nums[k] != nums[++k]) {
                    i = 0;
                }
                j = nums.length - 1;
                continue;
            }
            int ret = nums[i] + nums[k] + nums[j];
            if (ret > 0) {
                j--;
            } else if (ret < 0) {
                i++;
            } else {
                List<Integer> integers = new ArrayList<>();
                integers.add(nums[i]);
                integers.add(nums[k]);
                integers.add(nums[j]);
                lists.add(integers);
                while (i < j && i < nums.length - 1 && nums[i] == nums[++i]) ;
                while (i < j && j >= 0 && nums[j] == nums[--j]) ;
            }
        }

        return lists;
    }
}
