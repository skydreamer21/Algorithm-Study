// 10757번(2) 큰수 A+B  (3) 배열로도 만들어보기
/*
<문제 정보>
 1. 두 정수 A, B입력 받은 후 A+B 출력
 2. 0<A,B<10^10000

<프로그램 진행>
 1. 10^10000이면 long의 최대치인 2^63-1 을 벗어남
 2. BigInteger 사용

<필요 함수>
  .
 */

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Q10757_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        StringTokenizer tk = new StringTokenizer(S);
        BigInteger A = new BigInteger(tk.nextToken());
        BigInteger B = new BigInteger(tk.nextToken());
        BigInteger sum = A.add(B);
        bw.write(sum.toString());
        bw.flush();
        bw.close();
    }
}




