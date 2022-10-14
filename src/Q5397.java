// 5397번 키로거 (S3)
/*
<문제 정보>
 1. 화살표, 백스페이스, 문자열 입력되었을때 비밀번호 알아내기
    - 비밀번호의 길이는 항상 0보다 크다

<변수 범위>
 1. 1초 / 256MB
 2. 1<=L<=1,000,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q5397 {
    static char[] input;
    static StringBuilder sb = new StringBuilder();

    static final char START ='*';
    static final char RIGHT ='>';
    static final char LEFT ='<';
    static final char BACKSPACE ='-';

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- >0) {
            input = br.readLine().toCharArray();
            getPassword();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getPassword() {
        Deque<Character> dq = new ArrayDeque<>();
        dq.add(START);
        for (char order : input) {
            switch(order) {
                case LEFT: // 마지막 -> 처음
                    if (dq.peekLast()==START) continue;
                    dq.addFirst(dq.pollLast());
                    break;
                case RIGHT: // 처음 -> 마지막
                    if (dq.peek()==START) continue;
                    dq.add(dq.poll());
                    break;
                case BACKSPACE:
                    if (dq.peekLast()==START) continue;
                    dq.pollLast();
                    break;
                default:
                    dq.add(order);
            }
        }

        while (dq.peek() != START) dq.add(dq.poll());

        dq.poll(); // START 문자 버리기
        while(!dq.isEmpty()) sb.append(dq.poll());
        sb.append("\n");
    }
}
