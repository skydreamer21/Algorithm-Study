package Necessary_Class.Graph;
import Necessary_Class.Pair.VPair;

import java.util.ArrayList;


public class Graph_adjList2 {
    int size;
    public ArrayList<VPair>[] adjList;
    public Integer[] visited;

    public Graph_adjList2 (int size) {
        this.size = size;
        adjList = new ArrayList[size+1];
        visited = new Integer[size+1];
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