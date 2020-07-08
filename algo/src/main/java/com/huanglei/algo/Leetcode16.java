package com.huanglei.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Leetcode16 {

    public static void main(String args[]) {
        System.out.println(threeSumLatest(new int[]{-1, 2, 1, -4}, 1));

    }

    public static int threeSumLatest(int[] nums, int target) {

        Arrays.sort(nums);
        int latest = Integer.MAX_VALUE;
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
            if (ret > target) {
                j--;
                if (Math.abs(target - ret) < Math.abs(latest)) {
                    latest = target - ret;
                }
            } else if (ret < target) {
                i++;
                if (Math.abs(target - ret) < Math.abs(latest)) {
                    latest = target - ret;
                }
            } else {
                return ret;
            }
        }
        return target - latest;
//        return lists;
    }
}
