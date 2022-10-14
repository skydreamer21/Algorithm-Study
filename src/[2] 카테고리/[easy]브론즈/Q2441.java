// 2441번 별찍기-4 (B3)
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB
 2. N 100이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q2441 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++) {
            for (int j=1;j<=N;j++) {
                if(j<=i) sb.append(" ");
                else sb.append("*");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
