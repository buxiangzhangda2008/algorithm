package com.huanglei.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlgoPractice {

    private static String retStr = "";
    private static int count = 0;

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);


        //132413212131212
        //132*413*212*1*31*212
        //找出所有满足条件6个*号；
        //小于600；
        //不允许暴力破解

        String intStr = "11211211131245";
//        printStarStr2(intStr, 6);
        printStarStr(intStr, 5);
        System.out.println(strSet.size());
    }

    private static Set<String> strSet = new HashSet<>();

    public static void printStarStr(String str, int star) {

        if (star == 0 && str.length() <= 3) {
            retStr = retStr + str;
            strSet.add(retStr);
            retStr = "";
        }
        if (star <= 0 || str.length() > (star + 1) * 3) {
            return;
        }
        for (int i = 1; i < str.length() && i <= 3; i++) {
            String ret = str.substring(0, i);
            String tmpStr = retStr;
            retStr = retStr + ret + "*";
            printStarStr(str.substring(i), star - 1);
            retStr = tmpStr;
        }
    }

    static String retStr1 = "";


    public static void printStarStr2(String str, int star) {

//        int[][] state = new int[str.length() + 1][star + 1];
        List<String>[][] state2 = new ArrayList[str.length() + 1][star + 1];

//        state[1][1] = 1;
//        state[2][1] = 1;
//        state[2][2] = 1;
//        state[3][1] = 1;
//        state[3][2] = 2;
//        state[3][3] = 1;
        for (int i = 0; i < state2.length; i++) {
            for (int k = 0; k < state2[i].length; k++) {
                state2[i][k] = new ArrayList<String>();
            }
        }
        state2[1][1].add(str.substring(0, 1));
        state2[2][1].add(str.substring(0, 2));
        state2[2][2].add(str.substring(0, 1) + "*" + str.substring(1, 2));
        state2[3][1].add(str.substring(0, 3));
        state2[3][2].add(str.substring(0, 1) + "*" + str.substring(1, 3));
        state2[3][2].add(str.substring(0, 2) + "*" + str.substring(2, 3));
        state2[3][3].add(str.substring(0, 1) + "*" + str.substring(1, 2) + "*" + str.substring(2, 3));


        for (int i = 4; i < state2.length; i++) {
            for (int j = 2; j < state2[i].length; j++) {
                List<String> listStr1 = appendStrToList(str.substring(i - 1, i), state2[i - 1][j - 1]);
                List<String> listStr2 = appendStrToList(str.substring(i - 2, i), state2[i - 2][j - 1]);
                List<String> listStr3 = appendStrToList(str.substring(i - 3, i), state2[i - 3][j - 1]);
                state2[i][j] = unionList(listStr1, listStr2, listStr3);

            }
        }
        for (String str1 : state2[str.length()][star]) {
            System.out.println(str1);
        }
        System.out.println(state2[str.length()][star].size());

    }

    public static List<String> appendStrToList(String str, List<String> list) {
        ArrayList<String> listStr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listStr.add(i, list.get(i) + "*" + str);
        }
        return listStr;
    }

    public static List<String> unionList(List<String> list1, List<String> list2, List<String> list3) {
        ArrayList<String> list = new ArrayList();
        list.addAll(list1);
        list.addAll(list2);
        list.addAll(list3);

        return list;
    }
}
