// 2193번 이친수(S3) [dp] [fibonacci]
/*
<문제 정보>
 1. 이친수
    - 1로 시작함
    - 1이 두번 연속으로 나타나지 않음
 2. N자리 이친수의 개수 출력

<변수 범위>
 1. 2초 / 128MB


<프로그램 진행>
 1.

<필요 함수>
 1.

 */


/*
1 1/0 1
10 : 0/1 1
100, 101 : 1/1 2
1/2 3
2/3 5
3/5 8



 */

import java.io.*;

public class Q2193 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N+1];
        arr[1]=1;
        if(N>1) arr[2]=1;
        for (int i=3;i<=N;i++) arr[i]=arr[i-1]+arr[i-2];
        bw.write(String.valueOf(arr[N]));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
