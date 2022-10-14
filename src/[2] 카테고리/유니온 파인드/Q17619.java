// 17619번 개구리 점프 (G2) [유니온파인드]
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 512MB
 2. 좌표는 0이상 10^9 이하
 3. 1 <= N <= 100,000
 4. 1 <= Q <= 100,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q17619 {
    static int N, Q;
    static Log[] logs;
    static int[] parent;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        logs = new Log[N+1];
        parent = new int[N+1];
        initParent();

        int x1, x2, y;
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            logs[i] = new Log(i, x1, x2, y);
        }


        // ******************** 메인 로직 ********************
        Arrays.sort(logs, 1, N);

        int right = logs[1].x2;
        for (int i=2; i<=N; i++) {
//            System.out.printf("[i:%d] 현재 right : %d, 이번 통나무의 x1 : %d\n", i, right, logs[i].x1);
            if (logs[i].x1 <= right) {
                union(logs[i-1].num, logs[i].num);
//                System.out.printf("%d번과 %d번을 이었습니다.\n", logs[i-1].num, logs[i].num);
//                printParent();

            }
            right = Math.max(right, logs[i].x2);
        }

        int from, to;
        while ( Q-- >0 ) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            sb.append(find(from) == find(to) ? 1 : 0).append("\n");
        }

        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void initParent() {
        for (int i=1; i<=N ;i++) parent[i] = i;
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void printParent() {
        System.out.printf("-- Parent Status --\n");
        for (int i=1;i<=N;i++) {
            System.out.printf("%d ",parent[i]);
        }
        System.out.println();
    }
}

class Log implements Comparable<Log>{
    int num, x1, x2, y;

    public Log (int num, int x1, int x2, int y) {
        this.num = num;
        this.x1 = x1;
        this.x2 = x2;
        this.y = y;
    }

    @Override
    public int compareTo(Log o) {
        return this.x1 == o.x1 ? o.x2 - this.x2 : this.x1 - o.x1;
    }
}
