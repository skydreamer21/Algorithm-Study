// 1654번 랜선 자르기
/*
<문제 정보>
 1. 이미 가지고 있는 K개의 랜선으로 N개의 길이가 같은 랜선을 만들어야 함
 2. K는 10,000 이하의 자연수 / N은 1,000,000 이하의 자연수 / K<=N / 가지고 있는 랜선의 길이는 int범위
 3. 가지고 있는 K개의 랜선으로 N개를 만들 수 있는 랜선 길이의 최댓값 출력

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1654 {
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        bw.write(String.valueOf(Binary_Search(K)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int Binary_Search (int k) {
        int len = arr[arr.length-1];
        int prev_len=0;
        int temp1 = line(len); int temp2;
        // goal : line(len)>=k && line(len+1)<k

        // 1. 만들어야 할 K개를 맞추어 놓음
        while (temp1<k) {
            prev_len = len;
            len/=2;
            temp1 = line(len);
        }

        // 2. K이상이면서 자를 수 있는 최대 길이를 구함
        temp2 = line(len+1);
        if (temp2<k) return len;
        int mid_len;
        while (true) {
            mid_len = (len + prev_len)/2;
            temp1 = line(mid_len);
            temp2 = line(mid_len+1);
            if (temp1>=k && temp2<k) break;
            else if (temp1<k) prev_len = mid_len-1;
            else len = mid_len+1;
        }
        return mid_len;
    }

    public static int line (int len) {
        int sum=0;
        for (int num : arr) sum+=num/len;
        return sum;
    }
}