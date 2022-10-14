// 2346번 풍선 터뜨리기 (S3) [실패]
/*
<문제 정보>
 1. 풍선

<변수 범위>
 1. 2초 / 4MB
 2. 1<=N<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q2346 {
    static int N;
    static int[] arr;
    static int[] parent;
    static int[] parentDown;

    static final boolean UP = true;
    static final boolean DOWN = false;
    static final boolean RIGHT = true;
    static final boolean LEFT = false;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        parent = new int[N];
        parentDown = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        parentInitSet(parent);
        parentInitSet(parentDown);
        union(0,1);
        sb.append(0).append(" ");
        int poppedBalloon = 1;
        int dist = arr[0];
        int nextBalloon=0; // 이번에 터질 풍선
        boolean isConnected = false; // 마지막 풍선이 터졌니?
        boolean direction = dist>0;
        dist = Math.abs(dist);

        while (poppedBalloon<N) {

            while(dist-- >0) {
                if (find(nextBalloon, direction)==nextBalloon) {
                    // 방향이 오른쪽일 때
                    if (direction) {
                        if (find(nextBalloon+1,UP)==N-1) {
                            nextBalloon = find(0,UP);
                        }
                        else {
                            nextBalloon = find(nextBalloon+1,UP);
                        }
                    }
                    // 방향이 왼쪽일 때
                    else {
                        if (find(nextBalloon-1,DOWN)==0) {
                            nextBalloon = find(N-1,DOWN);
                        }
                        else {
                            nextBalloon = find(nextBalloon-1,DOWN);
                        }
                    }
                }
                else {
                    nextBalloon = direction ? find(nextBalloon,UP) : find(nextBalloon,DOWN);
                    dist++;
                }
            }
            // 여기서 union 진행
            if (!isConnected && nextBalloon == N-1) isConnected = true;
            if (direction) {

            }

        }




        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void parentInitSet(int[] parent) {
        for (int i=0;i<N;i++) parent[i] = i;
    }

    public static int find(int a, boolean direction) {
        if (direction) {
            if (parent[a]==a) return a;
            return parent[a] = find(parent[a], UP);
        }
        else {
            if (parentDown[a]==a) return a;
            return parentDown[a] = find(parentDown[a], DOWN);
        }

    }

    public static void union(int a, int b) {
        int a_up = find(a, UP);
        int b_up = find(b, UP);
        int a_down = find(a, DOWN);
        int b_down = find(b, DOWN);

        if (a_up>b_up) parent[b_up] = a_up;
        else parent[a_up] = b_up;

        if (a_down<b_down) parent[b_down] = a_down;
        else parent[a_down] = b_down;
    }
}
















