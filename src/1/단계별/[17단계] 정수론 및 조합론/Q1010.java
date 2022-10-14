// 1010번 다리놓기

/*
<문제 정보>
 1. 서쪽에 N개, 동쪽에 M개 사이트를 서로 연결 할 때, N개 연결하는 경우의 수
 2. 조합문제 (이항계수)
 3. 0<N<=M<30  (int 범위 안에서 해결 가능)


<프로그램 진행>
 1. dp (파스칼)

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q1010 {
    static Integer[][] memo = new Integer[31][31];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int M; int N;
        for (int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sb.append(BC(M,N)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BC (int m, int n) {
        if (memo[m][n]==null) {
            if (n==0 | n==m) memo[m][n]=1;
            else memo[m][n]=BC(m-1,n)+BC(m-1,n-1);
        }
        return memo[m][n];

    }
}