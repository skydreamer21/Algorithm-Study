// 10473번 인간 대포 (G2)
/*
<문제 정보>
 1.

<변수 범위>
1. 1초 / 256MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q10473 {
    static int N;
    static Cannon[] cannons;
    static double[][] time;

    static final double INF = Double.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        double startX, startY, goalX, goalY;
        st = new StringTokenizer(br.readLine());
        startX = Double.parseDouble(st.nextToken());
        startY = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        goalX = Double.parseDouble(st.nextToken());
        goalY = Double.parseDouble(st.nextToken());

        N = Integer.parseInt(br.readLine());
        cannons = new Cannon[N];
        double x_in, y_in;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            startX = Double.parseDouble(st.nextToken());
            startY = Double.parseDouble(st.nextToken());
        }


        // ******************** 메인 로직 ********************



        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Cannon {
    double x, y;

    public Cannon (double x, double y) {
        this.x = x;
        this.y = y;
    }
}
