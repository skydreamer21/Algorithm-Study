package Necessary_Class.Graph;

import java.util.Arrays;

public class Graph_matrix {
    public int vertex_size;
    public int[][] graph;
    public boolean[] visited;

    public Graph_matrix(int v) {
        this.vertex_size = v;
        graph = new int[v+1][v+1];
        visited = new boolean[v+1];
    }

    public void addEdge (int v1, int v2) {
        graph[v1][v2] = 1;
        graph[v2][v1] = 1;
    }

    //방문기록 초기화
    public void clear() {
        Arrays.fill(visited,false);
    }

}
