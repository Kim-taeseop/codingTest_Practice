package com.codingTest_practice.dataStructure.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

/*
- 문제
1부터 n까지의 수를 스택에 저장하고 출력하는 방식으로 하나의 수열을 만들 수 있다.
1부터 오름차순으로 스택에 push를 한다.
수열이 주어졌을 때 이 방식으로 주어진 수열을 만들 수 있는지 확인하고, 있다면 어떤 순서로 push와 pop을 수행해야 하는지 프로그램 작성

- 입력
1번째 줄 : 수열의 개수 n (1<=n<=100000)
2번째 줄 부터 n개의 줄 : 수열을 이루는 1이상 n이하의 정수가 1개씩 순서대로 주어짐. 같은 정수 두번 안나옴

- 출력
오름차순 수열을 만들기 위한 연산 순서를 출력. push는 + , pop은 - 로 출력, 불가능 할때는 NO를 출력
*/
public class P1874_스택오름차순 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int num=1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for(int i=0; i<N; i++){
            int su = A[i];
            if(su >= num){
                while(su>=num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }else {
                int n = stack.pop();
                if(n>su) {
                    System.out.println("NO");
                    result = false;
                    break;
                }else {
                    bf.append("-\n");
                }
            }
        }
        if(result){
            System.out.println(bf.toString());
        }
    }
}
