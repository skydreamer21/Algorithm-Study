package Necessary_Class.Graph;

import java.util.Arrays;

// 방향 - 가중치 그래프
public class Graph_matrix2 {
    public int vertex_size;
    public int[][] graph;
    public Integer[] visited;

    public Graph_matrix2(int v) {
        this.vertex_size = v;
        graph = new int[v+1][v+1];
        visited = new Integer[v+1];
    }

    public void addEdge (int v1, int v2, int w) {
        if (graph[v1][v2]!=0) graph[v1][v2]=Math.min(graph[v1][v2],w);
        else graph[v1][v2] = w;
    }

    //방문기록 초기화
    public void clear() {
        Arrays.fill(visited,0);
    }

    public void printGraph() {
        for (int i=1;i<=vertex_size;i++) {
            for (int j=1;j<=vertex_size;j++) System.out.print(graph[i][j]+" ");
            System.out.println();
        }
    }
}
