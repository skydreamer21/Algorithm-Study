// 2164번 카드2
/*
<문제 정보>
 1. N장의 카드, 1번카드 제일 위에, N번카드가 제일 아래
 2. 다음 동작 반복 (한장 남을때까지)
    - 제일 위에 카드 버림
    - 제일 위의 카드를 제일 아래로 옮긴다
 3. 마지막으로 남는 카드 출력
 4. 1<=N<=500,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2164 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i=1;i<=N;i++) q.add(i);
        while(q.size()>1) {
            q.poll();
            q.offerLast(q.poll());
        }
        bw.write(String.valueOf(q.poll()));
        bw.flush();
        bw.close();
        br.close();
    }
}