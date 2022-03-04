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
 1. Kruskal

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;



public class Q2887_2 {
    static int N;
    static int[] parent;
//    static PE[] edges;
    static PriorityQueue<PE> pq = new PriorityQueue<>();
    static int ans=0;
/*
    final static int X = 0;
    final static int Y = 1;
    final static int Z = 2;
*/



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
//        edges = new PE[3*N-3];
        Coor[] x= new Coor[N];
        Coor[] y= new Coor[N];
        Coor[] z= new Coor[N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = new Coor(i,Integer.parseInt(st.nextToken()));
            y[i] = new Coor(i,Integer.parseInt(st.nextToken()));
            z[i] = new Coor(i,Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(x);
        Arrays.sort(y);
        Arrays.sort(z);
        for (int i=0;i<N-1;i++) {
            push(x,i);
            push(y,i);
            push(z,i);
        }
        initSet();
        PE now;
        int cnt=0;
        while (!pq.isEmpty()) {
            now = pq.poll();

            if(!union(now.p1,now.p2)) continue;
            ans+=now.cost;
            cnt++;
//            System.out.printf("%d union : %d - %d\n",cnt,now.p1,now.p2);
            if(cnt==N-1) break;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void push (Coor[] c, int i) {
//        edges[3*i+xyz] = new PE(c[i].planet,c[i+1].planet,c[i+1].loca-c[i].loca);
        pq.add (new PE(c[i].planet,c[i+1].planet,c[i+1].loca-c[i].loca));
    }

    public static void initSet() {
        for (int i=0;i<N;i++) parent[i]=i;
    }

    public static int find (int a) {
        if (parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }

    public static boolean union (int a, int b) {
        a=find(a);
        b=find(b);
        if(a==b) return false;
        if(a>b) parent[a]=b;
        else parent[b]=a;
        return true;
    }

    public static void printCoor (Coor[] c) {
        for (int i=0;i<c.length;i++) System.out.printf("[p : %d, loc : %d] ",c[i].planet,c[i].loca);
        System.out.println();
    }
}

class Coor implements Comparable<Coor>{
    int planet;
    int loca;

    public Coor (int planet, int loca) {
        this.planet=planet;
        this.loca=loca;
    }

    @Override
    public int compareTo (Coor o) {
        return this.loca - o.loca;
    }
}

class PE implements Comparable<PE>{
    int p1, p2;
    int cost;

    public PE (int p1, int p2, int cost) {
        this.p1=p1;
        this.p2=p2;
        this.cost=cost;
    }

    @Override
    public int compareTo (PE o) {
        return this.cost - o.cost;
    }
}
































