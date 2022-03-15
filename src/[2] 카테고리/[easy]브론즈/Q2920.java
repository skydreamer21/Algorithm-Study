// 2920번 음계 (B2)
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

public class Q2920 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp1,tmp2;
        tmp1=Integer.parseInt(st.nextToken());
        tmp2=Integer.parseInt(st.nextToken());
        boolean up = tmp1<tmp2;
        boolean mixed=false;
        tmp1=tmp2;
        for (int i=1;i<=6;i++) {
            tmp2 = Integer.parseInt(st.nextToken());
            if(up && tmp2-tmp1!=1) {
                mixed=true;
                break;
            }
            else if (!up && tmp2-tmp1!=-1) {
                mixed=true;
                break;
            }
            tmp1=tmp2;
        }
        if(!mixed) bw.write(up ? "ascending" : "descending");
        else bw.write("mixed");
        bw.flush();
        bw.close();
        br.close();
    }
}
