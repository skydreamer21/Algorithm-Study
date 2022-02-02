// 1874번 스택 수열

/*
<문제 정보>
 1. 스택을 이용해 입력된 수열을 만들기 위해 필요한 연산을 한줄에 한개씩 출력
 2. push : + / pop : -
 3. 1~n 에서 n은 100,000이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import Necessary_Class.MyStack;
import java.io.*;

public class Q1874 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        MyStack<Integer> stack = new MyStack<>(N);
        int prev_num;
        int num=0;
        int max=0;
        boolean possible = true;
        while(N-->0) {
            prev_num = num;
            num = Integer.parseInt(br.readLine());
            if (num < prev_num) {
                if (stack.pop()!=num) {
                    possible=false;
                    break;
                }
                else sb.append("-\n");
            }
            else if (num > prev_num) {
                int i = num-prev_num;
                while (i-->0) {
                    stack.push(++max);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }


        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}