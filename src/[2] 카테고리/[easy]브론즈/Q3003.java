// 3003번 킹, 퀸, 룩, 비숍, 나이트, 폰 (B5)
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
import java.util.StringTokenizer;

public class Q3003 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // ******************** 입력 & 초기화 ********************



        // ******************** 메인 로직 ********************
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numOfChessPiece = {1, 1, 2, 2, 2, 8};
        for (int piece : numOfChessPiece) {
            sb.append(piece - Integer.parseInt(st.nextToken())).append(" ");
        }

        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
