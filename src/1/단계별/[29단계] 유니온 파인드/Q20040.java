// 20040번 사이클 게임
/*
<문제 정보>
 1. 사이클이 만들어졌다면 처음으로 만들어진 차례번호 출력, 만들어지지 않았다면 0

<변수 범위>
 1. 1초 / 512MB
 2. 점의 개수 3<=n<=500,000
 3. 진행된 차례의 수 3<=m<=1,000,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q20040 {
    static int N;
    static int[] parent;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        parent = new int[N];
        initSet();
        int M = Integer.parseInt(st.nextToken());
        int v1,v2;
        int cycle=0;
        for (int i=1;i<=M;i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            if(union(v1,v2)) {
                cycle = i;
                break;
            }
        }
        sb.append(cycle);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
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
        if (a==b) return true;
        else {
            if(a>b) parent[a]=b;
            else parent[b]=a;
            return false;
        }
    }

}
























