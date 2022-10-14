// 5543번 상근날드 (B4)
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

public class Q5543 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int burger=3; int drink=2;
        int sum=0;
        int tmp=2001;
        while(burger-->0) tmp=Math.min(tmp,Integer.parseInt(br.readLine()));
        sum+=tmp;
        tmp=2001;
        while(drink-->0) tmp=Math.min(tmp,Integer.parseInt(br.readLine()));
        sum+=tmp;
        bw.write(String.valueOf(sum-50));
        bw.flush();
        bw.close();
        br.close();
    }
}
