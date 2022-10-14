// 번
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

 // 실패 - 시간초과

import java.io.*;

public class Q17425_2 {
    static long[] sum;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sum = new long[1_000_001];
        for (int i=1;i<=1_000_000;i++) sum[i] = sum[i-1]+i;
        int T = Integer.parseInt(br.readLine());
        while(T-- >0) sb.append(g(Integer.parseInt(br.readLine()))).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static long g(int N) {
        int mul = 1;
        int div = 2;
        int divLimit = (int) Math.floor(Math.sqrt(N));
        int start = N/div;
        int end = N;
        long result= sum[end]-sum[start];

        while (++div<=divLimit) {
            end = start;
            start = N/div;
            result += (sum[end]-sum[start])*++mul;
//            System.out.printf("result : %d\n",result);
        }
        for (int i=1;i<=start;i++) result += (long) (N / i)*i;
        return result;
    }
}















