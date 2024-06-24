package com.codingTest_practice.search.dfs;

import java.util.Scanner;

/*
- 문제
신기한 소수 : N자리의 숫자가 주어졌을 때 왼쪽부터 1자리, 2자리, 3자리,...N자리 숫자 모두 소수인 소수
N이 주어졌을때 N의 자리 숫자중 신기한 소수를 모두 찾아라.

- 입력
1번째 줄에 N(1<=N<=8)이 주어짐.

- 출력
N의 자리 숫자 중 신기한 소수를 오름차순 정렬해 1줄에 1개씩 출력
*/
public class P2023_신기한소수 {
    static int N;
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();

        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    static void DFS(int s, int v){
        if(v == N){
            if(PRI(s)){
                System.out.println(s);
            }
            return;
        }

        for(int i =1; i<=9; i++){
            if(i%2 == 0){
                continue;
            }
            if(PRI(s*10 +i)){
                DFS(s*10 + i, v+1);
            }
        }
    }

    static boolean PRI(int s) {
        for(int i =2; i<=s/2; i++) {
            if (s % i == 0) {
                return false;
            }
        }
        return true;
    }
}
