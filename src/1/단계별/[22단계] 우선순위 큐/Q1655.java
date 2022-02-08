// 1655번 가운데를 말해요
/*
<문제 정보>
 1. 숫자가 연속적으로 주어질때마다 주어진 숫자중 중간값을 출력
 2. 짝수개라면 중간의 두개의 수중 작은 값을 출력

<변수 범위>
 1. 주어지는 숫자 개수 N은 100,000 이하의 자연수
 2. 주어지는 숫자는 절댓값 10,000 이하의 정수

<프로그램 진행>
 1. 중간값을 기준으로 작은수들은 maxheap으로, 큰수들은 minheap으로 구성
 (중간값은 heap에 포함시키지 않음)

<필요 함수>
 1.

 */


import java.io.*;
import java.util.PriorityQueue;
import java.util.Collections;

public class Q1655 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int mid=Integer.parseInt(br.readLine());
        sb.append(mid).append("\n");
        boolean isLeftMax = true;
        int temp;
        for (int i=2;i<=N;i++) {
            temp = Integer.parseInt(br.readLine());
            // 입력값이 중간값보다 작아서 left로 넘겨줘야 하는 경우
            if (mid>temp) {
                if(isLeftMax) {
                    right.offer(mid);
                    left.offer(temp);
                    mid = left.poll();
                }
                else left.offer(temp);
                isLeftMax=!isLeftMax;
            }

            // 입력값이 중간값보다 커서 right로 넘겨줘야 하는 경우
            else if (mid<temp) {
                if(!isLeftMax) {
                    left.offer(mid);
                    right.offer(temp);
                    mid = right.poll();
                }
                else right.offer(temp);
                isLeftMax=!isLeftMax;
            }

            // 입력값과 중간값이 같은 경우
            else {
                if (isLeftMax) right.offer(temp);
                else left.offer(temp);
                isLeftMax=!isLeftMax;
            }
            sb.append(mid).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}