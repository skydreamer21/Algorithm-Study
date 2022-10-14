import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 벽들을 전부 리스트에 넣어놓음
// 시작점에서 map을 dfs로 탐색, 끝점에서 map을 dfs로 탐색 (끝은 +1 <= 벽 부숨)해서
// dfs로 찾은 경로와, 벽 기준 오는것과 가는 것을 더한 값 중 최솟값을 선택

// --> 큐가 없으므로 프로그램 실행에 드는 메모리가 더 적음
// --> 벽을 부수고 나아가는 것을 bfs에 반영하는 것보다 그냥 맵 탐색이 시간 더 적음
// 이후에 벽들에 대해 조사하는 것이 있지만 그것은 탐색이 아니라 벽한개당 8번 비교
// --> 맵크기가 커지면 벽만 조사하는게 시간이 덜걸림

public class Q2206_other {
    static int N,M;
    static int map[][][];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static ArrayList<point> p;
    static int min_ = 1000001;
    static void copy_map(){

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[1][i][j] = map[0][i][j];
            }
        }
    }
    static void DFS(int y,int x, int cnt,int idx){

        map[idx][y][x] = cnt;
        for(int i = 0 ; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx >= 0 && cx < M && cy >=0 && cy < N){
                if(map[idx][cy][cx] == 0){
                    DFS(cy,cx, cnt + 1, idx);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[2][N][M];
        p = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                map[0][i][j] = (str.charAt(j)-'0')*-1;
                if(map[0][i][j] == -1){
                    p.add(new point(i,j));
                }
            }
        }
        copy_map();
        DFS(0, 0, 1, 0);
        DFS(N-1, M-1, 1, 1);

        if(map[0][N-1][M-1] != 0){
            min_ = map[0][N-1][M-1];
        }


        for(point i : p){
            int start = 1000001;
            for(int j = 0 ; j < 4; j++){
                int cx = i.x + dx[j];
                int cy = i.y + dy[j];
                if(cx >= 0 && cx < M && cy >=0 && cy < N){
                    if(map[0][cy][cx] > 0){
                        start = Math.min(start, map[0][cy][cx]);
                    }
                }
            }

            int end = 1000001;
            for(int j = 0 ; j < 4; j++){
                int cx = i.x + dx[j];
                int cy = i.y + dy[j];
                if(cx >= 0 && cx < M && cy >=0 && cy < N){
                    if(map[1][cy][cx] > 0){
                        end = Math.min(end, map[1][cy][cx]);
                    }
                }
            }

            // start와 end가 같더라도 최단경로일경우에는 min_이 적용
            if(start != 1000001 && end != 1000001){
                min_ = Math.min(min_, start + end + 1);
            }
        }


        if(min_ == 1000001){
            System.out.println(-1);
        }
        else{
            System.out.println(min_);
        }

    }
}

class point{
    public int x;
    public int y;
    public point(int y, int x){
        this.x =x;
        this.y = y;
    }
}