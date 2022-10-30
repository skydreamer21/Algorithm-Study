// 14601번 샤워실 바닥 깔기 (Large)
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import Necessary_Class.Pos;

import java.io.*;
import java.util.StringTokenizer;

public class Q14601 {
    static int N, K;
    static int outX, outY;
    static int[][] map;
    static int tileNum = 1;

    static final int OUT = -1;
    static final int[][] DIR = {{1,1}, {1,-1}, {-1, 1}, {-1,-1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        K = Integer.parseInt(br.readLine());
        N = (int) Math.pow(2, K);
        map = new int[N][N];
        st = new StringTokenizer(br.readLine());
        int tmpX = Integer.parseInt(st.nextToken());
        int tmpY = Integer.parseInt(st.nextToken());
        int outX = N - tmpY;
        int outY = tmpX - 1;
        map[outX][outY] = -1;

        // ******************** 메인 로직 ********************



        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 정사각형 모양의 타일에서 배수구 있는 쪽 찾기
    public static void search (int x, int y, int size) {
        if (size == 2) {
            for (int i=0; i<4; i++) {
                int dx = i / 2;
                int dy = i % 2;
                if (map[x + dx][y + dy] == OUT) {
                    int outerX = x + dx + DIR[i][0];
                    int outerY = y + dy + DIR[i][1];
                    fillTile(new Pos(outerX, outerY), new Pos(x + dx, y + dy));
                    break;
                }
            }
            return;
        }

        for (int i=0; i<4; i++) {
            int dx = (i / 2) * (size / 2);
            int dy = (i % 2) * (size / 2);

            if (checkOut(x + dx, y + dy, size / 2)) {
                int pointX = x + (dx*2) - 1;
                int pointY = y + (dy*2) - 1;
//                int outerX = pointX +
//                fillTile();
            }
        }
    }

    public static void fillTile (Pos outerCorner, Pos innerCorner) {

    }

    public static boolean checkOut (int x, int y, int size) {

        return true;
    }




}
