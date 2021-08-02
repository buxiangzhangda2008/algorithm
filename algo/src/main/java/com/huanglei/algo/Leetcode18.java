package com.huanglei.algo;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Leetcode18 {

    public static void main(String args[]) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums2 = {-1, -5, -5, -3, 2, 5, 0, 4};
//        System.out.println(fourSum(nums,0));
        System.out.println(fourSum(nums2, -7));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> fourlists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> threelists = threeSum(nums, target - nums[i], i);
            for (List l : threelists) {
                l.add(0, nums[i]);
            }
            fourlists.addAll(threelists);
        }
        return fourlists;
    }

    public static List<List<Integer>> threeSum(int[] nums, int target, int ignorePos) {
        List<List<Integer>> lists = new ArrayList<>();
        int i = ignorePos + 1, j = nums.length - 1;
        for (int k = ignorePos; k < nums.length - 1; ) {

            if (j <= k || i >= k) {
                if (nums[k] != nums[++k]) {
                    i = ignorePos + 1;
                    j = nums.length - 1;
                }
                continue;
            }
	

            int ret = nums[i] + nums[k] + nums[j];
            if (ret > target) {
                j--;
            } else if (ret < target) {
                i++;
            } else {
                List<Integer> integers = new ArrayList<>();
                integers.add(nums[i]);
                integers.add(nums[k]);
                integers.add(nums[j]);
                lists.add(integers);
                while (i < j && i < nums.length - 1 && nums[i] == nums[++i]) ;
                while (i < j && j >= ignorePos+1 && nums[j] == nums[--j]) ;
            }
        }
	        
        return lists;
    }
}
