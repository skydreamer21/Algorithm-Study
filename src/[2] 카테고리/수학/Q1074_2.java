// 1074번 Z (S1) [분할정복] [수학 -> 비트마스킹]
/*
<문제 정보>
 1. 2^N x 2^N 배열을 Z모양으로 방문할 때 r행 c열을 몇번째로 방문하는지 출력

<변수 범위>
 1. 0.5초 / 512MB
 2. 1<=N<15
 3. 0<=r,c<2^N

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q1074_2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int visitOrder = 0;
        int unit = 1;
        for (int i=0;i<N;i++) {
            if ((r & (1<<i)) != 0) visitOrder += unit<<1;
            if ((c & (1<<i)) != 0) visitOrder += unit;
            unit<<=2;
        }
        sb.append(visitOrder);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
