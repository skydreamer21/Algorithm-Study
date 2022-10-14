// 1436번 영화감독 숌

/*
<문제 정보>
 1. 종말의 숫자 : 6이 연속 세번이상 들어간 숫자
 2. 666 -> 1666 -> 2666 -> ...
 3. N번째 종말의 숫자 출력
 4. N<=10000, N은 자연수

<프로그램 진행>
 1. 완전탐색

<필요 함수>
 1. N 입력시 N이 종말숫자인지 boolean으로 return

 */

import java.io.*;

public class Q1436 {
    public static boolean IsThisTheNumber(int N) {
        boolean theNumber = String.valueOf(N).contains("666");
        return theNumber;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int temp = 666;
        int cnt=0;
        int NthNumber;
        while(cnt<N) {
            if(IsThisTheNumber(temp)) cnt++;
            temp++;
        }
        NthNumber = temp-1;
        bw.write(String.valueOf(NthNumber));
        bw.flush();
        bw.close();
    }
}