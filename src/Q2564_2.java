// 2564번 경비원 (S1)
/*
<문제 정보>
 1. 동근이의 위치로부터 각 상점까지의 최단거리의 합
    - 길은 내부가 아닌 가장자리로만 다닐 수 있다.

<변수 범위>
 1. 1초 / 128MB
 2. 블럭의 가로, 세로, 상점의 개수 모두 100 이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q2564_2 {
    static int width, height, total;
    static int security;
    static int[] clockwise = new int[5];
    static final int EAST = 4;
    static final int WEST = 3;
    static final int SOUTH = 2;
    static final int NORTH = 1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        total = (width+height)*2;
        // 시계방향 : 북 -> 동 -> 남 -> 서 : 1 -> 4 -> 2 -> 3
        clockwise[EAST] = width;
        clockwise[WEST] = width*2 + height;
        clockwise[SOUTH] = width + height;
        clockwise[NORTH] = 0;
        int storeNum = Integer.parseInt(br.readLine());
        int[] stores = new int[storeNum];
        int dir, dis;
        for (int i=0;i<=storeNum;i++) {
            st = new StringTokenizer(br.readLine());
            dir = Integer.parseInt(st.nextToken());
            dis = Integer.parseInt(st.nextToken());
            if (dir==2) dis = width - dis;
            if (dir==3) dis = height - dis; // 시계방향으로 통일
            if(i!=storeNum) stores[i] = clockwise[dir] + dis;
            else security = clockwise[dir] + dis;
        }

        int totalDist=0;
        int dist_tmp;
        for (int i=0;i<storeNum;i++) {
            dist_tmp = Math.abs(security-stores[i]);
            totalDist += Math.min(dist_tmp, total-dist_tmp);
        }

        sb.append(totalDist);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

