// 11653번 소인수분해
/*
<문제 정보>
 1. 정수 N이 주어졌을 때, 소인수분해 결과를 오름차순으로 출력
 2. N이 1인 경우, 아무것도 출력하지 않음

<프로그램 진행>
 1. 소수와 마찬가지로 루트값을 구해서 시작

<필요 함수>
  1. 소인수분해 결과 출력 함수
 */

import java.io.*;

public class Q11653_2 {

    public static void printFactorization (int N) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sqrtNum = (int) Math.floor(Math.sqrt(N));
        int temp = N;
        for (int i=2;i<=sqrtNum;i++) {
            while (temp%i==0) {
                bw.write(i+"\n");
                temp/=i;
            }
        }
        if (temp!=1) bw.write(String.valueOf(temp));
        bw.flush();
        bw.close();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        printFactorization(N);
    }
}




