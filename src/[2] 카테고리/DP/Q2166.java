// 2166번 다각형의 면적 (G5)
/*
<문제 정보>
 1. 2차원 평면상에 N개의 점으로 이루어진 다각형의 면적 출력

<변수 범위>
 1. 2초 / 128MB
 2. 3<=N<=10,000
 3. 좌표의 절댓값은 100,000을 넘지 않는다.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q2166 {
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        long value1 = 0;
        long value2 = 0;
        st = new StringTokenizer(br.readLine());
        N--;
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        int tempX = startX;
        int tempY = startY;
        int x, y;
        while (N-- >0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            value1 += (long) tempX*y;
            value2 += (long) tempY*x;
            tempX = x;
            tempY = y;
        }
        value1 += (long) tempX*startY;
        value2 += (long) tempY*startX;
        double Area = (double) Math.abs(value1 - value2)/2;
        sb.append(String.format("%.1f", Area));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
