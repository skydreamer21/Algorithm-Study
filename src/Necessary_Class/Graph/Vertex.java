package Necessary_Class.Graph;

import java.util.ArrayList;

public class Vertex {
    int num; // 정점 이름
    int w; // 정점 가중치
    boolean visited = false; // 해당 정점을 방문했는지

    // 정점 생성자
    public Vertex (int num, int w) {
        this.num = num;
        this.w = w;
    }
}
