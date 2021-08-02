package com.huanglei.algo;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis{
    public static void main(String args[]){
        new GenerateParenthesis().func(3);
    }
//    private String left = "(";
//    private String right = ")";
//    private List<String> resultList = new ArrayList<>();
//    public List<String> func(int N){
//        getNextParenthesis("",left,N,N);
//        getNextParenthesis("",right,N,N);
//        System.out.println(resultList);
//        return resultList;
//    }
//    public void getNextParenthesis(String curr,String append,int rightNum,int leftNum){
//
//        if(append.equals(left)){
//            if(leftNum==0) {
//                return;
//            }
//            leftNum--;
//        }else if(append.equals(right)){
//            if(rightNum==0||leftNum>=rightNum){
//                return;
//            }
//            rightNum--;
//        }
//        curr = curr+append;
//        if(rightNum==0&&leftNum==0){
//            resultList.add(curr);
//            return;
//        }
//        getNextParenthesis(curr,left,rightNum,leftNum);
//        getNextParenthesis(curr,right,rightNum,leftNum);
//    }
    private String left = "(";
    private String right = ")";
    private List<String> resultList = new ArrayList<>();
    public List<String> func(int N){
        getNextParenthesis("","",N,N);
        System.out.println(resultList);
        return resultList;
    }
    public void getNextParenthesis(String curr,String append,int rightNum,int leftNum){
        if(leftNum==0&&rightNum==0){
            resultList.add(curr+append);
            return;
        }
        if(leftNum>rightNum){
            return;
        }
        curr = curr+append;
        if(leftNum>0){
            getNextParenthesis(curr,left,rightNum,leftNum-1);
        }
        if(rightNum>0){
            getNextParenthesis(curr,right,rightNum-1,leftNum);
        }
    }

}