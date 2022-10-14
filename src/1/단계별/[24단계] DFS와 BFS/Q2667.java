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

// 스택을 2개로 두어서 0과 1을 나눠서 해보려 했으나
// 0stack에서 뺐을때 1이 이어져있는지 아닌지 확인하는게 매우 까다로움

// 모든 맵탐색을 dfs로 하려니까 힘듬.
// 찾고싶은 부분에 조건에 해당될때만 dfs를 쓰니까 훨씬더 간편


import java.io.*;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import Necessary_Class.Pair.Pair;

public class Q2667 {
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] visited2;
    static boolean[][] origin;
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
        visited2 = new boolean[N+1][N+1];
        origin = new boolean[N+1][N+1];
        String S;
        for (int i=1;i<=N;i++) {
            S=br.readLine();
            for (int j=0;j<N;j++) map[i][j+1] = S.charAt(j)-'0';
        }
        //for (int i=0;i<=N;i++) System.out.println(Arrays.toString(map[i]));
        dfs();
        Collections.sort(house);
        sb.append(count).append("\n");
        for(int i : house) sb.append(i).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs() {
        Deque<Pair> stack = new ArrayDeque<>();
        Deque<Pair> zero = new ArrayDeque<>();
        Pair start =new Pair(1,1);
        boolean inRange;
        int cnt=0;

        boolean flag=false;
        if(map[1][1]==1) {
            stack.add(start);
            flag = true;
            count++;
        }
        else zero.add(start);

        Pair cur;
        int x, y;


        while(!stack.isEmpty() || !zero.isEmpty()) {

            if (stack.isEmpty() && !zero.isEmpty()) {
                flag=false;
                if(cnt!=0) {
                    house.add(cnt);
                    cnt=0;
                }
            }



            if(!stack.isEmpty()) cur = stack.pollLast();
            else cur = zero.pollLast();
            System.out.printf("x : %d, y : %d\n",cur.x,cur.y);
            System.out.println(flag);

            inRange = cur.x>0 && cur.y>0 && cur.x<=N && cur.y<=N;
            if (inRange && !visited[cur.x][cur.y]) {
                if(map[cur.x][cur.y]==0 && (flag || !stack.isEmpty())) {
                    if(visited2[cur.x][cur.y]) continue;
                    zero.add(cur);
                    visited2[cur.x][cur.y]=true;
                }

                else {
                    if(map[cur.x][cur.y]!=0) {
                        if(!flag) {
                            count++;
                            flag=true;
                        }
                        cnt++;
                    }
                    visited[cur.x][cur.y]=true;
                    for (int[] d : dir) {
                        x = cur.x+d[0];
                        y = cur.y+d[1];
                        stack.add(new Pair(x,y));
                    }
                }
            }

            System.out.printf("count : %d\n",count);
            printStack(stack);
            printStack(zero);
            System.out.println("-----------------------");
        }



    }

    public static void printStack (Deque<Pair> stack) {
        for (Pair coor : stack) System.out.printf("(%d, %d) ",coor.x,coor.y);
        System.out.println();
    }
}
