package com.codingTest_practice.graph;

import java.util.*;

/*
- 문제
1번부터 N번까지의 도시와 M개의 단방향 도로가 있고, 모든 도로의 거리는 1이다.
도시 X로부터 출발해 도달할 수 있는 모든 도시 중 최단 거리가 K인 모든 도시들의 번호를 출력

- 입력
1번째 줄 : 도시의 갯수 N, 도로의 갯수M, 거리 정보K, 출발 도시 번호X
(2<=N<=300,000  1<=M<=1,000,000  1<=K<=300,000   1<=X<=N)
이후 M개의 줄에 자연수 A,B가 주어짐. A에서 B로 가는 단방향 도로가 존재.

- 출력
X로부터 출발해 도달 가능한 도시 중 최단 거리가 K인 모든 도시의 번호를 1줄에 1개씩 오름찬순으로 정렬. 없으면 -1

- 분석
다시 하기
*/
public class P18352_특정거리도시찾기 {

    static int N,M,K,X;
    static int visited[];
    static ArrayList<Integer>[] A;
    static List<Integer> answer;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        A = new ArrayList[N+1];    // 인접 리스트
        answer = new ArrayList<>();       // 정답 리스트

        for(int i =1; i<=N; i++){
            A[i] = new ArrayList<>();   // 배열 초기화
        }
        for(int i=0; i<M; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }
        visited = new int[N+1];
        for(int i=0; i<=N; i++){
            visited[i] = -1;
        }
        BFS(X);
        for(int i=0; i<=N; i++){
            if(visited[i]==K){
                answer.add(i);
            }
        }
        if(answer.isEmpty()){
            System.out.println("-1");
        }else {
            Collections.sort(answer);
        }
        for(int temp:answer){
            System.out.println(temp);
        }
    }

    private static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x]++;
        while (!queue.isEmpty()){
            int now_Node = queue.poll();
            for(int i : A[now_Node]){
                if (visited[i] == -1){
                    visited[i] = visited[now_Node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
