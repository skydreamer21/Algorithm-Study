// 25682번 체스판 다시 칠하기2 (G5) [2차원 구간합]
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
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q25682 {
    static int N, M, K;
    static int[][] board;
    static int[][][] diffs;

    enum COLOR {
        BLACK('B', 0),
        WHITE('W', 1);

        private final char color;
        private final int index;

        COLOR(char color, int index) {
            this.color = color;
            this.index = index;
        }

        public char getColor() {
            return color;
        }

        public int getIndex() {
            return index;
        }
    }

    static final int SAME = 0;
    static final int DIFFERENT = 1;

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
        diffs = new int[2][N][M];
        Arrays.stream(COLOR.values()).forEach(Q25682::makeDiffBoard);

        int[][][] prefixSum = new int[2][N][M];
        for (int i=0; i<2; i++) {
            prefixSum[i] = calculatePrefixSum(diffs[i]);
        }

        int answer = Math.min(prefixSum[0][K-1][K-1], prefixSum[1][K-1][K-1]);
        for (int i=K; i<N; i++) {
            for (int color=0; color<2; color++) {
                answer = Math.min(answer, prefixSum[color][i][K-1] - prefixSum[color][i-K][K-1]);
            }
        }

        for (int i=K; i<M; i++) {
            for (int color=0; color<2; color++) {
                answer = Math.min(answer, prefixSum[color][K-1][i] - prefixSum[color][K-1][i-K]);
            }
        }

        for (int i=K; i<N; i++) {
            for (int j=K; j<M; j++) {
                answer = Math.min(answer, count(prefixSum, i, j));
            }
        }

        // ******************** 정답 출력 ********************
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void makeDiffBoard(COLOR color) {
        int colorIndex = color.getIndex();
        int startColor = color.getColor();
        int currentColor;
        for (int i=0; i<N; i++) {
            currentColor = startColor;
            for (int j=0; j<M; j++) {
                diffs[colorIndex][i][j] = board[i][j] == currentColor ? SAME : DIFFERENT;
                currentColor = currentColor == COLOR.BLACK.getColor() ? COLOR.WHITE.getColor() : COLOR.BLACK.getColor();
            }
            startColor = startColor == COLOR.BLACK.getColor() ? COLOR.WHITE.getColor() : COLOR.BLACK.getColor();
        }
    }

    public static int[][] calculatePrefixSum(int[][] diff) {
        int[][] prefixSum = new int[N][M];
        prefixSum[0][0] = diff[0][0];

        for (int i=1; i<N; i++) {
            prefixSum[i][0] = diff[i][0] + prefixSum[i-1][0];
        }
        for (int i=1; i<M; i++) {
            prefixSum[0][i] += diff[0][i] + prefixSum[0][i-1];
        }

        for (int i=1; i<N; i++) {
            for (int j=1; j<M; j++) {
                prefixSum[i][j] = diff[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        return prefixSum;
    }

    public static int count(int[][][] prefixSums, int x, int y) {
        int a = countByColor(prefixSums[COLOR.BLACK.getIndex()], x, y);
        int b = countByColor(prefixSums[COLOR.WHITE.getIndex()], x, y);
        return Math.min(
                countByColor(prefixSums[COLOR.BLACK.getIndex()], x, y),
                countByColor(prefixSums[COLOR.WHITE.getIndex()], x, y)
        );
    }

    public static int countByColor(int[][] prefixSum, int x, int y) {
        return prefixSum[x][y] - prefixSum[x-K][y] - prefixSum[x][y-K] + prefixSum[x-K][y-K];
    }
}























