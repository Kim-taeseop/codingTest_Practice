package com.codingTest_practice.dataStructure.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
- 문제
수열 A에서 각 원소를 A(i)라 할때 오큰수NGE(i)는 오른쪽에서 A(i)보다 큰 가장 왼쪽의 수
이러한 값이 없을 경우 -1
오큰수 구하기

- 입력
1번째 줄 : 수열 A의 크기N (1<=N<=1000000)
2번째 줄 : 수열 A의 원소가 주어짐 (1<=A(i)<=1000000)

- 출력
총 N개의 수 NGE(i)를 공백으로 구분하여 출력

미완성

*/
public class P17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int index =0;
        stack.push(index++);

        st = new StringTokenizer(bf.readLine());

    }
}
