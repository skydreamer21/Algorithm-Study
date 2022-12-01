// 1402번 아무래도이문제는A번난이도인것같다 (S5) [수학]
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
import java.util.StringTokenizer;

public class Q1402 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // -1 * -1 * 1 => 곱의 값은 변하지 않으면서 합의 값은 -1
            // * 1 => 곱의 값은 변하지 않으면서 합의 값은 + 1
            // => 모든 값을 만들 수 있다.
            sb.append("yes").append("\n");
        }
        sb.append("yes");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
