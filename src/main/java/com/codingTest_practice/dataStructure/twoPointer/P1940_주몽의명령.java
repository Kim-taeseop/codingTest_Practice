package com.codingTest_practice.dataStructure.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
- 문제
번호를 가진 재료들을 2개를 합쳐 M이 될 때 갑옷이 만들어진다.
가진 재료로 갑옷을 몇개 만들수 있는지 구하는 프로그램을 제작

- 입력
1번째 줄 : 재료의 갯수 N(1<=N<=15000)
2번째 줄 : 갑옷이 되는 숫자 M(1<=M<=10000000)
3번째 줄 : N개의 재료들이 가진 고유한 번호들 (100000보다 작거나 같은 자연수)

- 출력
1번째 줄에 갑옷의 개수를 출력
*/
public class P1940_주몽의명령 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); // 배열 A를 오름차순

        int count =0;
        int sIndex=0;
        int eIndex=N-1;

        while(sIndex<eIndex){
            if(A[sIndex] + A[eIndex] == M){
                count ++;
                sIndex ++;
                eIndex --;
            } else if(A[sIndex] + A[eIndex] < M){
                sIndex ++;
            } else {
                eIndex ++;
            }
        }
        System.out.println(count);

        /*Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int count = 0;
        for(int i=0; i<N; i++){
            for(int j =i+1; j<N; j++){
                if(A[i]+A[j] == M){ count++;}
            }
        }
        System.out.println(count);*/
    }

}
