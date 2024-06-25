package com.codingTest_practice.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
- 문제
4*6 크기의 배열로 표현되는 미로가 존재.
마로의 각 칸에 들어 있는 숫자 중 1은 이동할수 있는 칸, 0은 이동할 수 없는 칸.
이동시 서로 인접한 칸으로만 이동 가능. 이동한 칸을 셀 때는 시작 위치와 도착 위치를 포함.
N*M 크기의 미로가 주어질 때 (1,1)에서 출발해 (N,M)의 위치로 이동하기 위해 지나야 하는 칸 수의 최솟값을 구하는 프로그램 작성

- 입력
1번째 줄 : 두 정수 N,M(2<=N,M<=100)
그다음 N개의 줄 : 미로의 내용이 M개의 정수로 주어짐. 각각의 수들은 붙어서 입력

- 출력
1번째 줄에 지나야 하는 칸 수의 최솟값을 출력.
*/
public class P2178_미로탐색 {
    // 상하좌우 탐색하기 위한 배열
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] A;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int [N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }

    static void BFS(int i,int j){
        Queue<int []>queue = new LinkedList<>();
        queue.offer(new int[] {i,j});   // 시작점 큐에 삽입
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int now[] = queue.poll();       // x,y
            for(int k=0; k<4; k++){ // 상하좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && y>=0 && x<N && y<M) {    // 배열을 넘어가면 안됨
                    if(A[x][y] !=0 && !visited[x][y]){  // 조건에 맞아야 함.
                        // 이제 갈 수 있는 곳
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // 깊이를 넣어줌.
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }
}
