// 6603번 로또 (S2) [dfs][BackTracking]
/*
<문제 정보>
 1. 집합 S와 k가 주어졌을 때 6개의 수를 고르는 모든 방법을 사전 순으로 출력
    - 집합 S는 오름차순으로 주어짐

<변수 범위>
 1. 1초 / 128MB
 2. k개의 수 6<k<13
 3. 고르는 수느 1~49

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Q6603_t {
    static Deque<Integer> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N==0) break;
            arr= new int[N];
            for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
            dfs(0,0);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int depth, int idx) {
        if(depth==6) {
            for (int num : stack) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }
        if(idx==N) return;
        for (int i=idx;i<N;i++) {
            stack.add(arr[i]);
            dfs(depth+1,i+1);
            stack.pollLast();
        }
    }
}
















