// 5904번 Moo 게임 (S1) [재귀]
/*
<문제 정보>
 1. N이 주어졌을 때 moo 수열의 N번째 글자 구하기

<변수 범위>
 1. 1초 / 128MB
 2. 1<=N<=10^9

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// S(0) ~ S(24)

import java.io.*;

public class Q5904 {
    static int N;
    static int[] mooArr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int maxSequenceTerms = 25;
        mooArr = new int[maxSequenceTerms];
        mooArr[0] = 3;
        for (int i=1;i<maxSequenceTerms;i++) mooArr[i] = 2*mooArr[i-1] + i+3;
//        for (int i=1;i<31;i++) findNthFigure(maxSequenceTerms-1, i);
        findNthFigure(maxSequenceTerms-1, N);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void findNthFigure (int n, int order) {
//        System.out.printf("n : %d, order : %d\n",n,order);
        if (n==0) {
            System.out.println(order==1 ? "m" : "o");
            return;
        }

        if (order>mooArr[n-1] && order<=mooArr[n]-mooArr[n-1]) {
            System.out.println(order-mooArr[n-1]==1 ? "m" : "o");
            return;
        }

        if (order<=mooArr[n-1]) findNthFigure(n-1,order);
        else if (order>mooArr[n]-mooArr[n-1]) findNthFigure(n-1,order-mooArr[n]+mooArr[n-1]);
    }
}
