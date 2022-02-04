// 17298번 오큰수
/*
<문제 정보>
 1. 크기가 N인 수열에서 i번째 수에 대한 오큰수는 오른쪽에 있으면서 첫번째로 큰수
 2. N개의 수에 대한 오큰수 NGE(N)을 출력
 3. 1<=N<=1,000,000  /  각 숫자는 1,000,000 이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// stack을 만드는 대신 처음 입력을 배열로 받고 인덱스 스택만 이용한다면
// 메모리 측면에서 효율적으로 풀 수 있음  (저장도 입력받은 배열에!)
// -> 스택하나를 안써도됨됨
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
        MyStack<Integer> idx = new MyStack<>(N);
        int max=Integer.parseInt(st.nextToken());
        stack.push(max);
        idx.push(0);
        int tmp;
        for (int i=1;i<N;i++) {
            tmp = Integer.parseInt(st.nextToken());
            if (tmp<=stack.peek()) {
                stack.push(tmp);
                idx.push(i);
            }
            else if (tmp>stack.peek()) {
                while(!stack.empty() && tmp>stack.peek() ) {
                    arr[idx.pop()] = tmp;
                    stack.pop();
                }
                stack.push(tmp);
                idx.push(i);
            }
        }
        if (!idx.empty()) {
            while (!idx.empty()) arr[idx.pop()] = -1;
        }
        for (int num : arr) sb.append(num).append(" ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}