// 2442번 별 찍기 - 5 (G3)
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q2442 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i=1;i<=N;i++) {
            printBlank(N-i);
            printStar(2*i-1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void printBlank(int n) {
        for (int i=1;i<=n;i++) sb.append(" ");
    }

    public static void printStar(int n) {
        for (int i=1;i<=n;i++) sb.append("*");
        sb.append("\n");
    }
}
