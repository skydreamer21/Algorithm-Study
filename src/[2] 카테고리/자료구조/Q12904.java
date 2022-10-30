// 12904번 A와 B [자료구조 - Deque][그리디]
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q12904 {
    static boolean REAR = false;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        String start = br.readLine();
        String end = br.readLine();

        // ******************** 메인 로직 ********************
        int endLength = end.length();
        int lengthDiff = end.length() - start.length();
        Deque<Character> deque = strToDeque(end);
        boolean rearDirection = REAR;
        int numOfRemove = 0;

        while (!deque.isEmpty() && numOfRemove < lengthDiff) {
//            System.out.printf("rearDirection : %s, deque : %s\n", rearDirection ? "FRONT" : "REAR", printDeque(deque, rearDirection));
            char lastChar = rearDirection ? deque.peekFirst() : deque.peekLast();
            if (rearDirection) deque.pollFirst();
            else deque.pollLast();
            if (lastChar == 'B') rearDirection = !rearDirection;
            numOfRemove++;
        }
//        System.out.printf("rearDirection : %s, deque : %s\n", rearDirection ? "FRONT" : "REAR", printDeque(deque, rearDirection));

        // ******************** 정답 출력 ********************
        StringBuilder resultSb = new StringBuilder();
        while (!deque.isEmpty()) {
            if (rearDirection) resultSb.append(deque.pollLast());
            else resultSb.append(deque.pollFirst());
        }

        String result = resultSb.toString();
        if (start.equals(result)) sb.append(1);
        else sb.append(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String printDeque(Deque<Character> deque, boolean flag) {
        StringBuilder dequeSb = new StringBuilder();
        Deque<Character> copy = new ArrayDeque<>(deque);
        while (!copy.isEmpty()) {
            if (flag) dequeSb.append(copy.pollLast());
            else dequeSb.append(copy.pollFirst());
        }
        return dequeSb.toString();
    }

    public static Deque<Character> strToDeque (String str) {
        char[] strCharArray = str.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : strCharArray) {
            deque.add(c);
        }
        return deque;
    }
}
