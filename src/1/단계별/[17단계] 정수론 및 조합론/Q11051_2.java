// 11050번 이항 계수2

/*
<문제 정보>
 1. 자연수 N, 정수 K가 주어졌을 때 이항 계수 (N,K) 를 10,007로 나눈 나머지 출력
 2. 1<=N<=1000, 0<=K<=N


<프로그램 진행>
 1. 파스칼의 삼각형 관련 점화식 (파스칼의 법칙)

<필요 함수>
 1.

 */

// 확장성 보다 파스칼 코드가 조금더 빠름

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q11051_2 {
    static Integer[][] memo;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        memo = new Integer[N+1][K+1];
        bw.write(String.valueOf(Binomial_Coefficient(N,K)));
        //for (int i=0;i<N+1;i++) System.out.println(Arrays.toString(memo[i]));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int Binomial_Coefficient(int n, int k) {
        //System.out.printf("(%d, %d)\n",n,k);
        if (memo[n][k]==null) {
            if (k==0 || n==k) memo[n][k]=1;
            else memo[n][k] = (Binomial_Coefficient(n-1,k)+
                    Binomial_Coefficient(n-1,k-1))%10007;
        }
        return memo[n][k];
    }
}