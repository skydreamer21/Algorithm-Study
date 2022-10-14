// 2615번 오목 (S2)
/*
<문제 정보>
 1. 19x19 바둑판 상태가 주어졌을 때 이겼는지 졌는지 아직 승부 안났는지 출력
     - 검은색 : 1, 흰색 : 2, 아직 : 0
     - 누군가 이겼을 때는 연속 5개 바둑알 중 가장 왼쪽 (세로이면 가장 위쪽) 좌표 출력

<변수 범위>
 1. 1초 / 128MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q2615 {
    static int[][] badukBoard = new int[19][19];
    static boolean[][][] visited = new boolean[19][19][4];

    // dir[0] : 위/아래, dir[1] : 대각선1, dir[2] : 왼오, dir[3] : 대각선2
    static int[][][] dir = { {{-1,0},{1,0}}, {{-1,-1},{1,1}}, {{0,-1},{0,1}}, {{1,-1},{-1,1}} };

    static final int SIZE = 19;

    static final int NOT_OMOK = -1;
    static final int EMPTY = 0;

    static final int NOT_YET = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************

        for (int i=0;i<SIZE;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<SIZE;j++) badukBoard[i][j] = Integer.parseInt(st.nextToken());
        }

        // ******************** 메인 로직 ********************

        int checkResult;
        int ansX, ansY;
        boolean findOmok = false;
        for (int i=0;i<SIZE;i++) {
            if (findOmok) break;
            for (int j=0;j<SIZE;j++) {
                if (badukBoard[i][j] == EMPTY) continue;

//                System.out.printf("x : %d, y : %d\n",i,j);
                checkResult = CheckOmok(i, j);
                if(checkResult != NOT_OMOK) {
                    // 좌표 바꿔서 출력하기 (코드 작성하기)
                    ansX = checkResult / SIZE;
                    ansY = checkResult % SIZE;
                    sb.append(badukBoard[i][j]).append("\n");
                    sb.append(ansX+1).append(" ").append(ansY+1);
                    findOmok = true;
                    break;
                }
            }
        }
        // ******************** 정답 출력 ********************
        if(!findOmok) sb.append(NOT_YET);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 가장 왼쪽 (위쪽) 의 좌표값을 반환
    public static int CheckOmok(int x, int y) {

        int count;
        int dx, dy;
        int nextX, nextY;
        boolean inRange;
        boolean omokPossible;

        int ansX, ansY;

        // dir의 4가지 방향
        for (int direction=0;direction<4;direction++) {
//            System.out.printf("direction : %d\n",direction);

            if (visited[x][y][direction]) continue;
            visited[x][y][direction] = true;

            count = 1;
            ansX = x;
            ansY = y;
            // 해당 방향에서 각각 반대방향
            for (int i=0;i<2;i++) {
                nextX = x;
                nextY = y;
                dx = dir[direction][i][0];
                dy = dir[direction][i][1];
                omokPossible = true;

                while (omokPossible && count<=5) {
                    nextX += dx;
                    nextY += dy;
                    inRange = nextX>=0 && nextY>=0 && nextX<SIZE && nextY<SIZE;
                    if (inRange && !visited[nextX][nextY][direction] && badukBoard[nextX][nextY] == badukBoard[x][y]) {
                        visited[nextX][nextY][direction] = true;

                        count++;

//                        System.out.printf("nextX : %d, nextY : %d, count : %d\n", nextX, nextY, count);

                        if (nextY == ansY && nextX < ansX) ansX = nextX;
                        else if (nextY < ansY) {
                            ansY = nextY;
                            ansX = nextX;
                        }
                    }
                    else omokPossible = false;
                }
            }

            if (count==5) return ansX*19 + ansY;

        }
        return NOT_OMOK;
    }
}















