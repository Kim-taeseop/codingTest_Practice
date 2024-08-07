package com.codingTest_practice.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
- 문제
각 집합에 속한 노드끼리 서로 인접하기 않은 두 집합으로 그래프의 노드를 나눌 수 있을 때 이 그래프를 '이분 그래프'라 함.
그래프가 입력으로 주어졌을 때 이 그래프가 이분 그래프인지 여부를 판별하는 프로그램 작성

- 입력
여러 개의 사례
1번째 줄 : 테스트 케이스의 개수 K(2<=K<=5)
각 사례의 1번째 줄에 그래프의 노드의 개수 V(1<=V<=20000)와 에지의 개수 E(1<=E<=200000)가 주어짐
각 노드에는 1부터 V까지 차례로 번호가 있음
이어서 2번째 줄부터 E개의 줄에 에지에 관련된 정보가 주어짐. 각 줄에 인접한 두 노드의 번호가 공백을 두고 주어짐.

- 출력
K개의 줄에 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 입력
*/
public class P1707_이분그래프 {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        // 그래프 데이터 저장
        for(int t=0; t<testCase; t++){
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int[V+1];
            IsEven = true;
            for(int i =1; i<=V; i++){
                A[i] = new ArrayList<Integer>();
            }
            // 에지 데이터 저장
            for(int i=0; i<E; i++){
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }
            // 모든 노드에서 DFS 실행
            for(int i=1; i<=V; i++){
                if(IsEven){
                    DFS(i);
                }else{
                    break;
                }
            }

            if(IsEven){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
    static void DFS(int node){
        visited[node] = true;
        for(int i : A[node]){   // 인접 리스트로 받아서 start에서 연결된 모든 노드를 탐색
            if(!visited[i]){
                // 바로 직전에 있는 노드와 다른 집합으로 분류
                check[i] = (check[node] + 1)%2;
                DFS(i);
            }else{
                if(check[node]== check[i]){
                    IsEven = false;
                }
            }
        }
    }
}
