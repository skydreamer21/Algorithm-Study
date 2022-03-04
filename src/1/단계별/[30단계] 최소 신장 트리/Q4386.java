// 4386번 별자리 만들기
/*
<문제 정보>
 1. n개의 별을 이어 별자리를 만드는 최소 비용

<변수 범위>
 1. 1초 / 128MB
 2. 별의 개수 1<=n<=100
 3. 별의 x,y 좌표 소수점 둘째자리까지 주어짐. 좌표는 1000을 넘지 않음

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Q4386 {
    static int N;
    static double[][] dist;
    static Star[] stars;
    static boolean[] visited;
    static double ans=0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        stars = new Star[N];
        dist = new double[N][N];
        visited = new boolean[N];
        double x, y;
        double dis;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(x,y);
            for (int j=0;j<i;j++) {
                dis = getDist(stars[i],stars[j]);
                dist[i][j] = dist[j][i] = dis;
            }
        }

//        for (int i=0;i<N;i++) System.out.println(Arrays.toString(dist[i]));
        Prim(0);
        bw.write(String.format("%.2f",ans));




        bw.flush();
        bw.close();
        br.close();
    }

    public static double getDist (Star s1, Star s2) {
        return Math.sqrt(Math.pow(s2.x-s1.x,2)+Math.pow(s2.y-s1.y,2));
    }

    public static void Prim (int start) {
        PriorityQueue<StarLink> pq = new PriorityQueue<>();
        pq.add(new StarLink(start,0));
        StarLink now;

        while(!pq.isEmpty()) {
            now = pq.poll();
            if(visited[now.to]) continue;
            ans+=now.cost;
            visited[now.to] = true;
//            System.out.printf("now : %d, ans : %f\n",now.to,ans);
            for (int i=0;i<N;i++) {
                if (i!=now.to && !visited[i]) pq.add(new StarLink(i,dist[now.to][i]));
            }

        }

    }
}

class Star {
    double x;
    double y;

    public Star (double x, double y) {
        this.x=x;
        this.y=y;
    }
}

class StarLink implements Comparable<StarLink>{
    int to;
    double cost;

    public StarLink(int to, double cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo (StarLink o) {
        return (this.cost<o.cost) ? -1 : 1;
    }
}





























