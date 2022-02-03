// 17298번 오큰수
/*
<문제 정보>
 1. 크기가 N인 수열에서 i번째 수에 대한 오큰수는 오른쪽에 있으면서 첫번째로 큰수
 2. N개의 수에 대한 오큰수 NGE(N)을 출력
 3. 1<=N<=1,000,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import Necessary_Class.MyStack;
import java.io.*;
import java.util.StringTokenizer;

public class Q1874 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        MyStack<Integer> stack = new MyStack<>(N);
        int max=0;
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int i=N-1;i>=0;i--) {
            if (arr[i]>max || stack.empty()) {
                stack.clear();
                max = arr[i];
                stack.push(arr[i]);
                arr[i]=-1;
            }
            else if (arr[i]<max) arr[i] = max;
            else if (arr[i]==max) arr[i]=-1;
        }
        for (int i=0;i<N;i++) sb.append(arr[i]).append(" ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}