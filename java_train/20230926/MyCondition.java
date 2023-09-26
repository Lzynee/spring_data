package com.mystudy.run;

public class MyCondition {
    public static void main(String[] args) {
        int a = 30;
        String pan = " ";

        if(a >= 150) {
            pan = "상";
        } else if (a >= 50) {
            pan = "중";
        } else {
            pan = "하";
        }
        
        System.out.println(pan + " 입니다.");
    }
}
