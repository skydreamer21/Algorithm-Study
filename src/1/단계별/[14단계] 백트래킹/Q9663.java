// 9663번 N-Queen

/*
<문제 정보>
 1. N-Queen : 크기가 NxN인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓음
 2. N이 주어졌을 때 퀸을 놓는 방법의 수를 출력
 3. 1<=N<15

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class Q9663 {
    static boolean[][] chessBoard;
    static int cnt=0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        chessBoard = new boolean[N][N];
        for (boolean[] row : chessBoard) Arrays.fill(row,true);
        dfs(N,0);

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int N, int depth) {
        ArrayList<int[]> removeList;
        if (depth==N) {
            cnt++;
            return;
        }

        for (int i=0;i<N;i++) {
            removeList = removeAttackPoint(depth,i,N);
            /*
            for (int j=0;j<removeList.size();j++) {
                System.out.printf("[%d, %d] ",removeList.get(j)[0], removeList.get(j)[1]);
                if (j==removeList.size()-1) System.out.println();
            }

            System.out.println("remove");
            printChess(N);
            System.out.println();
             */
            if (chessBoard[depth][i]) dfs(N,depth+1);
            undo(removeList);
            /*
            System.out.println("undo");
            printChess(N);
            System.out.println();
             */
        }
    }

    public static void undo(ArrayList<int[]> removeList) {
        for (int i=0;i<removeList.size();i++) {
            chessBoard[removeList.get(i)[0]][removeList.get(i)[1]] = true;
        }
    }
    public static ArrayList removeAttackPoint(int x, int y, int N) {
        ArrayList<int[]> removeList = new ArrayList<>();
        // 가로줄
        for (int i=0;i<N;i++) {
            if (chessBoard[x][i] && i!=y) {
                chessBoard[x][i]=false;
                int[] temp = new int[2];
                temp[0]=x; temp[1]=i;
                removeList.add(temp);
            }
        }
        // 세로줄
        for (int i=0;i<N;i++) {
            if (chessBoard[i][y] && i!=x) {
                chessBoard[i][y]=false;
                int[] temp = new int[2];
                temp[0]=i; temp[1]=y;
                removeList.add(temp);
            }
        }
        // 대각선
        int tmp=1;
        while (x+tmp<N && y+tmp<N) {
            if (chessBoard[x+tmp][y+tmp]) {
                chessBoard[x+tmp][y+tmp]=false;
                int[] temp = new int[2];
                temp[0]=x+tmp; temp[1]=y+tmp;
                removeList.add(temp);
            }
            tmp++;
        }
        tmp=1;
        while (x+tmp<N && y-tmp>=0) {
            if (chessBoard[x+tmp][y-tmp]) {
                chessBoard[x+tmp][y-tmp]=false;
                int[] temp = new int[2];
                temp[0]=x+tmp; temp[1]=y-tmp;
                removeList.add(temp);
            }
            tmp++;
        }
        tmp=1;
        while (x-tmp>=0 && y+tmp<N) {
            if (chessBoard[x-tmp][y+tmp]) {
                chessBoard[x-tmp][y+tmp]=false;
                int[] temp = new int[2];
                temp[0]=x-tmp; temp[1]=y+tmp;
                removeList.add(temp);
            }
            tmp++;
        }
        tmp=1;
        while (x-tmp>=0 && y-tmp>=0) {
            if (chessBoard[x-tmp][y-tmp]) {
                chessBoard[x-tmp][y-tmp]=false;
                int[] temp = new int[2];
                temp[0]=x-tmp; temp[1]=y-tmp;
                removeList.add(temp);
            }
            tmp++;
        }
        return removeList;
    }

    public static void printChess(int N) {
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (chessBoard[i][j]) System.out.print("1 ");
                else System.out.print("0 ");
                if (j==N-1) System.out.println();
            }
        }
    }

}