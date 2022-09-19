// 14719번 빗물 (G5) [탐색 - 구현]
/*
<문제 정보>
 1. 주어진 2차원 세계에 고일 수 있는 빗물의 최대량 출력

<변수 범위>
 1. 1초 / 256MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q14719 {
    static int N;
    static int[] heights;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        N = Integer.parseInt(st.nextToken());
        heights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) heights[i] = Integer.parseInt(st.nextToken());

        // ******************** 메인 로직 ********************
        int[] left = new int[N];
//        int[] right = new int[N];
        int before, now;

        // 1. left
        left[0] = 0;
        before = heights[0];
        for (int i=1;i<N;i++) {
            now = heights[i];
            if (now < before) left[i] = before - now;
            else {
                left[i] = 0;
                before = now;
            }
        }

        // 2. right
        int sum = 0;
        before = heights[N-1];
        for (int i=N-2; i>=0; i--) {
            now = heights[i];
            if (now < before) sum += Math.min(before - now, left[i]);
            else before = now;
        }

        // ******************** 정답 출력 ********************
        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
