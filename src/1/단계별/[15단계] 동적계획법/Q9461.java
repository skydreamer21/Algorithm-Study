// 9461 파도반 수열

/*
<문제 정보>
 1. 문제에서 주어진 방식대로 삼각형을 놓을 때 N번째 삼각형의 한번의 길이 구하기
 2. 1<=N<=100

<프로그램 진행>
 1. n>=9  P(n)=P(n-1)+P(n-5)
 2. n>=3  P(n)=P(n-2)+P(n-3) 도 가능 (평행사변형 이용) (P(0)=0 일 때)

 주의. N까지했을 때 int의 최대범위를 초과하므로 long으로 해주어야함.
 (점화식으로 더해나가는 수열들은 오버플로를 조심하자!)

<필요 함수>
 1.

 */

import java.io.*;

public class Q9461 {
    static long[] memo = new long[101];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        memo[1]=1; memo[2]=1; memo[3]=1; memo[4]=2;
        memo[5]=2; memo[6]=3; memo[7]=4; memo[8]=5;
        int T = Integer.parseInt(br.readLine());
        int N;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<T;i++) {
            N = Integer.parseInt(br.readLine());
            if (N<9) sb.append(memo[N]).append("\n");
            else sb.append(Padovan(N)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long Padovan (int n) {
        if (memo[n]==0) {
            for (int i=9;i<=n;i++) memo[i]=memo[i-1]+memo[i-5];
        }
        return memo[n];
    }
}