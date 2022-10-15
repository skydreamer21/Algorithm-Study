// 16438번 원숭이 스포츠 (G3) [분할 정복]
/*
<문제 정보>
 1. N마리 원숭이 1~N 번호
 2. 모든 두 원숭이에 대해서 적어도 한번은 적으로 만나도록 대진표를 짜자
 3. 7일간 하루에 한번씩 경기가 진행되는데 모든 원숭이들이 A팀과 B팀으로 나뉜다.

<변수 범위>
 1. 1초 / 128MB
 2. 2 <= N <= 99

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q16438 {
    static int N;
    static char[][] plan;

    static final char A = 'A';
    static final char B = 'B';

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        N = Integer.parseInt(br.readLine());
        plan = new char[7][N];

        // ******************** 메인 로직 ********************

        divideConquer(0, 0, N-1);

        // ******************** 정답 출력 ********************

        for (int i=0; i<7; i++) {
            for (int j=0; j<N; j++) {
                sb.append(plan[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void divideConquer(int day, int start, int end) {
        if (day == 7) return;

        if (start == end) {
            plan[day][start] = plan[day-1][start];
            divideConquer(day + 1, start, end);
            return;
        }

        int mid = (start + end) / 2;
        for (int i=start; i<=mid; i++) plan[day][i] = A;
        for (int i=mid+1; i<=end; i++) plan[day][i] = B;
        divideConquer(day+1, start, mid);
        divideConquer(day+1, mid+1, end);
    }
}
