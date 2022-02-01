// 10828번 스택

/*
<문제 정보>
 1. 정수 저장 스택 구현
    - push X : 정수 X를 스택에 넣는 연산
    - pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력 (하나도 없으면 -1 출력)
    - size : 스택에 들어있는 정수 개수 출력
    - empty : 스택이 비어있으면 1, 아니면 0을 출력
    - top : 스택의 가장 위에 있는 정수 출력 (하나도 없으면 -1 출력)
 2. 명령 수 N 10,000 이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 배열로 만들었다면 size 변수 하나만 더 추가해서 같이 다뤄주면 됨.

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Stack_1 {
    public LinkedList<Integer> stack = new LinkedList<>();

    public void push(int n) {
        this.stack.add(n);
    }

    public int pop() {
        if (this.size()==0) return -1;
        else return this.stack.pollLast();
    }

    public int size() {
        return this.stack.size();
    }

    public int empty() {
        if (this.size()==0) return 1;
        else return 0;
    }

    public int top() {
        if (this.size()==0) return -1;
        else return this.stack.peekLast();
    }
}

public class Q10828 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack_1 stack = new Stack_1();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(N-->0) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            switch(S) {
                case "push" :
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size" :
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty" :
                    sb.append(stack.empty()).append("\n");
                    break;
                case "top" :
                    sb.append(stack.top()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}