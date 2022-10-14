// 10819번 차이를 최대로(S2) [math] [backtracking]
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 256MB
 2. 3<=N<=8
 3. 배열에 들어있는 정수는 -100 이상 100 이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q10819 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int plus=0; int minus=0;
        int ans=0;
        // N이 짝수
        for (int i=0;i<N/2;i++) minus+=2*arr[i];
        if(N%2==0) minus-=arr[N/2-1];
        for (int i=N/2;i<N;i++) plus+=2*arr[i];
        plus-=arr[N/2];
        if (N%2==0) ans = plus-minus;

        // N이 홀수
        // 첫번째 케이스
        plus-=arr[N/2+1];
        if(N%2==1) ans = plus-minus;

        // 두번째 케이스
        minus-=arr[N/2-1]; minus+=arr[N/2];
        plus-=arr[N/2]; plus+=arr[N/2+1];
        if(N%2==1) ans = Math.max(ans, plus-minus);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
