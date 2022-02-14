import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// dfs를 재귀로 구현
public class Q2667_other{
    public static int[] dx ={-1,1,0,0};
    public static int[] dy ={0,0,-1,1};

    public static int apart = 0; // 단지 번호
    public static int N;
    public static int color = 0;
    public static int board[][];
    public static boolean visited[][];
    public static int ans[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board =new int[N][N];
        visited =new boolean[N][N];
        ans = new int[N*N];

        for(int i =0; i <N; i++){
            String s = br.readLine();
            for(int j=0; j <N; j++){
                board[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i =0; i <N; i++){
            for(int j =0; j<N; j++){
                if(board[i][j] ==1 && !visited[i][j]){
                    apart++;
                    color++;
                    dfs(i,j);
                }
            }
        }
        Arrays.sort(ans);

        System.out.println(color);
        for(int i=0; i <ans.length; i++){
            if(ans[i] !=0) System.out.println(ans[i]);
        }
    }
    public static void dfs(int r, int c){
        visited[r][c] = true;
        ans[apart]++;

        for(int i =0; i <4; i++){
            int nr = r+dx[i];
            int nc = c+dy[i];
            if(nr<0 || nr> N-1 || nc<0 || nc >N-1) continue;
            if(board[nr][nc] == 1 && !visited[nr][nc]){
                dfs(nr,nc);
            }
        }
    }


}