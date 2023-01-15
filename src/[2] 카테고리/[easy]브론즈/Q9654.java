// 9654번 나부 함대 데이터 (B5)
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

public class Q9654 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        String[][] outputs = {
                {"SHIP NAME", "CLASS", "DEPLOYMENT", "IN SERVICE"},
                {"N2 Bomber", "Heavy Fighter", "Limited", "21"},
                {"J-Type 327", "Light Combat", "Unlimited", "1"},
                {"NX Cruiser", "Medium Fighter", "Limited", "18"},
                {"N1 Starfighter", "Medium Fighter", "Unlimited", "25"},
                {"Royal Cruiser", "Light Combat", "Limited", "4"}
        };

        int[] lengths = {15, 15, 11, 10};

        for (int i=0; i<outputs.length; i++) {
            for (int j=0; j<4; j++) {
                sb.append(makeOutput(outputs[i][j], lengths[j]));
            }
            sb.append("\n");
        }


        // ******************** 메인 로직 ********************



        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String makeOutput(String value, int length) {
        return String.format("%-"+length+"s", value);
    }
}
