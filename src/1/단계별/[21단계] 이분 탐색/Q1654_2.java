// 1654번 랜선 자르기
/*
<문제 정보>
 1. 이미 가지고 있는 K개의 랜선으로 N개의 길이가 같은 랜선을 만들어야 함
 2. K는 10,000 이하의 자연수 / N은 1,000,000 이하의 자연수 / K<=N / 가지고 있는 랜선의 길이는 int범위
 3. 가지고 있는 K개의 랜선으로 N개를 만들 수 있는 랜선 길이의 최댓값 출력

<프로그램 진행>
 1. 랜선 길이의 최댓값이므로 UpperBound 진행

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1654_2 {
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(BS_UpperBound(K)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BS_UpperBound (int key) {
        int min = 0;
        int max = getMax()+1;
        int mid;
        while (min<max) {
            mid = (min+max)/2;
            System.out.printf("lo : %d, mid : %d, hi : %d\n",min,mid,max);
            if (line(mid)>=key) min = mid+1;
            else max = mid;
        }
        return max-1;
    }

    public static int getMax () {
        int max=arr[0];
        for (int num:arr) max = Math.max(max,num);
        return max;
    }

    public static int line (int len) {
        int sum=0;
        for (int num : arr) sum+=num/len;
        return sum;
    }
}