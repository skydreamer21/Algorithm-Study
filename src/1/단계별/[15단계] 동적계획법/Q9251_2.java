// 9251번 LCS

/*
<문제 정보>
 1. LCS : 최장 공통 부분 수열
 -> 두 수열이 있을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것
 2. 주어진 두 문자열의 LCS 길이를 출력

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// <주의> 왜 공통부분이 항상 있다고만 생각했지.... 없을수도 있는데...

import java.io.*;
import java.util.Arrays;

public class Q9251_2 {
    static Integer[][] memo;
    static String A;
    static String B;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        A = br.readLine();
        B = br.readLine();
        memo = new Integer[A.length()+1][B.length()+1];
        for (int i=0;i<=A.length();i++) memo[i][0]=0;
        for (int i=0;i<=B.length();i++) memo[0][i]=0;
        bw.write(String.valueOf(LCS(A.length(),B.length())));
        //bw.newLine();
        //printArr();
        bw.flush();
        bw.close();
        br.close();
    }
    public static int LCS (int x, int y) {
        //System.out.printf("%d,%d\n",x,y);
        if (memo[x][y]==null) {
            if (A.charAt(x-1)==B.charAt(y-1)) memo[x][y]=LCS(x-1,y-1)+1;
            else memo[x][y]=Math.max(LCS(x-1,y),LCS(x,y-1));
        }
        return memo[x][y];
    }

    public static void printArr() {
        for(int i=0;i<memo.length;i++) System.out.println(Arrays.toString(memo[i]));
        System.out.println();
    }
}