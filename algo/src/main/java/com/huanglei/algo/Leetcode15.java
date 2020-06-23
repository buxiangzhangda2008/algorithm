package com.huanglei.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
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

public class Leetcode15 {

    public static void main(String args[]) {
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{3,0,-2,-1,1,2}));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        nums = quickSort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int i = 0, j = nums.length - 1;
        for (int k = 1; k < nums.length - 1; ) {
            if (j <= k || i >= k) {
                k++;
                i = 0;
                j = nums.length - 1;
                continue;
            }
            int ret = nums[i] + nums[k] + nums[j];
            if (ret > 0) {
                j--;
            } else if (ret < 0) {
                i++;
            } else {
                if (!lists.isEmpty()) {
                    List<Integer> integers = lists.get(lists.size() - 1);
                    if (integers.get(0) == nums[i] && integers.get(1) == nums[k]) {
                        i++;
                        j--;
                        continue;
                    }
                }
                List<Integer> integers = new ArrayList<>();
                integers.add(nums[i++]);
                integers.add(nums[k]);
                integers.add(nums[j--]);
                lists.add(integers);
            }
        }

        return lists;
    }

    public static int[] quickSort(int[] nums) {

        QKSourt(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int sentinelPos = (start + end) / 2;
        int firstLargerPos = start;
        int target = nums[sentinelPos];
        for (int i = start; i <= end; i++) {
            if (nums[i] < target) {
                swap(nums, i, firstLargerPos);
                firstLargerPos++;
            }
        }
        quickSort(nums, start, firstLargerPos - 1);
        quickSort(nums, firstLargerPos + 1, end);

    }
    private static void QKSourt(int[] a, int start, int end) {
        if (a.length < 0){
            return ;
        }
        if (start >= end){
            return ;
        }
        int left = start;
        int right = end;
        int temp = a[left];
        while (left < right){
            while (left < right && a[right] > temp){
                right -- ;
            }
            a[left] = a[right];
            while (left < right && a[left] < temp){
                left ++ ;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        QKSourt(a, start, left -1);
        QKSourt(a,left+1,end);
    }
    private static void swap(int nums[], int i, int firstLargerPos) {

        int tmp = nums[i];
        nums[i] = nums[firstLargerPos];
        nums[firstLargerPos] = tmp;
    }
}
