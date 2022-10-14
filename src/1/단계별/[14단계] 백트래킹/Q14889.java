// 14889번 스타트와 링크

/*
<문제 정보>
 1. S(ij) i가 j와 같은 팀일 때 i로 인해 팀에 더해지는 능력치
 2. 두 팀을 짜서 모든 능력치를 더했을 때 가장 두 팀간의 능력치 차이의 최솟값 출력
 3. 4<=N<=20 / 각각의 능력치는 1이상 100이하

<프로그램 진행>
 1.

<필요 함수>
 1. 한 팀의 구성원이 주어지면 두 팀간의 능력치 합 차이 return

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q14889 {
    static int[][] abilityTable;
    static int N;
    static boolean[] players;
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        abilityTable = new int[N][N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) abilityTable[i][j] = Integer.parseInt(st.nextToken());
        }
        players = new boolean[N];
        players[0] = true;
        teamMatching(1,1);
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void teamMatching (int player, int depth) {
        if (depth == N/2) {
            min = Math.min(min,findDiff(players));
            return;
        }

        for (int i=player;i<N;i++) {
            if (!players[i]) {
                players[i] = true;
                teamMatching(i+1,depth+1);
                players[i] = false;
            }
        }
    }

    public static int findDiff (boolean[] players) {
        int team1=0;
        int team2=0;

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (players[i] && players[j]) team1 += abilityTable[i][j];
                else if (!players[i] && !players[j]) team2 += abilityTable[i][j];
            }
        }
        return Math.abs(team1-team2);
    }

    /*
    public static void printTable (int[][] abilityTable) {
        for (int i=0;i<abilityTable.length;i++) {
            for (int j=0;j<abilityTable.length;j++) System.out.printf("%d ",abilityTable[i][j]);
            System.out.println();
        }
    }
     */
}