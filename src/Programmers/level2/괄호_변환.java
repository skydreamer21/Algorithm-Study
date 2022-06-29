package Programmers.level2;

import java.util.Deque;
import java.util.ArrayDeque;

class 괄호_변환 {
    static int len;
    static char[] parentheses;
    static StringBuilder sb = new StringBuilder();

    static final char OPEN = '(';
    static final char CLOSE = ')';
    static final int CORRECT = 0;

    public String solution(String p) {
        parentheses = p.toCharArray();
        len = parentheses.length;
        fix(0);

        String answer = sb.toString();
        return answer;
    }

    /* fix Function
    idx부터 끝까지 괄호배열을 올바른 괄호 문자열로 고치는 함수
    1. 올바른 괄호 문자열이라면 재귀부르고 바로 함수 끝
    2. 올바른 괄호 문자열이 아니라면
     2-1. + OPEN
     2-2. call Recursion
     2-3. + CLOSE
     2-4. + reverse remians
     Recusion Escape : idx == LENGTH
     */
    public static void fix(int idx) {
        // Recursion Escape
        if (idx==len) return;

        // System.out.printf("%d에서 U part 구하기\n",idx);
        int uLastIdx = get_U_part(idx);
        // System.out.printf("%d에서 U part end : %d\n",idx,uLastIdx);
        // step1.
        if (uLastIdx>0) {
            for (int i=idx;i<=uLastIdx;i++) sb.append(parentheses[i]);
            fix(uLastIdx+1);
            return;
        }

        // step2.
        uLastIdx *= -1;
        sb.append(OPEN);
        fix(uLastIdx+1);
        sb.append(CLOSE);
        for (int i=idx+1;i<uLastIdx;i++) {
            sb.append(parentheses[i]==OPEN ? CLOSE : OPEN);
        }
    }

    // u part의 마지막 index 전달
    // 만약 음수로 전달된다면 올바른 괄호 문자열이 아님
    public static int get_U_part(int idx) {
        int pairCheck = 0;
        Deque<Character> stack = new ArrayDeque<>();
        pairCheck = parentheses[idx] == OPEN ? 1 : -1;
        stack.add(parentheses[idx++]);
        while(pairCheck != CORRECT) {
            // System.out.printf("pairCheck : %d\n",pairCheck);
            // System.out.printf("peek : %c, 이번 괄호 : %c\n",stack.peekLast(),parentheses[idx]);
            if (stack.peekLast() == OPEN && parentheses[idx] == CLOSE) stack.pollLast();
            else stack.add(parentheses[idx]);
            pairCheck += parentheses[idx++] == OPEN ? 1 : -1;
        }
        return stack.isEmpty() ? idx-1 : -idx+1;
    }
}
