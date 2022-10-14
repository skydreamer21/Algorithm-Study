// 9656번 돌 게임 2 (S5) [DP]
/*
<문제 정보>
 1. 각 턴에서 돌을 1개 또는 3개를 가져갈 수 있다.
 2. 완벽하게 게임을 했을 때 이기는 사람 출력
 3. 상근이 먼저 시작

<변수 범위>
 1. 돌의 개수 1 <= N <= 1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q9656 {
    static int N;
    static int[][] gameResult;

    static final int SK = 0;
    static final int CY = 1;
    static final int WIN = 1;
    static final int LOSE = -1;
    static final int EMPTY = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // ******************** 입력 & 초기화 ********************
        N = Integer.parseInt(br.readLine());
        gameResult = new int[2][N+1];

        // ******************** 메인 로직 ********************
        String winner = solveDP(SK, N) == WIN ? "SK" : "CY";
        /*for (int i=1; i<=20; i++) {
            String winner = solveDP(SK, i) == WIN ? "SK" : "CY";
            System.out.printf("%d개 일 때 : %s\n", i, winner);
        }*/

        // ******************** 정답 출력 ********************
        sb.append(winner);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP(int player, int n) {
        if (gameResult[player][n] != EMPTY) return gameResult[player][n];

        switch (n) {
            case 0:
            case 1:
                gameResult[player][n] = LOSE;
                break;
            case 2:
                gameResult[player][n] = WIN;
                break;
            default:
                int oppositePlayer= (player + 1)%2;
                gameResult[player][n] = -Math.max(solveDP(oppositePlayer, n-1), solveDP(oppositePlayer, n-3));
        }
        return gameResult[player][n];
    }
}
