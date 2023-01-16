// 번
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


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q5339 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        sb.append("     /~\\\n")
                .append("    ( oo|\n")
                .append("    _\\=/_\n")
                .append("   /  _  \\\n")
                .append("  //|/.\\|\\\\\n")
                .append(" ||  \\ /  ||\n")
                .append("============\n")
                .append("|          |\n")
                .append("|          |\n")
                .append("|          |\n");

        // ******************** 메인 로직 ********************



        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
