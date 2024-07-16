package com.codingTest_practice.search.bfs;

import java.util.*;

/*
- 문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램 작성
방문할 수 있는 노드가 여러개일 경우 노드 번호가 작은 것을 먼저 방문
더 이상 방문할 수 있는 노드가 없을 때 종료
노드 번호는 1에서 N까지

- 입력
1번째 줄 : 노드의 개수 N(1<=N<=1000), 에지의 개수 M(1<=M<=10000), 탐색 시작하는 노드 번호 V
그다음 M개의 줄 : 에지가 연결하는 두 노드의 번호가 주어짐. 양방향 에지, 두 노드 사이 에지가 여러개일 수 있음.

- 출력
1번째 줄에 DFS를 수행한 결과, 그 다음줄에 BFS를 수행한 결과를 출력
V부터 방문된 점을 순서대로 출력
*/
public class P1260_DFS와BFS {

    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        A = new ArrayList[N+1];

        for(int i =1; i<N+1; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        // 번호가 작은 것을 먼저 방문하기 위해 정렬
        for(int i=1; i<=N; i++){
            Collections.sort(A[i]);
        }

        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();

        visited = new boolean[N + 1];
        BFS(V);
        System.out.println();

    }

    static void BFS(int v){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int now_Node = queue.poll();
            System.out.print(now_Node + " ");
            for(int i : A[now_Node]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    static void DFS(int v){
        System.out.print(v + " ");
        visited[v] = true;
        for(int i : A[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
