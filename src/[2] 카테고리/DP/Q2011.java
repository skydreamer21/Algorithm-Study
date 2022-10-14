// 2011번 암호코드 (G5) [dp]
/*
<문제 정보>
 1. 숫자 - 알파벳 매핑으로 암호화 했을 때 암호코드의 해석 경우의 수를 출력
 2. 1_000_000 으로 나눈 나머지 

<변수 범위>
 1. 2초 / 128MB
 2. 5000자리 이하 암호

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 한자리에서 해석은 한자리 또는 두자리(현재 숫자가 1또는 2일때만)

import java.io.*;
import java.util.stream.Stream;

public class Q2011 {
    static int N;
    static int[] code;
    static int[] dp;

    static final int EMPTY = 0;
    static final int NUM_OF_ALPHABET = 26;
    static final int DIV = 1_000_000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // ******************** 입력 & 초기화 ********************
        String input = br.readLine();
        code = Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();
//        System.out.println(code.getClass().getSimpleName());
        N = code.length;
        dp = new int[N];

        // ******************** 메인 로직 ********************
        int numOfCases = solveDP(0);
        for (int i=0;i<N;i++) {
            System.out.printf("dp[%d]:%d\n", i,dp[i]);
        }

        // ******************** 정답 출력 ********************

        sb.append(numOfCases);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP (int n) {
//        System.out.printf("[IN] n : %d\n",n);
        if (n > N-1) {
//            System.out.printf("[OUT - maxLength] n : %d\n",n);
            return 1;
        }
        if (code[n] == 0) return 0;
        if ( n == N-1 ) return 1;

        if (dp[n] != EMPTY) {
//            System.out.printf("[OUT - already counted] n : %d\n",n);
            return dp[n];
        }

        dp[n] = solveDP(n+1);
        int readTwoDigit = 10*code[n] + code[n+1];
        // 만약 readTwoDigit 가 0 이라면?
//        System.out.printf("n:%d, readTwoDigit : %d\n",n,readTwoDigit);
        dp [n] += readTwoDigit <= NUM_OF_ALPHABET ? solveDP(n+2) : 0;

//        System.out.printf("[OUT - count Finished] n : %d\n",n);
        return dp[n] %= DIV;
    }
}
