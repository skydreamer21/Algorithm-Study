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
    static int[] gameResult;

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
            case 0:
            case 1:
                gameResult[n] = LOSE;
                break;
            case 2:
                gameResult[n] = WIN;
                break;
            default:
                gameResult[n] = -Math.max(solveDP(n-1), solveDP(n-3));
        }
        return gameResult[n];
    }
}