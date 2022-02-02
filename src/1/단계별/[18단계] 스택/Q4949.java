// 4949번 균형잡힌 세상

/*
<문제 정보>
 1. 주어진 문자열의 두가지 종류의 괄호가 각각의 종류끼리 짝을 잘 이루고 있어야 균형잡힌 문자열
 2. 각 문자열은 100이하  /  맨 마지막은 . 한개 들어옴

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import Necessary_Class.MyStack;

public class Q4949 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        MyStack<Character> stack = new MyStack<>(100);
        String S; char c;
        boolean SearchAll;
        boolean type=true;
        while (true) {
            stack.clear();
            SearchAll = true;
            int cnt1=0; int cnt2=0;
            S = br.readLine();
            if (S.equals(".")) break;
            for (int i=0;i<S.length();i++) {
                c=S.charAt(i);
                if (c=='(') {
                    type = true;
                    stack.push(c);
                    cnt1++;
                }
                else if (c=='[') {
                    type = false;
                    stack.push(c);
                    cnt2++;
                }
                else if ((c==')' && (!type || cnt1==0)) || (c==']' && (type || cnt2==0))) {
                    SearchAll = false;
                    break;
                }
                else if (c==')' || c==']') {
                    stack.pop();
                    if (stack.size()!=0) type = (stack.peek()=='(');
                    if (c==')') cnt1--;
                    else cnt2--;
                }
            }
            if (SearchAll && stack.empty()) sb.append("yes\n");
            else sb.append("no\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}