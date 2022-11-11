package com.huanglei.algo;

import java.util.HashMap;

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
public class Leetcode1_1 {

    public static void main(String args[]) {
        Leetcode1_1 lc = new Leetcode1_1();
        int[] result = lc.solution2(new int[] { 1, 3, 5, 7, 9 }, 8);
        System.out.println(result[0] + "," + result[1]);
        System.out.println("Leetcode1_1");

    }

    int a = 1;

    public double myName(String name) {
        int[] myIntArray = new int[] { 1, 2, 3 };
        return 0d;
    }

    public int[] solution(int arr[], int sum) {
        int res[] = new int[] { -1, -1 };
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }

    public int[] solution2(int arr[], int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(sum - arr[i]) != null) {
                return new int[] { i, map.get(sum - arr[i]) };
            }
        }
        return null;

    }

}
