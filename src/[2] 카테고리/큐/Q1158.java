// 1158번 요세푸스 문제 pm 5:13 ~ pm 5:37
/*
<문제 정보>
 1. 요세푸스 순열 출력

<변수 범위>
 1. 2초 / 256MB
 2. 사람 수 1<=N<=5,000
 3. K<=N


<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;


public class Q1158 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i=1;i<=N;i++) q.add(i);
        sb.append("<");
        while(q.size()>1) {
            for (int i=1;i<K;i++) q.add(q.poll());
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}




















