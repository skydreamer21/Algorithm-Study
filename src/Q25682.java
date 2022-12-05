// 25682번 체스판 다시 칠하기2
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
import java.util.StringTokenizer;

public class Q25682 {
    static int N, M, K;
    static int answer = Integer.MAX_VALUE;
    static int[][] board;

    static final int BLACK = 'B';
    static final int WHITE = 'W';

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i=0; i<N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j=0; j<M; j++) {
                board[i][j] = input[j];
            }
        }

        // ******************** 메인 로직 ********************
        for (int i=0; i<=N-K; i++) {
            for (int j=0; j<=M-K; j++) {
                answer = Math.min(answer, solve(i, j));
            }
        }

        // ******************** 정답 출력 ********************
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int startX, int startY) {
        return Math.min(
                solveByColor(startX, startY, BLACK),
                solveByColor(startX, startY, WHITE)
                );
    }

    public static int solveByColor(int startX, int startY, int color) {
        int changes = 0;
        int startColor = color;
        int currentColor;
        for (int i=0; i<K; i++) {
            currentColor = startColor;
            for (int j=0; j<K; j++) {
                if (board[startX + i][startY + j] != currentColor) changes++;
                currentColor = currentColor == BLACK ? WHITE : BLACK;
            }
            startColor = startColor == BLACK ? WHITE : BLACK;
        }
        return changes;
    }
}























