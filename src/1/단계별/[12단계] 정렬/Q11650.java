// 11650번 좌표 정렬하기

/*
<문제 정보>
 1. 2차원 평면 점 N개가 있을 때, x좌표가 증가하는 순으로 나열.
 2. 만약 x좌표가 같다면 y좌표가 증가하는 순서로 정렬
 3. 1<=N<=100,000 / x, y좌표는 절댓값이 100,000을 넘지않는 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;

public class Q11650 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());

        bw.flush();
        bw.close();
    }
}