package com.codingTest_practice.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
- 문제
A개인 카드 묶음과 B개인 카드 묶음인 정렬된 두 묶음의 숫자 카드를 1개로 합칠때 A+B번 비교해야 한다.
N개의 숫자 카드 묶음의 각각의 크기가 주어질 때 최소한 몇 번의 비교가 필요한지 구하는 프로그램 작성

- 입력
1번째 줄 : N이 주어짐 (1<=N<=100,000)
그다음 N개의 줄 : 숫자 카드 묶음의 각가의 크기가 주어짐. (크기는 1000보다 작거나 같은 양의 정수)

- 출력
1번째 줄에 최소 비교 횟수를 출력
*/
public class P1715_카드정렬 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();   // 우선순위 큐
        for(int i=0; i<N; i++){
            int data = sc.nextInt();
            queue.add(data);
        }
        int data1 = 0;
        int data2 = 0;
        int sum = 0;
        while(queue.size() != 1){
            data1= queue.remove();
            data2= queue.remove();
            sum += data1 + data2;
            queue.add(data1 + data2);
        }
        System.out.println(sum);
    }
}
