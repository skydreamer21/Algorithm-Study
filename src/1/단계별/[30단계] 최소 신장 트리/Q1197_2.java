import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 코드 이해해보기
// 우선순위로 Prim 구현

public class Q1197_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Node[] adjList = new Node[V+1];
        boolean[] visited = new boolean[V+1];

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from] = new Node(to, adjList[from], weight);
            adjList[to] = new Node(from, adjList[to], weight);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        int answer = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.vertex]) {
                continue;
            }

            visited[cur.vertex]=true;
            answer+=cur.weight;

            for(Node temp=adjList[cur.vertex];temp!=null;temp=temp.link) {
                if(!visited[temp.vertex]) {
                    pq.offer(new Node(temp.vertex, temp.weight));
                }
            }
        }
        System.out.println(answer);
    }

    static class Node implements Comparable<Node>{
        int vertex;
        Node link;
        int weight;
        public Node(int vertex, Node link, int weight) {
            super();
            this.vertex = vertex;
            this.link = link;
            this.weight = weight;
        }
        public Node(int vertex, int weight) {
            super();
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }

    }

}