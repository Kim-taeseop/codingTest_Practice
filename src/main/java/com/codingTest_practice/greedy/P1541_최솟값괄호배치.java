package com.codingTest_practice.greedy;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/*
- 문제
양수와 +,- 그리고 괄호를 사용한 수식에서 괄호를 다 지우고 새로 괄호를 적절히 넣어 수식의 값을 최소로 만드는 프로그램 작성

- 입력
1번째 줄 : 식이 주어짐. 식은 0~9, +, -로 이뤄져 있고, 처음과 마지막은 숫자
        연속 2개 이상 연산자 나오지 않음. 5자리보다 많이 연속되는 숫자는 없음.수는 0으로 시작할 수 있음.
        입력으로 주어지는 식의 길이는 50보다 작거나 같음.

- 출력
1번째 줄에 정답을 출력
*/
@Slf4j
public class P1541_최솟값괄호배치 {
    static int answer =0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String[] str = A.split("-");    // -를 기준으로 나머지 문자를 배열에 저장
        // log.info("A : " + A);

        for(int i=0; i<str.length; i++){
            int temp = mySum(str[i]);
            if(i==0) {
                answer = answer + temp;
            }else {
                answer = answer - temp;
            }
            System.out.println(answer);
        }
    }

    private static int mySum(String a){
        int sum =0;
        String[] temp = a.split("[+]");     // + 는 정규식에서 특별한 의미를 가지므로 []로 감싸줘야함.
        // log.info("a : " + a);
        for(int i=0; i<temp.length; i++){
            sum = sum + Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
