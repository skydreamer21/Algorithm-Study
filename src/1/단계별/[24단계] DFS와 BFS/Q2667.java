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




import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q2667 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static ArrayList<Integer> house = new ArrayList<>();
    static int count=0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        String S;
        for (int i=1;i<=N;i++) {
            S=br.readLine();
            for (int j=0;j<N;j++) map[i][j+1] = S.charAt(j)-'0';
        }
        //for (int i=0;i<=N;i++) System.out.println(Arrays.toString(map[i]));




        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs() {
        Deque<int[]> stack = new ArrayDeque<>(Arrays.asList(dir));
        Deque<int[]> zero = new ArrayDeque<>();
        int[] cur = new int[2];
        cur[0]=1; cur[1]=1;
        visited[1][1]=true;
        int[] d;
        boolean inRange;
        int[] temp = new int[2];
        boolean flag = false;
        int cnt=0;
        // 일단 1우선 쭉 도는것까지 구현
        while (!stack.isEmpty() || !zero.isEmpty()) {
            d = stack.pollLast();
            temp[0] = cur[0]+d[0]; temp[1] = cur[1]+d[1];
            inRange = temp[0]>0 && temp[1]>0 && temp[0]<=N && temp[1]<=N;
            if (inRange && !visited[temp[0]][temp[1]]) {
                if(map[temp[0]][temp[1]]==0) zero.add(temp);
                else {
                    if (!flag) {
                        count++;
                        cnt=0;
                        flag=true;
                    }
                    visited[temp[0]][temp[1]]=true;
                    cnt++;
                    cur[0] = temp[0];
                    cur[1] = temp[1];
                    stack.addAll(Arrays.asList(dir));
                }
            }
        }

    }
}
