// 1259번 펠린드롬수
/*
<문제 정보>
 1. 앞에서부터 읽나 뒤에서부터 읽나 같은 수를 펠린드롬 수
    - 주어지는 수가 펠린드롬수이면 yes 아니면 no

<변수 범위>
 1. 1초 / 128MB
 2. 1이상 99,999 이하 정수 주어짐

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q1259 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n;
        while(true) {
            n = Integer.parseInt(br.readLine());
            if (n==0) break;
            sb.append(isPalindrome(n) ? "yes" : "no").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPalindrome(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean palindrome = true;
        int div = 1;
        int nLength = 0;
        for (int i=1;i<=5;i++) {
            if (n/div<10) {
                nLength = i;
                break;
            }
            div *= 10;
        }
        int num;
        int tmpLength = nLength;
        while (tmpLength*2>nLength) {
            num = n%10;
            n /= 10;
            stack.add(num);
            tmpLength--;
        }

        if (nLength%2==1) stack.pollLast();
        while (n>0) {
            num = n%10;
            n /= 10;
            if (stack.pollLast() != num) {
                palindrome = false;
                break;
            }
        }
        return palindrome;
    }
}

























