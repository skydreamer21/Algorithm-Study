// 11399번 ATM

/*
<문제 정보>
 1. N명이 줄 서있고 i번 사람 걸리는 시간은 P_i분
 2. 줄을 어떻게 서느냐에 따라 각 사람이 돈을 인출하는 데 걸리는 시간의 합이 달라짐
 3. 합의 최솟값 출력
 4. 1<=N<=1,000  /  1<=P_i<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 수의 범위가 크지 않으므로 Counting Sort를 쓴다면 더 빨라질 수 있음.



import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11399 {
    static int[] times;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        times = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) times[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(times);
        int total=0;
        for (int i=0;i<N;i++) total+=times[i]*(N-i);
        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
        br.close();
    }
}