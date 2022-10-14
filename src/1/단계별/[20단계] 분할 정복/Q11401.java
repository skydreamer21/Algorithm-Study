// 11401번 이항계수3
/*
<문제 정보>
 1. 이항계수 (N,K)를 1,000,000,007로 나눈 나머지를 출력
 2. 1<=N<=4,000,000 / K는 N이하의 자연수

<프로그램 진행>
 1. 페르마의 소정리

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q11401 {
    static int p = 1000000007;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //int ans = (int) (factorial_2(N)*(exp(factorial_2(K)*factorial_2(N-K)%p,p-2,p))%p);
        //int ans = (int) factorial_2(N);
        long numerator = factorial_2(N);
        long denominator = factorial_2(K)*factorial_2(N-K)%p;
        long ans = numerator*exp(denominator,p-2,p)%p;
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static long exp(long a, long b, int c) {
        if (b==1) return a%c;
        else {
            if (b%2==1) return ((a%c)*exp((a*a)%c,(b-1)/2,c))%c;
            else return (exp((a*a)%c, b/2,c))%c;
        }
    }

    public static long factorial (int N) {
        if (N<=1) return 1;
        else return N*factorial(N-1)%p;
    }

    public static long factorial_2 (int N) {
        long result=1;
        if (N==0) return 1;
        for (int i=N;i>1;i--) result=result*i%p;
        return result;
    }
}