// 11050번 이항 계수2_3

/*
<문제 정보>
 1. 자연수 N, 정수 K가 주어졌을 때 이항 계수 (N,K) 를 10,007로 나눈 나머지 출력
 2. 1<=N<=1000, 0<=K<=N


<프로그램 진행>
 1. 페르마의 소정리
 2. 문제에서 주어진 10007이 소수임을 활용

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q11051_3 {
    public static final int div = 10007;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(BC_prime_mod(N,K)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BC_prime_mod (int N, int K) {
        return factorial(N)*exp((factorial(K)*factorial(N-K))%div,div-2)%div;
    }

    public static int factorial(int n) {
        if (n<=1) return 1;
        else return n*factorial(n-1)%div;
    }

    public static int exp(int a, int p) {
        int result=1;
        while (p>0) {
            if (p%2==1) {
                result*=a;
                p--; // 이후에 p는 항상 짝수
                result%=div;
            }
            //a^(2n) = (a^2)^n 으로 바꿈
            a*=a;
            a%=div;
            p>>>=1;
        }
        return result;
    }
}