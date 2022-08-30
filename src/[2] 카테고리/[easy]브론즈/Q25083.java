// 25083번 새싹 (B5)
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

// """ => 텍스트 블록은 java13부터 지원

import java.io.*;

public class Q25083 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // ******************** 입력 & 초기화 ********************



        // ******************** 메인 로직 ********************
        sb.append("         ,r'\"7\n")
          .append("r`-_   ,'  ,/\n")
          .append(" \\. \". L_r'\n")
          .append("   `~\\/\n")
          .append("      |\n")
          .append("      |");



        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
