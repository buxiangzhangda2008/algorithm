package com.huanglei.algo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */

public class Leetcode42 {

    public static void main(String args[]) throws IOException {
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3};
        System.out.println(trap(nums));
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(InetAddress.getLocalHost(),80));

    }

    public static int trap(int[] nums) {
        int trapWater = 0;
        int i = 0, j = nums.length - 1;
        int waterLevel = 0;
        while (j - i > 0) {
            int height = (nums[i] < nums[j]) ? nums[i++] : nums[j--];
            if (height > waterLevel) {
                trapWater += (j - i) * (height - waterLevel) - waterLevel;
                waterLevel = height;
            } else
                trapWater -= height;

        }
        return trapWater;
    }

}
