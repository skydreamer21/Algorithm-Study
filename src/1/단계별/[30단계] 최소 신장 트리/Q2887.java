// 2887번 행성터널
/*
<문제 정보>
 1. N-1개 터널로 모든 행성이 연결되려고 할 때 필요한 최소 비용

<변수 범위>
 1. 1초 / 128MB
 2. 행성의 개수 1<=N<=100,000
 3. 행성의 좌표 -1,000,000,000<=x,y,z<=1,000,000,000
 4. 한 위치에 행성 두 개 있는 경우는 없음

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 행성 개수가 100,000 이라 그냥 쓰면 Prim을 쓰든, Kruskal을 쓰든 시간,메모리 초과
// -> 문제의 특수성을 이용해야 함

import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;



public class Q2887 {
    static int N;
    static Planet[] planets;
    static int ans=0;
    static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        planets = new Planet[N];
        visited = new boolean[N];
        int x,y,z;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            planets[i]=new Planet(x,y,z);
        }
        Prim();
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Prim() {
        PriorityQueue<PlanetEdge> pq = new PriorityQueue<>();
        pq.add(new PlanetEdge(0,0));
        PlanetEdge now;

        while(!pq.isEmpty()) {
            now = pq.poll();
            if(visited[now.planet]) continue;
            ans+=now.cost;
            visited[now.planet]=true;
            for (int i=0;i<N;i++) {
                if (!visited[i]) pq.add(new PlanetEdge(i,getCost(planets[now.planet],planets[i])));
            }
        }

    }

    public static int getCost (Planet p1, Planet p2) {
        return Math.min(Math.min(Math.abs(p2.x-p1.x),Math.abs(p2.y-p1.y)),Math.abs(p2.z-p1.z));
    }
}

class Planet {
    int x;
    int y;
    int z;

    public Planet (int x, int y, int z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }
}

class PlanetEdge implements Comparable<PlanetEdge>{
    int planet;
    int cost;

    public PlanetEdge (int planet, int cost) {
        this.planet=planet;
        this.cost=cost;
    }

    @Override
    public int compareTo (PlanetEdge o) {
        return this.cost-o.cost;
    }
}

































