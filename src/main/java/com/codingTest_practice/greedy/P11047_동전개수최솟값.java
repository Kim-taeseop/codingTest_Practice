package com.codingTest_practice.greedy;

import java.util.Scanner;

/*
- 문제
소유한 동전은 총 N종류, 각 동전의 개수가 많음.
동전을 적절히 사용해 그 가격의 합을 K로 만들려 할때, 필요한 동전 개수의 최솟값을 구하는 프로그램 작성

- 입력
1번째 줄 : N과 K(1<=N<=10, 1<=K<=100,000,000)
2번째 줄부터 N개의 줄 : 동전의 가격 A(i)가 오름차순으로 주어짐(1<=A(i)<=1,000,000 , A(1)=1, i>=2일 때, A(i)는 A(i-1)의 배수)

- 출력
1번째 줄에 K원을 만드는데 필요한 동전 개숫의 최솟값을 출력.
*/
public class P11047_동전개수최솟값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if(A[i] <= K) {
                count += K / A[i];
                K = K % A[i];
            }
        }
        System.out.println(count);
    }
}
