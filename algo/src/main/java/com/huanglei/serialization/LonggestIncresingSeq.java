package com.huanglei.serialization;

public class LonggestIncresingSeq {

    public static void main(String[] args) {
        // int numbers[] = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        int numbers[] = new int[] { 0, 1, 0, 3, 2, 3 };
        // int numbers[] = new int[] { 7, 7, 7, 7, 7, 7, 7 };
        int maxLen = new LonggestIncresingSeq().solution(numbers);
        System.out.println("maxLen:" + maxLen);
    }

    private int getMaxLenFromPos(int i, int[] numbers) {

        int maxLen = 1;
        for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[j] > numbers[i]) {
                int tmplen = 1 + getMaxLenFromPos(j, numbers);
                maxLen = Math.max(tmplen, maxLen);
            }
        }

        return maxLen;
    }

    public int solution(int[] numbers) {

        int maxLen = 1;
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                maxLen = Math.max(maxLen, getMaxLenFromPos(i, numbers));
            }
        }
        return maxLen;
    }
}
