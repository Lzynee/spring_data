package com.mystudy.etc;

public class JHOper {
    public static void main(String[] args) {
        int a = 5;
        int sum = 0;

        System.out.println("a = " + a + "  sum = " + sum);
        
        sum = ++a + ++a;

        System.out.println("a = " + a + "  sum = " + sum);

        sum += 0;
        sum += a++;  // sum = sum + a++
        sum += ++a;  // sum = sum + ++a; 대입 연산자
        System.out.println("a = " + a + "  sum = " + sum);

        for(int i = 0; i < 10; ++i)
            System.out.print(i+1 + " ");
    }
}
