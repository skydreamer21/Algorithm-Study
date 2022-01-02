// 10757번 큰수 A+B
/*
<문제 정보>
 1. 두 정수 A, B입력 받은 후 A+B 출력
 2. 0<A,B<10^10000

<프로그램 진행>
 1. 10^10000이면 long의 최대치인 2^63-1 을 벗어남

<필요 함수>
  . 주어진 문자열을 거꾸로한 문자열 반환
  . 주어진 문자열을 거꾸로 출력
 */

import java.io.*;
import java.util.StringTokenizer;

public class Q10757 {
    static StringBuilder sb = new StringBuilder();

    public static void processRemDigit(String S, int n, int overTen) {
        int val;
        for (int i=n;i<S.length();i++) {
            val = S.charAt(i)-'0';
            if (overTen==1) {
                if (val==9) {
                    sb.append("0");
                    if (i==S.length()-1) sb.append("1");
                }
                else {
                    sb.append(String.valueOf(val+1));
                    overTen=0;
                }
            }
            else sb.append(String.valueOf(val));
        }
    }

    public static String getReversedString(String s) {
        StringBuilder sb1 = new StringBuilder();
        for (int i=1;i<=s.length();i++) sb1.append(String.valueOf(s.charAt(s.length()-i)));
        return sb1.toString();
    }

    public static void printReversedString(String s) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=1;i<=s.length();i++) bw.write(String.valueOf(s.charAt(s.length()-i)));
        bw.flush();
        bw.close();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        StringTokenizer tk = new StringTokenizer(S);
        String A = getReversedString(tk.nextToken());
        String B = getReversedString(tk.nextToken());
        int n = (A.length()<B.length()) ? A.length() : B.length();
        int A_val;
        int B_val;
        int sum_val;
        String temp;
        int overTen=0;
        for (int i=0;i<n;i++) {
            A_val = A.charAt(i)-'0';
            B_val = B.charAt(i)-'0';
            sum_val = A_val+B_val;
            if (overTen==0) temp = String.valueOf(sum_val%10);
            else if(sum_val==9) {
                temp="0";
                sum_val++;
            }
            else temp = String.valueOf((sum_val)%10+1);
            sb.append(temp);
            if (sum_val>=10) overTen=1;
            else overTen=0;
        }
        if (A.length()<B.length()) processRemDigit(B, n, overTen);
        else if (A.length()>B.length()) processRemDigit(A, n, overTen);
        else if (overTen==1) sb.append("1");

        printReversedString(sb.toString());
    }
}






