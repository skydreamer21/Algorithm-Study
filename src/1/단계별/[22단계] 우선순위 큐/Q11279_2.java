// 11279번 최대 힙 - pq class
/*
<문제 정보>
 1. 최대힙을 이용해서 다음 연산 구현
    - 배열에 자연수 x를 넣는다.
    - 0이 입력되면 배열에서 가장 큰 값을 출력하고 그값을 배열에서 제거
    (비어있는데도 0이 있다면 0 출력)

<변수 범위>
 1. 연산의 개수 N 1<=N<=100,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.PriorityQueue;
import java.util.Collections;

public class Q11279_2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int temp;
        while (N-->0) {
            temp = Integer.parseInt(br.readLine());
            if (temp==0) {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
            else pq.offer(temp);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}