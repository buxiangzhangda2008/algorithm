package com.huanglei.algo;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * <p>
 * 示例 2:
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * 说明:
 * 你的解法应该是 O(logN) 时间复杂度的。
 */
public class findTop {
    public static void main(String[] args) {
//        int[] arr = {1,2,1,3,5,6,4};
        int[] arr = {1,2};
        int[] arr2 = {1,2,3,5,6,7,8};
        int[] arr3 = {8,7,6,5,4,3,2};
        int ret1 = findAnyTop(arr,0,arr.length-1,0);
        int ret2 = findAnyTop(arr2,0,arr2.length-1,0);
        int ret3 = findAnyTop(arr3,0,arr3.length-1,0);
        ret1 = findAnyPeek(arr,0,arr.length-1);
        ret2 = findAnyPeek(arr2,0,arr2.length-1);
        ret3 = findAnyPeek(arr3,0,arr3.length-1);
        System.out.println("ret is :" + ret1);
        System.out.println("ret2 is :" + ret2);
        System.out.println("ret3 is :" + ret3);
    }

    public static int findAnyTop(int[] arr, int left, int right,int direction) {
        int mid = left +(right-left) / 2;
        if(direction==1){
            mid = left +(right-left)/2 + 1;
        }
//        if(mid+1>right){
//            return arr[right];
//        }else if(mid-1<left){
//            return arr[left];
//        }
        if ((mid+1)<=right && arr[mid] < arr[mid + 1]) {
            return findAnyTop(arr, mid, right,1);
        } else if ((mid-1)>=left&&arr[mid] < arr[mid - 1]) {
            return findAnyTop(arr, left, mid,0);
        }else {
            return arr[mid];
        }
    }
    public static int findAnyPeek(int arr[],int l,int r){
        if(l==r){
            return arr[l];
        }
        int mid = (l+r)/2;
        if(arr[mid]<arr[mid+1]){
            return findAnyPeek(arr,mid+1,r);
        }
        return findAnyPeek(arr,l,mid);
    }
}