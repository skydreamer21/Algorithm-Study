import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q2178_3 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[][] DIR = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0;i<N;i++) {
            char[] input = br.readLine().toCharArray();
            for (int j=0;j<M;j++) {
                map[i][j] = input[j] - '0';
            }
        }

        Deque<Pos100> q = new ArrayDeque<>();
        q.add(new Pos100(0,0));
        visited[0][0] = true;

        Pos100 now;
        int nextX, nextY;
        boolean inRange;
        int size;
        int dist = 0;
        boolean findAns = false;

        while (!q.isEmpty()) {
            if (findAns) break;
            dist++;
            size = q.size();

            for (int i=0;i<size;i++) {
                if (findAns) break;
                now = q.poll();
                for (int[] d: DIR) {
                    nextX = now.x + d[0];
                    nextY = now.y + d[1];
                    inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
                    if (inRange && !visited[nextX][nextY] && map[nextX][nextY]==1) {
                        if (nextX == N-1 && nextY == M-1) {
                            findAns = true;
                            break;
                        }
                        visited[nextX][nextY] = true;
                        q.add(new Pos100(nextX, nextY));
                    }
                }
            }
        }

        sb.append(dist+1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Pos100 {
    int x, y;

    public Pos100(int x, int y) {
        this.x = x;
        this.y = y;
    }
}