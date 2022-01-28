// 1037번 약수

/*
<문제 정보>
 1. 진짜 약수 : 1과 자기 자신이 아닌 약수
 2. 진짜 약수가 모두 주어질 때 N을 출력
 3. 약수들 범위 1,000,000 이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// sort 를 안쓴다면 최댓값 최솟값을 찾는 방법으로 구현해도 괜찮!

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q1037 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] factor = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) factor[i] = Integer.parseInt(st.nextToken());
        if (N==1) bw.write(String.valueOf(factor[0]*factor[0]));
        else {
            Arrays.sort(factor);
            bw.write(String.valueOf(factor[0]*factor[N-1]));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}