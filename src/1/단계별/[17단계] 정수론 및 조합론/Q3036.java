// 3036번 링

/*
<문제 정보>
 1. 링 N개, 서로 접하게
 2. 톱니바퀴 맞물리면서 돌아가듯 링도 돌아갈때, 첫번째 링을 한바퀴 돌리면
 나머지 링은 몇바퀴 돌아가는지 출력
 3. 3<=N<=100
 4. 바닥에 놓은 순서대로 링의 반지름이 주어짐. 1이상 1000이하
 5. 출력은 기약분수의 형태로 출력

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q3036 {
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int gcd;
        arr = new int[N];
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int i=1;i<N;i++) {
           gcd = GCD(arr[0],arr[i]);
            //gcd = (arr[0]>arr[i]) ? GCD(arr[0],arr[i]) : GCD(arr[i],arr[0]);
            sb.append(arr[0]/gcd).append("/").append(arr[i]/gcd).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int GCD (int A, int B) {
        if(B==0) return A;
        else return GCD(B,A%B);
    }
}