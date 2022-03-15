// 2217번 로프 (S4) [Sorting, Greedy]
/*
<문제 정보>
 1. 로프들을 사용해 들어 올릴 수 있는 최대 중량
 2. 모든 로프를 사용할 필요는 없음

<변수 범위>
 1.2초 / 192MB
 2. N개 로프 1<=N<=100,000
 3. 로프 버티는 중량 10,000이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.Arrays;

public class Q2217 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for (int i=0;i<N;i++) ropes[i]=Integer.parseInt(br.readLine());
        Arrays.sort(ropes);
        int max=0;
        for (int i=0;i<N;i++) max=Math.max(max,ropes[i]*(N-i));
        System.out.println(max);
        /*bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();*/
    }
}













