// 1193번 분수찾기
/*
<문제 정보>
 1. 주어져있는 분수 배열에서 지그재그 경로로 분수번호를 붙임
 2. X번째 분수를 출력
 */

/*
<프로그램 진행>

 */

/*
<필요 함수>

 */

import java.io.*;

public class Q1193 {
    public static int[] getSumOfNU_DE(int num) {
        int[] info = new int[2];
        int i=1;
        int val=1;
        while(num>val) {
            i++;
            val+=i; //
        }
        info[0]=i+1;
        info[1]=val-num;
        return info;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int X = Integer.parseInt(br.readLine());
        int[] info = getSumOfNU_DE(X);
        int Denominator = info[1] + 1;
        int Numerator = info[0] - Denominator;
        bw.write(Numerator +"//"+Denominator);
        bw.flush();
        bw.close();
    }
}






