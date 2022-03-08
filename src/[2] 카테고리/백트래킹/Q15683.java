// 15683번 감시 (G5)
/*
<문제 정보>
 1. CCTV를 적당히 회전해서 사각지대의 최솟값 출력

<변수 범위>
 1. 1초 / 512MB
 2. 세로 N, 가로 M 1이상 8이하
 3. CCTV 개수 8개 이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q15683 {
    static int N,M;
    static int[][] map;
    static int cctv;
    static int min;
    static int walls=0;
    static ArrayList<cctv> CCTVs = new ArrayList<>();


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=M;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if (map[i][j]!=0 && map[i][j]!=6) CCTVs.add(new cctv(i,j));
                if (map[i][j]==0) walls++;
            }
        }

        cctv=CCTVs.size();
        min = walls;

        BlindSpot(map,0,0);
        bw.write(String.valueOf(min));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void BlindSpot (int[][] m, int depth, int bs) {
        if(depth==cctv) {
            min = Math.min(min,walls-bs);
            return;
        }
//        System.out.printf("%d in\n",depth);

        cctv now = CCTVs.get(depth);
        Deque<cctv> q = new ArrayDeque<>();
        int tmp_bs;
        switch (map[now.x][now.y]) {
            case 1 :
                for (int i=0;i<4;i++) {
                    tmp_bs=bs+cctv1(m,now,i,q);
                    BlindSpot(m,depth+1,tmp_bs);
                    backToOrigin(m,q);
                }
                break;
            case 2 :
                for (int i=0;i<2;i++) {
                    tmp_bs=bs+cctv2(m,now,i,q);
                    BlindSpot(m,depth+1,tmp_bs);
                    backToOrigin(m,q);
                }
                break;
            case 3 :
                for (int i=0;i<4;i++) {
                    tmp_bs=bs+cctv3(m,now,i,q);
                    BlindSpot(m,depth+1,tmp_bs);
                    backToOrigin(m,q);
                }
                break;
            case 4 :
                for (int i=0;i<4;i++) {
                    tmp_bs=bs+cctv4(m,now,i,q);
                    BlindSpot(m,depth+1,tmp_bs);
                    backToOrigin(m,q);
                }
                break;
            case 5 :
                tmp_bs=bs+cctv5(m,now,q);
                BlindSpot(m,depth+1,tmp_bs);
                backToOrigin(m,q);
        }
//        System.out.printf("%d out\n",depth);
    }

    public static void backToOrigin(int[][] m, Deque<cctv> q) {
        cctv now;
        while(!q.isEmpty()) {
            now=q.poll();
            m[now.x][now.y]=0;
        }
    }

    public static int cctv1 (int[][] m, cctv c, int rotate, Deque<cctv> q) {
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int x = c.x;
        int y = c.y;
        boolean inRange;
        int cnt=0;
        while (true) {
            x+=dir[rotate][0];
            y+=dir[rotate][1];
            inRange = x>=1 && y>=1 && x<=N && y<=M;
            if (!inRange || m[x][y]==6) break;
            if (m[x][y]==0) {
                m[x][y]=-1;
                q.add(new cctv(x,y));
                cnt++;
            }
        }
        return cnt;
    }

    public static int cctv2 (int[][] m, cctv c, int rotate, Deque<cctv> q) {
        int cnt=0;
        switch (rotate) {
            case 0 :
                cnt+=cctv1(m,c,0,q);
                cnt+=cctv1(m,c,2,q);
                break;
            case 1 :
                cnt+=cctv1(m,c,1,q);
                cnt+=cctv1(m,c,3,q);
        }
        return cnt;
    }

    public static int cctv3 (int[][] m, cctv c, int rotate, Deque<cctv> q) {
        int cnt=0;
        switch (rotate) {
            case 0 :
                cnt+=cctv1(m,c,0,q);
                cnt+=cctv1(m,c,1,q);
                break;
            case 1 :
                cnt+=cctv1(m,c,1,q);
                cnt+=cctv1(m,c,2,q);
                break;
            case 2 :
                cnt+=cctv1(m,c,2,q);
                cnt+=cctv1(m,c,3,q);
                break;
            case 3 :
                cnt+=cctv1(m,c,3,q);
                cnt+=cctv1(m,c,0,q);
        }
        return cnt;
    }

    public static int cctv4 (int[][] m, cctv c, int rotate, Deque<cctv> q) {
        int cnt=0;
        switch (rotate) {
            case 0 :
                cnt+=cctv1(m,c,0,q);
                cnt+=cctv1(m,c,1,q);
                cnt+=cctv1(m,c,2,q);
                break;
            case 1 :
                cnt+=cctv1(m,c,0,q);
                cnt+=cctv1(m,c,1,q);
                cnt+=cctv1(m,c,3,q);
                break;
            case 2 :
                cnt+=cctv1(m,c,0,q);
                cnt+=cctv1(m,c,2,q);
                cnt+=cctv1(m,c,3,q);
                break;
            case 3 :
                cnt+=cctv1(m,c,1,q);
                cnt+=cctv1(m,c,2,q);
                cnt+=cctv1(m,c,3,q);
        }
        return cnt;
    }

    public static int cctv5 (int[][] m, cctv c, Deque<cctv> q) {
        int cnt=0;
        cnt+=cctv1(m,c,0,q);
        cnt+=cctv1(m,c,1,q);
        cnt+=cctv1(m,c,2,q);
        cnt+=cctv1(m,c,3,q);
        return cnt;
    }


}

class cctv {
    int x,y;

    public cctv (int x, int y) {
        this.x=x;
        this.y=y;
    }
}























