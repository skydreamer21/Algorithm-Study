// 2744번 대소문자 바꾸기 (B5)
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

public class Q2744 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        char[] input = br.readLine().toCharArray();
        int diff = 'a' - 'A';
        for (int i=0; i<input.length; i++) {
            if (input[i] < 'a') {
                input[i] += diff;
            } else {
                input[i] -= diff;
            }
        }
        sb.append(String.valueOf(input));


        // ******************** 메인 로직 ********************



        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
