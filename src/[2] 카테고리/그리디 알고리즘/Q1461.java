// 1461번 도서관 [그리디]
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Q1461 {
    static int N, M;
    static int answer = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> negatives = new PriorityQueue<>();
        PriorityQueue<Integer> positives = new PriorityQueue<>((a,b) -> b-a);
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int elem = Integer.parseInt(st.nextToken());
            if (elem > 0) positives.add(elem);
            else negatives.add(elem);
        }

        // ******************** 메인 로직 ********************
        int positiveRemain = solve(positives);
        int negativeRemain = solve(negatives);

        answer += positiveRemain
                + negativeRemain
                + Math.min(positiveRemain, negativeRemain);

        // ******************** 정답 출력 ********************
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(PriorityQueue<Integer> pq) {
        if (pq.isEmpty()) return 0;

        int first = pq.peek();

        while ( pq.size() > M ) {
            IntStream.range(0, M).forEach(i -> pq.poll());
            answer += 2 * Math.abs(pq.peek());
        }

        return Math.abs(first);
    }
}
