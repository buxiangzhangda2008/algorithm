package com.huanglei.algo;

import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.function.BiFunction;

public class LonggestNoDupStr {
    public static void main(String[] args) {
        int ret = new LonggestNoDupStr().longgestDoDupStr4("aa");
        System.out.println(ret + "");
    }

    /**
     * 输入：abcddef
     * 输出：4
     *
     * @param str
     * @return
     */
    public int longgestDoDupStr(String str) {
        Position dp[] = new Position[str.length()];
        //dp[i]表示以i结束的最长不重复子串的长度
        dp[0] = new Position(0, 1);
        int max = dp[0].end - dp[0].start;
        for (int i = 1; i < dp.length; i++) {
            Position pos = dp[i - 1];
            int index = str.substring(pos.start, pos.end).indexOf(str.charAt(i));
            if (index >= 0) {
                dp[i] = new Position(pos.start + index + 1, pos.end + 1);
            } else {
                dp[i] = new Position(pos.start, pos.end + 1);
            }
            max = Math.max(max, dp[i].end - dp[i].start);
        }
        return max;
    }

    /**
     * 因为只会依赖前一个状态，所以只需要一个point来记录状态就好；
     * 结果值存在max内，记录不断变化过程中的最大值
     *
     * @param str
     * @return
     */
    public int longgestDoDupStr3(String str) {

        int start = 0, end = 1, max = 1;
        for (int i = 1; i < str.length(); i++) {
            int index = str.substring(start, end).indexOf(str.charAt(i));
            if (index >= 0) {
                start = start + index + 1;
            }
            end++;
            max = Math.max(max, end - start);
        }
        return max;
    }

    public int longgestDoDupStr4(String str) {

//        int start = 0, max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
////        map.put(str.charAt(0),0);
//        for (int i = 0; i < str.length(); i++) {
//            if(map.containsKey(str.charAt(i))){
//                start = map.get(str.charAt(i))+1;
//            }
//            map.put(str.charAt(i),i);
//            max = Math.max(max, i - start);
//        }
//        return max;
        int i = -1, res = 0, max = 0;
        for (int j = 0; j < str.length(); j++) {
            if (map.containsKey(str.charAt(j)))
                i = Math.max(i, map.get(str.charAt(j))); // 更新左指针 i
            map.put(str.charAt(j), j); // 哈希表记录
            max = Math.max(max, j - i); // 更新结果
        }
        return max;
    }

    static class Position {
        int start;
        int end;

        public Position(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public int longgestDoDupStr2(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int dp[] = new int[str.length()];
        //dp[i]表示以i结束的最长不重复子串的长度长度
        dp[0] = 1;
        map.put(str.charAt(0), 0);
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            Integer value = map.get(str.charAt(i));
            //map中存储字符最近一次出现的位置，通过判断dp[i-1]为以str[i-1]结尾的无重复字符串长度，如果
            //i - map.get(str[i]) > dp[i-1],则说明dp[i-1]对应的字符串不包含 str[i],则此时dp[i]可以比dp[i-1]增加1
            if (value != null && (i - value <= dp[i - 1])) {
                dp[i] = i - value;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            map.put(str.charAt(i), i);

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
