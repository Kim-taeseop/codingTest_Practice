package com.codingTest_practice.sort.bubbleSort;

import java.util.Scanner;

/*
- 문제
N개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성

- 입력
1번째 줄 : 수의 갯수 N(1<=N<=1000)
2번째 줄 부터 N개의 줄 : N개의 숫자가 주어짐. 수는 절댓값이 1000보다 작거나 같은 정수, 중복되지 않음.

- 출력
1번째 줄부터 N개의 줄에 오름차순 정렬한 결과를 1줄에 1개씩 출력

- 분석
자바는 sort() 함수가 있지만 이번에는 정렬을 직접 구현함.
*/
public class P2750_수정렬1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }

        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-1-i; j++){
                if(A[j]>A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        for(int i =0; i<N; i++) {
            System.out.println(A[i]);
        }
    }
}
