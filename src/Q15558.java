// 15558번 점프 게임
/*
<문제 정보>
 1. 한 턴에 취할 수 있는 행동
    - 같은 줄 : i -> i+1
    - 같은 줄 : i -> i-1
    - 다른 줄 : i -> i+k
 2. 유저가 움직이고 첫번째 칸부터 하나씩 사라짐
 3. 시작은 항상 왼쪽 줄의 1번칸

<변수 범위>
 1. 2초 / 512MB
 2. 1 <= N, k <= 100,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q15558 {
    static final int LEFT = 0;
    static final int RIGHT = 1;

    static int N, step;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        step = Integer.parseInt(st.nextToken());

        char[][] lines = new char[2][N];
        lines[LEFT] = br.readLine().toCharArray();
        lines[RIGHT] = br.readLine().toCharArray();

        // ******************** 메인 로직 ********************

        int[][] dir = {{0, 1}, {0, -1}, {1, step}};
        int ans = canClearGameByBfs(lines, dir);

        // ******************** 정답 출력 ********************

        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int canClearGameByBfs(char[][] lines, int[][] dir) {
        final int LINE = 0;
        final int POSITION = 1;
        final char POSSIBLE = '1';

        boolean[][] visited = new boolean[2][N];
        Deque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(LEFT, 0));
        visited[LEFT][0] = true;

        Pos now;
        int nextLine, nextPosition;
        int time = -1;
        int size;
        boolean canClearGame = false;

        while (!q.isEmpty()) {
            if (canClearGame) break;
            time++;
            size = q.size();
            for (int i = 0; i < size; i++) {
                if (canClearGame) break;
                now = q.poll();
                for (int[] d : dir) {
                    nextLine = (now.line + d[LINE]) % 2;
                    nextPosition = now.position + d[POSITION];
                    if (nextPosition >= N) {
                        canClearGame = true;
                        break;
                    }
                    if (nextPosition > time
                        && !visited[nextLine][nextPosition]
                        && lines[nextLine][nextPosition] == POSSIBLE) {
                        q.add(new Pos(nextLine, nextPosition));
                        visited[nextLine][nextPosition] = true;
                    }
                }
            }
        }
        return canClearGame ? 1 : 0;
    }
}

class Pos {
    int line, position;

    public Pos(int line, int position) {
        this.line = line;
        this.position = position;
    }
}
