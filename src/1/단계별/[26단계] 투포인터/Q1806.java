// 1806번 부분합
/*
<문제 정보>
 1. 연속된 수들의 부분합 S 이상 중 가장 짧은 것의 길이
 2. 합을 만드는 것이 불가능 하다면 0을 출력

<변수 범위>
 1. 0.5초 (addX) / 128MB
 2. 수열의 크기 N 10<=N<100,000
 3. 부분 합 target S 0<S<=100,000,000
 4. 수열의 각 수 10,000 이하 자연수

<프로그램 진행>
 1. 수열의 순서가 중요 -> 정렬X

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1806 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int left=0;
        int right=0;
        int sum=0;
        int minlen=Integer.MAX_VALUE;
        boolean flag = true;
        while (right<N) {
            // sum을 sum[right]-sum[left]로도 짤 수 있음!
            if (flag) sum+=arr[right];
            else sum-=arr[left-1];

            if (sum>=S) {
                minlen = Math.min(minlen,right-left+1);
                //if(left==right) right++;
                left++;
                flag = false;
            }
            else {
                right++;
                flag = true;
            }
        }
        bw.write(String.valueOf((minlen==Integer.MAX_VALUE) ? 0 : minlen));
        bw.flush();
        bw.close();
        br.close();
    }
}
