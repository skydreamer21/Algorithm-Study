// 1717번 집합의 표현
/*
<문제 정보>
 1. 0~n n+1개의 집합에 대해 합집합 연산, 같은 집합에 포함되어있는지 확인 연산 수행
 2. 0 : 합집합 / 1 : 확인

<변수 범위>
 1. 2초 / 128MB
 2. 1<=n<=1,000,000
 3. 1<=m<=100,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Q1717 {
    static int n;
    static int[] parent;
    static int[] rank;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        initialSet();
        rank = new int[n+1];
        Arrays.fill(rank,1);
        int order, a, b;
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            order = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
//            if (order==0) union(a,b);
            if (order==0) union_rank(a,b);
            else if (order==1) sb.append(isSameSet(a,b) ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void initialSet() {
        for (int i=0;i<=n;i++) parent[i]=i;
    }

    public static int find (int a) {
        if (parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }

    public static void union (int a, int b) {
        // a가 단독집합이라면 a가 나올 것이고 아니면 a가 포함되는 집합이 나올테니
        // 처음에 입력된 그대로를 사용안하더라도 포함하는 집합을 합쳐준다면 이어지는 것이 됨.
        a = find(a);
        b = find(b);
        if (a<b) parent[b]=a;
        if (a>b) parent[a]=b;
    }

    public static void union_rank (int a, int b) {
        a = find(a);
        b = find(b);
        if(rank[a]<rank[b]) parent[a]=b;
        else {
            parent[b]=a;
            if(rank[a]==rank[b]) rank[a]++;
        }
    }

    public static boolean isSameSet (int a, int b) {
        return find(a)==find(b);
    }

}























