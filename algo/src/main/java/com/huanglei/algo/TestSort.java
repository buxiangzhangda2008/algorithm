package com.huanglei.algo;

import java.util.Arrays;
import java.util.Random;

public class TestSort {
    public static void main(String[] args) {
        int []arr=gennerateArray(200000, 100000);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        long time = System.currentTimeMillis();
        time = System.nanoTime();
        Arrays.sort(arr);
        System.out.println(System.nanoTime()-time);
    }
    public static int[]  gennerateArray(int len,int max){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }

}
