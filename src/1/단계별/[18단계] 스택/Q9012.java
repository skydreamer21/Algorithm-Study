// 9012번 괄호

/*
<문제 정보>
 1. 올바른 괄호 문자열이면 YES 아니면 NO 출력
 2. 하나의 괄호 문자열 길이는 2이상 50 이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q9012 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String S;
        int cnt;
        while (T-->0) {
            cnt=0;
            S = br.readLine();
            if (S.length()%2==1) {
                sb.append("NO\n");
                continue;
            }
            for (int i=0;i<S.length();i++) {
                if (S.charAt(i)=='(') cnt++;
                else if (S.charAt(i)==')') cnt--;
                if (cnt<0) {
                    sb.append("NO\n");
                    break;
                }
                else if (i==S.length()-1 && cnt!=0) sb.append("NO\n");
            }
            if (cnt==0) sb.append("YES\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}