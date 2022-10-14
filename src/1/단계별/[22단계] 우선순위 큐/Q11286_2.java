// 11286번 절댓값 힙
/*
<문제 정보>
 1. 절댓값 힙을 이용해서 다음 연산 구현
    - 배열에 0이 아닌 정수 X를 넣는다.
    - 0이 입력되면 배열에서 절댓값이 가장 작은 값을 출력하고 배열에서 제거
    - 절댓값이 작은게 여러개이면 가장 작은수 출력하고 그 값을 제거
    (비어있는데도 0이 있다면 0 출력)

<변수 범위>
 1. 연산의 개수 N 1<=N<=100,000
 2. 입력되는 정수는 int 범위

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Q11286_2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare (Integer n1, Integer n2) {
                if (Math.abs(n1)==Math.abs(n2)) return n1-n2;
                else return Math.abs(n1)-Math.abs(n2);
            }
        });
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (Integer n1, Integer n2) -> (Math.abs(n1)==Math.abs(n2)) ? n1-n2 : Math.abs(n1)-Math.abs(n2));
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