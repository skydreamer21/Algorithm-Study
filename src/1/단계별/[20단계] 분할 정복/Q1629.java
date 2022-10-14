// 1629번 곱셈
/*
<문제 정보>
 1. 자연수 A를 B번 곱한 수를 C로 나눈 나머지를 출력
 2. A,B,C는 int 범위의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1629 {
    static long C;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());
        bw.write(String.valueOf(exp(A,B)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static long exp(long a, long b) {
        if (b==1) return a%C;
        else {
            if (b%2==1) return ((a%C)*exp((a*a)%C,(b-1)/2))%C;
            else return (exp((a*a)%C, b/2))%C;
        }
    }
}