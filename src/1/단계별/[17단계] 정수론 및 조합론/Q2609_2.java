// 2609번 최대공약수와 최소공배수(2)

/*
<문제 정보>
 1. 두개의 자연수를 입력받아 최대공약수와 최소공배수 출력
 2. 10,000 이하의 자연수

<프로그램 진행>
 1. 유클리드 호제법

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q2609_2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int GCD; int LCM;
        if (A<B) GCD = GCD(B,A);
        else GCD = GCD(A,B);
        LCM = A*B/GCD;
        sb.append(GCD).append("\n").append(LCM);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int GCD (int A, int B) {
        // A>B
        if (B==0) return A;
        else return GCD(B,A%B);
    }
}