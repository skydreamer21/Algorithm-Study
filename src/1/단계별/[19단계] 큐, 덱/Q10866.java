// 10866번 덱
/*
<문제 정보>
 1. 정수 저장하는 덱
    - push_front X : 정수 X를 덱의 앞에 넣는다.
    - push_back X
    - pop_front
    - pop_back
    - size
    - empty
    - front
    - back
 2. 명령수 1<=N<=10,000  /   주어지는 수는 100,000 이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.*;

public class Q10866 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front" :
                    q.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    q.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    sb.append((q.isEmpty()) ? -1 : q.pollFirst()).append("\n");
                    break;
                case "pop_back" :
                    sb.append((q.isEmpty()) ? -1 : q.pollLast()).append("\n");
                    break;
                case "size" :
                    sb.append(q.size()).append("\n");
                    break;
                case "empty" :
                    sb.append((q.isEmpty()) ? 1 : 0).append("\n");
                    break;
                case "front" :
                    sb.append((q.isEmpty()) ? -1 : q.peekFirst()).append("\n");
                    break;
                case "back" :
                    sb.append((q.isEmpty()) ? -1 : q.peekLast()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}