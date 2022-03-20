// 15686번 치킨 배달 (G5) [bfs dfs]
/*
<문제 정보>
 1. 폐업시키지 않을 치킨집 M개를 골랐을 때 도시의 치킨거리 최솟값

<변수 범위>
 1. 1초 / 512MB
 2. 2<=N<=50
 3. 1<=M<=13
 4. 집의 개수 <= 2N

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

//ArrayList -> 배열로 바꾼다면 약간 성능 더 좋아질 듯

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Q15686_4 {
    static int N,M;
    static int[][] map;
    static int[][] dists;
    static int[] selected;
    static ArrayList<P11> chicken = new ArrayList<>();
    static ArrayList<P11> house = new ArrayList<>();
    static int ans=Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        selected = new int[M];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) {
                    map[i][j]=-2;
                    chicken.add(new P11(i,j));
                }
                if(map[i][j]==1) house.add(new P11(i,j));

            }
        }

        /*for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) System.out.printf("%d ",map[i][j]);
            System.out.println();
        }*/

        dists = new int[chicken.size()][house.size()];
        getChickDis();

        choose(0,0);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void choose (int depth, int idx) {
        if(depth==M) {
            /*for (int i=0;i<chicken.size();i++) {
                System.out.printf("(%d,%d) dis : ",chicken.get(i).x,chicken.get(i).y);
                for (int j=0;j<house.size();j++) System.out.printf("%d ",dists[i][j]);
                System.out.println();
            }*/

            int tmp=0;
            int sum=0;
            for (int j=0;j<house.size();j++) {
                tmp=Integer.MAX_VALUE;
                for (int i=0;i<M;i++) {
                    tmp = Math.min(tmp,dists[selected[i]][j]);
                }
                sum+=tmp;
            }
            ans=Math.min(ans,sum);
            return;
        }
        if(idx==chicken.size()) return;
        for (int i=idx;i<chicken.size();i++) {
            selected[depth]=i;
            choose(depth+1,i+1);
        }
    }

    public static void getChickDis () {
        for (int i=0;i<chicken.size();i++) {
            for (int j=0;j<house.size();j++) {
                dists[i][j]=getDis(chicken.get(i),house.get(j));
            }
        }

    }

    public static int getDis (P11 chicken, P11 house) {
        return Math.abs(chicken.x-house.x)+Math.abs(chicken.y-house.y);
    }
}

class P11 {
    int x,y;
    public P11 (int x, int y) {
        this.x=x;
        this.y=y;
    }
}





























