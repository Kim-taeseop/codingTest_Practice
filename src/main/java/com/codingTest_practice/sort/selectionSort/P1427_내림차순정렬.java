package com.codingTest_practice.sort.selectionSort;

import java.util.Scanner;

/*
- 문제
수가 주어지면 그 수의 각 자릿수를 내림차순으로 정렬하시오

- 입력
1번째 줄에 정렬할 수 N이 주어짐. N은 1000000000보다 작거나 같은 자연수다.

- 출력
1번째 줄에 자릿수를 내림차순 정렬한 수를 출력한다.
*/
public class P1427_내림차순정렬 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] A = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            A[i]= Integer.parseInt(str.substring(i,i+1));
        }

        for(int i=0; i<str.length(); i++){
            int Max = i;
            for(int j=i+1; j<str.length(); j++){
                if(A[j]>A[Max]) {
                    Max=j;
                }
            }
            if(A[i] < A[Max]){
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        for(int i=0; i<str.length(); i++){
            System.out.print(A[i]);
        }
    }
}
