package com.huanglei.algo;

public class MartirxLonggestPath {

    public static void main(String[] args) {
        MartirxLonggestPath lcf = new MartirxLonggestPath();
        lcf.solution(new int[][] { { 1, 2, 3, 3 }, { 2, 3, 3, 5 }, { 3, 4, 2, 6 }, { 3, 7, 6, 9 } });
        // System.out.println(lcf.answer);

    }

    public int travel(int i, int j, int[][] martrix) {

        int left = j - 1;
        int right = j + 1;
        int up = i - 1;
        int down = i + 1;
        int current = martrix[i][j];
        int leftlen = 0;
        int rightlen = 0;
        int uplen = 0;
        int downlen = 0;
        if (left >= 0 && martrix[i][left] > current) {
            j = left;
            leftlen = travel(i, j, martrix) + 1;
        }
        if (right < martrix[i].length && martrix[i][right] > current) {
            j = right;
            rightlen = travel(i, j, martrix) + 1;
        }
        if (up >= 0 && martrix[up][j] > current) {
            i = up;
            uplen = travel(i, j, martrix) + 1;
        }
        if (down < martrix.length && martrix[down][j] > current) {
            i = down;
            downlen = travel(i, j, martrix) + 1;
        }
        int maxlen = leftlen > rightlen ? leftlen : rightlen;
        maxlen = uplen > maxlen ? uplen : maxlen;
        maxlen = Math.max(maxlen, downlen);
        return Math.max(Math.max(Math.max(leftlen, rightlen), uplen), downlen);
    }

    public static String thisIs() {
        return null;
    }

    public int solution(int[][] martrix) {

        int len = 0;
        for (int i = 0; i < martrix.length; i++) {
            for (int j = 0; j < martrix[i].length; j++) {
                len = Math.max(len, travel(i, j, martrix));

                // System.out.print(martrix[i][j] + ",");
            }
        }
        System.out.println(len + "");
        return 0;
    }

}
