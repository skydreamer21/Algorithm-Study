// 1774번 우주신과의 교감
/*
<문제 정보>
 1. 모든 신들을 다 연결하기 위해 만들어야 할 최소 통로 길이

<변수 범위>
 1. 2초 / 128MB
 2. 우주신들의 개수 N<=1,000
 3. 이미 연결된 통로 M<=1,000
 4. x,y 좌표 각각 1,000,000 보다 작은 음 아닌 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Q1774 {
    static int N;
    static double[][] dist;
    static boolean[] visited;
    static int[] parent;
    static PriorityQueue<GodLink> pq = new PriorityQueue<>();
    static double ans = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new double[N+1][N+1];
        visited = new boolean[N+1];
        parent = new int[N+1];
        initSet();
        God[] gods = new God[N+1];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            gods[i] = new God(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        int from, to;
        while (M-- >0) {
            st=new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            visited[from]=true;
            visited[to]=true;
            union(from,to);
        }

        double dis;
        for (int i=1;i<=N;i++) {
            for (int j=1;j<i;j++) {
                dis = getDist(gods[i],gods[j]);
                dist[i][j] = dist[j][i] = dis;
            }
        }

        int minIdx=0;
        for (int i=1;i<=N;i++) {
            if(visited[i]) {
                for (int j=1;j<=N;j++) {
                    // 이미 연결 되어있는 선들로 인해 사이클이 나올수도 있음
                    if (!isConnected(i,j)) {
                        pq.add(new GodLink(i,j,dist[i][j]));
                        /*if (dist[i][j]<min) {
                            min = dist[i][j];
                            minIdx = i;
                            System.out.printf("i : %d, j : %d, min : %f\n",i,j,min);
                        }*/
                    }
                }
            }
        }
        minIdx=pq.peek().from;
        /*for (GodLink gl : pq) {
            System.out.printf("[%d, %d, %f] ",gl.from,gl.to,gl.cost);
        }*/
        //System.out.println();

        Prim();
        bw.write(String.format("%.2f",ans));



        bw.flush();
        bw.close();
        br.close();
    }

    public static void Prim () {
        int prev;
        GodLink now;

        while (!pq.isEmpty()) {
            now = pq.poll();
            prev = now.from;
            if(isConnected(prev,now.to)) continue;
            ans+=now.cost;
//            visited[now.to]=true;
            union(prev, now.to);
            //System.out.printf("prev : %d, to : %d, ans : %f\n",prev,now.to,ans);
            for (int i=1;i<=N;i++) {
                if(!isConnected(now.to,i)) pq.add(new GodLink(now.to,i,dist[now.to][i]));
            }
        }
    }

    public static double getDist(God g1, God g2) {
        return Math.sqrt(Math.pow(g2.x-g1.x,2)+Math.pow(g2.y-g1.y,2));
    }

    public static void initSet() {
        for (int i=1;i<=N;i++) parent[i]=i;
    }

    public static int find (int a) {
        if (parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }

    public static void union (int a, int b) {
        a=find(a);
        b=find(b);
        if(a>b) parent[a]=b;
        else parent[b]=a;
    }

    public static boolean isConnected (int a, int b) {
        return find(a)==find(b);
    }
}

class God {
    int x;
    int y;

    public God (int x, int y) {
        this.x=x;
        this.y=y;
    }
}

class GodLink implements Comparable<GodLink>{
    int from;
    int to;
    double cost;

    public GodLink (int from, int to, double cost) {
        this.from=from;
        this.to=to;
        this.cost=cost;
    }

    @Override
    public int compareTo (GodLink o) {
        return (this.cost<o.cost) ? -1 : 1;
    }
}






















