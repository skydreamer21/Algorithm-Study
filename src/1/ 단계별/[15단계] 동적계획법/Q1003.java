// 1003번 피보나치 함수

/*
<문제 정보>
 1. 피보나치 함수를 재귀함수로 짰을 때, 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력
 2. N<=40, 0포함

<프로그램 진행>
 1. 0과 1이 쓰인 횟수 자체도 피보나치 수열을 따름


<필요 함수>
 1. 0부터 40까지 피보나치 결과를 저장하는 함수

 */

import java.io.*;

public class Q1003 {
    /* 함수 안쓰고 main에 넣음 -> -4ms
    public static int[] fibonacci40() {
        int[] results = new int[41];
        results[0]=0;
        results[1]=1;
        for(int i=2;i<41;i++) results[i]=results[i-1]+results[i-2];
        return results;
    }
     */

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N;
        int[] results = new int[41];
        results[0]=0;
        results[1]=1;
        for(int i=2;i<41;i++) results[i]=results[i-1]+results[i-2];
        for (int i=0;i<T;i++) {
            N = Integer.parseInt(br.readLine());
            if (N==0) sb.append("1 0\n");
            //한번에 append 안하고 요소 따로따로 append -> -28ms !! 메모리도 2000KB가까이 줄음)
            // else sb.append(results[N-1]+" "+results[N]+"\n");
            else sb.append(results[N-1]).append(" ").append(results[N]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}