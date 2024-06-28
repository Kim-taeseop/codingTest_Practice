package com.codingTest_practice.search.binary;

import java.util.Arrays;
import java.util.Scanner;

/*
- 문제
N개의 정수 A[1], A[2], .. A[N] 이 주어질때 이 안에 X라는 정수가 존재하는지 알아내는 프로그램 작성

- 입력
1번째 줄 : 자연수 N(1<=N<= 100000)
2번째 줄 : N개의 정수가 주어짐
3번째 줄 : 찾아야 할 숫자 갯수 M(1<=M<= 100000)
4번째 줄 : M개의 숫자
모든 정수의 범위는 -2^31 이상 2^31이하

- 출력
M개의 줄에 답을 출력. 존재하면 1, 존재하지 않으면 0 출리
*/
public class P1920_원하는정수 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int [N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();

        for(int i=0; i<M; i++){
            int B = sc.nextInt();
            boolean find = false;
            int start = 0;
            int end = N-1;
            while(start <= end){
                int C = (start + end)/2;
                int Cv = A[C];
                if(Cv > B){
                    end = C-1;
                } else if(Cv < B){
                    start = C+1;
                }else{
                    find = true;
                    break;
                }
            }
            if(find){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
}
