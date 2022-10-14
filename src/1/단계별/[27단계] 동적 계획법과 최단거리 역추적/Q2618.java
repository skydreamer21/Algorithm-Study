// 2618번 경찰차
/*
<문제 정보>
 1. 주어진 순서대로 사건 처리, 경찰차 이동거리 합 최소가 되게끔 배정
 2. 첫째줄에 총 이동 거리
 3. 그다음부터 어떤 경찰차에 배정되었는지

<변수 범위>
 1. 1초 / 128MB
 2. 도로 개수 N 5<=N<=1,000
 3. 사건의 개수 W 1<=W<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// https://subbak2.tistory.com/83
// 맨처음에 2^W 가 나올것이라고 생각했던 접근방법
// 근데 dp를 쓰기때문에 실제로 W^2이 나오게 됨

import Necessary_Class.Pair.Pair;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q2618 {
    static int W;
    static Pair[] locations;
    static int[][] dp;
    static int[][] path;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        locations = new Pair[W+1];
        int x, y;
        for (int i=1;i<=W;i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            locations[i] = new Pair(x, y);
        }
        Pair A = new Pair(1,1);
        Pair B = new Pair(N,N);

        // step1. A,B 시작 사건 고르기 : O(W)
        int[][] start = new int[W+1][2];
        start[1][1] = Math.min(distance(locations[1],A),distance(locations[1],B));
        start[1][0] = (start[1][1]==distance(locations[1],A)) ? 1 : 2;
        int Astart;
        int Bstart;
        for (int i=2;i<=W;i++) {
            Astart=distance(locations[1],A)+distance(locations[i],B);
            Bstart=distance(locations[1],B)+distance(locations[i],A);
            start[i][1] = Math.min(Astart,Bstart);
            start[i][0] = (start[i][1]==Astart) ? 1 : 2;
        }
        /*
        //확인
        System.out.println("<start>");
        for(int i=1;i<=W;i++) System.out.printf("(%d, %d) ",start[i][0],start[i][1]);
        System.out.println();
         */


        // step 2. DP : O(W^2)
        // dp[i][j] (i>j) : i까지 사건이 처리가 되었고 두 경찰차가 i와 j 위치에 있는 상황에서
        // N번째 사건까지 마치는데 필요한 최소 이동거리의 합
        // dp[N-1][N-2] 부터 dp[2][1] 까지 채움
        dp = new int[W+1][W+1];
        path = new int[W+1][W+1];
        int tmp_i; // i 위치 경찰차가 i+1 위치 사건 해결
        int tmp_j; // j 위치 경찰차가 i+1 위치 사건 해결
        for (int i=W-1;i>=2;i--) {
            for (int j=1;j<i;j++) {
                tmp_i = dp[i+1][j]+distance(locations[i],locations[i+1]);
                tmp_j = dp[i+1][i]+distance(locations[j],locations[i+1]);
                dp[i][j] = Math.min(tmp_i,tmp_j);
                path[i][j] = (dp[i][j]==tmp_i) ? i : j;
            }
        }
/*
        //확인
        System.out.println("<dp>");
        for (int i=0;i<=W;i++) System.out.println(Arrays.toString(dp[i]));
        System.out.println();
        System.out.println("<path>");
        for (int i=0;i<=W;i++) System.out.println(Arrays.toString(path[i]));
 */



        // step3. 최소 거리 구하기 : O(W)
        int min=0; int startCar; int startCase;
        int[] sum = new int[W+1];
        int tmp_sum=0;
        for (int i=3;i<=W;i++) {
            tmp_sum+=distance(locations[i-2],locations[i-1]);
            sum[i]=tmp_sum;
        }
        if (W>1) sum[1]=tmp_sum+distance(locations[W-1],locations[W]);
        /*
        System.out.println("<sum>");
        System.out.println(Arrays.toString(sum));
         */

        startCar=start[1][0];
        min=sum[1]+start[1][1];
        startCase=1;
        int temp=0;
        for (int i=2;i<=W;i++) {
            temp=start[i][1]+sum[i]+dp[i][i-1];
            if (temp<min) {
                min = temp;
                startCar = start[i][0];
                startCase=i;
            }
        }
/*
        //확인
        System.out.println("<start>");
        for(int i=1;i<=W;i++) System.out.printf("(%d, %d) ",start[i][0],start[i][1]);
        System.out.println();
        System.out.println("<results>");
        System.out.printf("startCar : %d, 최소 이동거리 : %d startCase : %d\n",startCar, min,startCase);
 */


       // step4. 경찰차 배정 결과 : O(W)
        int[] police = new int[W+1];
        if (startCase==1) Arrays.fill(police,startCar);
        else {
            int path_idx=startCase-1;
            for (int i=1;i<=W;i++) {
                if (i<=startCase-1) police[i] = startCar;
                else if (i==startCase) police[i] = (startCar==1) ? 2 : 1;
                else {
                    police[i] = police[path[i-1][path_idx]];
                    path_idx= (path[i-1][path_idx]==i-1) ? path_idx : i-1;
                }
            }
        }

        /*
        //확인
        System.out.println("<policeCar>");
        System.out.println(Arrays.toString(police));
         */

        //결과 출력
        sb.append(min).append("\n");
        for (int i=1;i<=W;i++) sb.append(police[i]).append("\n");


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int distance(Pair p1, Pair p2) {
        return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
    }
}
















