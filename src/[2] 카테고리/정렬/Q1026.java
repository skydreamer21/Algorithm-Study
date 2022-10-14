// 1026번 보물 pm 5:44 ~ pm 5:56 (Silver4)
// 그리디알고리즘도 포함
/*
<문제 정보>
 1. A 수열을 재배열 해서 A,B 같은 인덱스의 원소끼리 곱해서 더한 값 S의 최솟값을 출력

<변수 범위>
 1. 2초 / 128MB
 2. N 50 이하의 자연수
 3. 수열의 각 숫자는 0이상 100 이하의 정수

<프로그램 진행>
 1. B에 큰숫자일수록 작은 숫자를 주면 됨

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Q1026 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st1.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for (int i=0;i<N;i++) sum+=A[i]*B[N-1-i];
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}



























