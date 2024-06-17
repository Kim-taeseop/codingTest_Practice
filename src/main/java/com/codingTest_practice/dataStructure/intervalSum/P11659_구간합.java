package com.codingTest_practice.dataStructure.intervalSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
- 문제
수 N개가 주어졌을 때 i 번째 수에서 j 번째 수까지 합을 구하는 프로그램 작성

- 입력
1번째 줄 : 수의 개수(1<=N<=100000), 합을 구해야 하는 횟수M(1<=M<=100000)
2번째 줄 : N개의 수 (1000보다 작거나 같은 자연수)
3번째 줄 : M개의 줄에 합을 구해야하는 구간 i와 j

- 출력
총 M개의 줄에 입력으로 주어진 i 번째 수에서 j번째 수까지의 합을 출력
*/
public class P11659_구간합 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] A = new int[N+1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i =1; i<=N; i++){
            A[i] = A[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int t=1; t<=M; t++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(A[j]-A[i-1]);
        }
    }
}
