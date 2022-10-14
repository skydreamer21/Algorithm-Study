import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 큐에다가 모든 정보 다 넣은 케이스
// 좌표, 거리, 벽 부숴졌는지

public class Q2206_other2 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m;
    static char[][] board;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m][2];

        for(int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        System.out.print(bfs());

    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0, 0});
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            if(now[0] == n - 1 && now[1] == m - 1) {
                return now[3] + 1;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 & ny < m) {
                    if(!visited[nx][ny][now[2]]) {
                        if(board[nx][ny] == '1') {
                            if(now[2] < 1) {
                                queue.add(new int[] {nx, ny, now[2] + 1, now[3] + 1});
                            }
                        }
                        else {
                            queue.add(new int[] {nx, ny, now[2], now[3] + 1});
                        }
                        visited[nx][ny][now[2]] = true;
                    }
                }
            }
        }
        return -1;
    }
}