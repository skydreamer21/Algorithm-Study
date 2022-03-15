// 11719번 그대로 출력하기 (B1)
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 256MB
 2. 입력 100줄, 각 줄은 100글자 넘지 않음
 3. 빈줄이 있을 수 있고 앞뒤 고백이 있을 수 있음

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q11719 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String S;
        while( (S=br.readLine())!=null) sb.append(S).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
