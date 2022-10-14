// 11050번 이항 계수_3

/*
<문제 정보>
 1. 자연수 N, 정수 K가 주어졌을 때 이항 계수 (N,K) 구하는 프로그램 작성
 2. 1<=N<=10, 0<=K<=N


<프로그램 진행>
 1. 확장성을 고려한 dp 풀이

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q11050_3 {
    static Integer[][] memo;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        memo = new Integer[N+1][N+1];
        bw.write(String.valueOf(BC(N,K)));

        bw.flush();
        bw.close();
        br.close();
    }

    public static int BC (int N, int K) {
        if (K>N) return 0;
        else return choose(N,K,0,0);
    }

    public static int choose (int N, int K, int times, int got) {
        if (times==N) {
            if (got==K) return 1;
            else return 0;
        }
        if (memo[times][got]==null) {
            memo[times][got] = choose(N,K,times+1,got)+choose(N,K,times+1,got+1);
        }
        return memo[times][got];
    }
}