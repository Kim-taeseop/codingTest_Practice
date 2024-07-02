package com.codingTest_practice.numberTheory;

import java.util.Scanner;

/*
- 문제
두 자연수 A,B가 주어졌을 때 A와 B의 최소 공배수를 구하는 프로그램 작성

- 입력
1번째 줄 : 테스트 케이스 개수 T(1<=T<=1000)
2번째 줄부터 T개의 줄 : A,B가 주어짐 (1<=A,B<=45000)

- 출력
1번째 줄부터 T개의 줄에 A와 B의 최소 공배수 1줄에 하나씩

- 분석
책 풀이대로면 a%b 에서 a가 작아도 상관이 없는건가???
*/
public class P1934_최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int result = A*B/gcd(A,B);
            System.out.println(result);
        }


        /* 나의 풀이

        for (int i = 0; i < T; i++) {
            int[] C = new int[2];
            int A = sc.nextInt();
            int B = sc.nextInt();
            C[0] = A;
            C[1] = B;
            int D = 1;

            while (D != 0) {
                if (C[0] > C[1]) {
                    D = C[0] % C[1];
                    C[0] = D;
                } else {
                    D = C[1] % C[0];
                    C[1] = D;
                }
            }
            if (C[0] == 0) {
                System.out.println(A * B / C[1]);
            } else {
                System.out.println(A * B / C[0]);
            }
        }*/
    }
    private static int gcd(int a, int b) {
        if(b==0){
            return a;
        }else {
            return gcd(b,a%b);
        }
    }
}
