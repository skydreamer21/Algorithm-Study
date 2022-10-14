// 1094번 막대기 (S5) [수학 - 2진수]
/*
<문제 정보>
 1.

<변수 범위>
 1. 2초 / 128MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q1094 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // ******************** 입력 & 초기화 ********************
        int N = Integer.parseInt(br.readLine());



        // ******************** 메인 로직 ********************
        int cmp = 1 << 6;
        int cnt = 0;
        while (N > 0) {
            if (N >= cmp) {
                N -= cmp;
                cnt++;
            }
            cmp >>= 1;
        }


        // ******************** 정답 출력 ********************

        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
