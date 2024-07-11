package com.codingTest_practice.dataStructure.slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
- 문제
DNA 문자열 : 모든 문자가 A,C,G,T로 구성
DNA를 이용하여 비밀번호를 제작
부분 문자열에 등장하는 문자의 개수가 특정 개수 이상이어야 함.
조건과 부분 문자열 길이, DNA 문자열이 주어질때 몇가지의 비밀번호를 만들수 있는가
부분 문자열이 등장하는 위치가 다르면 부분 문자열 내용이 같아도 다른 문자열로 취급

- 입력
1번째 줄 : DNA 문자열 길이 ISI, 부분 문자열 길이 IPI ( 1<= IPI <= ISI <= 1000000)
2번째 줄 : DNA 문자열
3번째 줄 : A,C,G,T의 최소 개수

- 출력
비밀번호 종류의 갯수를 출력
*/


public class P12891_DNA {
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());  // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken());   // 부분 문자열 길이
        int result = 0;
        checkArr = new int[4];    // 조건
        myArr = new int[4];       // 현재 부분 문자열이 조건에 얼마나 만족하는지
        char[] A = new char[S];     // DNA 문자열
        checkSecret = 0; // 4개의 문자열중 몇개의 조건에 만족하는지 => 4가 되어야 함.

        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) { // 부분문자열 처음 받을때 세팅
            Add(A[i]);
        }

        if (checkSecret == 4) {
            result++;
        }

        // 슬라이딩 윈도우 (1칸 갔을때 부터 시작)
        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) {
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }
}
