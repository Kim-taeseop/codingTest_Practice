package com.codingTest_practice.dataStructure.twoPointer;

import java.util.Scanner;

/*
- 문제
어떠한 자연수 N(1<=N<=10000000) 을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 구하는 문제
ex) 15 -> 15, 7+8, 4+5+6, 1+2+3+4+5  답 : 4가지

- 입력
1번째 줄에 정수 N이 주어짐

- 출력
입력된 자연수 N을 연속된 자연수의 합으로 나타내는 가짓수를 출력

- 시간 복잡도
N
*/
public class P2018_연속된자연수합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum = 1;
        int count = 1;
        int sIndex = 1;
        int fIndex = 1;

        while (fIndex != N) {
            if (sum < N) {
                fIndex++;
                sum += fIndex;
            } else if (sum == N) {
                count++;
                fIndex++;
                sum += fIndex;
            } else {
                sum -= sIndex;
                sIndex++;
            }
        }
        System.out.println(count);
    }
}
