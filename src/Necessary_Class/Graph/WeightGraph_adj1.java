package Necessary_Class.Graph;
import Necessary_Class.Pair.VPair;

import java.util.ArrayList;
import java.util.Arrays;

// 무방향 가중치 그래프 - 인접리스트
public class WeightGraph_adj1 {
    int size;
    public ArrayList<VPair>[] adjList;
    public boolean[] visited;

    public WeightGraph_adj1(int size) {
        this.size = size;
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=1;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge(VPair v1, VPair v2) {
        adjList[v1.v].add(v2);
        adjList[v2.v].add(v1);
    }

    public void clear() {
        Arrays.fill(visited, false);
    }


    public void printGraph() {
        for (int i=1;i<=size;i++) {
            System.out.printf("[%d] == ",i);
            for (VPair j : adjList[i]) System.out.printf("%d-",j.v);
            System.out.println();
        }
    }
}