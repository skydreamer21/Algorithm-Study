// 52220KB	444ms

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2573_other {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = scan.nextInt();
            }
        }
    }

    static class Melt {
        int x, y, cnt;

        public Melt(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static List<Melt> meltList;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static void sol() {
        int time = 0;
        while(true) {
            visited = new boolean[N][M];
            int cnt = 0;
            meltList = new ArrayList<>();
            for (int i = 1; i < N-1; i++) {
                for (int j = 1; j < M-1; j++) {
                    if(graph[i][j] > 0 && !visited[i][j]) {
                        if(cnt > 0) {
                            System.out.println(time);
                            return;
                        }
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            if(meltList.size() > 0) {
                for(Melt melt : meltList) {
                    graph[melt.x][melt.y] = Math.max(0, graph[melt.x][melt.y] - melt.cnt);
                }
            }

            if(cnt==0) {
                System.out.println(0);
                return;
            }

            if(cnt >= 2) {
                System.out.println(time);
                return;
            }

            time++;
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        int cnt = 0;
        for(int[] move : moves) {
            int nx = x + move[0];
            int ny = y + move[1];
            if(!visited[nx][ny]) {
                if(graph[nx][ny] == 0) {
                    cnt++;
                } else {
                    dfs(nx, ny);
                }
            }
        }
        if(cnt != 0) {
            meltList.add(new Melt(x, y, cnt));
        }
    }

    public static void main(String[] args) {
        input();
        sol();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}