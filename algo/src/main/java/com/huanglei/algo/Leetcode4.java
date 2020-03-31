package com.huanglei.algo;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * <p>aaa
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Leetcode4 {

    public static void main(String args[]) {
        int arr[] = {5};
        int arr2[] = {1, 2, 3, 4, 6};
        System.out.println(findMedianSortedArrays(arr, arr2));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int k = (totalLen + 1) / 2;
        int k2 = (totalLen + 2) / 2;
        int a = findK(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k);
        int b = findK(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k2);
        return (a + b) / 2.0;
    }

    /**
     * 有序数组找第K大
     *
     * @param arr1
     * @param left1
     * @param right1
     * @param arr2
     * @param left2
     * @param right2
     * @param k
     * @return
     */
    public static int findK(int arr1[], int left1, int right1, int arr2[], int left2, int right2, int k) {

        if (left1 > right1) {
            return arr2[left2 + k - 1];
        }
        if (left2 > right2) {
            return arr1[left1 + k - 1];
        }
        if (k == 1) {
            return Math.min(arr1[left1], arr2[left2]);
        }
        int left1K = left1 + k / 2 - 1;
        int left2K = left2 + k / 2 - 1;

        if (left1K > right1) {
            left1K = right1;
        }
        if (left2K > right2) {
            left2K = right2;
        }
        if (arr1[left1K] > arr2[left2K]) {
            return findK(arr1, left1, right1, arr2, left2K + 1, right2, k - (left2K - left2 + 1));
        } else {
            return findK(arr1, left1K + 1, right1, arr2, left2, right2, k - (left1K - left1 + 1));

        }
    }
}
