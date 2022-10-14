// 2629번 양팔저울
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB
 2. 추의 개수 N 30 이하 자연수 / 각 추의 무게는 500g 이하 자연수
 3. 확인할 구슬 개수는 7이하 / 확인하고자하는 구슬의 무게는 40,000 이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q2629 {
    static boolean[] dp;
    static int[] arr;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        int total=0;
        for (int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total+=arr[i];
        }
        int size = Math.min(total,40000);
        dp = new boolean[size+1];
        int temp_diff;
        int temp_sum;
        // i : 추  /  j : 범위내 무게
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=size;j++) {
                if (dp[j]) {
                    temp_diff = Math.abs(j-arr[i]);
                    temp_sum = j+arr[i];
                    if (temp_diff>0 && !dp[temp_diff]) {
                        stack.add(temp_diff);
                    }
                    if (temp_sum<=size && !dp[temp_sum]) {
                        stack.add(temp_sum);
                    }
                }
            }
            if (!dp[arr[i]]) stack.add(arr[i]);
            while(stack.size()>0) dp[stack.poll()] = true;
            //System.out.printf("%d번째 추 : %dg\n",i,arr[i]);
            //System.out.println(Arrays.toString(dp));
        }
        int M = Integer.parseInt(br.readLine());
        int w;
        st = new StringTokenizer(br.readLine());
        while(M-- >0) {
            w = Integer.parseInt(st.nextToken());
            if (w>size) sb.append('N').append(" ");
            else sb.append(dp[w] ? 'Y' : 'N').append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}