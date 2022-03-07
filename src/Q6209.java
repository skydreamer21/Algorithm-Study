// 6209번 제자리 멀리뛰기 (G2)
// 22.3.7 pm 6:00 ~ 7:07 (1차 구현)
/*
<문제 정보>
 1. m개 작은 돌섬 제거한 뒤 학생들이 점프할 수 있는 최소거리의 최댓값 출력

<변수 범위>
 1. 1초 / 128MB
 2. 탈출구까지의 거리 1<=d<=1,000,000,00
 3. 돌섬의 수 0<=n<=50,000
 4. 제거할 수 있는 돌섬 수 (0<=m<=n)

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q6209 {
    static int N;
    static int[] dist;
    static int[] parDown;
    static int[] parUp;
    static final int INF = Integer.MAX_VALUE;
    static final boolean UP = true;
    static final boolean DOWN = false;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        if (N==0) {
            bw.write(String.valueOf(0));
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        int M = Integer.parseInt(st.nextToken());
        int[] isld = new int[N];
        for (int i=0;i<N;i++) isld[i]=Integer.parseInt(br.readLine());
        Arrays.sort(isld);
        dist = new int[N+2];
        dist[1]=isld[0];
        for (int i=2;i<=N;i++) dist[i]=isld[i-1]-isld[i-2];
        dist[N+1]=D-isld[N-1];

        PriorityQueue<P1> pq = new PriorityQueue<>();
        for (int i=1;i<=N+1;i++) pq.add(new P1(i,dist[i]));
        parDown = new int[N+1];
        parUp = new int[N+1];
        initSet(parDown);
        initSet(parUp);

        int cnt=0;
        P1 now;
        int last=N;
        while(cnt<M) {
            now = pq.poll();
            if (dist[now.to]!=now.dist) {
                pq.add(new P1(now.to,dist[now.to]));
                continue;
            }

            if (now.to==N+1) {
                // 섬이 아닌 도착지가 걸렸을 때
                if (dist[N]!=INF) last=N;
                else last=find(parDown,N)-1;
                dist[N+1]+=dist[last];
                dist[last]=INF;
                DeleteIsld(last);
                pq.add(new P1(N+1,dist[N+1]));
//                pq.add(new P1(last,INF));
            }
            else {
                // 메인 구현 (섬)
                dist[now.to]=INF;
                DeleteIsld(now.to);
                dist[find(parUp,now.to)+1]+=now.dist;
//                pq.add(new P1(now.to,INF));
            }

            //debug 출력
            System.out.printf("now : %d\n",now.to);
            for (int i=1;i<=N+1;i++) {
                System.out.printf("[%d,",i);
                if(dist[i]==INF) System.out.printf("INF] ");
                else System.out.printf("%d] ",dist[i]);
            }
            System.out.println();
            cnt++;
        }

        // 답구하기
        while(true) {
            now = pq.poll();
            if (dist[now.to]!=now.dist) {
                pq.add(new P1(now.to,dist[now.to]));
                continue;
            }
            bw.write(String.valueOf(now.dist));
            break;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void DeleteIsld (int isld) {
        if (isld-1>=1 && dist[isld-1]==INF) {
            union(parUp,isld-1,isld,UP);
            union(parDown,isld-1,isld,DOWN);
        }
        if (isld+1<=N && dist[isld+1]==INF) {
            union(parUp,isld+1,isld,UP);
            union(parDown,isld+1,isld,DOWN);
        }
    }

    public static void initSet(int[] parent) {
        for (int i=1;i<parent.length;i++) parent[i]=i;
    }

    public static int find (int[] parent, int a) {
        if(parent[a]==a) return a;
        return parent[a]=find(parent, parent[a]);
    }

    public static void union(int[] parent, int a, int b, boolean mode) {
        a = find(parent, a);
        b = find(parent, b);
        if (a==b) return;
        if(a<b) {
            if(mode==UP) parent[a]=b;
            else parent[b]=a;
        }
        else {
            if(mode==UP) parent[b]=a;
            else parent[a]=b;
        }

    }
}

class P1 implements Comparable<P1>{
    int to;
    int dist;

    public P1 (int to, int dist) {
        this.to=to;
        this.dist=dist;
    }

    @Override
    public int compareTo (P1 o) {
        return (this.dist==o.dist) ? this.to-o.to : this.dist-o.dist;
    }
}













