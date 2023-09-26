package com.mystudy.scanner;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  //System으로부터 문자를 받아옴

        System.out.print("x 값 입력: ");
        String strX = scanner.nextLine();
        int x = Integer.parseInt(strX);  //받은 문자열을 정수 형식으로 파싱

        System.out.print("y 값 입력: ");
        String strY = scanner.nextLine();
        int y = Integer.parseInt(strY);  //받은 문자열을 정수 형식으로 파싱

        int result = x + y;
        System.out.println("x + y: " + result);
        System.out.println();

        while (true) {
            System.out.print("입력 문자열: ");
            String data = scanner.nextLine();

            if(data.equals("q")) {
                break;
            }  //입력된 문자열이 q라면 반복을 중지

            System.out.println("출력 문자열: " + data);
            System.out.println();
        }  //중괄호 안을 무한히 반복 실행함

        System.out.println("종료");
    }
}