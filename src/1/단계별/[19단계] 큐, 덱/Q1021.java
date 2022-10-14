// 1021번 회전하는 큐
/*
<문제 정보>
 1. N개의 원소를 포함하는 덱에서 3가지 연산을 수행 가능
  - 첫번째 원소 뽑기
  - 왼쪽으로 한칸 이동 (첫번째 원소는 마지막으로 이동)
  - 오른쪽으로 한칸 이동 (마지막 원소는 첫번째로 이동)
 2. 주어진 원소를 순서대로 뽑아내는 데 드는 2번,3번 연산의 최솟값 출력
 3. N은 50보다 작거나 같은 자연수, M은 N보다 작거나 같은 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// N이 작은 수이기 때문에 Math.min을 써도 나쁘지 않음. 하지만 N이 커지면 절반 위치를 구해서
// 비교해서 구하는게 더 시간적으로 효율적

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q1021 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i=1;i<=N;i++) q.offerLast(i);
        int sum=0;
        int cnt;
        int tmp;
        for (int i=0;i<M;i++) {
            cnt =0;
            tmp = Integer.parseInt(st.nextToken());
            while (q.peekFirst()!=tmp) {
                q.offerLast(q.pollFirst());
                cnt++;
            }
            sum+=Math.min(cnt,q.size()-cnt);
            q.pollFirst();
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}