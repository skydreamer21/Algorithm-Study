// 1018번 체스판 다시 칠하기

/*
<문제 정보>
 1. 각 칸마다 검정색(B) 또는 하얀색(W)으로 칠해져 있는 MxN 크기의 보드
 2. 이 보드에서 8x8만큼 잘라서 체스판을 만드려고 하는데 체스판에 맞도록 일부색을 다시 칠해야함
 3. 다시 칠해야하는 칸의 수가 최소가 되도록 잘라낼 때, 다시 칠해야하는 칸의 수를 출력

<프로그램 진행>
 1. 자를 수 있는 모든 8*8 의 개수
    - 가로 : M-7 & 세로 : N-7   => (M-7)*(N-7)
 2. 흰색으로 시작하는 배열과 검은색으로 시작하는 배열이 하나도 겹치지 않음 -> 하나만 체크하면 나머지 것도 알 수 있음
 3. 흰색 시작 배열과 검은색 시작 배열 둘 중 하나 만들어 놓기 (번갈아가면서 바뀐다는 개념사용하면 안만들어 놔도 괜찮)

<필요 함수>
 1. 8*8 시작 인덱스를 입력할 때, 다시 칠해야 하는 칸의 수 return

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1018_2 {
    static char[][] blackFirst =
            {{'B','W','B','W','B','W','B','W'},
             {'W','B','W','B','W','B','W','B'},
             {'B','W','B','W','B','W','B','W'},
             {'W','B','W','B','W','B','W','B'},
             {'B','W','B','W','B','W','B','W'},
             {'W','B','W','B','W','B','W','B'},
             {'B','W','B','W','B','W','B','W'},
             {'W','B','W','B','W','B','W','B'}};

    public static int getDiffColorNum(char[][] origin, char[][] compare, int x, int y) {
        int cnt=0;
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                if(origin[x+i][y+j]!=compare[i][j]) cnt++;
            }
        }
        return (cnt<=64-cnt) ? cnt : 64-cnt;
    }

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
                temp = getDiffColorNum(board,blackFirst,i,j);
                if(temp<min) min = temp;
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}