// 5338번 마이크로소프트 로고 (B5)
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

public class Q5338 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // ******************** 입력 & 초기화 ********************



        // ******************** 메인 로직 ********************
        sb.append("       _.-;;-._\n")
        .append("'-..-'|   ||   |\n")
        .append("'-..-'|_.-;;-._|\n")
        .append("'-..-'|   ||   |\n")
        .append("'-..-'|_.-''-._|");


        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
