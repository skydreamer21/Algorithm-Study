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
import java.util.Map;
import java.util.StringTokenizer;

public class Q2754 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        String input = br.readLine();
        Map<Character, Double> rank = Map.of(
                'A', 4.0,
                'B', 3.0,
                'C', 2.0,
                'D', 1.0
        );
        Map<Character, Double> additional = Map.of(
                '+', 0.3,
                '0', 0.0,
                '-', -0.3
        );

        // ******************** 메인 로직 ********************
        double score = 0;
        if (!input.equals("F")) {
            score += rank.get(input.charAt(0));
            score += additional.get(input.charAt(1));
        }

        // ******************** 정답 출력 ********************
        sb.append(String.format("%.1f",score));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
