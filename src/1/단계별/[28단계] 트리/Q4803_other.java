import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유니온 파인드 풀이

public class Q4803_other {
    static int[] parent;
    static int N;
    static boolean[] isNotTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int tc=1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0) break;

            isNotTree = new boolean[N+1];
            parent = new int[N+1];
            make();

            while(M-->0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            int ans = 0;
            for(int i=1;i<=N;i++) {
                if(i==parent[i]) {
                    if(!isNotTree[i]) ans++;
                }
            }

            sb.append("Case ").append(tc++).append(": ");
            if(ans==0) {
                sb.append("No trees.");
            }else if(ans==1) {
                sb.append("There is one tree.");
            }else {
                sb.append("A forest of ").append(ans).append(" trees.");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void make() {
        for(int i=1;i<=N;i++) {
            parent[i] = i;
        }
    }

    static int find(int a) {
        if(a==parent[a]) return a;

        return parent[a]=find(parent[a]);
    }

    static void union(int a, int b) {
        int ar = find(a);
        int br = find(b);

        if(ar==br || isNotTree[ar]) {
            isNotTree[ar] = isNotTree[br] = true;
            return;
        }

        parent[ar] = br;
    }
}