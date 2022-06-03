// 1725번 히스토그램 (P5)
/*
<문제 정보>
 1. 히스토그램에서 가장 큰 직사각형의 넓이 출력

<변수 범위>
 1. 0.7초 / 128MB
 2. 직사각형의 개수 1<=N<=100,000
 3. 각 칸의 높이 1,000,000,000 이하의 자연수 또는 0
 4. 가장 큰 직사각형의 넓이는 20억을 넘지 않는다.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q1725 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int height;
        int maxArea = -1;
        int numOfRec;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=1;i<=N;i++) {
            numOfRec = 1;
            height = Integer.parseInt(br.readLine());
            if (stack.isEmpty()) {
                stack.add(height);
                continue;
            }

            if (height==0) {
                while (!stack.isEmpty()) maxArea = Math.max(maxArea, stack.pollLast()*numOfRec++);
                continue;
            }

            if (height<stack.peekLast()) {
                while(!stack.isEmpty() && height<stack.peekLast()) {
                    int h = stack.pollLast();
//                    System.out.printf("height : %d\n",h);
                    maxArea = Math.max(maxArea, h*numOfRec++);
//                    maxArea = Math.max(maxArea, stack.pollLast()*numOfRec++);
                }
                while (numOfRec-- >0) stack.add(height);
//                System.out.printf("%d번째 Bar에서 maxArea : %d\n",i,maxArea);
            }
            else stack.add(height);
        }

        numOfRec = 1;
        while (!stack.isEmpty()) {
            maxArea = Math.max(maxArea, stack.pollLast()*numOfRec++);
//            System.out.printf("마지막 스택 비우기에서 Bar에서 maxArea : %d\n",maxArea);
        }

        sb.append(maxArea);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}



















