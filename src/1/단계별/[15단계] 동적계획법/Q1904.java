// 1904번 01타일

/*
<문제 정보>
 1. 2진 수열을 만들때 쓸 수 있는 수가 1 또는 00
 -> 10 이나 110 같은것은 만들지 못함
 2. 크기가 N으로 주어졌을 때, 만들 수 있는 2진 수열의 가짓수를 '15746'으로 나눈 나머지를 출력
 3. 1<=N<=1,000,000


<프로그램 진행>
 이러한 성질을 만족하는 모든 2진 수열은 00으로 끝나거나 1로 끝나거나 둘 중하나에 속함. 그리고 이 두가지는 겹칠 수 없음
 1. 00 조각을 빼면 N-2 일 때
 2. 1 조각을 빼면 N-1 일 때
 -> 피보나치
 * N범위가 커서 Top-down이면 재귀가 종료시점으로 가기 전에 이미 너무 많이 호출되어 stackoverflow 에러 발생

<필요 함수>
1.

 */

// memoization 필요없이 코드를 짤 수 있음 (1904_other 참고)
// 한 개의 입력에 대한 출력만 하기 때문에 저장하는 배열은 필요없는 문제

/*
 백준에서는 IDE에서 stackoverflow 나와도 결과가 나올 수 있음
 Top-down : 57676KB / 308ms
 Bottom-up : 18172KB / 144ms
 */

import java.io.*;

public class Q1904 {
    static int[] memo = new int[1000001];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        memo[1] = 1;
        memo[2] = 2;
        bw.write(String.valueOf(fibo_2(N)));
        bw.flush();
        bw.close();
        br.close();
    }

    // Top-down -> StackOverflow error
    public static int fibo (int n) {
        if (memo[n]==0) memo[n] = (fibo(n-1)+fibo(n-2))%15746;
        return memo[n];
    }

    // Bottom-up
    public static int fibo_2 (int n) {
        if (memo[n]==0) {
            for (int i=3;i<=n;i++) memo[i]=(memo[i-1]+memo[i-2])%15746;
        }
        return memo[n];
    }
}