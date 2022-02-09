// 11066번 파일 합치기
/*
<문제 정보>
 1. 연속된 2개의 파일끼리 합치면서 모든 파일을 합칠 때 드는 최소 비용 출력
 2. 합칠때의 비용은 두 파일 크기의 합

<변수 범위>
 1. 파일의 수 3<=K<=500
 2. 파일 크기는 10,000 이하의 자연수 -> 합치는 시간은 long 타입이 되야 할 듯

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q11066 {
    static int[][] dp;
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int N;
        while(T-->0) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N+1][N+1];
            arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i=1;i<=N;i++) arr[i]=Integer.parseInt(st.nextToken());
            sb.append(fileMerge(N,1)).append("\n");
            //for (int i=0;i<=N;i++) System.out.println(Arrays.toString(dp[i]));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int fileMerge (int num, int file) {
        //System.out.printf("num : %d, file : %d\n",num,file);
        if(dp[num][file]==0) {
            if (num==1) dp[num][file] = arr[file];
            else if (num==2) dp[num][file] = fileMerge(1,file)+fileMerge(1,file+1);
            else {
                int filesize = 0;
                for (int i=0;i<num;i++) filesize+=arr[file+i];
                dp[num][file]=fileMerge(num-1,file) + filesize;
                int temp;
                for (int i = num-2;i>=1;i--) {
                    if (i==1) temp = fileMerge(num-i,file+i)+filesize;
                    else temp = fileMerge(i,file)+fileMerge(num-i,file+i)+filesize;
                    dp[num][file] = Math.min(dp[num][file],temp);
                }
            }
        }
        return dp[num][file];
    }
}