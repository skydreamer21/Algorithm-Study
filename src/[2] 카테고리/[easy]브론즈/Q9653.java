// 9653번 스타워즈 로고
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

public class Q9653 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // ******************** 입력 & 초기화 ********************



        // ******************** 메인 로직 ********************
        sb.append("    8888888888  888    88888\n")
          .append("   88     88   88 88   88  88\n")
          .append("    8888  88  88   88  88888\n")
          .append("       88 88 888888888 88   88\n")
          .append("88888888  88 88     88 88    888888\n\n")
          .append("88  88  88   888    88888    888888\n")
          .append("88  88  88  88 88   88  88  88\n")
          .append("88 8888 88 88   88  88888    8888\n")
          .append(" 888  888 888888888 88  88      88\n")
          .append("  88  88  88     88 88   88888888");


        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
