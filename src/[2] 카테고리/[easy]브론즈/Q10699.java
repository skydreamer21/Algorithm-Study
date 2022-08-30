// 10699번 오늘 날짜 (B5)
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

// Date 및 formatter 사용
// 참고링크 : https://developer-talk.tistory.com/408

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Q10699 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // ******************** 입력 & 초기화 ********************



        // ******************** 메인 로직 ********************
        Date date = new Date();
        SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");
        sb.append(formatter.format(date));

        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
