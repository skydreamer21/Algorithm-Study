// 2558번 A+B -2
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB
 2. 0과 10사이 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q2558 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(a+b));
        bw.flush();
        bw.close();
        br.close();
    }
}
