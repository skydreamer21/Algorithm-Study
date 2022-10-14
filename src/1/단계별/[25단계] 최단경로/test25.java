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


import java.io.*;
import java.util.Arrays;

public class test25 {
    final static long INF = Long.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        long a = Long.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = b+b;

        long[] t = new long[5];
        for (int i=0;i<5;i++) t[i]=INF;

        System.out.println(Arrays.toString(t));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
