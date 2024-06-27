package com.codingTest_practice.search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
- 문제
방향 없는 그래프가 주어졌을 때 연결 요소의 개수를 구하는 프로그램을 작성하시오.

- 입력
1번째 줄 : 노드의 개수 N(1<=N<=1000)과 에지의 갯수 M(0<=M<=N*(N-1)/2)
2번째 줄부터 M개의 줄에 에지의 양끝 점 u와v가 주어짐(1<=u,v<=N, u!=v) 같은 에지는 한 번만 주어짐.

- 출력
1번째 줄에 연결 요소의 개수를 출력
*/
public class P11724_연결요소갯수 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());   // 노드의 갯수
        int m = Integer.parseInt(st.nextToken());   // 에지의 갯수
        visited = new boolean[n + 1]; // 방문 배열
        A = new ArrayList[n + 1];     // 그래프 데이터 저장 인접 리스트

        // A 인접 리스트의 각 ArrayList 초기화
        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        // A 인접 리스트에 그래프 데이터 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());   // 시작점
            int e = Integer.parseInt(st.nextToken());   // 종료점
            A[s].add(e);
            A[e].add(s);
        }

        int count = 0;  // 갯수
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
