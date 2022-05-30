// 1300번 K번째 수 (G2)
/*
<문제 정보>
 1. NxN 배열 A A[i][j] = i*j
    - 이 수들을 일차원배열에 넣고 오름차순 정렬했을 때 B[k] 출력
    - A,B 인덱스는 1부터 시작

<변수 범위>
 1. 2초 / 128MB
 2. N은 10^5보다 작거나 같은 자연수
 3. k는 min(10^9, N^2) 보다 작거나 같은 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q1300_studySolve {
    static int N,K;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());





        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}















