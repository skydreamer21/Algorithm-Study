// 1271번 엄청난 부자2
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

// BigInteger divide float
// https://stackoverflow.com/questions/39762172/in-java-how-do-i-divide-two-bigintegers-and-store-the-value-in-a-double

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Q1271 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        BigInteger N = new BigInteger(st.nextToken());
        BigInteger M = new BigInteger(st.nextToken());

        // ******************** 메인 로직 ********************
        sb.append(N.divide(M)).append("\n").append(N.remainder(M));


        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
