// 14938번 서강그라운드 (G4) [dfs]
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;

public class Q14938 {
    static int N, limitDis, R;
    static int[] items;
    static boolean[] hasItem;
    static WGraph1 g;
    static int maxItems = Integer.MIN_VALUE;
    static int itemsInEachStartingPoint;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        limitDis = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        g = new WGraph1(N);
        items = new int[N+1];
        hasItem = new boolean[N+1];

        // item 입력
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) items[i] = Integer.parseInt(st.nextToken());

        // Edge 입력
        int v1, v2, w;
        while (R-- > 0) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            g.addEdge(v1, v2, w);
        }

        // ******************** 메인 로직 ********************
        for (int i=1;i<=N;i++) {
//            System.out.printf("\n=========== [%d] START ===========\n", i);
            Arrays.fill(hasItem, true);
            itemsInEachStartingPoint = 0;
            dfs(i, 0);
            maxItems = Math.max(maxItems, itemsInEachStartingPoint);
//            System.out.printf("얻은 아이템 개수 : %d\n", itemsInEachStartingPoint);
        }

        // ******************** 정답 출력 ********************
        sb.append(maxItems);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int loc, int dis) {
//        System.out.printf("[IN] loc : %d, 현재까지 dis : %d\n", loc, dis);
        if (dis > limitDis) {
//            System.out.printf("[OUT - out of search range] loc : %d, 현재까지 dis : %d\n", loc, dis);
            return;
        }
        if (hasItem[loc]) {
            itemsInEachStartingPoint += items[loc];
            hasItem[loc] = false;
        }
        g.visited[loc] = true;
        for (Pos2 nextLoc : g.adjList[loc]) {
            if (g.visited[nextLoc.loc]) continue;
            dfs(nextLoc.loc ,dis + nextLoc.w);
        }
        g.visited[loc] = false;
//        System.out.printf("[OUT - All Searched] loc : %d, 현재까지 dis : %d\n", loc, dis);
    }
}

class WGraph1 {
    ArrayList<Pos2>[] adjList;
    boolean[] visited;

    public WGraph1(int size) {
        adjList = new ArrayList[size + 1];
        visited = new boolean[size + 1];
        for (int i=1;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge(int v1, int v2, int w) {
        adjList[v1].add(new Pos2(v2, w));
        adjList[v2].add(new Pos2(v1, w));
    }
}

class Pos2 {
    int loc, w;

    public Pos2 (int loc, int w) {
        this.loc = loc;
        this. w = w;
    }
}


















