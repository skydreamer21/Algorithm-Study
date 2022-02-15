// 1697번 숨바꼭질
/*
<문제 정보>
 1. 걸으면 +,- 1
 2. 순간이동하면 x2
 3. 동생 찾는 시간 최솟값 출력

<변수 범위>
 1. 2초 / 128MB
 2. N, K : 100,000 이하 자연수 또는 0

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q1697 {
    static boolean[] visited = new boolean[100001];
    static int N;
    static int K;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N>=K) bw.write(String.valueOf(N-K));
        else bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(N);
        int now;
        int next=0;
        int sec=0;
        int size;
        boolean inRange;
        boolean findAns = false;
        while(!q.isEmpty()) {
            if(findAns) break;
            size = q.size();
            for (int s=0;s<size;s++) {
                if(findAns) break;
                now = q.poll();
                if(!visited[now]) {
                    //System.out.printf("<Current No : %d>\n",now);
                    visited[now]=true;
                    for (int i=0;i<3;i++) {
                        switch(i) {
                            case 0 :
                                next = now-1;
                                break;
                            case 1 :
                                next = now+1;
                                break;
                            case 2 :
                                next = now*2;
                        }
                        inRange = next>=0 && next<=100000;
                        if (inRange && !visited[next]) {
                            if (next==K) {
                                findAns = true;
                                break;
                            }
                            q.add(next);
                        }
                    }
                    //printQueue(q);
                    //System.out.printf("time : %dsec\n",sec);
                    //System.out.println("------------------");
                }
            }
            sec++;
        }
        return sec;
    }

    public static void printQueue(Deque<Integer> q) {
        int cnt=0;
        System.out.print("(");
        for (int i : q) {
            cnt++;
            if (cnt==q.size()) System.out.print(i);
            else System.out.printf("%d ",i);
        }
        System.out.println(")");
    }
}
