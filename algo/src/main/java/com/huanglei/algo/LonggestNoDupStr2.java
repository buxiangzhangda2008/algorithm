package com.huanglei.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LonggestNoDupStr2 {
    public static void main(String[] args) {
//        int ret = new LonggestNoDupStr2().longgestDoDupStr("abcaafjdfaa");
        int ret = new LonggestNoDupStr2().getMax("abcaafjdfaa");
        System.out.println(ret + "");
    }

    /**
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     */
    private int longgestDoDupStr(String str) {
       int max = 0;
       int lastLongest = 0;
       for(int i=1;i<str.length();i++){
           //int index = str.substring(i-lastLongest,i).indexOf(str.charAt(i));
           int index = -1;
           for(int j=i-lastLongest;j<i;j++){
               if(str.charAt(j)==str.charAt(i)){
                   index = j;
               }
           }

           lastLongest= index==-1?(lastLongest+1):(lastLongest-index);
           max = Math.max(max,lastLongest);
       }
       return max;
    }
    private static int getMax(String s){
        if(s == null){
            return 0;
        }
        Set<Character> temp = new HashSet<>();
        char []  arrays = s.toCharArray();
        int fromIndex = 0;
        int toIndex = 0;
        int result = 0;
        for(int i = 0; i < arrays.length; i++){
            if(temp.contains(arrays[i])){
                toIndex = i;
                result = result > (toIndex - fromIndex) ? result : (toIndex - fromIndex);
                fromIndex = i;
                temp.clear();
            } else {
                temp.add(arrays[i]);
                toIndex = i;
            }
        }
        result = result > (toIndex - fromIndex) ? result : (toIndex - fromIndex);
        return result;

    }
}