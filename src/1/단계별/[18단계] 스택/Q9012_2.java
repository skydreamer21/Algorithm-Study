// 9012번 괄호

/*
<문제 정보>
 1. 올바른 괄호 문자열이면 YES 아니면 NO 출력
 2. 하나의 괄호 문자열 길이는 2이상 50 이하

<프로그램 진행>
 1. 스택 사용

<필요 함수>
 1.

 */



import java.io.*;
import Necessary_Class.MyStack;

public class Q9012_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        MyStack<Character> stack = new MyStack<>(50);
        boolean SearchAll;
        while (T-->0) {
            stack.clear();
            SearchAll = true;
            String S = br.readLine();
            for (int i=0;i<S.length();i++) {
                char c = S.charAt(i);
                if (c=='(') stack.push(c);
                else if (stack.empty()) {
                    SearchAll = false;
                    break;
                }
                else stack.pop();
            }
            if (SearchAll && stack.empty()) sb.append("YES\n");
            else sb.append("NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}