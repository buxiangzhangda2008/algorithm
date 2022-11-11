package com.huanglei.serialization;

public class PrintMartrix {

    public static void main(String[] args) {
        System.out.println("PrintMartrix");
        int[][] martrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        new PrintMartrix().printMartrix(martrix);
    }

    boolean[][] martrixStatus = new boolean[][] { { false, false, false, false }, { false, false, false, false },
            { false, false, false, false }, { false, false, false, false } };

    public void printMartrix(int[][] martrix) {
        final int right = 1;
        final int down = 2;
        final int left = 3;
        final int up = 4;
        final int rows = martrix.length;
        final int cols = martrix[0].length;

        int direction = right;
        int starti = 0;
        int startj = -1;
        while (printCount < rows * cols) {

            switch (direction) {
                case right:
                    // System.out.println(starti + "," + startj);
                    if (startj + 1 >= cols || martrixStatus[starti][startj + 1]) {
                        direction = down;
                    } else {
                        startj++;
                        print(starti, startj, martrix[starti][startj]);
                    }
                    break;
                case down:
                    if (starti + 1 >= rows || martrixStatus[starti + 1][startj]) {
                        direction = left;
                    } else {
                        starti++;
                        print(starti, startj, martrix[starti][startj]);
                    }
                    break;
                case left:
                    if (startj - 1 < 0 || martrixStatus[starti][startj - 1]) {
                        direction = up;
                    } else {
                        startj--;
                        print(starti, startj, martrix[starti][startj]);
                    }
                    break;
                case up:
                    if (starti - 1 < 0 || martrixStatus[starti - 1][startj]) {
                        direction = right;
                    } else {
                        starti--;
                        print(starti, startj, martrix[starti][startj]);
                    }
                    break;
                default:
                    break;
            }
        }

    }

    static int printCount = 0;

    private void print(int i, int j, int martrixItem) {
        printCount++;
        System.out.println(martrixItem + ",");
        martrixStatus[i][j] = true;
    }

}
