// 14502번 연구소 (G5)
/*
<문제 정보>
 1. 벽을 3개 세울 때 안전영역크기의 최댓값 출력

<변수 범위>
 1. 2초 / 512MB
 2. 바이러스 개수 2이상 10이하

<프로그램 진행>
 1. 3<=N,M<=8

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;


public class Q14502 {
    static int N,M;
    static int[][] map;
    static int SA=0; // Safe Area
    static int firstSA;
    static ArrayList<V> virus = new ArrayList<>();
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int debug=0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        firstSA=N*M;
        map = new int[N+1][M+1];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=M;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if (map[i][j]!=0) {
                    firstSA--;
                    if (map[i][j]==2) virus.add(new V(i,j));
                }
            }
        } // 여기까지 초기 안전지대, 바이러스 위치 저장 완료

        // 입력 확인 - 통과1
        /*for (int i=1;i<=N;i++) {
            for (int j=1;j<=M;j++) System.out.printf("%d ",map[i][j]);
            System.out.println();
        }
        System.out.printf("* firstSA : %d\n",firstSA);
        System.out.println("* virus list");
        for (V vir : virus) {
            System.out.printf("(%d,%d) ",vir.x,vir.y);
        }
        System.out.println();*/



        getMaxSA(map,0,firstSA,1,1);
        bw.write(String.valueOf(SA));


        bw.flush();
        bw.close();
        br.close();
    }

    public static void getMaxSA (int[][] m, int walls, int safe, int x, int y) {

        if (walls==3) {

            Deque<V> q = new ArrayDeque<>();
            int tmp_sa = getSA(m,safe,q);
            /*System.out.printf("result; SA : %d\n",tmp_sa);
            if(debug++<5) {
                for (int i=1;i<=N;i++) {
                    for (int j=1;j<=M;j++) System.out.printf("%d ",m[i][j]);
                    System.out.println();
                }
            }*/
            SA = Math.max(SA,tmp_sa);
            backToOrigin(m, q);
            return;
        }

        for (int i=x;i<=N;i++) {
           for (int j=1;j<=M;j++) {
                if(m[i][j]!=0) continue;
                if(i==x && j<y) continue;
                m[i][j]=1;
//                System.out.printf("%d번째 벽 in : (%d,%d)\n",walls+1,i,j);
                if (j==M) {
                    if (i==N && walls==2)  getMaxSA(m,3,safe-1,N,M);
                    else if (i!=N) getMaxSA(m,walls+1,safe-1,i+1,1);
                }
                else getMaxSA(m,walls+1,safe-1,i,j+1);
                m[i][j]=0;
//               System.out.printf("%d번째 벽 out : (%d,%d)\n",walls+1,i,j);
            }
        }
    }


    // 주어진 map에서 안전지대 개수를 반환하고, 퍼진 지역을 저장
    public static int getSA (int[][] m, int safe, Deque<V> save) {
        int vrs=0;
        int nextX, nextY;
        boolean inRange;
        V now;
        Deque<V> q = new ArrayDeque<>();
        for (V Vstart : virus) {
            q.add(Vstart);
            while(!q.isEmpty()) {
                now = q.poll();
                for (int[] d : dir) {
                    nextX=now.x+d[0];
                    nextY=now.y+d[1];
                    inRange = nextX>=1 && nextY>=1 && nextX<=N && nextY<=M;
                    if (inRange && m[nextX][nextY]==0) {
                        vrs++;
                        m[nextX][nextY]=2;
                        q.add(new V(nextX,nextY));
                        save.add(new V(nextX,nextY));
                    }
                }
            }
        }
        return safe-vrs;
    }

    public static void backToOrigin (int[][] m, Deque<V> save) {
        V now;
        while(!save.isEmpty()) {
            now = save.poll();
            m[now.x][now.y]=0;
        }
    }

}

class V {
    int x,y;

    public V (int x, int y) {
        this.x=x;
        this.y=y;
    }
}

















