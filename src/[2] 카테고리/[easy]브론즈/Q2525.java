// 2525번 오븐 시계 (B4)
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q2525 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        h+=t/60;
        m+=t%60;
        if(m>=60) {
            m-=60;
            h+=1;
        }
        if(h>=24) h%=24;
        bw.write(h+" "+m);
        bw.flush();
        bw.close();
        br.close();
    }
}
