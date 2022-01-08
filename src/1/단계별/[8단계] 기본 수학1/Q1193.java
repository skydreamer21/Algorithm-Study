// 1193번 분수찾기
/*
<문제 정보>
 1. 주어져있는 분수 배열에서 지그재그 경로로 분수번호를 붙임
 2. X번째 분수를 출력
 */

/*
<프로그램 진행>
1. 지그재그 줄이 짝수번째인지 홀수번째인지에 따라 나눠야함
 */

/*
<필요 함수>
1. 지그재그로 몇번째 줄인지와 그줄의 최댓값이 담겨있는 배열 반환
 */

import java.io.*;

public class Q1193 {
    public static int[] getSumOfFraction(int num) {
        int[] info = new int[2];
        int i=1;
        int val=1;
        while(num>val) {
            i++;
            val+=i; //
        }
        info[0]=i+1; // 분자,분모 합
        info[1]=val-num; // 해당 줄과 입력된 수가 얼만큼 차이나는지
        return info;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int X = Integer.parseInt(br.readLine());
        int[] info = getSumOfFraction(X);
        int Numerator;
        int Denominator;
        if (info[0]%2==1) {
            Denominator = info[1] + 1;
            Numerator = info[0] - Denominator;
        }
        else {
            Denominator = info[0] - info[1] -1;
            Numerator = info[0] - Denominator;
        }
        bw.write(Numerator +"/"+Denominator);
        bw.flush();
        bw.close();
    }
}






