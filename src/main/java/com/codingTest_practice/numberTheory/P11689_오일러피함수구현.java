package com.codingTest_practice.numberTheory;

import java.util.Scanner;

/*
- 문제
자연수 n이 주어졌을 때 GCD(n,k)=1(1<=k<=n)(최대 공약수)을 만족하는 자연수의 갯수를 구하는 프로그램 작성

- 입력
1번째 줄에 자연수 n(1<=n<=10^12)이 주어짐

- 출력
GCD(n,k)=1(1<=k<=n)을 만족하는 자연수 갯수 출력

- 참고
n이 int값으론 풀었는데 범위때문에 long으로 다시 풀어야 함.
*/
public class P11689_오일러피함수구현 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n+1];

        for(int i=1; i<n+1; i++){
            A[i] = i;
        }
        for(int i=2; i<n+1; i++){
            if(A[i] == i){
                for(int j=1; j<=n/i; j++){
                    A[i*j] = A[i*j] - A[i*j]/i;
                }
            }
        }

        System.out.println(A[n]);
    }
}
