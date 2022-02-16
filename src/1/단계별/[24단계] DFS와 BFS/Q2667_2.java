// 2667번 단지번호붙이기
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB
 2. 지도의 크기 N 5<=N<=25
 3.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */



import Necessary_Class.Pair.Pair;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Q2667_2 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static ArrayList<Integer> house = new ArrayList<>();
    static int count=0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        String S;
        for (int i=1;i<=N;i++) {
            S=br.readLine();
            for (int j=0;j<N;j++) map[i][j+1] = S.charAt(j)-'0';
        }
        //for (int i=0;i<=N;i++) System.out.println(Arrays.toString(map[i]));
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                if (!visited[i][j] && map[i][j]==1) {
                    count++;
                    house.add(dfs(i,j));
                }
            }
        }


        Collections.sort(house);
        sb.append(count).append("\n");
        for(int i : house) sb.append(i).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // (x,y)에서 1이 몇개까지 이어져있는지 개수를 세고 visited 등록
    public static int dfs(int x, int y) {
        Deque<Pair> stack = new ArrayDeque<>();
        Pair start = new Pair(x,y);
        stack.add(start);
        Pair cur;
        int cnt=0;
        boolean inRange;
        while (!stack.isEmpty()) {
            cur = stack.pollLast();
            inRange = cur.x>0 && cur.y>0 && cur.x<=N && cur.y<=N;
            if(inRange && !visited[cur.x][cur.y]) {
                visited[cur.x][cur.y] = true;
                if(map[cur.x][cur.y]==1) {
                    cnt++;
                    for (int[] d : dir) {
                        stack.add(new Pair(cur.x+d[0],cur.y+d[1]));
                    }
                }

            }
        }
        return cnt;
    }

    public static void printStack (Deque<Pair> stack) {
        for (Pair coor : stack) System.out.printf("(%d, %d) ",coor.x,coor.y);
        System.out.println();
    }
}
