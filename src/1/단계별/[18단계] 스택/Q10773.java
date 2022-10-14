// 10773번 제로

/*
<문제 정보>
 1. K개의 수가 주어지는데 값이 0일 경우 가장 최근에 쓴 수를 지우고 아닐 경우 해당 수를 쓴다
 2. 최종적으로 적어 낸 수의 합 출력
 3. 1<=K<=100,000


<프로그램 진행>
 1. 스택

<필요 함수>
 1.

 */


import java.io.*;

class Stack {
    int top;
    int[] stack;
    int size;

    public Stack (int size) {
        this.top = -1;
        this.stack = new int[size];
        this.size = size;
    }

    public void push (int n) {
        this.stack[++top] = n;
    }

    public int pop() {
        return this.stack[top--];
    }

    public int size() {
        return this.top+1;
    }
}

public class Q10773 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        Stack stack = new Stack(100000); // K로 size를 정하면 더 메모리 효율적
        int n;
        while(K-->0) {
            n=Integer.parseInt(br.readLine());
            if (n!=0) stack.push(n);
            else stack.pop();
        }
        int sum=0;
        for (int i=0;i<stack.size();i++) sum+=stack.stack[i];
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}