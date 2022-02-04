// 11866번 요세푸스 문제 0
/*
<문제 정보>
 1. 1번~N번 원을 이룸  양의 정수 K(<=N)
 2. 순서대로 K번째 사람을 제거
 3. 모든사람이 제거될 때 까지 했을 때 제거되는 순서를 (N,K) - 요세푸스 순열
 4. 요세푸스 순열 출력
 5. 1<=K<=N<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q11866 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> q = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i=1;i<=N;i++) q.add(i);
        sb.append("<");
        int repeat;
        while(N-->1) {
            repeat = K;
            while(repeat-->1) q.add(q.poll());
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}