// 10773번 제로

/*
<문제 정보>
 1.


<프로그램 진행>
 1. dp (파스칼)

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q10773 {
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