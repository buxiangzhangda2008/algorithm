package com.huanglei.serialization;

import java.util.HashMap;

public class LongestNodupStr {

    public static void main(String[] args) {
        System.out.println(longgestNodupStr2("abcdeaaabcdaaef"));
    }

    public static int longgestNodupStr(String str) {
        int leftPos = 0;
        int len = 0;
        for (int i = 1; i < str.length(); i++) {
            boolean dup = false;
            for (int j = leftPos; j < i; j++) {
                if (str.charAt(j) == str.charAt(i)) {
                    leftPos = j + 1;
                    dup = true;
                    break;
                }
            }
            if (!dup) {
                int tmplen = i - leftPos + 1;
                len = Math.max(len, tmplen);
            }
        }
        return len;
    }

    public static int longgestNodupStr2(String str) {
        int leftPos = 0;
        int len = 0;
        if (str == null || str.isEmpty()) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(str.charAt(leftPos), 0);
        for (int rightPos = 1; rightPos < str.length(); rightPos++) {
            Integer dup = map.get(str.charAt(rightPos));
            if (dup != null && dup >= leftPos) {
                leftPos = dup + 1;
            }
            map.put(str.charAt(rightPos), rightPos);
            len = Math.max(len, rightPos - leftPos + 1);
            if (len >= str.length() - leftPos)
                return len;
        }
        return len;
    }

}
