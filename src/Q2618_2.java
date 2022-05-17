// 2618번 경찰차
/*
<문제 정보>
 1. 주어진 순서대로 사건 처리, 경찰차 이동거리 합 최소가 되게끔 배정
 2. 첫째줄에 총 이동 거리
 3. 그다음부터 어떤 경찰차에 배정되었는지

<변수 범위>
 1. 1초 / 128MB
 2. 도로 개수 N 5<=N<=1,000
 3. 사건의 개수 W 1<=W<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q2618_2 {
    static int N, C;
    static Pair15[] accidents;
    static int[][] dist;
    static int[][] dp;
    static Pair15[][] whichCars;

    static final int EMPTY = 0;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        accidents = new Pair15[C];
        dist = new int[C][C];
        dp = new int[C][C];
        whichCars = new Pair15[C][C];

        int x, y;
        for (int i=0;i<C;i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            accidents[i] = new Pair15(x, y);
        }

        makeGraph();

        int minDist = INF;
        int whichIsMin=0;
        // 1번 차가 시작할때
        for (int i=1;i<C;i++) {
            if (solveDP(0,i)<minDist) {
                minDist = solveDP(0,i);
                whichIsMin = i;
            }
        }

        // 2번 차가 시작할 때
        for (int i=1;i<C;i++) {
            if (solveDP(i,0)<minDist) {
                minDist = solveDP(i,0);
                whichIsMin = i+C;
            }
        }

        int ac1, ac2;
        sb.append(minDist).append("\n");
        if (whichIsMin>C) {
            sb.append(2).append("\n");
            whichIsMin-=C;
            ac1 = 2;
        }
        else {
            sb.append(1).append("\n");
            ac1 = 1;
        }
        ac2 = whichIsMin;
        for (int i=0;i<C;i++) {
            sb.append(ac1).append("\n");
            ac1 = whichCars[ac1][ac2].x;
            ac1 = whichCars[ac1][ac2].x;
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void makeGraph() {
        for (int i=0;i<C;i++) {
            for (int j=i+1;j<C;j++) {
                dist[i][j] = Math.abs(accidents[i].x - accidents[j].x) + Math.abs(accidents[i].y - accidents[j].y);
                dist[j][i] = dist[i][j];
            }
        }
    }

    public static int solveDP(int acidnt1, int acidnt2) {
        if (dp[acidnt1][acidnt2] != EMPTY) return dp[acidnt1][acidnt2];

        int case1, case2;

        // 두 사건의 번호가 2이상 차이나면 한개씩 줄임
        if (acidnt1 - acidnt2>=2) {
            dp[acidnt1][acidnt2] = dist[acidnt2][acidnt2+1] + solveDP(acidnt1, acidnt2+1);
            whichCars[acidnt1][acidnt2] = new Pair15(2, acidnt2+1);
        }
        else if (acidnt2 - acidnt1>=2) {
            dp[acidnt1][acidnt2] = dist[acidnt1][acidnt1+1] + solveDP(acidnt1+1, acidnt2);
            whichCars[acidnt1][acidnt2] = new Pair15(1, acidnt1+1);
        }

        // 두 사건의 번호가 차이가 1이고 하나가 마지막 사건이면 처리 완료이므로 return 0
        else if (acidnt1 == C-1 || acidnt2 == C-1) return 0;

        // 마지막 사건이 없으면서 두 사고번호의 차이가 1이면 둘중 하나 최솟값

        else {
            if (acidnt1>acidnt2) {
                dp[acidnt1][acidnt2] =
                        Math.min(
                                case1 = dist[acidnt1][acidnt1+1] + solveDP(acidnt1 + 1, acidnt2),
                                case2 = dist[acidnt2][acidnt2+2] + solveDP(acidnt1, acidnt2+2)
                        );
                if (case1<case2) whichCars[acidnt1][acidnt2] = new Pair15(1, acidnt1+1);
                else whichCars[acidnt1][acidnt2] = new Pair15(2, acidnt2+2);
            }
            else {
                dp[acidnt1][acidnt2] =
                        Math.min(
                                case1 = dist[acidnt1][acidnt1+2] + solveDP(acidnt1 + 2, acidnt2),
                                case2 = dist[acidnt2][acidnt2+1] + solveDP(acidnt1, acidnt2+1)
                        );
                if (case1<case2) whichCars[acidnt1][acidnt2] = new Pair15(1, acidnt1+2);
                else whichCars[acidnt1][acidnt2] = new Pair15(2, acidnt2+1);
            }
        }
        return dp[acidnt1][acidnt2];
    }
}

class Pair15 {
    int x, y;

    public Pair15 (int x, int y) {
        this.x = x;
        this.y = y;
    }
}














