package com.codingTest_practice.dataStructure.arrayAndLists;

import java.util.Scanner;

/*
- 문제
기말고사 점수 조작
자기 점수의 최댓값을 M이라 할 때, 모든 점수를 점수/M*100으로 수정
새로운 평균을 구하라

- 입력
1번째 줄 : 시험을 본 과목의 개수 N(N<=1000)
2번째 줄 : 현재 성적 (100보다 같거나 작고, 음이 아닌정수, 적어도 1개는 0보다 큼)

- 출력
1번째 줄에 새로운 평균을 출력
*/
public class P1546_평균구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] score = new int[N];

        for(int i=0; i<N; i++) {
            score[i] = sc.nextInt();
        }

        long sum = 0;
        long max = 0;
        for(int i=0; i<N; i++){
            if(score[i]>max){max = score[i];}
            sum += score[i];
        }

        System.out.println(sum * 100.0 / N / max);

    }
}
