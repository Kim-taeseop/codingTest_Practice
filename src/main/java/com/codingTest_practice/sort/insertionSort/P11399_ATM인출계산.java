package com.codingTest_practice.sort.insertionSort;

import lombok.extern.slf4j.Slf4j;


import java.util.Scanner;

/*
- 문제
ATM 인출 시간 문제
요약 : N명의 사람이 돈을 뽑는데 걸리는 최소한의 시간을 구하라

- 입력
1번째 줄 : 사람의 수 (1<=N<=1000)
2번째 줄 : 각 사람이 돈을 인출하는데 걸리는 시간Pi (1<=Pi<=1000)

- 출력
1번째 줄에 각 사람이 돈을 인출하는 데 필요한 시간의 합의 최솟값을 출력

- 분석
주어진 수를 오름차순 후 계산
헷갈림.
*/
@Slf4j
public class P11399_ATM인출계산 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int [N];
        for(int i =0; i<N; i++){
            A[i] = sc.nextInt();
        }

        for(int i=1; i<N; i++){
            int insert_point =i;
            int insert_value=A[i];
            for(int j=i-1; j>=0; j--){
                if(A[j]<A[i]){
                    insert_point = j+1;
                    break;
                }
                if(j==0){
                    insert_point = 0;
                }
            }
            for(int j =i; j>insert_point; j--){
                A[j] = A[j-1];
            }
            A[insert_point] = insert_value;
        }

        for(int i =0; i<N; i++){
            log.info("A[i] : " + A[i]);
        }

        int sum=0;
        for(int i=0; i<N; i++){
            sum += (N-i)*A[i];
        }
        System.out.println(sum);
    }
}
