// 11054번 가장 긴 바이토닉 부분 수열

/*
<문제 정보>
 1. S_k를 기준으로 왼쪽으로 갈수록, 오른쪽으로 갈수록 점차 작아지는 수열을 바이토닉 수열
 2. 수열 A가 주어졌을 때 가장 긴 바이토닉 수열의 길이를 출력
 3. 수열 A의 크기 N 1<=N<=1000   /   수열을 이루는 수 1000 이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */



import java.io.*;
import java.util.StringTokenizer;

public class Q11054 {
    static int[] A;
    static int[] memo_LIS;
    static int[] memo_LDS;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N+1];
        memo_LIS = new int[N+1];
        memo_LIS[1] = 1;
        memo_LDS = new int[N+1];
        memo_LDS[N] = 1;
        for (int i=1;i<=N;i++) A[i] = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(bitonic(N)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bitonic (int n) {
        int max = LIS(1)+LDS(1)-1;
        for (int i=1;i<=n;i++) {
            if(LIS(i)+LDS(i)-1>max) max = LIS(i)+LDS(i)-1;
        }
        return max;
    }

    public static int LIS (int n) {
        if (memo_LIS[n]==0 && n!=0) {
            int temp=0;
            for (int i=0;i<n;i++) {
                if(A[n]>A[i] && LIS(i)>temp) temp = memo_LIS[i];
            }
            memo_LIS[n]=temp+1;
        }
        else if (n==0) return 0;
        return memo_LIS[n];
    }

    public static int LDS (int n) {
        if (memo_LDS[n]==0 && n!=0) {
            int temp=0;
            for (int i=A.length-1;i>n;i--) {
                if(A[n]>A[i] && LDS(i)>temp) temp = memo_LDS[i];
            }
            memo_LDS[n] = temp+1;
        }
        else if (n==0) return 0;
        return memo_LDS[n];
    }


}