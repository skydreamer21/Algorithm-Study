import java.io.*;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class test24_code {
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] visited2;
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
        String S;
        for (int i=1;i<=N;i++) {
            S=br.readLine();
            for (int j=0;j<N;j++) map[i][j+1] = S.charAt(j)-'0';
        }
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
        }
    }
}

class Pair {
    public int x,y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}