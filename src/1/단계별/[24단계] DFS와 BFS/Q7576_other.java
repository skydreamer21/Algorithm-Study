import java.io.*;
import java.util.*;

public class Q7576_other {
    static int M, N;
    static int[] di = { -1, 0, 1, 0 };
    static int[] dj = { 0, 1, 0, -1 };
    static int[][] map;
    static ArrayDeque<int[]> tomato;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        tomato = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    tomato.offer(new int[] { i, j });
                }
            }
        }

        System.out.println(tomato());

        br.close();
    }

    private static int tomato() {
        int days = 0;

        while (!tomato.isEmpty()) {
            int size = tomato.size();

            for (int i = 0; i < size; i++) {
                int[] cur = tomato.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + di[d];
                    int ny = cur[1] + dj[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0)
                        continue;

                    map[nx][ny] = 1;
                    tomato.offer(new int[] { nx, ny });
                }
            }

            days++;
        }


        if (check())
            days = 0;

        return days - 1;
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    return true;
            }
        }

        return false;
    }
}
