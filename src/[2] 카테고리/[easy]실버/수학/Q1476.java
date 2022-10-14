// 1476번 날짜 계산 (S5)
/*
<문제 정보>
 1. E S M 으로 표현되는 가장 빠른 년도 출력

<변수 범위>
 1. 2초 / 4MB
 2. E ~15
 3. S ~28
 4. M ~19

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q1476 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int tmp=0;
        for (int i=0;i<15*19;i++) {
            tmp=28*i+S;
            if (tmp%15==E%15 && tmp%19==M%19) break;
        }
        bw.write(String.valueOf(tmp));

        bw.flush();
        bw.close();
        br.close();
    }
}
