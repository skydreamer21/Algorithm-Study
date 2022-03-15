// 11721번 열 개씩 끊어 출력하기 (B2)
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 256MB
 2. 길이는 100을 넘지 않음

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q11721 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        int len = S.length();
        int num = len/10;
        for (int i=0;i<num;i++) sb.append(S, i*10, (i+1)*10).append("\n");
        if (len>num*10) sb.append(S,num*10,len);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
