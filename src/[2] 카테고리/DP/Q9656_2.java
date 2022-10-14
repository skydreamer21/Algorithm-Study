// 9656번
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q9656_2 {
    static int N;
    static int[] gameResult; // gameResult[n] : 돌개수가 n개일 때 먼저 시작한 사람이 이기냐?

    static final int WIN = 1;
    static final int LOSE = -1;
    static final int EMPTY = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // ******************** 입력 & 초기화 ********************
        N = Integer.parseInt(br.readLine());
        gameResult = new int[N+1];

        // ******************** 메인 로직 ********************
        String winner = solveDP(N) == WIN ? "SK" : "CY";

        // ******************** 정답 출력 ********************
        sb.append(winner);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP(int n) {
        if (gameResult[n] != EMPTY) return gameResult[n];

        switch (n) {
            case 1:
                gameResult[n] = LOSE;
                break;
            case 0:
            case 2:
                gameResult[n] = WIN;
                break;
            default:
                gameResult[n] = -Math.min(solveDP(n-1), solveDP(n-3));
                // solveDP(n-1) : n-1 개일 때 먼저 시작한 사람의 결과 즉 상대방의 결과
                // solveDP(n-3) : n-3 개일 때 먼저 시작한 사람의 결과 즉 상대방의 결과
                /*
                1 1 => lose
                1 -1 => win
                -1 1 => win
                -1 -1 => win
                 */
        }
        return gameResult[n];
    }
}