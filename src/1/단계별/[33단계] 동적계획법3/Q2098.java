// 2098번 외판원 순회(Traveling Salesman problem : TSP) (G1)
/*
<문제 정보>
 1. 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행의 최소 비용 구하기
    - 한번 갔던 도시는 갈 수 없음
    - 순회할 수 있는 경우만 입력으로 주어진다.

<변수 범위>
 1. 1초 / 128MB
 2. 도시의 수 2<=N<=16
 3. 각 행렬의 성분은 1,000,000 이하의 양의 정수, 갈 수 없는 경우 : 0

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q2098 {
    static int N;
    static int dp[][][];
    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new int[N][N+1][N+1];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) dp[1][i][j] = Integer.parseInt(st.nextToken());

        }

        for (int path=2;path<N;path++) solveDP(path);

        int minCost = INF;
        for (int start=1;start<=N;start++) {
//            minCost = Math.min(minCost, dp[N-1][])
        }



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solveDP (int path) {
        // i -> j 로 갈때 path 개의 길을 거칠 때 최소 비용 구하기
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                // 여기서부터는 dp[path][i][j] 를 구하기 위한 과정
                dp[path][i][j] = INF;
                for (int via=1;via<=N;via++) {
                    for (int frontPath=1;frontPath<path;frontPath++) {
                        /*
                        1. i->j 까지 간다.
                        2. 중간에 via를 거친다.
                        3. i->via 는 frontPath 개의 길을 지난다.
                        4. via->j 는 (path - frontPath) 개의 길을 지난다.
                        5. via와 frontPath를 변화시켜가며 dp[path][i][j]의 최솟값을 구한다.
                         */
                        if (i==via || j==via) continue;
                        dp[path][i][j] = Math.min(
                                dp[path][i][j],
                                dp[frontPath][i][via] + dp[path - frontPath][via][j]
                        );
                    }
                }
            }
        }
    }
}



















