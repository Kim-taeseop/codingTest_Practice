package com.codingTest_practice.numberTheory;

import java.util.Scanner;

/*
- 문제
M 이상 N이하의 소수를 모두 출력하는 프로그램을 작성

- 입력
1번째 줄 : 자연수 M과 N이 빈칸을 두고 주어짐 (1<=M<=N<=1,000,000) M 이상 N이하의 소수가 존재하는 입력만 주어짐

- 출력
1줄에 1개씩, 증가하는 순서대로 소수를 출력.
*/
public class P1929_소수구하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] A = new int[N+1];
        for(int i=2; i<=N; i++){
            A[i] = i;
        }

        for(int i=2; i<=N; i++){
            for(int j=2; j<=N/i; j++){
                A[i*(j)] =0;
            }
        }
        /*
        - 위 for문 책 설명
        for(int i=2; i<=Math.sqrt(N); i++) {    // 제곱근까지만 수행
            if(A[i] == 0){
                continue;
            }
            for(int j=i+i; j<=N; j=j+i){        // 배수 지우기
                A[j] =0;
            }
        }
        */

        for(int i=M; i<=N; i++){
            if(A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
}
