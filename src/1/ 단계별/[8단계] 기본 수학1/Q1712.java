// 1712번 손익분기점
/*
<문제 정보>
 1. A(고정비용), B(가변비용), C(노트북가격) 이 주어질 때 손익분기점 계산
 2. 손익분기점이 없다면 -1
 */

/*
<프로그램 진행>
 */

/*
<필요 함수>
 */

import java.io.*;
import java.util.StringTokenizer;

public class Q1712 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        String S = br.readLine();
        StringTokenizer tk = new StringTokenizer(S);
        int A = Integer.parseInt(tk.nextToken());
        int B = Integer.parseInt(tk.nextToken());
        int C = Integer.parseInt(tk.nextToken());
        int BEP;
        if (B>=C) BEP=-1;
        else BEP=A/(C-B)+1;
        bw.write(String.valueOf(BEP));
        bw.flush();
        bw.close();
    }
}






