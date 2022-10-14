// 2470번 두 용액
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초(addX) / 128MB
 2. 전체 용액 수 N 2<=N<=100,000
 3. 용액 특성값 -1,000,000,000<=x<=1,000,000,000
 4. 용액 특성값은 모두 다름

<프로그램 진행>
 1. 입력된 수열의 순서가 유지될 필요 없음 -> 정렬

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q2470 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int left = 0;
        int right = N-1;
        int sum=Integer.MAX_VALUE;
        int temp_sum;
        int first=0;
        int second=0;
        while(left<right) {

            if (arr[left]>=0 || arr[right]<=0) {
                if(arr[left]>=0) right = left+1;
                else left = right-1;
                temp_sum = Math.abs(arr[left]+arr[right]);
                if(temp_sum<sum) {
                    first = arr[left];
                    second = arr[right];
                }
                break;
            }

            temp_sum = Math.abs(arr[left]+arr[right]);
            if(temp_sum<sum) {
                sum = temp_sum;
                first = arr[left];
                second = arr[right];
            }
            if (arr[left]+arr[right]>=0) right--;
            else left++;

        }
        bw.write(first+" "+second);
        bw.flush();
        bw.close();
        br.close();
    }
}











