// 2475번 검증수 (B5)
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
import java.util.StringTokenizer;

public class Q2475 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum=0;
        while(st.hasMoreTokens()) sum+=Math.pow(Integer.parseInt(st.nextToken()),2);
        bw.write(String.valueOf(sum%10));
        bw.flush();
        bw.close();
        br.close();
    }
}
