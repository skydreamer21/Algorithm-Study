// 1966번 프린터 큐
/*
<문제 정보>
 1. 다음 조건 따라 인쇄
    - 큐에 가장 앞 문서의 '중요도' 확인
    - 나머지 문서들 중 현재 문서보도 중요도가 높은 문서 있으면 큐 가장 뒤에 재배치
    - N개의 문서가 있을 때 왼쪽에서 M번째 있는 문서가 몇번째로 출력되는지 출력
2. N은 100이하 자연수  /  중요도는 1이상 9이하의 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

public class Q1966 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        StringTokenizer st;
        Integer[] arr = new Integer[100];
        int N; int M;
        int trace;
        int max;
        int cnt;
        // 테스트 케이스 반복문
        while (T-- > 0) {
            q.clear();
            cnt =0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            trace = M;
            st = new StringTokenizer(br.readLine());
            // 입력받은 중요도로 배열과 큐만들기
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                q.add(arr[i]);
            }
            //중요도 배열을 내림차순으로 정렬
            Arrays.sort(arr,0,N,Collections.reverseOrder());
            max = arr[0];
            // M번째가 출력될 때까지 주어진 규칙대로 큐 돌림
            while (true) {
                if (q.peek()!=max) {
                    q.add(q.poll());
                    trace = (trace==0) ? q.size()-1 : trace-1;
                }
                else {
                    cnt++;
                    if (trace==0) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                    else {
                        q.poll();
                        trace-=1;
                        max = arr[cnt];
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}