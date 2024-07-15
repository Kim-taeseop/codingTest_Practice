package com.codingTest_practice.search.dfs;

import java.util.ArrayList;
import java.util.Scanner;

/*
- 문제
캠프에 총 N명이 존재. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구.
아래와 같은 친구 관계가 존재하는지 구하려 함.
A,B는 친구  /  B,C는 친구  /  C,D는 친구  /  D,E는 친구

- 입력
1번째 줄 : 사람의 수 N(5<=N<=2000) 와 친구 관계의 수 M(1<=M<=2000)
2번째 줄부터 M개의 줄 : 정수 a,b가 주어짐. a,b는 친구 (0<=a,b<=N-1)

- 출력
문제 조건에 맞는 A,B,C,D,E가 존재하면1 없으면 0 출력
*/
public class P13023_친구관계 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int count;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N];
        A = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        result = 0;
        count = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                DFS(i);
            }
        }
        System.out.println(result);
    }

    private static void DFS(int v) {
        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        if (count >= 4) {
            result = 1;
        }
    }
}
