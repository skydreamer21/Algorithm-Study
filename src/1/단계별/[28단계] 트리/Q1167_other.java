import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// 아무데서나 시작한 다음에 dfs로 제일 큰 leaf 찾고
// 그 maxleaf에서 시작해서 두번째로 큰 leaf노드를 찾는 방식
// pq가 추가로 들어가지 않음
// 시간 복잡도 O(N)


public class Q1167_other {

    static class Edge{
        int to, dist;
        public Edge(int to, int dist){
            this.to = to;
            this.dist = dist;
        }
    }

    static int V;
    static List<Edge>[] adjLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = stoi(br.readLine());
        adjLists = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            adjLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to;
            while((to = stoi(st.nextToken())) != -1){
                int dist = stoi(st.nextToken());
                adjLists[from].add(new Edge(to, dist));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(maxNo, 0);

        System.out.println(maxDist);
    }

    static boolean[] visited;
    static int maxDist;
    static int maxNo;
    static void dfs(int cur, int dist){
        if(visited[cur]){
            return;
        }
        if(maxDist < dist) {
            maxDist = dist;
            maxNo = cur;
        }
        visited[cur] = true;
        for (Edge edge : adjLists[cur]) {
            int next = edge.to;
            dfs(next, dist + edge.dist);
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}