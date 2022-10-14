// 11057번 오르막 수(S1) [math] [dp]
/*
<문제 정보>
 1. 수의 길이 N이 주어졌을 때 오르막 수의 개수를 출력 (10,007로 나눈 나머지)
    - 수는 0으로 시작할 수 있음

<변수 범위>
 1. 1초 / 256MB
 2. 1<=N<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;



public class Q11057 {
    static int N;
    static int[] fact;
    static final int div = 10007;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        fact=new int[N+10];
        fact[0]=1;
        bw.write(String.valueOf(nHr(10,N)));
        /*
        만약 N=5?
        00000 -> 00000 ~ 00009
        00011 -> 00011 ~ 00019
        00022 ~ 00029 ....
        두자리일때 구함
        00111 ~ 00199 :
        중복조합 -> 6H5
        N=1 숫자 10개 10H1 = 10
        N=2 10H2 = 11C2=55
        */




        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int nHr(int n, int r) {
        return nCr(n+r-1,r);
    }
    public static int factorial(int n) {
        if(fact[n]==0) fact[n]=(n*factorial(n-1))%div;
        return fact[n];
    }
    public static int exp(int x, int y) {
        if(y==1) return x;
        if(y%2==0) return exp((x*x)%div,y/2);
        else return (x*exp(x,y-1))%div;

    }
    public static int nCr(int n, int r) {
        int numerator=factorial(n);
        int denominator=(factorial(r)*factorial(n-r))%div;
        return (numerator*exp(denominator,div-2))%div;
    }

}













