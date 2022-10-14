// 2748번 피보나치 수 2 (B1)
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB
 2. n 90이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q2748 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] fibo = new long[n+1];
        fibo[1]=1;
        for (int i=2;i<=n;i++) fibo[i]=fibo[i-1]+fibo[i-2];
        bw.write(String.valueOf(fibo[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
