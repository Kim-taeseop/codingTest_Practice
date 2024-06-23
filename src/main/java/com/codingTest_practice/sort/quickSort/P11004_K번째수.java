package com.codingTest_practice.sort.quickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/*
- 문제
수 N개 (A1, A2, ... An)이 주어진다. A를 오름차순 정렬했을 때 앞에서 부터 K 번째에 있는 수를 구하는 프로그램 작성

- 입력
1번째 줄 : N(1<=N<=5000000)과 K(1<=K<=N)
2번째 줄 : A1, A2, ... An 이 주어짐 (-10^9<=Ai<=10^9)

- 분석
미완성
어려움
*/
public class P11004_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N-1, K-1);

    }

    // 미완성
    private static void quickSort(int[] A, int S, int E, int K) {
        if(S < E){
            int pivot = partition(A,S,E);
        }
    }

    // 미완성
    private static int partition(int[] A, int S, int E) {
        if(S+1 == E){
            if(A[S] > A[E]){
                swap(A,S,E);
                return E;
            }
            int M = (S+E) /2;
            swap(A,S,M);


        }
        return 0;
    }

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
