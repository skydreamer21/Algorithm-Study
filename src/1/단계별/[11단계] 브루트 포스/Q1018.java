// 1018번 체스판 다시 칠하기 (43:48 / 52:01)

/*
<문제 정보>
 1. 각 칸마다 검정색(B) 또는 하얀색(W)으로 칠해져 있는 MxN 크기의 보드
 2. 이 보드에서 8x8만큼 잘라서 체스판을 만드려고 하는데 체스판에 맞도록 일부색을 다시 칠해야함
 3. 다시 칠해야하는 칸의 수가 최소가 되도록 잘라낼 때, 다시 칠해야하는 칸의 수를 출력

<프로그램 진행>
 1. 자를 수 있는 모든 8*8 의 개수
    - 가로 : M-7 & 세로 : N-7   => (M-7)*(N-7)
 2. 하나당 두번씩 체크해서 더 작은 수
 3. 흰색 시작 배열과 검은색 시작 배열 만들어 놓기

<필요 함수>
 1. 8*8 시작 인덱스를 입력할 때, 다시 칠해야 하는 칸의 수 return

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1018 {
    static char[][] blackFirst =
            {{'B','W','B','W','B','W','B','W'},
             {'W','B','W','B','W','B','W','B'},
             {'B','W','B','W','B','W','B','W'},
             {'W','B','W','B','W','B','W','B'},
             {'B','W','B','W','B','W','B','W'},
             {'W','B','W','B','W','B','W','B'},
             {'B','W','B','W','B','W','B','W'},
             {'W','B','W','B','W','B','W','B'}};

    static char[][] whiteFirst =
            {{'W','B','W','B','W','B','W','B'},
             {'B','W','B','W','B','W','B','W'},
             {'W','B','W','B','W','B','W','B'},
             {'B','W','B','W','B','W','B','W'},
             {'W','B','W','B','W','B','W','B'},
             {'B','W','B','W','B','W','B','W'},
             {'W','B','W','B','W','B','W','B'},
             {'B','W','B','W','B','W','B','W'}};

    public static int getDiffColorNum(char[][] origin, char[][] compare, int x, int y) {
        int cnt=0;
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                if(origin[x+i][y+j]!=compare[i][j]) cnt++;
            }
        }
        return cnt;
    }

    public static int getMinDiffColorNum(char[][] origin, char[][] black, char[][] white, int x, int y) {
        int cnt_black;
        int cnt_white;
        cnt_black = getDiffColorNum(origin, black, x, y);
        cnt_white = getDiffColorNum(origin, white, x, y);
        return (cnt_black<=cnt_white) ? cnt_black : cnt_white;
    }
/*
    public static void printBoard(char[][] arr) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr[i].length;j++) {
                bw.write(arr[i][j]);
                if (j==arr[i].length-1) bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

 */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        StringTokenizer st = new StringTokenizer(S);
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][] board = new char[M][N];
        int min = 64;
        int temp;
        for (int i=0;i<M;i++) {
            S = br.readLine();
            board[i] = S.toCharArray();
        }
        for (int i=0;i<M-7;i++) {
            for (int j=0;j<N-7;j++) {
                temp = getMinDiffColorNum(board,blackFirst,whiteFirst,i,j);
                if(temp<min) min = temp;
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}