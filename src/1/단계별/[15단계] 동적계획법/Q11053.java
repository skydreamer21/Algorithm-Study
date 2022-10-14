// 11053번 가장 긴 증가하는 부분 수열

/*
<문제 정보>
 1. 수열 A의 가장 긴 부분 수열의 길이 출력
 2. 수열 A의 크기 N 1<=N<=1000   /   수열을 이루는 수 1000 이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */



import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11053 {
    static int[] A;
    static int[] memo;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N+1];
        memo = new int[N+1];
        for (int i=1;i<=N;i++) A[i] = Integer.parseInt(st.nextToken());
        memo[1] = 1;
        int max=0;
        for (int i=1;i<=N;i++) {
            if(find(i)>max) max = memo[i];
        }
        bw.write(String.valueOf(max));
        //bw.newLine();
        //bw.write(Arrays.toString(memo));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find (int n) {
        if (memo[n]==0 && n!=0) {
            int temp=0;
            for (int i=0;i<n;i++) {
                if (A[n]>A[i] && find(i)>temp) temp = memo[i];
            }
            memo[n] = temp+1;
        }
        else if (n==0) return 0;
        return memo[n];
    }
}