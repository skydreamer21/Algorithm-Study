// 1152번 단어의 개수
// 문장에 쓰인 단어 개수 세기 (단어 사이엔 공백)

/*
프로그램 진행
1. 처음 공백이 아닌 문자가 나왔을 때 부터 공백 카운트
2. 마지막이 공백이라면 공백 개수 = 단어 개수, 아니라면 단어개수 = 공백 +1

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1152 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        String S = br.readLine();
        StringTokenizer tk = new StringTokenizer(S);
        int num = tk.countTokens();
        bw.write(String.valueOf(num));
        bw.flush();
        bw.close();
    }
}






