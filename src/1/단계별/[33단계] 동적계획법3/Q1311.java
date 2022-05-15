// 1311번 할 일 정하기1 (G1)
/*
<문제 정보>
 1. N명의 사람과 N개의 일이 있다. D_ij : i번 사람이 j번 일을 할 때 드는 비용
    -> 모든 일을 하는데 필요한 비용의 최솟값

<변수 범위>
 1. 1초 / 512MB
 2. 사람, 일의 수 1<=N<=20
 3. 각 비용은 10,000 보다 작거나 같은 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q1311 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int a = 754;
        sb.append(Integer.toBinaryString(a)).append("\n");
        sb.append(Integer.bitCount(a)).append("\n");
        sb.append(Integer.numberOfTrailingZeros(a)).append("\n");
        sb.append(a & -a);



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
