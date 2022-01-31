// 2004번 조합 0의 개수

/*
<문제 정보>
 1. nCm 끝자리 0의 개수
 2. 0<=m<=n<=2,000,000,000  (n은 자연수)

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q2004 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int numerator_5num=factor_5_ofFactorial(n)-factor_5_ofFactorial(n-m);
        int denominator_5num=factor_5_ofFactorial(m);

        int numerator_2num=factor_2_ofFactorial(n)-factor_2_ofFactorial(n-m);
        int denominator_2num=factor_2_ofFactorial(m);

        int factor_5 = numerator_5num-denominator_5num;
        int factor_2 = numerator_2num-denominator_2num;
        bw.write(String.valueOf(Math.min(factor_2,factor_5)));
        //bw.write(String.valueOf(numerator_5num-denominator_5num));
        //bw.newLine();
        //bw.write(String.valueOf(numerator_2num-denominator_2num));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int factor_5_ofFactorial (int num) {
        int cnt=0;
        while(num>0) {
            num/=5;
            cnt+=num;
        }
        return cnt;
    }

    public static int factor_2_ofFactorial (int num) {
        int cnt=0;
        while(num>0) {
            num/=2;
            cnt+=num;
        }
        return cnt;
    }
}