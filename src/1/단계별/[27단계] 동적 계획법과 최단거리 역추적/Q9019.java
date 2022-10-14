// 9019번 DSLR
/*
<문제 정보>
 1.

<변수 범위>
 1. 6초 / 256MB
 2.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import Necessary_Class.Pair.Pair;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q9019 {
    static Pair[] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int A,B;
        int times;
        while (T-- >0) {
            st = new StringTokenizer(br.readLine());
            A=Integer.parseInt(st.nextToken());
            B=Integer.parseInt(st.nextToken());
            dp = new Pair[10000];
            times = bfs(A,B);
            int tmp = B;
            int[] path = new int[times];
            for (int i=times-1;i>=0;i--) {
                path[i] = dp[tmp].y;
                tmp = dp[tmp].x;
            }
            for (int i=0;i<times;i++){
                switch(path[i]) {
                    case 0 :
                        sb.append('D');
                        break;
                    case 1 :
                        sb.append('S');
                        break;
                    case 2 :
                        sb.append('L');
                        break;
                    case 3 :
                        sb.append('R');
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int a, int b) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(a);
        //dp[a] = new Pair(-1,-1);
        //어차피 막힘
        int now;
        int size;
        int temp=0;
        int times=0;
        boolean findAns = false;
        int db_max=0;

        while (!q.isEmpty()) {
            if(findAns) break;
            size=q.size();

            for (int s=0;s<size;s++) {
                if(findAns) break;
                now=q.poll();
                for (int i=0;i<4;i++) {
                    switch(i) {
                        case 0 :
                            temp = D(now);
                            break;
                        case 1 :
                            temp = S(now);
                            break;
                        case 2 :
                            temp = L(now);
                            break;
                        case 3 :
                            temp = R(now);
                    }
                    if (dp[temp]==null) {
                        q.add(temp);
                        dp[temp] = new Pair(now,i);
                        if(temp==b) {
                            findAns=true;
                            break;
                        }
                    }
                }
                db_max=Math.max(db_max,q.size());
            }
            times++;
        }
        System.out.printf("q max : %d\n",db_max);
        return times;
    }

    public static int D (int n) {
        return (2*n)%10000;
    }
    public static int S (int n) {
        return (n==0) ? 9999 : n-1;
    }
    public static int L (int n) {
        return (n%1000)*10 + (n/1000);
    }
    public static int R (int n) {
        return (n%10)*1000 + (n/10);
    }
}

















