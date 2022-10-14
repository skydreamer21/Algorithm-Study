// 12852번 1로 만들기2
/*
<문제 정보>
 1. 사용 가능 연산
    - 3으로 나누어 떨어지면 3으로 나눈다
    - 2로 나누어 떨어지면 2로 나눈다
    - 1을 뺀다
 2. 위 3개를 적절히 사용해서 1을 만드려고 함. 연산 사용 최소 횟수 출력
 3. 두번째 줄에는 N을 1로 만드는 수를 출력

<변수 범위>
 1. 0.5초 / 512MB
 2. 1,000,000 이하의 자연수 N


<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.Arrays;

public class Q12852 {
    static Integer[] dp;
    static int[] path;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1];
        path = new int[N+1];
        dp[1]=0;
        if(N>1) {
            dp[2]=1;
            path[2]=1;
        }
        sb.append(solve(N)).append("\n");
        sb.append(N).append(" ");
        int temp=N;
        while(temp>1) {
            sb.append(path[temp]).append(" ");
            temp = path[temp];
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int n) {
        //System.out.println(n);
        if (dp[n]==null) {
            if (n%3==0) {
                if (n%2==1) {
                    dp[n]=Math.min(solve(n-1)+1,solve(n/3)+1);
                    path[n] = (dp[n]==dp[n/3]+1) ? n/3 : n-1;
                }
                else {
                    dp[n]=Math.min(solve(n/2)+1,solve(n/3)+1);
                    path[n] = (dp[n]==dp[n/3]+1) ? n/3 : n/2;
                }
            }
            else if (n%3==1) {
                if (n%2==1) {
                    dp[n]=solve(n-1)+1;
                    path[n] = n-1;
                }
                else {
                    dp[n]=Math.min(solve(n/2)+1,solve(n-1)+1);
                    path[n] = (dp[n]==dp[n/2]+1) ? n/2 : n-1;
                }
            }
            else {
                if (n%2==1) {
                    dp[n]=solve(n-1)+1;
                    path[n] = n-1;
                }
                else {
                    dp[n]=Math.min(solve(n/2)+1,solve(n-1)+1);
                    path[n] = (dp[n]==dp[n/2]+1) ? n/2 : n-1;
                }
            }
        }
        //System.out.printf("%d out\n",n);
        return dp[n];
    }
}
