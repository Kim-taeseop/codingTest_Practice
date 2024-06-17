package com.codingTest_practice.dataStructure.arrayAndLists;

import java.util.Scanner;

/*
- 문제
N개의 숫자가 공백없이 있다. 이 숫자를 모두 합해 출력하는 프로그램 작성

- 입력
1번째 줄에 숫재의 개수N(1<=N<=100), 2번째 줄에 숫자 N개가 공백 없이 주어짐.

- 출력
입력으로 주어진 숫자 N개의 합을 출력
*/
public class P11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();   // 숫자가 int,long의 범위를 넘어갈 수 있으므로 배열로 받음
        int sum = 0;

        for (int i=0; i<N; i++){
            sum += cNum[i] - '0';   // 배열의 각 자릿값을 정수형으로 변환 => 아스키코드
        }
        System.out.println(sum);
    }
}
