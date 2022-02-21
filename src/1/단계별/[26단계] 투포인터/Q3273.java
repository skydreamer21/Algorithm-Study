// 3273번 두 수의 합
/*
<문제 정보>
 1. 두 수의 합이 특정 수가 되는 쌍의 수 출력
 2. 수열의 수는 서로 다름

<변수 범위>
 1. 1초 / 128MB
 2. 수열의 크기 n 1<=n<=100,000
 3. 수열 안의 수 1,000,000 이하 자연수
 4. 합 x 1<=x<=2,000,000

<프로그램 진행>
 1. 정렬 필요

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q3273 {
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int left = 0;
        int right = N-1;
        int sum;
        int cnt=0;
        while(left<right) {
            sum=arr[left]+arr[right];
            if (sum==target) {
                cnt++;
                right--;
                left++;
            }
            else if (sum<target) left++;
            else right--;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}