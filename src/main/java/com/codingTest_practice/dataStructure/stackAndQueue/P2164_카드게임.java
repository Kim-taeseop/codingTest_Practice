package com.codingTest_practice.dataStructure.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
- 문제
N장의 카드에 각각 1~N의 번호가 붙어있으며, 1번이 가장위, N번이 가장 아래에 위치해 있다.
반복 : 가장위 카드를 버리고, 그다음 가장위 카드를 맨밑으로 내린다.
마지막 1장이 남을때 카드를 구하라

- 입력
1번째 줄에 정수 N(1<=N<=500000)이 주어짐

- 출력
1번째 줄에 남는 카드의 번호를 출력
*/
public class P2164_카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        while(queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
