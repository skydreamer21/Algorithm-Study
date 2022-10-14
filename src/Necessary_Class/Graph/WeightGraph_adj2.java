package Necessary_Class.Graph;
import Necessary_Class.Pair.VPair;

import java.util.ArrayList;

// 방향 가중치 그래프 - 인접리스트
public class WeightGraph_adj2 {
    int size;
    public ArrayList<VPair>[] adjList;
    public boolean[] visited;

    public WeightGraph_adj2 (int size) {
        this.size = size;
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=1;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge(int v1, VPair v2) {
        adjList[v1].add(v2);
    }

    public void printGraph() {
        for (int i=1;i<=size;i++) {
            System.out.printf("[%d] == ",i);
            for (VPair j : adjList[i]) System.out.printf("%d-",j.v);
            System.out.println();
        }
    }
}