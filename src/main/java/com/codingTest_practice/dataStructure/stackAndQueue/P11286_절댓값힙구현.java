package com.codingTest_practice.dataStructure.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
- 문제
절댓값힙은 아래 연산을 지원하는 자료구조
1. 배열에 정수x(x=!0)를 넣는다.
2. 배열에서 절댓값이 가장 작은 값을 출력 후 그 값을 배열에서 제거
   절댓값이 가장 작은 값이 여러 개일경우 그중 가장 작은수를 출력하고, 그 값을 배열에서 제거한다.
처음에 비어있는 상태에서 시작

- 입력
1번째 줄 : 연산의 갯수 N(1<=N<=100000)
다음 N개의 줄 : 정수x가 주어짐 / 정수가 0이 아니라면 문제의 1번, 0이라면 2번을 실행
입력되는 정수는 -2^31 보다 크고 2^31 보다 작음.

- 출력
입력에서 0이 주어진 횟수만큼 답을 출력. 만약 배열이 빈상태에서 절댓값을 출력할때는 0을 출력
*/
public class P11286_절댓값힙구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // 헷갈림.
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->{
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            // 절댓값이 같은 경우 음수 우선
            if(first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }
            // 절댓값이 작은 데이터 우선
            return first_abs - second_abs;
        });   // 우선순위 큐 Integer 기준 설정 없으면 오름차순

        for(int i=0; i<N; i++){
            int request = Integer.parseInt(bf.readLine());
            if(request == 0){
                if(queue.isEmpty()){
                    System.out.println("0");
                }else {
                    System.out.println(queue.poll());
                }
            }else {
                queue.add(request);
            }
        }
    }
}
