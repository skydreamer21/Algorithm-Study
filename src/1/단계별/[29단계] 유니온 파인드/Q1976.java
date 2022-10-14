// 1976번 여행 가자
/*
<문제 정보>
 1. 여행 가능 여부 출력

<변수 범위>
 1. 2초 / 128MB
 2. 도시의 수 N 200이하
 3. 여행 계획에 속한 도시 수 M 1,000 이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q1976 {
    static int N;
    static int[] parent;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        initSet();
        int M = Integer.parseInt(br.readLine());
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) {
                if(j<=i) {
                    st.nextToken();
                    continue;
                }
                if (Integer.parseInt(st.nextToken())==1) union(i,j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int root = find(Integer.parseInt(st.nextToken())); M--;
        boolean possible = true;
        int tmp_root;
        while (M-->0) {
            tmp_root = find(Integer.parseInt(st.nextToken()));
            if(root!=tmp_root) {
                possible=false;
                break;
            }
        }
        sb.append(possible ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void initSet() {
        for (int i=0;i<=N;i++) parent[i] = i;
    }

    public static int find(int a) {
        if (parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }

    public static void union (int a, int b) {
        a=find(a);
        b=find(b);
        if(a<b) parent[b]=a;
        else parent[a]=b;
    }


}



























