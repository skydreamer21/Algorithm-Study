// C번 MBTI
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 1024MB
 2. 1<=N,M<=100

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class YPC1_3 {
    static int N,M;
    static char[][] map;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        String S;
        for (int i=0;i<N;i++) {
            S=br.readLine();
            for (int j=0;j<M;j++) {
                map[i][j]=S.charAt(j);
            }
        }

        int nMBTI=0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (map[i][j]=='I' || map[i][j]=='E') {
                    for (int d=0;d<8;d++) {
//                        System.out.printf("(%d,%d)에서 %d방향 : %b\n",i,j,d,MBTI(i,j,d));
                        if(MBTI(i,j,d)) nMBTI++;
                    }
                }
            }
        }
        bw.write(String.valueOf(nMBTI));
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean MBTI (int x, int y, int d) {
        boolean inRange;
        for (int i=0;i<3;i++) {
            x+=dir[d][0]; y+=dir[d][1];
            inRange=x>=0 && y>=0 && x<N && y<M;
            if(!inRange) return false;
            switch(i) {
                case 0 :
                    if(map[x][y]!='S' && map[x][y]!='N') return false;
                    break;
                case 1 :
                    if(map[x][y]!='T' && map[x][y]!='F') return false;
                    break;
                case 2 :
                    if(map[x][y]!='J' && map[x][y]!='P') return false;
            }
        }
        return true;
    }
}
