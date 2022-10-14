// 3197번 백조의 호수 (P5) [최단거리 - Daijkstra]
/*
<문제 정보>
 1. 빙판이 녹아서 두 백조가 만날때까지 걸리는 날 출력

<변수 범위>
 1. 1초 / 256MB
 2. 1<=R,C<=1,500

<프로그램 진행>
 1. 2차원 맵 대상 UnionFind
 2. 물과 맞닿아 있는 빙산 큐에 저장 (bfs)
 3. melt 함수
    - 큐에 저장 되어 있는 빙산들을 녹이고 주변의 물들과 union
 4. bfs 한번 돌때마다 두 백조의 루트값을 체크해서 같다면 일수를 출력하고 끝

<필요 함수>
 1.

 */

import java.io.*;

public class Q3197_2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
