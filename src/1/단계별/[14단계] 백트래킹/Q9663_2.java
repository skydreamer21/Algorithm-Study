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

// 37602123 (zkdlajt1) - 14796KB / 3680ms
// 37550798 (chanee88) - 14840KB / 2556ms
// 37492147 (5905kjh) - 19580KB / 1996ms
// 37126793 (hyeonwoo7269) - 14780KB / 2524ms

import java.io.*;
import java.util.Arrays;

public class Q9663_2 {
    static int cnt=0;
    static int[] chess;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        chess = new int[N];
        Arrays.fill(chess,-1);
        dfs(N,0);
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs (int N, int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i=0;i<N;i++) {
            chess[depth]=i;
            //System.out.printf("depth : %d ", depth);
            //System.out.println(Arrays.toString(chess));
            if(possible(N,depth)) dfs(N,depth+1);
        }
    }

    public static boolean possible (int N, int col) {
        //판위에 놓여진 퀸이 서로 공격을 할 수 있나 없나를 체크
        for (int i=0;i<col;i++) {
            if (chess[col]==chess[i]) return false; // 같은 행마다 순차적으로 검사
            //대각선
            else if (Math.abs(col-i) == Math.abs(chess[col]-chess[i])) return false;
        }
        return true;
        //false에 걸리는 것 없이 true이면 현재 상태에서
        //서로 공격할 수 있는 퀸이 없다는 뜻
    }
}