// 10216번 Count Circle Group (G5) [UnionFind]
/*
<문제 정보>
 1. 적진 그룹 개수 출력
    - i번째 진영은 R_i거리 이내가 통신영역
    - 통신영역이 겹치면 상호 통신 가능
    - 거쳐서도 통신 가능

<변수 범위>
 1. 8초 / 256MB
 2. 진영 숫자 N  1<=N<=3,000
 3. 좌표 0<= x,y <=5,000
 4. 해당 진영의 R 0<=R<=5,000


<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q10216 {
    static int N; // 적군 진영 개수
    static int[] parent;
    static Enemy[] Enemies;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int x, y, R;
        int groups;
        while(T-- >0) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N+1];
            parentInitSet();
            Enemies = new Enemy[N+1];
            groups=0;
            for (int i=1;i<=N;i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                R = Integer.parseInt(st.nextToken());
                Enemies[i] = new Enemy(x, y, R);
            }
            for (int i=1;i<=N;i++) {
                for (int j=i+1;j<=N;j++) {
                    if (CanBeConnected(Enemies[i], Enemies[j])) union(i, j);
                }
            }
            boolean[] groupCheck = new boolean[N+1];
            for (int i=1;i<=N;i++) groupCheck[find(i)] = true;
            for (int i=1;i<=N;i++) {
                if(groupCheck[i]) groups++;
            }
            sb.append(groups).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean CanBeConnected (Enemy e1, Enemy e2) {
        return e1.radius + e2.radius >= Math.sqrt(Math.pow(e1.x-e2.x,2)+Math.pow(e1.y-e2.y,2));
        //Math가 시간을 좀 잡아먹음
    }

    public static void parentInitSet() {
        for (int i=1;i<=N;i++) parent[i]=i;
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a]=find(parent[a]);
    }

    public static void union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a<b) parent[b] = a;
        else parent[a] = b;
    }
}

class Enemy {
    int x, y;
    int radius;

    public Enemy (int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
















