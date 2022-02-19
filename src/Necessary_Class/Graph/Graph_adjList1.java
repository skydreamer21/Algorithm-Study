package Necessary_Class.Graph;

import java.util.ArrayList;
import java.util.Arrays;

// 가중치가 없을 때 쓰는 그래프

/*
 <구성요소>
 - 정점
 - 정점과 연결되어 있는 점들의 List
 - 방문 기록
 - 정점 연결 메소드

 */

public class Graph_adjList1 {
    int vertex_size; // 정점 개수
    public ArrayList<Integer>[] adjList; // 정점과 연결되어 있는 점들의 List -> 정점당 하나의 List를 갖고 있음
    public boolean[] visited; // 방문 기록 --> 정점의 개수 만큼

    // 생성자 -> 그래프의 크기를 입력받아 정해줌
    public Graph_adjList1(int v) {
        this.vertex_size = v;
        adjList = new ArrayList[vertex_size+1];
        visited = new boolean[vertex_size+1];
        for (int i=0;i<=vertex_size;i++) adjList[i] = new ArrayList<>(); // (중요!) 정점하나당 인접리스트 생성
    }

    // 정점 연결 메소드
    public void addEdge(int v1, int v2) {
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }

    // 방문 기록 초기화
    public void clear() {
        Arrays.fill(visited, false);
    }
}