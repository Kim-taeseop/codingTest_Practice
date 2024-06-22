package com.codingTest_practice.sort.quickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
- 문제
수 N개 (A1, A2, ... An)이 주어진다. A를 오름차순 정렬했을 때 앞에서 부터 K 번째에 있는 수를 구하는 프로그램 작성

- 입력
1번째 줄 : N(1<=N<=5000000)과 K(1<=K<=N)
2번째 줄 : A1, A2, ... An 이 주어짐 (-10^9<=Ai<=10^9)
*/
public class P11004_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());

        long[] A = new long[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(bf.readLine());
        }

        int pivot = N-1;
        int start = 0;
        int end = N-2;
        while(start != end) {
            if (A[start] < A[pivot]) {
                start++;
            }
            if (A[end] > A[pivot]) {
                end--;
            }
            if (A[start] > A[pivot] && A[end] < A[pivot]) {
                long temp = A[start];
                A[start] = A[end];
                A[end] = temp;
                start++;
                end--;
            }
        }

        long data = A[pivot];
        if(A[pivot] > A[start]){

        }
    }
}
